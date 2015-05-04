package hackstreet.sixeswild.controller;

import hackstreet.sixeswild.gui.SWApplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Controller for button that takes a user to achievements screen.
 * @author Tim 
 *
 */
public class ToAchievementsScreenController implements ActionListener {

	private SWApplication application;
	
	public ToAchievementsScreenController(SWApplication application) {
		this.application = application;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		application.enterAchievementsScreen();
	}
}
