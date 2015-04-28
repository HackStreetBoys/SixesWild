package hackstreet.sixeswild.gui;

import hackstreet.sixeswild.controller.ToLevelSelectScreenController;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class SWMainScreen extends AbstractScreen {
	
	private JButton playBtn;
	private JButton achievementsBtn;
	
	public SWMainScreen(SWApplication application) {
		super(application, "Sixes Wild");
		
	    super.setLayout(null);

	    playBtn = new JButton("Play");
	    playBtn.setSize(150,50);
	    playBtn.setLocation(325,190);
	    playBtn.addActionListener(new ToLevelSelectScreenController(super.getApplication()));

	    achievementsBtn = new JButton("Achievements");
	    achievementsBtn.setSize(150,50);
	    achievementsBtn.setLocation(325,250);
	    
	    super.add(playBtn);
	    super.add(achievementsBtn);
	}
}
