package hackstreet.sixeswild.level;

import hackstreet.sixeswild.config.SavedLevelData;
import hackstreet.sixeswild.game.AI;
import hackstreet.sixeswild.game.EliminationSlot;
import hackstreet.sixeswild.game.InertSlot;
import hackstreet.sixeswild.game.Location;
import hackstreet.sixeswild.game.Slot;
import hackstreet.sixeswild.game.Tile;
import hackstreet.sixeswild.move.AbstractGameMove;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * If SixesWild is in the GamePlay screen, there should
 * be a single AbstractLevel representing the current game.
 * 
 * @author Tim, Nicholas
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
		this.selectedSlots = new ArrayList<Slot>();
		this.ai = new AI(board);
		this.isRemoveMoveSelected = false;
		this.isSwapMoveSelected = false;
		this.isShuffleMoveSelected = false;
		this.isAISelected = false;
		this.moveStack = new Stack<AbstractGameMove>();

		this.initBoard(this.savedLevelData.getLevelConfig().getNullLocations());
		this.populateBoard();
	}

	/**
	 * If the addition is valid, add a Slot to the selectedSlot ArrayList.
	 * @param loc
	 */
	public void addToSelection(Location loc){
		if (isValidSelectionAddition(loc)){
			selectedSlots.add(board.get(loc));
			board.get(loc).selected=true;
		}
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

		this.populateBoard();
	}

	/**
	 * Apply gravity to sift down existing tiles into null spaces.
	 */
	public void applyGravity() {

		// apply gravity to all columns individually
		for (int col=0; col < 9; col++) {
			this.applyGravityInColumn(col);
		}

	}

	/**
	 * Apply gravity in given column, stacking tiles in column on the bottom.
	 * @param column
	 */
	public void applyGravityInColumn(int col) {

		for (int row = 8; row > 0; row--) {
			Location loc = new Location(col, row);

			// if slot is not inert and does not have a tile, find one in column above to move down
			if (!(board.get(loc) instanceof InertSlot) && !(board.get(loc).hasTile())) {

				// look through slots above
				for (int row2 = row-1; row2 >= 0; row2--) {
					Location loc2 = new Location(col, row2);

					// if this slot has a tile, move it down
					if (!(board.get(loc2) instanceof InertSlot) && (board.get(loc2).hasTile())) {

						// copy down value to first slot
						board.get(loc).setTile(board.get(loc2).getTile());	
						// set tile in slot over to null
						board.get(loc2).setTile(null);
						break;
					}
				}
			}
		}
	}


	/**
	 * 
	 * @return the new value for a Tile {1-6}
	 */
	public int generateRandomValue() {
		double freq1 = this.getSavedLevelData().getLevelConfig().getFreq1();
		double freq2 = this.getSavedLevelData().getLevelConfig().getFreq2();
		double freq3 = this.getSavedLevelData().getLevelConfig().getFreq3();
		double freq4 = this.getSavedLevelData().getLevelConfig().getFreq4();
		double freq5 = this.getSavedLevelData().getLevelConfig().getFreq5();

		double r = Math.random();

		if (r < freq1)
			return 1;
		else if (r < freq1 + freq2)
			return 2;
		else if (r < freq1+freq2+freq3)
			return 3;
		else if (r < freq1+freq2+freq3+freq4)
			return 4;
		else if (r < freq1+freq2+freq3+freq4+freq5)
			return 5;
		else
			return 6;
	}

	/**
	 * Generates the multiplier for a tile using information stored in leveldata.
	 * @return the new multiplier for a tile {1-3}
	 */
	public int generateRandomMultiplier(){
		double mult2Freq = this.getSavedLevelData().getLevelConfig().getFreqMult2();
		double mult3Freq = this.getSavedLevelData().getLevelConfig().getFreqMult3();

		double rand = Math.random();
		if(rand<mult2Freq)
			return 2;
		else if(rand<mult2Freq+mult3Freq)
			return 3;
		else
			return 1;
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

	private void initBoard(ArrayList<Location> inertLocs){
		for(int row=0; row<9; row++){
			for(int col=0; col<9; col++){
				Location loc = new Location(col,row);
				if(inertLocs.contains(loc))
					board.put(loc, new InertSlot(loc));
				else
					board.put(loc, new Slot(loc));
			}
		}
	}

	public void populateBoard(){
		// go over each column
		for (int col = 0; col < 9; col++) {

			// repopulate each cell
			for (int row = 0; row < 9; row++) {

				Location loc = new Location(col,row);

				// if slot is not inert and does not have tile, give it a new tile
				if (!(board.get(loc) instanceof InertSlot) && !(board.get(loc).hasTile())) {

					int val = this.generateRandomValue();
					int mult = this.generateRandomMultiplier();

					Tile t = new Tile(val, mult);
					board.get(loc).setTile(t);

				}
			}
		}	
	}

	/**
	 * Validate whether a location can be added to the selected slots.
	 * @param loc
	 * @return boolean
	 */
	private boolean isValidSelectionAddition(Location loc){
		return this.selectedSlots.isEmpty() || this.getAllAdjacentLocations().contains(loc);
	}

	/**
	 * Gets the raw adjacent locations of a loc, and then filters to make sure
	 * that none of them are Inert, Elimination, or already added.
	 * 
	 * @return a list of all valid adjacent tiles to the selected tiles
	 */
	private ArrayList<Location> getAllAdjacentLocations(){

		ArrayList<Location> answer = new ArrayList<Location>();
		ArrayList<Location> temp = new ArrayList<Location>();

		// run check for every selected slot
		for (Slot slot : selectedSlots){
			temp = slot.getLoc().getRawAdjacentLocations();

			for (Location loc : temp){

				Slot s = board.get(loc);

				// do not add location to answer if the loc is Inert, Elimination, or already added
				if ( !(s instanceof InertSlot) && !(s instanceof EliminationSlot) && !selectedSlots.contains(s)
						&& !answer.contains(s)){
					answer.add(loc);
				}
			}
		}
		return answer;
	}
}
