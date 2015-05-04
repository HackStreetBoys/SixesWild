package hackstreet.sixeswild.gui;

import java.awt.Color;
import java.awt.GridLayout;

import hackstreet.sixeswild.achievement.AbstractAchievement;
import hackstreet.sixeswild.controller.ToMainScreenController;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Screen for displaying game stats and achievements.
 * 
 * @author Tim 
 *
 */
public class AchievementScreen extends AbstractScreen {

	private JButton backButton;
	private JPanel achievementPanel;
	// TODO: Add overall game stats
	
	
	public AchievementScreen(SWApplication application) {
		super(application, "Achievements");
		
		this.backButton = new JButton("Back");
		this.backButton.setSize(100,50);
		this.backButton.setLocation(10,500);
		this.backButton.addActionListener(new ToMainScreenController(super.getApplication()));
	    super.add(backButton);	
		
		this.achievementPanel = new JPanel();
		this.achievementPanel.setBackground(Color.WHITE);
		this.achievementPanel.setLocation(250,50);
		this.achievementPanel.setSize(300, 500);
		this.achievementPanel.setLayout(new GridLayout(1,5,10,10));	
		super.add(achievementPanel);
		
		for (AbstractAchievement a: this.getApplication().getModel().getAchievements()) {
			AchievementView av = new AchievementView(a);
			this.achievementPanel.add(av);
		}
		
	}

	
	
}
