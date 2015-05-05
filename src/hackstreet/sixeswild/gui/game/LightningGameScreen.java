package hackstreet.sixeswild.gui.game;

import javax.swing.JLabel;

import hackstreet.sixeswild.gui.SWApplication;
import hackstreet.sixeswild.level.LightningLevel;

@SuppressWarnings("serial")
public class LightningGameScreen extends ActiveGameScreen {
	
	private JLabel timeLeftLabel;

	public LightningGameScreen(SWApplication application, int levelNum) {
		super(application, levelNum);
		LightningLevel level = (LightningLevel)application.getModel().getLevel();
		
		this.timeLeftLabel = new JLabel("Moves left: " + level.getTimeLeft());
		this.timeLeftLabel.setSize(100,35);
		this.timeLeftLabel.setLocation(15,85);
		super.add(this.timeLeftLabel);
	}
	
	public JLabel getMovesLabel(){
		return this.timeLeftLabel;
	}

	
}
