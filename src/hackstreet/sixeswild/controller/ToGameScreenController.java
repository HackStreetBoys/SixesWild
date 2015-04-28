package hackstreet.sixeswild.controller;

import hackstreet.sixeswild.gui.SWApplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class ToGameScreenController implements ActionListener{
	SWApplication application;
	
	public ToGameScreenController(SWApplication application){
		this.application = application;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		application.enterGameScreen(Integer.parseInt(((JButton)e.getSource()).getText()));
	}
}
