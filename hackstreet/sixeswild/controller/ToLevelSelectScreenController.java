package hackstreet.sixeswild.controller;

import hackstreet.sixeswild.gui.SWApplication;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ToLevelSelectScreenController implements ActionListener{
	SWApplication application;
	
	public ToLevelSelectScreenController(SWApplication application){
		this.application = application;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		application.enterLevelSelectScreen();
	}
}
