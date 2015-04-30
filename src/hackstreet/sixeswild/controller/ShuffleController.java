package hackstreet.sixeswild.controller;

import hackstreet.sixeswild.gui.ActiveGameScreen;
import hackstreet.sixeswild.gui.SWApplication;
import hackstreet.sixeswild.level.AbstractLevel;
import hackstreet.sixeswild.move.ShuffleBoardMove;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShuffleController implements ActionListener{

	private SWApplication application;
	
	public ShuffleController(SWApplication application){
		this.application = application;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		AbstractLevel level = this.application.getModel().getLevel();
		ShuffleBoardMove move = new ShuffleBoardMove(level);
		
		move.doMove();
		level.getMoveStack().push(move);
		repaint();
	}
	
	private void repaint(){
		((ActiveGameScreen)application.getActiveScreen()).getGridView().refreshSlots();
		application.revalidate();
		application.repaint();
	}


}
