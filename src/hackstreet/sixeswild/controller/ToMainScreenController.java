package hackstreet.sixeswild.controller;

import hackstreet.sixeswild.gui.SWApplication;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ToMainScreenController implements ActionListener{
	SWApplication application;
	
	public ToMainScreenController(SWApplication application){
		this.application = application;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		application.enterMainScreen();
	}
}
