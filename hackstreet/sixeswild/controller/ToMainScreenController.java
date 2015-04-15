package hackstreet.sixeswild.controller;

import hackstreet.sixeswild.gui.SixesWildApplication;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ToMainScreenController implements ActionListener{
	SixesWildApplication application;
	
	public ToMainScreenController(SixesWildApplication application){
		this.application = application;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		application.enterMainScreen();
	}
}
