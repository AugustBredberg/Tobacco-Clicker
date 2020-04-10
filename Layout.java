package game;

import resources.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Layout extends JFrame{

    public Container mainContainer;

    public Layout(String title){
	super(title);
	this.setSize(1400, 800);
	this.setLocation(100, 100);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	JButton buyPlantBtn = new JButton("Buy plant");
	JButton button2 = new JButton("Button2");
	JButton button3 = new JButton("Button3");
	JButton button4 = new JButton("Button4");
	JButton button5 = new JButton("Button555555");
	JButton button6 = new JButton("Button6");
	JButton button7 = new JButton("Button7");
	JButton button8 = new JButton("Button8");
	JButton button9 = new JButton("Button9");
	JButton button10 = new JButton("Button10");
	JButton button11 = new JButton("Button11");

	///////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////

	buyPlantBtn.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
		    
		    System.out.println("klickadbror");
		    TobaccoPlant.incrementBy(1);
		    //repaint();
		}
	    });

	///////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////

	Container mainContainer = this.getContentPane();
	this.mainContainer = mainContainer; 
	mainContainer.setLayout(new BorderLayout(8,6));
	mainContainer.setBackground(Color.YELLOW);
	this.getRootPane().setBorder
	    (BorderFactory.createMatteBorder(4,4,4,4, Color.GREEN));

	/////// TOP PANEL
	JPanel topPanel = new JPanel();
	//topPanel.setBorder(new LineBorder(Color.BLACK, 3));
	topPanel.setBackground(Color.ORANGE);
	topPanel.setLayout(new FlowLayout(5));
	mainContainer.add(topPanel, BorderLayout.NORTH);

	topPanel.add(buyPlantBtn);
	topPanel.add(button2);
	topPanel.add(button3);
	topPanel.add(button4);
	mainContainer.add(topPanel, BorderLayout.NORTH);

	/////// MIDDLE-LEFT PANEL
	JPanel middlePanel = new JPanel();
	middlePanel.setLayout(new FlowLayout(4,4,4));
	middlePanel.setBackground(Color.ORANGE);

	JPanel gridPanel = new JPanel();
	gridPanel.setLayout(new GridLayout(4,1,5,5));
	//gridPanel.setBackground(Color.RED);
	gridPanel.add(button5);
	gridPanel.add(button6);
	gridPanel.add(button7);
	gridPanel.add(button8);

	JLabel label = new JLabel("CENTER M8", SwingConstants.CENTER);
	label.setOpaque(true);

	middlePanel.add(gridPanel);
	//mainContainer.add(label);
	mainContainer.add(middlePanel, BorderLayout.WEST);

	/////// BOTTOM PANEL
	JPanel bottomPanel = new JPanel();
	bottomPanel.setLayout(new FlowLayout(3));
	bottomPanel.add(button9);
	bottomPanel.add(button10);
	bottomPanel.add(button11);
	bottomPanel.setBackground(Color.ORANGE);
	mainContainer.add(bottomPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args){
	Layout mylayout = new Layout("TEST LAYOUTen");
	mylayout.setVisible(true);
    }

}
