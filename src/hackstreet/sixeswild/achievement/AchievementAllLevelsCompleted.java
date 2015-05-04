package hackstreet.sixeswild.achievement;

import hackstreet.sixeswild.SixesWild;
import hackstreet.sixeswild.config.SavedLevelData;

import java.util.ArrayList;
import java.util.Date;

/**
 * Achievement class for achievement achieved when all levels in game have been completed.
 * Completed here means that it is unlocked and at least one star has been earned.
 * 
 * @author Tim 
 *
 */
public class AchievementAllLevelsCompleted extends AbstractAchievement {
	
	public AchievementAllLevelsCompleted() {
		super(false, null);
		super.name = "All levels competed";
	}
	
	public AchievementAllLevelsCompleted(boolean achieved, Date dateAchieved) {
		super(achieved, dateAchieved);
		super.name = "All levels competed";
	}


	@Override
	public boolean isAchieved(SixesWild model) {
		
		ArrayList<SavedLevelData> list = model.getSavedLevelDataList();
		
		for (SavedLevelData s: list) {
			if (s.getStarsEarned() == 0 || !s.isUnlocked()) {
				return false;
			}
		}
		
		this.achieved = true;
		this.dateAchieved = new Date();
		
		return this.achieved;

	}
	
	
	
	
	
	
	
}
