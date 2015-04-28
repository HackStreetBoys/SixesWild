package hackstreet.sixeswild.level;

import hackstreet.sixeswild.config.SavedLevelData;
import hackstreet.sixeswild.game.AI;
import hackstreet.sixeswild.game.Location;
import hackstreet.sixeswild.game.Slot;
import hackstreet.sixeswild.move.AbstractGameMove;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * If SixesWild is in the GamePlay screen, there should
 * be a single AbstractLevel representing the current game.
 * 
 * @author Nicholas
 *
 */
public class AbstractLevel {

	/** The data used to create the level. */
	SavedLevelData savedLevelData;
	int numShuffleLeft;
	int numSwapLeft;
	int numRemoveLeft;
	int numHintLeft;
	int pointsEarned;
	HashMap <Location, Slot> board;
	ArrayList<Slot> selectedSlots;
	AI ai;
	boolean isRemoveMoveSelected;
	boolean isSwapMoveSelected;
	boolean isShuffleMoveSelected;
	boolean isAISelected;
	Stack<AbstractGameMove> moveStack;
	
	/**
	 * AbstractLevel constructor.
	 * @param savedLevelData The data used to create the level.
	 */
	public AbstractLevel(SavedLevelData savedLevelData){
		this.savedLevelData = savedLevelData;
		this.numShuffleLeft = this.savedLevelData.getConfig().getNumShuffle();
		this.numSwapLeft = this.savedLevelData.getConfig().getNumSwap();
		this.numRemoveLeft = this.savedLevelData.getConfig().getNumRemove();
		this.numHintLeft = this.savedLevelData.getConfig().getNumHint();
		this.pointsEarned = 0;
		this.board = new HashMap<Location, Slot>();
		this.selectedSlots = new ArrayList<Slot>();
		this.ai = new AI();
		this.isRemoveMoveSelected = false;
		this.isSwapMoveSelected = false;
		this.isShuffleMoveSelected = false;
		this.isAISelected = false;
		this.moveStack = new Stack<AbstractGameMove>();
	}
	
}
