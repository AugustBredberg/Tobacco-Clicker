package game;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;

public class GrowTobaccoButton extends GameObject{

    private int growth = 1;
    
    public GrowTobaccoButton(int posX, int posY){
	super(posX, posY);	
    }
    

    public void render(Graphics g){
	g.setColor(Color.red);
	g.fillRect(x, y, 10, 10);
    }

    public void tick(){
    }
}
