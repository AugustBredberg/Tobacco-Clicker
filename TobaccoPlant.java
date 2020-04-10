package resources;

import game.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.util.*;;

public class TobaccoPlant extends Resource{

    public int posx;
    public int posy;
    public float growth;

    public boolean alive;
    public double leaves = 0;

    static double tickPlantCounter = Constants.TOBACCO_PLANT_GROWTH_SPEED;

    public TobaccoPlant(int posx, int posy){
	this.posx = posx;
	this.posy = posy;
	this.growth = 1;
	this.alive = true;
    }

    public static void incrementBy(int incr){
	if(Constants.TOBACCOPLANTMAX > Stats.CURRENT_PLANTS){
	    Stats.CURRENT_PLANTS++;
	}
	else{
	    System.out.println("Max amount of plants is 4");
	}
    }

    public void grow(){
	this.growth += Constants.TOBACCO_PLANT_GROWTH_SPEED;
    }
    
    public void tick(){
	if(!alive || growth >= 340) return;

	//this.tickPlantCounter --;
	//if(tickPlantCounter <= 0){
	//this.tickPlantCounter = Constants.TOBACCO_PLANT_GROWTH_SPEED;
	this.leaves += 0.01 + (this.growth/1000 * Constants.TOBACCO_PLANT_YIELD_MULTIPLIER) * Constants.TOBACCO_PLANT_GROWTH_SPEED;
	this.growth += Constants.TOBACCO_PLANT_GROWTH_SPEED;
	if(this.growth > 340) this.growth = 340;
	//}
	//this.growth += Constants.TOBACCO_PLANT_GROWTH_SPEED;

	// Plant grows
	//if(this.growth % 25 == 0){
	
	    //}
	
	///** Died? **//
	if(this.growth % 25 == 0){
	    int death = new Random().nextInt(Constants.TOBACCO_PLANT_DEATHRISK + 1);
	    if(death >= Constants.TOBACCO_PLANT_DEATHRISK) this.alive = false;
	}
    }

    public void render(Graphics g){
	g.setColor(Color.gray);
	g.fillRect(posx, posy, 340, 25);

	
	HUD.drawReplant(g);
	HUD.drawHarvest(g);
	
	if(alive) g.setColor(Color.green);
	else g.setColor(Color.red); 

	
	g.fillRect(posx, posy, (int)growth, 25);
	g.setColor(Color.black);
	g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
	g.drawString("Leaves: "+ (int) leaves , posx+360, posy+20);
	
    }
}
