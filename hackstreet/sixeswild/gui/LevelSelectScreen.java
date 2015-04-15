package hackstreet.sixeswild.gui;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LevelSelectScreen extends AbstractScreen {
	
	JButton backBtn;
	ArrayList<JButton> levelBtns;
	
	public LevelSelectScreen(SixesWildApplication sixesWildApplication){
		super(sixesWildApplication, "Levels");
		
		levelBtns = new ArrayList<JButton>();
		
		for (int i = 0 ; i<4; i++)
		{
			for (int j = 0;j<4;i++)
			{
				JButton temp = new JButton( (i*4 + j++)+""); 
				temp.setSize(50,50);
				temp.setLocation( (300+i*50), (100+j*50));
				levelBtns.add(temp);
				super.add(temp);
			}
		}
		
	    backBtn = new JButton("Back");
	    backBtn.setSize(60,60);
	    backBtn.setLocation(720,20);
	    super.add(backBtn);
	    
	    
		
		//Check if more or less 16
		
//		for (int i = 0; i<16; i++){
//			levelBtns.add(sixesWildApplication.levels[i])
//		}
		
		
		
	}

}
