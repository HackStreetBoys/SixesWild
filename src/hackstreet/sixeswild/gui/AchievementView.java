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
import javax.swing.SwingConstants;

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
		this.setSize(new Dimension(150,50));
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		
		this.name = new JLabel(this.achievement.getName());
		this.name.setFont(new Font("Serif",Font.BOLD,14));
		this.name.setLocation(70,5);
		this.name.setSize(180, 14);
		super.add(name);
		
		this.description = new JLabel("Description goes here!!");
		this.description.setFont(new Font("Serif",Font.BOLD,12));
		this.name.setLocation(70,20);
		this.name.setSize(180, 30);
		super.add(name);
		
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
		g.drawImage(this.img, 5, 50, null);
		g.setColor(Color.black);
		g.drawRect(0, 0, super.getWidth()-1, super.getHeight()-1);
		
	}
	
	
}
