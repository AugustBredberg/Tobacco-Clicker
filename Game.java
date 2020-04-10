package game;
import resources.*;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{

    private Thread thread;

    private static final int WIDTH = 1600, HEIGHT = 900;
    public static Handler handler;

    /// VARIABLES FOR GAME LOOP
    private boolean running = false;
    double interpolation = 0;
    final int TICKS_PER_SECOND = 100;
    final int SKIP_TICKS = 1000 / TICKS_PER_SECOND;
    final int MAX_FRAMESKIP = 1000;
    private int fps = 60;
    private int frameCount = 0;

    public static long gameTime;

    public Game(){
	this.handler = new Handler();
	this.addKeyListener(new KeyInput(handler));

	this.setFocusable(true);
	//this.handler.addObject(new GrowTobaccoButton(50,50));

	this.handler.addObject(new HUD());
	new Window(WIDTH, HEIGHT, "Tobacco Clicker by Bredberg", this);

	
	//this.running = true;
	
    }


    
    public synchronized void start() {
	thread = new Thread(this);
	thread.start();
	running = true;
    }
	
    public synchronized void stop() {
	try {
	    thread.join();
	    running = false;
	}catch(Exception e){
	    e.printStackTrace();
	}
    }

    /*
    public void run() {
	long lastLoopTime = System.nanoTime();
	final int TARGET_FPS = 144;
	final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
	long lastFpsTime = 0;
	while(true){
	    long now = System.nanoTime();
	    long updateLength = now - lastLoopTime;
	    lastLoopTime = now;
	    double delta = updateLength / ((double)OPTIMAL_TIME);

	    lastFpsTime += updateLength;
	    if(lastFpsTime >= 1000000000){
		lastFpsTime = 0;
	    }
	    tick();
	    render();
	    Toolkit.getDefaultToolkit().sync();
	    try{
		gameTime = (lastLoopTime - System.nanoTime() + OPTIMAL_TIME) / 1000000;
		System.out.println(gameTime);
		Thread.sleep(gameTime);
	    }catch(Exception e){
	    }
	}
    }
    */
    public void run(){
      //This value would probably be stored elsewhere.
	boolean paused = false;
	final double GAME_HERTZ = 144.0;
	//Calculate how many ns each frame should take for our target game hertz.
	final double TIME_BETWEEN_UPDATES = 1000000000 / GAME_HERTZ;
	//At the very most we will update the game this many times before a new render.
	//If you're worried about visual hitches more than perfect timing, set this to 1.
	final int MAX_UPDATES_BEFORE_RENDER = 1;
	//We will need the last update time.
	double lastUpdateTime = System.nanoTime();
	//Store the last time we rendered.
	double lastRenderTime = System.nanoTime();
      
      
	//If we are able to get as high as this FPS, don't render again.
	final double TARGET_FPS = 144;
	final double TARGET_TIME_BETWEEN_RENDERS = 1000000000 / TARGET_FPS;
      
	//Simple way of finding FPS.
	int lastSecondTime = (int) (lastUpdateTime / 1000000000);
      
	while (running)
	    {
		double now = System.nanoTime();
		int updateCount = 0;
         
		if (!paused)
		    {
			//Do as many game updates as we need to, potentially playing catchup.
			while( now - lastUpdateTime > TIME_BETWEEN_UPDATES && updateCount < MAX_UPDATES_BEFORE_RENDER )
			    {
				tick();
				//render();
				lastUpdateTime += TIME_BETWEEN_UPDATES;
				updateCount++;
			    }
   
			//If for some reason an update takes forever, we don't want to do an insane number of catchups.
			//If you were doing some sort of game that needed to keep EXACT time, you would get rid of this.
			if ( now - lastUpdateTime > TIME_BETWEEN_UPDATES)
			    {
				lastUpdateTime = now - TIME_BETWEEN_UPDATES;
			    }
         
			//Render. To do so, we need to calculate interpolation for a smooth render.
			//float interpolation = Math.min(1.0f, (float) ((now - lastUpdateTime) / TIME_BETWEEN_UPDATES) );
			render();//interpolation);
			lastRenderTime = now;
         
			//Update the frames we got.
			int thisSecond = (int) (lastUpdateTime / 1000000000);
			if (thisSecond > lastSecondTime)
			    {
				System.out.println("NEW SECOND " + thisSecond + " " + frameCount);
				fps = frameCount;
				frameCount = 0;
				lastSecondTime = thisSecond;
			    }
         
			//Yield until it has been at least the target time between renders. This saves the CPU from hogging.
			while ( now - lastRenderTime < TARGET_TIME_BETWEEN_RENDERS && now - lastUpdateTime < TIME_BETWEEN_UPDATES)
			    {
				//Thread.yield();
				//try {Thread.sleep(1);} catch(Exception e) {} 
            
				now = System.nanoTime();
			    }
		    }
	    }
    }

    public void tick(){
	handler.tick();
    }


    public void render(){
	BufferStrategy bs = this.getBufferStrategy();
	
	if(bs == null){
	    this.createBufferStrategy(3);
	    return;
	}
	Graphics g = bs.getDrawGraphics();
	
	this.setPreferredSize(new Dimension(WIDTH,HEIGHT));

	g.setColor(Color.white);
	g.fillRect(0,0,WIDTH,HEIGHT);
	handler.render(g);
	

	g.dispose();
	bs.show();
	
	//repaint();
    }


    public static void main(String[] args){
	new Game();
    }
}
