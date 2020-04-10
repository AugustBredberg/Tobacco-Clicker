package game;

import resources.*;
import java.awt.event.MouseAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.*;
import java.util.LinkedList;

public class KeyInput extends KeyAdapter {

    private Handler handler;
    
    public KeyInput(Handler handler){
	this.handler = handler;
    }

    @Override
    public void keyPressed(KeyEvent e){
	//// PROBLEM MED ATT HITTA SOURCE AV KNAPPTRYCK, JPANEL MED OBJECT I?
	int key = e.getKeyCode();
	System.out.println("Key pressed: " + key);

	/// BUY TOBACCOPLANT
	if(key == KeyEvent.VK_1){
	    Constants.DEC_DR_BUTTON = true;
	    if(Stats.DOLLARS_TOTAL < Constants.TOBACCO_PLANT_UPGRADE_COST)return;
	    
	    if(Constants.TOBACCOPLANTMAX > Stats.CURRENT_PLANTS){
		Game.handler.addObject(new TobaccoPlant(15, Stats.CURRENT_PLANTS*40+280));
		Stats.DOLLARS_TOTAL -= Constants.TOBACCO_PLANT_UPGRADE_COST; 
		Constants.TOBACCO_PLANT_UPGRADE_COST *= 2;
		Stats.CURRENT_PLANTS++;
	    }
	    else{
		if(Constants.TOBACCO_PLANT_GROWTH_SPEED >= 16){
		    System.out.println("MAX MAX MAX");
		    return;
		}
		Stats.DOLLARS_TOTAL -= Constants.TOBACCO_PLANT_UPGRADE_COST; 
		Constants.TOBACCO_PLANT_UPGRADE_COST *= 2;
		Constants.TOBACCO_PLANT_GROWTH_SPEED *= 2;
	    }
	}

	// DECREASE RISK OF DEATH
	if(key == KeyEvent.VK_2 && Constants.DEC_DR_BUTTON){
	    if(Stats.DOLLARS_TOTAL >= Constants.TOBACCO_PLANT_DEC_DEATHRISK_COST){
		Constants.TOBACCO_PLANT_DEATHRISK *= 2;
		Stats.DOLLARS_TOTAL -= Constants.TOBACCO_PLANT_DEC_DEATHRISK_COST; 
		Constants.TOBACCO_PLANT_DEC_DEATHRISK_COST *= 2;
		Constants.DEC_DR_TEXT_i++;
	    }
	}

	// UPGRADE LEAF COST
	if(key == KeyEvent.VK_3){

	}

	// UPGRADE LEAF YIELD
	if(key == KeyEvent.VK_4){
	    if(Stats.DOLLARS_TOTAL >= Constants.TOBACCO_PLANT_YIELD_MULT_UPGRADE_COST){
		Stats.DOLLARS_TOTAL -= Constants.TOBACCO_PLANT_YIELD_MULT_UPGRADE_COST;
		Constants.TOBACCO_PLANT_YIELD_MULT_UPGRADE_COST *= 2;
		Constants.TOBACCO_PLANT_YIELD_MULTIPLIER *= 2;
	    }
	}
	
	/// REPLANT DEAD PLANT
	if(key == KeyEvent.VK_R){
	    for(int i=0; i < handler.object.size(); i++){
		Resource temp = handler.object.get(i);
		if(temp instanceof TobaccoPlant){
		    TobaccoPlant tempPlant = (TobaccoPlant) temp;
		    if(!tempPlant.alive){
			tempPlant.alive = true;
			tempPlant.growth = 0;
			tempPlant.leaves = 0;
			break;
		    }
		}
	    }
	}

	/// HARVEST MOST GROWN PLANT
	if(key == KeyEvent.VK_H){
	    LinkedList<TobaccoPlant> plants = new LinkedList<TobaccoPlant>();
	    
	    for(int i=0; i < handler.object.size(); i++){
		Resource temp = handler.object.get(i);
		if(temp instanceof TobaccoPlant){
		    TobaccoPlant tempPlant = (TobaccoPlant) temp;
		    if(tempPlant.alive) plants.add(tempPlant);
		}
	    }
	    int mostGrownIndex = 0;
	    float mostGrowth = 0;
	    for(int i=0; i < plants.size(); i++){
		TobaccoPlant plant = plants.get(i);
		if(plant.growth > mostGrowth){
		    mostGrownIndex = i;
		    mostGrowth = plant.growth;
		}
	    }
	    if(plants.size() == 0)return;
	    plants.get(mostGrownIndex%plants.size()).growth = 1;
	    Stats.TOBACCO_LEAVES_TOTAL += plants.get(mostGrownIndex).leaves;
	    plants.get(mostGrownIndex).leaves = 0;
	}

	/// SELL SELL SELL SELL
	if(key == KeyEvent.VK_ENTER){
	    Stats.DOLLARS_TOTAL += Stats.TOBACCO_LEAVES_TOTAL *
		Constants.TOBACCO_LEAF_PRICE;
	    Stats.TOBACCO_LEAVES_TOTAL = 0;
	}
	

	/// EXIT GAME
	if(key == KeyEvent.VK_ESCAPE) System.exit(1);
    }

    

}
