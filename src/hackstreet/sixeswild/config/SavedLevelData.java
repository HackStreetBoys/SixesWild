package hackstreet.sixeswild.config;

/**
 * Stores a player's accomplishments on a specific level
 * (whether it is unlocked, and how many stars were earned).
 * <p>
 * This class is saved to disk.
 * @author Nicholas
 *
 */
public class SavedLevelData {

	AbstractLevelConfig config;
	boolean isUnlocked;
	int starsEarned;
	
	/**
	 * SavedLevelData constructor;
	 * @param config
	 */
	public SavedLevelData(AbstractLevelConfig config){
		this.config = config;
		this.isUnlocked = false;
		this.starsEarned = 0;
	}
	
	public AbstractLevelConfig getLevelConfig() {
		return config;
	}

	public void setConfig(AbstractLevelConfig config) {
		this.config = config;
	}

	public boolean isUnlocked() {
		return isUnlocked;
	}

	public void setUnlocked(boolean isUnlocked) {
		this.isUnlocked = isUnlocked;
	}

	public int getStarsEarned() {
		return starsEarned;
	}

	public void setStarsEarned(int starsEarned) {
		this.starsEarned = starsEarned;
	}

}
