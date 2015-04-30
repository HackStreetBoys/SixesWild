package hackstreet.sixeswild.controller;

import hackstreet.sixeswild.game.AI;
import hackstreet.sixeswild.gui.ActiveGameScreen;
import hackstreet.sixeswild.gui.SWApplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HintController implements ActionListener{

	private SWApplication application;
	
	public HintController(SWApplication application){
		this.application = application;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		application.getModel().getLevel().setAISelected(true);
		
		AI ai = application.getModel().getLevel().getAi();
		ai.calculateValidMove();
		
		// TODO here?
		
		repaint();
	}
	
	private void repaint(){
		((ActiveGameScreen)application.getActiveScreen()).getGridView().refreshSlots();
		application.revalidate();
		application.repaint();
	}
}