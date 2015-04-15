package hackstreet.sixeswild.gui;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SWMainScreen extends AbstractScreen {
	JButton playBtn = new JButton();
	JButton achievementsBtn = new JButton();
	

	
	public SWMainScreen(SixesWildApplication sixesWildApplication)
	{
		super(sixesWildApplication, "Sixes Wild");
		
	    JPanel panel = new JPanel();
	    achievementsBtn = new JButton("Achievements");
	    playBtn = new JButton("Play");
	    panel.add(playBtn);
	    panel.add(achievementsBtn);
	    
	}
}
