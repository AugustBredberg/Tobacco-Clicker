package resources;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class TobaccoLeaves extends Resource{

    private static int amount;

    public TobaccoLeaves(int amount){
	this.amount = amount;
    }

    public int getAmount(){
	return this.amount;
    }

    public static void incrementBy(int amount){
	amount += amount;
    }

    public void render(Graphics g){
	//g.setColor(Color.black);
	//g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
	//g.drawString("Total number of Tobacco Plants", 15, 40);
	//g.drawString(amount+"", 15, 70 );
    }
    
}
