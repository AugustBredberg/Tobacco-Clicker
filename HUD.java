package game;
import resources.*;
import java.awt.*;
import javax.imageio.*; //ImageIO;
import javax.swing.ImageIcon;
import java.io.File;
import java.io.IOException;

public class HUD extends Resource{

    private static Image keyA;
    private static Image key1;
    private static Image key2;
    private static Image key3;
    private static Image key4;
    private static Image keyR;
    private static Image keyH;
    private static Image keyEnter;
    
    public HUD(){}

    public void render(Graphics g){
	g.setColor(Color.orange);
	g.fillRect(0, 0, 1600, 170);
	
	g.setColor(Color.black);
	g.setFont(new Font("TimesRoman", Font.PLAIN, 15));

	try{
            File key1 = new File("images/1.png");
	    File key2 = new File("images/2.png");
	    File key3 = new File("images/3.png");
	    File key4 = new File("images/4.png");
	    File keyR = new File("images/r.png");
	    File keyH = new File("images/h.png");
	    File keyEnter = new File("images/enter.png");
	    
	    this.key1 = ImageIO.read(key1);
	    this.key2 = ImageIO.read(key2);
	    this.key3 = ImageIO.read(key3);
	    this.key4 = ImageIO.read(key4);
	    this.keyR = ImageIO.read(keyR);
	    this.keyH = ImageIO.read(keyH);
	    this.keyEnter = ImageIO.read(keyEnter);
	    
	} catch (IOException e){
            e.printStackTrace();
        }
	drawSell(g);
	drawPlantButton(g);
	drawYieldUpgrade(g);
	/// DECREASE DEATHRISK KEY
	if(Constants.DEC_DR_BUTTON) drawDecDRButton(g);
	//g.drawString("(Decrease risk of withering)", 650, 75);

	
	
	
	
	g.drawString("Money: "+ Stats.DOLLARS_TOTAL+" $", 20, 30);
	g.drawString("Total leaves: " + Stats.TOBACCO_LEAVES_TOTAL, 20, 55);
    }

    public static void drawSell(Graphics g){
	g.drawImage(keyEnter, 1400, 110, 100, 45, null);
	g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
	g.drawString("SELL", 1510, 140);
	g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
    }

    public static void drawPlantButton(Graphics g){
	if(Stats.DOLLARS_TOTAL >= Constants.TOBACCO_PLANT_UPGRADE_COST){
	    g.setColor(Color.black);
	}
	else g.setColor(Color.gray);

	g.drawImage(key1, 450, 10, 30, 30, null);
	if(Stats.CURRENT_PLANTS < 4) g.drawString("Buy TobaccoPlant    "+Constants.TOBACCO_PLANT_UPGRADE_COST, 490, 35);
	else{
	    g.drawString("Upgrade soil quality    "+Constants.TOBACCO_PLANT_UPGRADE_COST, 490, 35);
	}
	g.setColor(Color.black);
    }
    
    public static void drawDecDRButton(Graphics g){
	if(Stats.DOLLARS_TOTAL >= Constants.TOBACCO_PLANT_DEC_DEATHRISK_COST){
	    g.setColor(Color.black);
	}
	else g.setColor(Color.gray);
	g.drawImage(key2, 450, 50, 30, 30, null); // fågelskrämma //sprinklers //vattna
	g.drawString(Constants.DEC_DEATHRISK_TEXT[Constants.DEC_DR_TEXT_i % Constants.DEC_DEATHRISK_TEXT.length] + Constants.TOBACCO_PLANT_DEC_DEATHRISK_COST + " $  (Decrease risk of withering)", 490, 75);
	g.setColor(Color.black);
    }

    public static void drawLeafCostButton(Graphics g){
	g.drawImage(key3, 450, 90, 30, 30, null);
	//g.drawString();
    }

    public static void drawYieldUpgrade(Graphics g){
	g.drawImage(key4, 450, 130, 30, 30, null);
	g.drawString("Upgrade leaf yield    " + Constants.TOBACCO_PLANT_YIELD_MULT_UPGRADE_COST + " $  (Current Yield multiplier: "+Constants.TOBACCO_PLANT_YIELD_MULTIPLIER+ ")", 490, 155);
	//g.drawString();
    }
    
    public static void drawHarvest(Graphics g){
	g.drawImage(keyH, 20, 190, 30, 30, null);
	g.setColor(Color.black);
	g.drawString("Harvest most grown plant", 60, 215);
    }

    public static void drawReplant(Graphics g){
	g.drawImage(keyR, 20, 230, 30, 30, null);
	g.setColor(Color.black);
	g.drawString("Replant withered plant", 60, 255);
    }

    

}
