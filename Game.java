package game;
//import classes.resources.*;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{

    private Thread thread;

    private static final int WIDTH = 600, HEIGHT = 600;
    private Handler handler;

    /// VARIABLES FOR GAME LOOP
    private boolean running = false;
    double interpolation = 0;
    final int TICKS_PER_SECOND = 10;
    final int SKIP_TICKS = 1000 / TICKS_PER_SECOND;
    final int MAX_FRAMESKIP = 5;

    public Game(){
	this.handler = new Handler();
	//this.addKeyListener();
	//this.setFocusable(true);
	this.handler.addObject(new GrowTobaccoButton(50,50));
	new Window(WIDTH, HEIGHT, "Tobacco Clicker by Bredberg", this);

	this.addMouseListener(new KeyInput(handler));
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
    
    public void run() {
	double next_game_tick = System.currentTimeMillis();
	int loops;

	while (true) {
	    loops = 0;
	    while (System.currentTimeMillis() > next_game_tick
		   && loops < MAX_FRAMESKIP) {

		tick();
		render();
		//System.out.println("FPS: "+ SKIP_TICKS);
		next_game_tick += SKIP_TICKS;
		loops++;
	    }

	    interpolation = (System.currentTimeMillis() + SKIP_TICKS - next_game_tick
			     / (double) SKIP_TICKS);
	    //render();
	}
    }

    public void tick(){

    }


    public void render(){
	BufferStrategy bs = this.getBufferStrategy();
	if(bs == null){
	    this.createBufferStrategy(3);
	    return;
	}
	Graphics g = bs.getDrawGraphics();
	g.setColor(Color.black);
	//g.fillRect(0, 0, WIDTH, HEIGHT);

	g.setColor(Color.white);
	//g.drawString(this.test + "", 10, 10);
	handler.render(g);
	
	g.dispose();
	bs.show();
	
    }


    public static void main(String[] args){
	new Game();
    }
}
