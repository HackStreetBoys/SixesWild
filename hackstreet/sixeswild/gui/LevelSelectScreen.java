package hackstreet.sixeswild.gui;

import java.util.ArrayList;

import javax.swing.JButton;

public class LevelSelectScreen extends AbstractScreen {
	
	JButton backBtn;
	ArrayList<JButton> levelBtns;
	
	public LevelSelectScreen(SixesWildApplication sixesWildApplication){
		super(sixesWildApplication, "Sixes Wild");
		
		levelBtns = new ArrayList<JButton>();
		
		
		//Check if more or less 16
		
//		for (int i = 0; i<16; i++){
//			levelBtns.add(sixesWildApplication.levels[i])
//		}
		
		
		
	}

}
