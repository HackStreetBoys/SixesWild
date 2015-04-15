package hackstreet.sixeswild.gui;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SWMainScreen extends AbstractScreen {
	JButton playBtn;
	JButton achievementsBtn;
	

	
	public SWMainScreen(SixesWildApplication sixesWildApplication)
	{
		super(sixesWildApplication, "Sixes Wild");
		
//	    JPanel panel = new JPanel();
	    achievementsBtn = new JButton("Achievements");
	    playBtn = new JButton("Play");
	    
	    super.setLayout(null);
	    
	    playBtn.setSize(150,50);
	    achievementsBtn.setSize(150,50);
	    
	    playBtn.setLocation(350,190);
	    playBtn.setLocation(350,190);
	    
	    achievementsBtn.setLocation(350,250);
	    
	    super.add(playBtn);
	    super.add(achievementsBtn);
	    
	}
}
