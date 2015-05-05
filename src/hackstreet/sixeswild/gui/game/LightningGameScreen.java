package hackstreet.sixeswild.gui.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

import hackstreet.sixeswild.gui.SWApplication;
import hackstreet.sixeswild.level.LightningLevel;

@SuppressWarnings("serial")
public class LightningGameScreen extends ActiveGameScreen {
	
	private Timer timer;
	
	private JLabel timeLeftLabel;

	public LightningGameScreen(SWApplication application, int levelNum) {
		super(application, levelNum);
		final LightningLevel level = (LightningLevel)application.getModel().getLevel();
		
		this.timeLeftLabel = new JLabel("Time left: " + level.getTimeLeft());
		this.timeLeftLabel.setSize(100,35);
		this.timeLeftLabel.setLocation(15,85);
		super.add(this.timeLeftLabel);
		
		this.timer = new Timer(1000,new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				level.decrementTime();
				level.handlePostMove();
				timeLeftLabel.setText("Time left: " + level.getTimeLeft());
			}
		});
		this.timer.start();
	}
	
	public JLabel getMovesLabel(){
		return this.timeLeftLabel;
	}

	
}
