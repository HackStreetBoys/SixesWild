package hackstreet.sixeswild.move;

import java.util.List;

import hackstreet.sixeswild.SixesWild;
import hackstreet.sixeswild.achievement.AbstractAchievement;
import hackstreet.sixeswild.level.AbstractLevel;

/**
 * Different game moves have different implementations,
 * but each of them have validation, execution, and a 
 * list of slots the move is performed on.
 * 
 * @author Nicholas
 *
 */
public abstract class AbstractGameMove {
	
	SixesWild model;
	
	/** Current level being played. */
	AbstractLevel level;
	
	/**
	 * Different game moves have different implementations,
	 * but each of them have validation, execution, and a 
	 * list of slots the move is performed on.
	 * @param level The current level being played.
	 */
	public AbstractGameMove(SixesWild model, AbstractLevel level){
		this.model = model;
		this.level = level;
	}
	
	public void manageAchievements(){
		List<AbstractAchievement> achievements = model.updateAchievements();
		for(AbstractAchievement a:achievements){
			//TODO manage achievement stuff
		}
	}
	
	public abstract boolean isValid();
	public abstract void doMove();
}
