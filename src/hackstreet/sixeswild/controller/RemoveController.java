package hackstreet.sixeswild.controller;

import hackstreet.sixeswild.gui.ActiveGameScreen;
import hackstreet.sixeswild.gui.SWApplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveController implements ActionListener{

	private SWApplication application;
	
	public RemoveController(SWApplication application){
		this.application = application;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		application.getModel().getLevel().setRemoveMoveSelected(true);
		repaint();
	}
	
	private void repaint(){
		((ActiveGameScreen)application.getActiveScreen()).getGridView().refreshSlots();
		application.revalidate();
		application.repaint();
	}


}
