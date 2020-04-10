package game;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;

public class Window extends Canvas{
		
    public static JFrame frame;
    public JPanel panel;
    public GridBagConstraints gbc;

    public Window(int width, int height, String title, Game game) {
	main(width, height, title, game);
    }

   
	
    public void main(int width, int height, String title, Game game) {
	/*
	Layout layout = new Layout("Tobacco Clicker by Bredberg");
	this.frame = layout;
	System.out.println("hello world");
	JPanel panel = new JPanel(new GridLayout());
	panel.setPreferredSize(new Dimension(width,height));
	*/
	JFrame frame = new JFrame(title);
	
	frame.setPreferredSize(new Dimension(width,height));
	frame.setMaximumSize(new Dimension(width,height));
	frame.setMinimumSize(new Dimension(width,height));
	//panel.setBackground(Color.red);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(false);
	frame.setLocationRelativeTo(null);
	frame.add(game);
	
	//layout.add(panel);
	//layout.setVisible(true);	
	frame.setVisible(true);
	//layout.getContentPane().add(game);
	//panel.pack();
	game.start();
    }		
}
