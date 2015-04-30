package hackstreet.sixeswild.achievement;

import hackstreet.sixeswild.SixesWild;
import hackstreet.sixeswild.config.SavedLevelData;

import java.util.ArrayList;
import java.util.Date;

/**
 * Achievement class for achievement achieved when first level in game has been completed.
 * Completed here means that it is unlocked and at least one star has been earned.
 * 
 * @author Tim 
 *
 */
public class AchievementFirstLevelCompleted extends AbstractAchievement {

	public AchievementFirstLevelCompleted(boolean achieved, Date dateAchieved) {
		super(achieved, dateAchieved);
		super.name = "First level completed";
	}

	@Override
	public boolean isAchieved(SixesWild model) {
		ArrayList<SavedLevelData> list = model.getSavedLevelDataList();
		
		SavedLevelData s = list.get(0);
		if (s.getStarsEarned() == 0 || !s.isUnlocked()) {
				return false;
		}
		
		this.achieved = true;
		this.dateAchieved = new Date();
		
		return this.achieved;
	}

}
