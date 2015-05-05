package hackstreet.sixeswild.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import hackstreet.sixeswild.achievement.AbstractAchievement;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Shows information about an achievement.
 * 
 * @author Tim 
 *
 */
public class AchievementView extends JPanel {
	
	
	private AbstractAchievement achievement;
	BufferedImage img;
	JLabel name;
	JLabel description;
	
	
	public AchievementView(AbstractAchievement achievement) {
		this.achievement = achievement;
		this.setSize(new Dimension(350,50));
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		
		this.name = new JLabel(this.achievement.getName());
		this.name.setFont(new Font("Serif",Font.BOLD,14));
		this.name.setSize(280, 14);
		this.name.setLocation(55,5);
		super.add(name);
		
		this.description = new JLabel(this.achievement.getDescription());
		this.description.setFont(new Font("Serif",Font.BOLD,12));
		this.description.setSize(280, 30);
		this.description.setLocation(55,24);
		super.add(this.description);
		
		try {
			this.img = ImageIO.read(new File(getImagePath()));
		} catch(IOException e) {
			System.out.println(e);
		}
		
		
	}
	

	public String getImagePath() {
		// determine image based on achievement
		// for now, return place holder
		return "images/achievement-placeholder.png";
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.img, 5, 5, null);
		
		if (!this.achievement.getAchieved()) {
			g.setColor(new Color(0,0,0,100));
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		}
		g.setColor(Color.black);
		g.drawRect(0, 0, super.getWidth()-1, super.getHeight()-1);
		
	}
	
	
}
