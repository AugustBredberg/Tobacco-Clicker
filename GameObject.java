package game;

import java.awt.Graphics;

public abstract class GameObject{

    protected int x;
    protected int y;
    
    public GameObject(int posX, int posY){
	this.x = posX;
	this.y = posY;
    }
    
    public void action(){
	
    }

    public void test(){ System.out.println("hejhejhejhej");}

    public abstract void tick();
    public abstract void render(Graphics g);
    
}
