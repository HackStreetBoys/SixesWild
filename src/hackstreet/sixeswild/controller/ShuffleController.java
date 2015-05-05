package hackstreet.sixeswild.controller;

import hackstreet.sixeswild.gui.SWApplication;
import hackstreet.sixeswild.gui.game.ActiveGameScreen;
import hackstreet.sixeswild.gui.game.EliminationGameScreen;
import hackstreet.sixeswild.gui.game.PuzzleGameScreen;
import hackstreet.sixeswild.gui.game.ReleaseGameScreen;
import hackstreet.sixeswild.level.AbstractLevel;
import hackstreet.sixeswild.level.EliminationLevel;
import hackstreet.sixeswild.level.PuzzleLevel;
import hackstreet.sixeswild.level.ReleaseLevel;
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
		ShuffleBoardMove move = new ShuffleBoardMove(this.application.getModel(), level);
		move.doMove();
		level.getMoveStack().push(move);
		

		level.handlePostMove();
		this.updateMoveLabelIfRelevant(level);
		ActiveGameScreen screen = (ActiveGameScreen)application.getActiveScreen();
		screen.popupAchievements(application.getModel().updateAchievements());
		repaint();
	}
	
	private void repaint(){
		((ActiveGameScreen)application.getActiveScreen()).getGridView().refreshSlots();
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
