package hackstreet.sixeswild.controller;

import hackstreet.sixeswild.game.BucketSlot;
import hackstreet.sixeswild.game.InertSlot;
import hackstreet.sixeswild.game.Location;
import hackstreet.sixeswild.game.Slot;
import hackstreet.sixeswild.gui.SWApplication;
import hackstreet.sixeswild.gui.game.ActiveGameScreen;
import hackstreet.sixeswild.gui.game.EliminationGameScreen;
import hackstreet.sixeswild.gui.game.PuzzleGameScreen;
import hackstreet.sixeswild.gui.game.ReleaseGameScreen;
import hackstreet.sixeswild.level.AbstractLevel;
import hackstreet.sixeswild.level.EliminationLevel;
import hackstreet.sixeswild.level.PuzzleLevel;
import hackstreet.sixeswild.level.ReleaseLevel;
import hackstreet.sixeswild.move.RemoveTileMove;
import hackstreet.sixeswild.move.StandardMove;
import hackstreet.sixeswild.move.SwapTilesMove;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * @author Patrick
 *
 */
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

			RemoveTileMove move = new RemoveTileMove(this.application.getModel(), level);
			if(move.doMove()){
				level.getMoveStack().push(move);
				application.getModel().getLevel().setRemoveMoveSelected(false);

				int status = level.handlePostMove();
				if(status > 0){
					try {
						application.getModel().winLevel();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					application.enterVictoryScreen();
				}
				else if(status < 0)
					application.enterLossScreen();
				this.updateMoveLabelIfRelevant(level);
				ActiveGameScreen screen = (ActiveGameScreen)application.getActiveScreen();
				screen.popupAchievements(application.getModel().updateAchievements());
			}
			this.repaint();
		}
		else{
			Slot slot = level.getBoard().get(loc);
			if(!(slot instanceof BucketSlot) && !(slot instanceof InertSlot) && slot.getTile().getValue()==6)
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
			if(!(slot instanceof BucketSlot) && !(slot instanceof InertSlot) && slot.getTile().getValue()==6)
				return;
			if(!selectedSlots.contains(level.getBoard().get(loc))){
				application.getModel().getLevel().addToSelection(loc);
				application.repaint();
			}

			if(level.isSwapMoveSelected()&&selectedSlots.size()==2){
				SwapTilesMove move = new SwapTilesMove(this.application.getModel(),level);
				move.doMove();
				level.getMoveStack().push(move);
				this.accepting = false;
				application.getModel().getLevel().setSwapMoveSelected(false);

				int status = level.handlePostMove();
				if(status > 0){
					try {
						application.getModel().winLevel();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					application.enterVictoryScreen();
				}
				else if(status < 0)
					application.enterLossScreen();
				this.updateMoveLabelIfRelevant(level);
				ActiveGameScreen screen = (ActiveGameScreen)application.getActiveScreen();
				screen.popupAchievements(application.getModel().updateAchievements());
				this.repaint();
			}

			for(Slot s:selectedSlots){
				Location l = s.getLoc();
				gameScreen.getGridView().getSlotView(l).getTileView().setBlink(false);
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e){
		if(this.accepting){
			AbstractLevel level = application.getModel().getLevel();
			StandardMove move = new StandardMove(this.application.getModel(),level);
			if(move.doMove()){
				level.getMoveStack().push(move);
				int status = level.handlePostMove();
				if(status > 0){
					try {
						application.getModel().winLevel();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					application.enterVictoryScreen();
				}
				else if(status < 0)
					application.enterLossScreen();
			}
			this.accepting = false;

			this.updateMoveLabelIfRelevant(level);
			ActiveGameScreen screen = (ActiveGameScreen)application.getActiveScreen();
			screen.popupAchievements(application.getModel().updateAchievements());
			this.repaint();
		}
	}

	private void repaint(){
		ActiveGameScreen game = ((ActiveGameScreen)application.getActiveScreen());
		game.getGridView().refreshSlots();
		AbstractLevel level = application.getModel().getLevel();
		game.getProgressView().setValue(level.getPointsEarned());
		game.getScoreLabel().setText("Score: " + level.getPointsEarned());
		application.revalidate();
		application.repaint();
	}

	private void updateMoveLabelIfRelevant(AbstractLevel level){
		String type = level.getSavedLevelData().getLevelConfig().getType();
		if(type.equals("Elimination")){
			int numMovesLeft = ((EliminationLevel)level).getNumMovesLeft();
			((EliminationGameScreen)application.getActiveScreen()).getMovesLabel().setText("Moves Left: " + numMovesLeft);
		}
		else if(type.equals("Puzzle")){
			int numMovesLeft = ((PuzzleLevel)level).getNumMovesLeft();
			((PuzzleGameScreen)application.getActiveScreen()).getMovesLabel().setText("Moves Left: " + numMovesLeft);
		}
		else if(type.equals("Release")){
			int numMovesLeft = ((ReleaseLevel)level).getNumMovesLeft();
			((ReleaseGameScreen)application.getActiveScreen()).getMovesLabel().setText("Moves Left: " + numMovesLeft);
		}
	}

}
