package game;

import java.awt.event.MouseAdapter;
//import java.awt.event.KeyAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {

    private Handler handler;
    
    public MouseInput(Handler handler){
	this.handler = handler;
    }

    public void mousePressed(MouseEvent e){
	//// PROBLEM MED ATT HITTA SOURCE AV KNAPPTRYCK, JPANEL MED OBJECT I?
	if(e.getSource() instanceof GameObject){
	    System.out.println("på knappen");
	}
	System.out.println("klick");
	//Object btnPanel = (GameObject) e.getSource();
	
	//handler.removeObject(btnPanel);
    }

    

}
