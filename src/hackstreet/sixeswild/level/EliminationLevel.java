package hackstreet.sixeswild.level;

import hackstreet.sixeswild.config.EliminationLevelConfig;
import hackstreet.sixeswild.config.SavedLevelData;

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

}
