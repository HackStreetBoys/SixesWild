package hackstreet.sixeswild.achievement;

import hackstreet.sixeswild.SixesWild;
import hackstreet.sixeswild.config.SavedLevelData;

import java.util.ArrayList;
import java.util.Date;

public class AchievementAllLevelsCompleted extends AbstractAchievement {
	
	
	
	public AchievementAllLevelsCompleted(boolean achieved, Date dateAchieved) {
		super(achieved, dateAchieved);
		this.name = "All levels competed";
	}


	@Override
	public boolean isAchieved(SixesWild model) {
		
		ArrayList<SavedLevelData> list = model.getSavedLevelDataList();
		
		for (SavedLevelData s: list) {
			if (s.getStarsEarned() == 0) {
				return false;
			}
		}
		
		this.achieved = true;
		this.dateAchieved = new Date();
		
		return this.achieved;

	}
	
	
	
	
	
	
	
}
