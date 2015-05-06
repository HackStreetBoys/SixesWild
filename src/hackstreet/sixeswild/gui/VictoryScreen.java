package hackstreet.sixeswild.gui;

import hackstreet.sixeswild.controller.ToLevelSelectScreenController;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * Screen that is displayed after winning a level.
 * 
 * @author Tim
 */
public class VictoryScreen extends AbstractScreen {

	private JLabel Message;
	private JButton replayButton;
	private JButton levelSelectButton;
	private JButton nextButton;
	private BufferedImage fullStar;
	private BufferedImage blackStar;

	public VictoryScreen(SWApplication application) {
		super(application, "");
		this.setBackground(new Color(0,0,0,50));
		this.setLayout(null);
		
		
//		this.replayButton = new JButton("Replay Level");
//		this.replayButton.setSize(120,50);
//		this.replayButton.setLocation(205,300);
//		// add listener
//		super.add(replayButton);	
		
		this.levelSelectButton = new JButton("Level Select");
		this.levelSelectButton.setSize(120,50);
		this.levelSelectButton.setLocation(335,300);
		// add listener
		this.levelSelectButton.addActionListener(new ToLevelSelectScreenController(super.getApplication()));
		super.add(levelSelectButton);
		
//		this.nextButton = new JButton("Next Level");
//		this.nextButton.setSize(120,50);
//		this.nextButton.setLocation(465,300);
		// add listener
		//super.add(nextButton);	
		
		this.Message = new JLabel("You Won!");
		this.Message.setSize(200, 35);
		this.Message.setLocation(300, 200);
		this.Message.setFont(new Font("Serif",Font.BOLD,40));
		super.add(this.Message);
		
		try {
			this.fullStar = ImageIO.read(new File("images/star.png"));
			this.blackStar = ImageIO.read(new File("images/black-star.png"));
		} catch(IOException e) {
			System.out.println(e);
		}
		
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.fillRoundRect(185, 185, 420, 180, 20, 20);
		g.setColor(Color.BLACK);
		g.drawRoundRect(185, 185, 420, 180, 20, 20);
		
		
		int starsEarned = 2;
		
		switch(starsEarned) 
		{
			case 1:	
				g.drawImage(fullStar, 300, 240, null);
				g.drawImage(blackStar, 366, 240, null);
				g.drawImage(blackStar, 432, 240, null);
				break;
			case 2:
				g.drawImage(fullStar, 300, 240, null);
				g.drawImage(fullStar, 366, 240, null);
				g.drawImage(blackStar, 432, 240, null);
				break;
			case 3:
				g.drawImage(fullStar, 300, 240, null);
				g.drawImage(fullStar, 366, 240, null);
				g.drawImage(fullStar, 432, 240, null);
		}
		
		
		
	}
}
