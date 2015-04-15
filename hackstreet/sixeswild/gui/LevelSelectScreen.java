package hackstreet.sixeswild.gui;

import hackstreet.sixeswild.controller.ToGameScreenController;
import hackstreet.sixeswild.controller.ToMainScreenController;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class LevelSelectScreen extends AbstractScreen {
	
	private JButton backButton;
	private ArrayList<JButton> levelBtns;
	
	public LevelSelectScreen(SWApplication application){
		super(application, "Levels");
		
		levelBtns = new ArrayList<JButton>();
		
		for(int x = 0; x<4; x++){
			for(int y = 0; y<4; y++){
				JButton button = new JButton((y*4+x+1)+"");
				if(Integer.parseInt(button.getText())>2){
					button.setEnabled(false);
					button.setBackground(new Color(180,180,180));
					button.setForeground(Color.white);
				}
				button.setSize(50,50);
				button.setLocation(255+x*50+30*x,120+y*50+30*y);
				button.addActionListener(new ToGameScreenController(super.getApplication()));
				this.levelBtns.add(button);
				super.add(button);
			}
		}
		
		this.backButton = new JButton("Back");
		this.backButton.setSize(100,50);
		this.backButton.setLocation(10,500);
		this.backButton.addActionListener(new ToMainScreenController(super.getApplication()));
	    super.add(backButton);		
	}

}
