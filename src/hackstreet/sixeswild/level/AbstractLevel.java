package hackstreet.sixeswild.level;

import hackstreet.sixeswild.game.AI;
import hackstreet.sixeswild.game.Location;
import hackstreet.sixeswild.game.Slot;
import hackstreet.sixeswild.move.AbstractGameMove;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class AbstractLevel {

	//SavedLevelData savedLevelData;
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
	

	
}
