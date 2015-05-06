package hackstreet.sixeswild.gui.game;

import javax.swing.JLabel;

import hackstreet.sixeswild.gui.SWApplication;
import hackstreet.sixeswild.level.ReleaseLevel;

/**
 * 
 * @author Patrick
 *
 */
@SuppressWarnings("serial")
public class ReleaseGameScreen extends ActiveGameScreen {
	
	private JLabel movesLeftLabel;

	public ReleaseGameScreen(SWApplication application, int levelNum) {
		super(application, levelNum);
		ReleaseLevel level = (ReleaseLevel)application.getModel().getLevel();
		
		this.movesLeftLabel = new JLabel("Moves left: " + level.getNumMovesLeft());
		this.movesLeftLabel.setSize(100,35);
		this.movesLeftLabel.setLocation(15,85);
		super.add(this.movesLeftLabel);
	}
	
	public JLabel getMovesLabel(){
		return this.movesLeftLabel;
	}

	
}