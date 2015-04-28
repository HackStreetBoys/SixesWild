package hackstreet.sixeswild.level;

import hackstreet.sixeswild.config.SavedLevelData;
import hackstreet.sixeswild.game.AI;
import hackstreet.sixeswild.game.Location;
import hackstreet.sixeswild.game.Slot;
import hackstreet.sixeswild.move.AbstractGameMove;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class AbstractLevel {

	SavedLevelData savedLevelData;
	int numShuffleLeft;
	int numSwapLeft;
	int numRemoveLeft;
	int numHintLeft;
	int pointsEarned;
	HashMap <Location, Slot> board;
	ArrayList<Slot> selectedSlots;
	AI ai;
	boolean removeMoveSelected;
	boolean swapMoveSelected;
	boolean shuffleMoveSelected;
	Stack<AbstractGameMove> moveStack;
	
	public AbstractLevel(SavedLevelData savedLevelData){
		this.savedLevelData = savedLevelData;
		/*
		this.numShuffleLeft = this.savedLevelData.getConfig().getNumShuffle();
		this.numSwapLeft = this.savedLevelData.getConfig().getNumSwap();
		this.numRemoveLeft = this.savedLevelData.getConfig().getNumRemove();
		this.numHintLeft = this.savedLevelData.getConfig().getNumHint();
		this.this.pointsEarned;
		this.board;
		this.selectedSlots;
		this.ai;
		this.removeMoveSelected;
		this.swapMoveSelected;
		this.shuffleMoveSelected;
		this.moveStack = new Stack<AbstractGameMove>();
		*/
	}
	
}
