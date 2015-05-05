package hackstreet.sixeswild.level;

import java.util.ArrayList;

import hackstreet.sixeswild.config.EliminationLevelConfig;
import hackstreet.sixeswild.config.SavedLevelData;
import hackstreet.sixeswild.game.BucketSlot;
import hackstreet.sixeswild.game.EliminationSlot;
import hackstreet.sixeswild.game.InertSlot;
import hackstreet.sixeswild.game.Location;
import hackstreet.sixeswild.game.Slot;

/**
 * 
 * @author Nicholas
 *
 */
public class EliminationLevel extends AbstractLevel {

	private int numMovesLeft;
	
	/**
	 * 
	 * @param savedLevelData
	 */
	public EliminationLevel(SavedLevelData savedLevelData) {
		super(savedLevelData);
		if (savedLevelData.getLevelConfig() instanceof EliminationLevelConfig){
			numMovesLeft = (((EliminationLevelConfig) savedLevelData.getLevelConfig()).getNumMoves());
		}
		else
			throw new IllegalArgumentException();
	}
	
	@Override
	public void handlePostMove(){
		this.decreaseNumMovesLeft();
		//TODO Win/Lose conditions
	}

	public int getNumMovesLeft() {
		return numMovesLeft;
	}

	public void decreaseNumMovesLeft() {
		this.numMovesLeft--;
	}
	
	@Override
	public void initBoard(ArrayList<Location> inertLocs){
		for(int row=0; row<9; row++){
			for(int col=0; col<9; col++){
				Location loc = new Location(col,row);
				if(inertLocs.contains(loc))
					super.getBoard().put(loc, new InertSlot(loc));
				else
					super.getBoard().put(loc, new EliminationSlot(loc));
			}
		}
	}

}
