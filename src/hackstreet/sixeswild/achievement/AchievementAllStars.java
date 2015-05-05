package hackstreet.sixeswild.achievement;

import hackstreet.sixeswild.SixesWild;
import hackstreet.sixeswild.config.SavedLevelData;
import java.util.ArrayList;
import java.util.Date;
/**
 * Achievement received for getting three stars in all available levels.
 * 
 * @author Tim 
 *
 */
public class AchievementAllStars extends AbstractAchievement {

	public AchievementAllStars() {
		this(false,null);
	}
	
	public AchievementAllStars(boolean achieved, Date dateAchieved) {
		super(achieved, dateAchieved);
		super.name = "True all-star";
		super.description = "Complete all available levels with three stars";
		super.imgPath = "images/himanshu-achievement.png";
	}

	@Override
	public boolean isAchieved(SixesWild model) {
		
		ArrayList<SavedLevelData> list = model.getSavedLevelDataList();
		
		for (SavedLevelData s: list) {
			if (s.getStarsEarned() != 3) {
				return false;
			}
		}
		
		this.achieved = true;
		this.dateAchieved = new Date();
		
		return this.achieved;
	}

}

