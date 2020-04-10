package game;
import resources.*;

import java.util.LinkedList;
import java.awt.Graphics;

public class Handler{

    static LinkedList<Resource> object = new LinkedList<Resource>();
    static int  tickPlantCounter = Constants.TOBACCO_PLANT_GROWTH_SPEED;

    public void tick(){
	tickPlantCounter--;
	for(int i=0; i < object.size(); i++){
	    Resource tempObject = object.get(i);
	    
	    if(tempObject instanceof TobaccoPlant){
		TobaccoPlant plant = (TobaccoPlant) tempObject;
		
		if(tickPlantCounter <= 0){
		    //
		    System.out.println("tick");
		    //tickPlantCounter = 0;
		}
		//plant.grow();
	    }
	    //else
	    tempObject.tick();
	}
	
	//System.out.println(tickPlantCounter);
	if(tickPlantCounter <= 0){
	    //tickPlantCounter = 0;
	    tickPlantCounter = Constants.TOBACCO_PLANT_GROWTH_SPEED;
	}
    }

    public void render(Graphics g){
	for(int i=0; i < object.size(); i++){
	    Resource tempObject = object.get(i);
	    tempObject.render(g);
	}
    }

    public void addObject(Resource object){
	this.object.add(object);
    }

    public void removeObject(Resource object){
	this.object.remove(object);
    }

}
