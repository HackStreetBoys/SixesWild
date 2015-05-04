/**
 * 
 */
package hackstreet.sixeswild.achievement;

import hackstreet.sixeswild.SixesWild;
import hackstreet.sixeswild.config.SavedLevelData;
import hackstreet.sixeswild.level.AbstractLevel;
import hackstreet.sixeswild.move.AbstractGameMove;
import hackstreet.sixeswild.move.StandardMove;

import java.util.ArrayList;
import java.util.Date;
import java.util.Stack;

/**
 * @author Tim Petri
 */
public class AchievementOneOfEachLevel extends AbstractAchievement {

	public AchievementOneOfEachLevel() {
		super(false, null);
		super.name = "Win one level of each type";
	}
	
	public AchievementOneOfEachLevel(boolean achieved, Date dateAchieved) {
		super(achieved, dateAchieved);
		super.name = "Win one level of each type";
	}

	@Override
	public boolean isAchieved(SixesWild model) {
		
		boolean completedPuzzle;
		boolean completedElimination;
		boolean completedRelease;
		boolean completedLightning;
		
		ArrayList<SavedLevelData> list = model.getSavedLevelDataList();
		
		for (SavedLevelData s: list) {
			if (s.getStarsEarned() > 0 || s.getLevelConfig().getType().equals("Puzzle")) {
				
			}
		}
		
		this.achieved = true;
		this.dateAchieved = new Date();
		
		return this.achieved;

	}
	
}

