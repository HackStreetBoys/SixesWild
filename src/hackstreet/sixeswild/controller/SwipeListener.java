package hackstreet.sixeswild.controller;

import hackstreet.sixeswild.game.Location;
import hackstreet.sixeswild.game.Slot;
import hackstreet.sixeswild.gui.SWApplication;
import hackstreet.sixeswild.level.AbstractLevel;
import hackstreet.sixeswild.move.RemoveTileMove;
import hackstreet.sixeswild.move.StandardMove;
import hackstreet.sixeswild.move.SwapTilesMove;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class SwipeListener extends MouseAdapter{

	SWApplication application;
	boolean accepting;

	public SwipeListener(SWApplication application){
		this.application = application;
		this.accepting = false;
	}

	public void mousePressed(MouseEvent e){
		AbstractLevel level = application.getModel().getLevel();
		if(level.isRemoveMoveSelected()){
			RemoveTileMove move = new RemoveTileMove(level);
			move.doMove();
			level.getMoveStack().push(move);
		}
		else{
			this.accepting = true;
		}
	}

	@Override
	public void mouseDragged(MouseEvent e){
		if(this.accepting){
			AbstractLevel level = application.getModel().getLevel();
			ArrayList<Slot> selectedSlots = level.getSelectedSlots();
			int x = e.getX()/9;
			int y = e.getY()/9;

			Location loc = new Location(x,y);
			if(!selectedSlots.contains(loc))
				application.getModel().getLevel().addToSelection(loc);

			if(level.isSwapMoveSelected()&&selectedSlots.size()==2){
				SwapTilesMove move = new SwapTilesMove(level);
				move.doMove();
				level.getMoveStack().push(move);
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e){
		if(this.accepting){
			AbstractLevel level = application.getModel().getLevel();
			StandardMove move = new StandardMove(level);
			move.doMove();
			level.getMoveStack().push(move);
			this.accepting = false;
		}
	}

}
