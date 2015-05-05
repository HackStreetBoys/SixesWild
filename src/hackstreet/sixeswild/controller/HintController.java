package hackstreet.sixeswild.controller;

import hackstreet.sixeswild.gui.SWApplication;
import hackstreet.sixeswild.level.AbstractLevel;
import hackstreet.sixeswild.move.HintMove;
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
		AbstractLevel level = this.application.getModel().getLevel();
		HintMove move = new HintMove(application.getModel(), level, application);
		
		move.doMove();
		level.getMoveStack().push(move);
		repaint();
	}
	
	private void repaint(){
		application.revalidate();
		application.repaint();
	}
}