package hackstreet.sixeswild.level;

import hackstreet.sixeswild.config.ReleaseLevelConfig;
import hackstreet.sixeswild.config.SavedLevelData;

public class ReleaseLevel extends AbstractLevel {

	private int numMovesLeft;
	
	public ReleaseLevel(SavedLevelData savedLevelData) {
		super(savedLevelData);
		if (savedLevelData.getLevelConfig() instanceof ReleaseLevelConfig){
			numMovesLeft = (((ReleaseLevelConfig) savedLevelData.getLevelConfig()).getNumMoves());
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
	public void handlePostMove() {
		this.decreaseNumMovesLeft();
		//TODO Win/Lose conditions
	}

}