package hackstreet.sixeswild.level;

import hackstreet.sixeswild.config.PuzzleLevelConfig;
import hackstreet.sixeswild.config.SavedLevelData;

/**
 * 
 * @author Nicholas
 *
 */
public class PuzzleLevel extends AbstractLevel {

	private int numMovesLeft;
	
	/**
	 * 
	 * @param savedLevelData
	 */
	public PuzzleLevel(SavedLevelData savedLevelData) {
		super(savedLevelData);
		if (savedLevelData.getLevelConfig() instanceof PuzzleLevelConfig){
			numMovesLeft = ((PuzzleLevelConfig) savedLevelData.getLevelConfig()).getNumMoves();
		}
		else
			throw new IllegalArgumentException();
	}
	
	public int getNumMovesLeft() {
		return numMovesLeft;
	}

	public void decreaseNumMovesLeft() {
		this.numMovesLeft--;
	}
}
