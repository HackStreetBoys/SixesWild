package hackstreet.sixeswild.level;

import hackstreet.sixeswild.config.LightningLevelConfig;
import hackstreet.sixeswild.config.SavedLevelData;

/**
 * 
 * @author Nicholas
 *
 */
public class LightningLevel extends AbstractLevel {

	private int secondsLeft;
	
	/**
	 * 
	 * @param savedLevelData
	 */
	public LightningLevel(SavedLevelData savedLevelData) {
		super(savedLevelData);
		if (savedLevelData.getLevelConfig() instanceof LightningLevelConfig){
			this.secondsLeft =  ((LightningLevelConfig) savedLevelData.getLevelConfig()).getSeconds();
			
		}
		else
			throw new IllegalArgumentException();
	}
	
	public long getTimeLeft() {
		return this.secondsLeft;
	}

	@Override
	public void handlePostMove() {
		//TODO Check Win/Lose Conditions
	}
}
