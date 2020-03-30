package game;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class Window extends Canvas{
		
    public JFrame frame;
    

    public Window(int width, int height, String title, Game game) {
	main(width, height, title, game);
    }
		
	
    public void main(int width, int height, String title, Game game) {
	JFrame frame = new JFrame("Tobacco Clicker by Bredberg");
	this.frame = frame;
	frame.setPreferredSize(new Dimension(width, height));
	frame.setMaximumSize(new Dimension(width, height));
	frame.setMinimumSize(new Dimension(width, height));

	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(false);
	frame.setLocationRelativeTo(null);
	//frame.add(game);
	frame.setVisible(true);

	JPanel container = new JPanel(new GridBagLayout());	
	GridBagConstraints c = new GridBagConstraints();
	JButton button = new JButton("knappjaevel");
	button.setBounds(0,0,150,150);
	container.add(button);
	//frame.add(button);
	frame.getContentPane().add(container);
	System.out.println("hello world");

	frame.pack();
	game.start();
    }		
}
