package hackstreet.sixeswild.gui;

import hackstreet.sixeswild.controller.ToLevelSelectScreenController;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * Screen that is displayed after winning a level.
 * 
 * @author Tim
 */
public class VictoryScreen extends AbstractScreen {

	private JLabel victoryMessage;
	private JButton replayButton;
	private JButton levelSelectButton;
	private JButton nextButton;
	private String imgPath;

	public VictoryScreen(SWApplication application){
		super(application, "Victory Screen");
		this.setBackground(new Color(0,0,0,50));
		this.setLayout(null);
		
		
		this.replayButton = new JButton("Replay Level");
		this.replayButton.setSize(120,50);
		this.replayButton.setLocation(205,300);
		// add listener
		super.add(replayButton);	
		
		this.levelSelectButton = new JButton("Level Select");
		this.levelSelectButton.setSize(120,50);
		this.levelSelectButton.setLocation(335,300);
		// add listener
		this.levelSelectButton.addActionListener(new ToLevelSelectScreenController(super.getApplication()));
		super.add(levelSelectButton);
		
		this.nextButton = new JButton("Next Level");
		this.nextButton.setSize(120,50);
		this.nextButton.setLocation(465,300);
		// add listener
		super.add(nextButton);	
		
		this.victoryMessage = new JLabel("You Won!");
		this.victoryMessage.setSize(200, 50);
		this.victoryMessage.setLocation(300, 200);
		this.victoryMessage.setFont(new Font("Serif",Font.BOLD,40));
		super.add(this.victoryMessage);
		
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.fillRoundRect(185, 185, 420, 180, 20, 20);
		g.setColor(Color.BLACK);
		g.drawRoundRect(185, 185, 420, 180, 20, 20);
	}
}
