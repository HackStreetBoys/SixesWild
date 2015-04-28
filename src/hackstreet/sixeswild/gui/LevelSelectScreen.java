package hackstreet.sixeswild.gui;

import hackstreet.sixeswild.controller.ToGameScreenController;
import hackstreet.sixeswild.controller.ToMainScreenController;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * 
 * Screen for selecting which level to play.
 * 
 * @author Tim Petri | tapetri@wpi.edu
 * Apr 26, 2015
 *
 */
public class LevelSelectScreen extends AbstractScreen {
	
	private JButton backButton;
	private JPanel	levelPanel;
	
	public LevelSelectScreen(SWApplication application){
		super(application, "Levels");
		
		
		levelPanel = new JPanel();
		levelPanel.setBounds(120, 100, 540, 350);
		levelPanel.setLayout(new GridLayout(4, 5, 10, 10));
		for (int x = 1; x <= 20; x++) {
			JButton button = new JButton(x+"");
			
			setImages(button, x);
			button.setBorderPainted(true);
			button.setFocusPainted(false);
			button.setContentAreaFilled(false);
			button.setHorizontalTextPosition(SwingConstants.CENTER);
			
			if (x > 4) { 
				button.setEnabled(false);
				button.setForeground(Color.black);
			}
			
			
			button.addActionListener(new ToGameScreenController(super.getApplication()));
			
			levelPanel.add(button);
		}
		
		super.add(levelPanel);
		
		this.backButton = new JButton("Back");
		this.backButton.setSize(100,50);
		this.backButton.setLocation(10,500);
		this.backButton.addActionListener(new ToMainScreenController(super.getApplication()));
	    super.add(backButton);		
	}

	/**
	 * Returns the path to correct image for level #x.
	 * 
	 * @param x
	 * @return
	 */
	private void setImages(JButton b, int x) {
		
		// for now..
		int stars = -1;
		if (x < 5) 
			stars = 1 + (int)(Math.random()*3);
		
		
		// supposed to switch on actual value
		switch(stars) {
			case 0:
				b.setIcon(new ImageIcon("images/0-stars-unpressed.png"));
				b.setPressedIcon(new ImageIcon("images/0-stars-pressed.png"));
				break;
			case 1:
				b.setIcon(new ImageIcon("images/1-star-unpressed.png"));
				b.setPressedIcon(new ImageIcon("images/1-star-pressed.png"));
				break;
			case 2:
				b.setIcon(new ImageIcon("images/2-stars-unpressed.png"));
				b.setPressedIcon(new ImageIcon("images/2-stars-pressed.png"));
				break;
				
			case 3:
				b.setIcon(new ImageIcon("images/3-stars-unpressed.png"));
				b.setPressedIcon(new ImageIcon("images/3-stars-pressed.png"));
				break;
			
			default: 
				b.setIcon(new ImageIcon("images/locked-button.png"));
				break;
				
		}
		return;
	}

}
