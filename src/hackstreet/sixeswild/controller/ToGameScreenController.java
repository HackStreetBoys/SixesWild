package hackstreet.sixeswild.controller;

import hackstreet.sixeswild.gui.SWApplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class ToGameScreenController implements ActionListener{
	SWApplication application;
	int number;
	
	public ToGameScreenController(SWApplication application, int number){
		this.application = application;
		this.number = number;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		application.getModel().prepareLevel(this.number);
		application.enterGameScreen(this.number);
	}
}
