package hackstreet.sixeswild.level;

import hackstreet.sixeswild.config.LightningLevelConfig;
import hackstreet.sixeswild.config.SavedLevelData;

/**
 * 
 * @author Nicholas
 *
 */
public class LightningLevel extends AbstractLevel {

	private long startTime;
	private long endTime;
	
	/**
	 * 
	 * @param savedLevelData
	 */
	public LightningLevel(SavedLevelData savedLevelData) {
		super(savedLevelData);
		if (savedLevelData.getLevelConfig() instanceof LightningLevelConfig){
			startTime = System.currentTimeMillis();
			endTime = startTime + 1000 * ((LightningLevelConfig) savedLevelData.getLevelConfig()).getSeconds();
		}
		else
			throw new IllegalArgumentException();
	}
	
	public long getEndTime() {
		return endTime;
	}
}
