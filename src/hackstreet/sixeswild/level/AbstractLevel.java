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
	private SavedLevelData savedLevelData;
	private int numShuffleLeft;
	private int numSwapLeft;
	private int numRemoveLeft;
	private int numHintLeft;
	private int pointsEarned;
	private HashMap <Location, Slot> board;
	private ArrayList<Slot> selectedSlots;
	private AI ai;
	private boolean isRemoveMoveSelected;
	private boolean isSwapMoveSelected;
	private boolean isShuffleMoveSelected;
	private boolean isAISelected;
	private Stack<AbstractGameMove> moveStack;
	
	/**
	 * AbstractLevel constructor.
	 * @param savedLevelData The data used to create the level.
	 */
	public AbstractLevel(SavedLevelData savedLevelData){
		this.savedLevelData = savedLevelData;
		this.numShuffleLeft = this.savedLevelData.getLevelConfig().getNumShuffle();
		this.numSwapLeft = this.savedLevelData.getLevelConfig().getNumSwap();
		this.numRemoveLeft = this.savedLevelData.getLevelConfig().getNumRemove();
		this.numHintLeft = this.savedLevelData.getLevelConfig().getNumHint();
		this.pointsEarned = 0;
		this.board = new HashMap<Location, Slot>();
		this.setSelectedSlots(new ArrayList<Slot>());
		this.ai = new AI();
		this.isRemoveMoveSelected = false;
		this.isSwapMoveSelected = false;
		this.isShuffleMoveSelected = false;
		this.isAISelected = false;
		this.moveStack = new Stack<AbstractGameMove>();
	}
	
	
	
	public SavedLevelData getSavedLevelData() {
		return savedLevelData;
	}



	public void setSavedLevelData(SavedLevelData savedLevelData) {
		this.savedLevelData = savedLevelData;
	}



	public int getNumShuffleLeft() {
		return numShuffleLeft;
	}



	public void setNumShuffleLeft(int numShuffleLeft) {
		this.numShuffleLeft = numShuffleLeft;
	}



	public int getNumSwapLeft() {
		return numSwapLeft;
	}



	public void setNumSwapLeft(int numSwapLeft) {
		this.numSwapLeft = numSwapLeft;
	}



	public int getNumRemoveLeft() {
		return numRemoveLeft;
	}



	public void setNumRemoveLeft(int numRemoveLeft) {
		this.numRemoveLeft = numRemoveLeft;
	}



	public int getNumHintLeft() {
		return numHintLeft;
	}



	public void setNumHintLeft(int numHintLeft) {
		this.numHintLeft = numHintLeft;
	}



	public int getPointsEarned() {
		return pointsEarned;
	}



	public void setPointsEarned(int pointsEarned) {
		this.pointsEarned = pointsEarned;
	}



	public HashMap<Location, Slot> getBoard() {
		return board;
	}



	public void setBoard(HashMap<Location, Slot> board) {
		this.board = board;
	}



	public AI getAi() {
		return ai;
	}



	public void setAi(AI ai) {
		this.ai = ai;
	}



	public boolean isRemoveMoveSelected() {
		return isRemoveMoveSelected;
	}



	public void setRemoveMoveSelected(boolean isRemoveMoveSelected) {
		this.isRemoveMoveSelected = isRemoveMoveSelected;
	}



	public boolean isSwapMoveSelected() {
		return isSwapMoveSelected;
	}



	public void setSwapMoveSelected(boolean isSwapMoveSelected) {
		this.isSwapMoveSelected = isSwapMoveSelected;
	}



	public boolean isShuffleMoveSelected() {
		return isShuffleMoveSelected;
	}



	public void setShuffleMoveSelected(boolean isShuffleMoveSelected) {
		this.isShuffleMoveSelected = isShuffleMoveSelected;
	}



	public boolean isAISelected() {
		return isAISelected;
	}



	public void setAISelected(boolean isAISelected) {
		this.isAISelected = isAISelected;
	}



	public Stack<AbstractGameMove> getMoveStack() {
		return moveStack;
	}



	public void setMoveStack(Stack<AbstractGameMove> moveStack) {
		this.moveStack = moveStack;
	}



	/**
	 * First, apply gravity to sift down existing tiles into null spaces.
	 * Then, repopulate any remaining NULL Tiles using the random generation of
	 * values and multipliers.
	 */
	public void repopulateSlots(){
		this.applyGravity();
		// TODO HERE
	}
	
	/**
	 * Apply gravity to sift down existing tiles into null spaces.
	 */
	public void applyGravity(){
		// TODO HERE
	}
	
	/**
	 * 
	 * @return the new value for a Tile {1-6}
	 */
	public int generateRandomValue(){
		// TODO HERE
		return 0;
	}
	
	/**
	 * 
	 * @return the new multiplier for a tile {1-3}
	 */
	public int generateRandomMultiplier(){
		// TODO HERE
		return 0;
	}

	public ArrayList<Slot> getSelectedSlots() {
		return selectedSlots;
	}

	public void setSelectedSlots(ArrayList<Slot> selectedSlots) {
		this.selectedSlots = selectedSlots;
	}

	/**
	 * Add points to the score.
	 * @param delta The number of points to add to the score.
	 */
	public void addPointsEarned(int delta) {
		this.pointsEarned += delta;
	}
	
	
	
	
}
