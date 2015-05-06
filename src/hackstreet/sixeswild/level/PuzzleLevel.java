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

	@Override
	public int handlePostMove() {
		this.decreaseNumMovesLeft();
		if(this.numMovesLeft<=0){
			int points1 = super.getSavedLevelData().getLevelConfig().getPointsStar1();
			if(super.getPointsEarned()>=points1){
				return 1;
			}
			else
				return -1;
		}
		return 0;
	}
}
