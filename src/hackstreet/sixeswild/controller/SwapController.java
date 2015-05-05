package hackstreet.sixeswild.controller;

import hackstreet.sixeswild.gui.SWApplication;
import hackstreet.sixeswild.gui.game.ActiveGameScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwapController implements ActionListener{

	private SWApplication application;
	
	public SwapController(SWApplication application){
		this.application = application;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		application.getModel().getLevel().setSwapMoveSelected(true);
		repaint();
	}
	
	private void repaint(){
		((ActiveGameScreen)application.getActiveScreen()).getGridView().refreshSlots();
		application.revalidate();
		application.repaint();
	}


}
