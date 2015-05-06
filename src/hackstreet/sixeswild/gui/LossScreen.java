/**
 * 
 */
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
public class LossScreen extends AbstractScreen {

	private JLabel Message;
	private JButton replayButton;
	private JButton levelSelectButton;

	public LossScreen(SWApplication application){
		super(application, "");
		this.setBackground(new Color(0,0,0,50));
		this.setLayout(null);
		
		
		this.replayButton = new JButton("Replay Level");
		this.replayButton.setSize(120,50);
		this.replayButton.setLocation(205,300);
		// add listener
		//super.add(replayButton);	
		
		this.levelSelectButton = new JButton("Level Select");
		this.levelSelectButton.setSize(120,50);
		this.levelSelectButton.setLocation(335,300);
		// add listener
		this.levelSelectButton.addActionListener(new ToLevelSelectScreenController(super.getApplication()));
		super.add(levelSelectButton);
		
		this.Message = new JLabel("You Lost!");
		this.Message.setSize(200, 35);
		this.Message.setLocation(300, 200);
		this.Message.setFont(new Font("Serif",Font.BOLD,40));
		super.add(this.Message);
		
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.fillRoundRect(185, 185, 420, 180, 20, 20);
		g.setColor(Color.BLACK);
		g.drawRoundRect(185, 185, 420, 180, 20, 20);
	}
}