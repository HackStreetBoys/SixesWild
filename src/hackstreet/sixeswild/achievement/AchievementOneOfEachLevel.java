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
		this(false,null);
	}
	
	public AchievementOneOfEachLevel(boolean achieved, Date dateAchieved) {
		super(achieved, dateAchieved);
		super.name = "Tried em' all";
		super.description = "Complete a level of each type";
		super.imgPath = "images/pat-achievement.png";
	}

	@Override
	public boolean isAchieved(SixesWild model) {
		
		boolean completedPuzzle = false;
		boolean completedElimination = false;
		boolean completedRelease = false;
		boolean completedLightning = false;
		
		ArrayList<SavedLevelData> list = model.getSavedLevelDataList();
		
		for (SavedLevelData s: list) {
			if (s.getStarsEarned() > 0 || s.getLevelConfig().getType().equals("Puzzle")) {
				completedPuzzle = true;
				
			}
			else if (s.getStarsEarned() > 0 || s.getLevelConfig().getType().equals("Elimination")) {
				completedElimination = true;
				
			}
			else if (s.getStarsEarned() > 0 || s.getLevelConfig().getType().equals("Release")) {
				completedRelease = true;
				
			}
			else if (s.getStarsEarned() > 0 || s.getLevelConfig().getType().equals("Lightning")) {
				completedLightning = true;
				
			}
			
			if (completedPuzzle && completedElimination && completedRelease && completedLightning) {
				this.achieved = true;
				this.dateAchieved = new Date();
				return true;
			}
			
		}
		
		return false;

	}
	
}

