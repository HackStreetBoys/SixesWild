package hackstreet.sixeswild.controller;

import hackstreet.sixeswild.game.InertSlot;
import hackstreet.sixeswild.game.Location;
import hackstreet.sixeswild.game.Slot;
import hackstreet.sixeswild.gui.ActiveGameScreen;
import hackstreet.sixeswild.gui.SWApplication;
import hackstreet.sixeswild.level.AbstractLevel;
import hackstreet.sixeswild.move.RemoveTileMove;
import hackstreet.sixeswild.move.StandardMove;
import hackstreet.sixeswild.move.SwapTilesMove;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class SwipeController extends MouseAdapter{

	SWApplication application;
	boolean accepting;

	public SwipeController(SWApplication application){
		this.application = application;
		this.accepting = false;
	}

	public void mousePressed(MouseEvent e){
		AbstractLevel level = application.getModel().getLevel();
		ActiveGameScreen gameScreen = (ActiveGameScreen)application.getActiveScreen();
		int size = gameScreen.getGridView().getWidth()/9;
		int x = e.getX()/size;
		int y = e.getY()/size;
		Location loc = new Location(x,y); // TODO

		if(level.isRemoveMoveSelected()){
			level.addToSelection(loc);
			
			RemoveTileMove move = new RemoveTileMove(level);
			move.doMove();
			level.getMoveStack().push(move);
			application.getModel().getLevel().setRemoveMoveSelected(false);
			this.repaint();
		}
		else{
			Slot slot = level.getBoard().get(loc);
			if(!(slot instanceof InertSlot) && slot.getTile().getValue()==6)
				return;
			this.accepting = true;
		}
	}

	@Override
	public void mouseDragged(MouseEvent e){
		if(this.accepting){
			AbstractLevel level = application.getModel().getLevel();
			ArrayList<Slot> selectedSlots = level.getSelectedSlots();
			ActiveGameScreen gameScreen = (ActiveGameScreen)application.getActiveScreen();
			int size = gameScreen.getGridView().getWidth()/9;
			int x = e.getX()/size;
			int y = e.getY()/size;

			Location loc = new Location(x,y);
			Slot slot = level.getBoard().get(loc);
			if(!(slot instanceof InertSlot) && slot.getTile().getValue()==6)
				return;
			if(!selectedSlots.contains(level.getBoard().get(loc))){
				application.getModel().getLevel().addToSelection(loc);
				application.repaint();
			}

			if(level.isSwapMoveSelected()&&selectedSlots.size()==2){
				SwapTilesMove move = new SwapTilesMove(level);
				move.doMove();
				level.getMoveStack().push(move);
				this.accepting = false;
				application.getModel().getLevel().setSwapMoveSelected(false);
				this.repaint();
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
			this.repaint();
		}
	}

	private void repaint(){
		((ActiveGameScreen)application.getActiveScreen()).getGridView().refreshSlots();
		application.revalidate();
		application.repaint();
	}

}
