/**
 * 
 */
package hackstreet.sixeswild.achievement;

import hackstreet.sixeswild.SixesWild;
import hackstreet.sixeswild.level.AbstractLevel;
import hackstreet.sixeswild.move.AbstractGameMove;
import hackstreet.sixeswild.move.StandardMove;

import java.util.Date;
import java.util.Stack;

/**
 * @author Tim Petri
 */
public class AchievementThousandPointMove extends AbstractAchievement {

	public AchievementThousandPointMove() {
		this(false,null);
	}
	
	public AchievementThousandPointMove(boolean achieved, Date dateAchieved) {
		super(achieved, dateAchieved);
		super.name = "That's a ton of points";
		super.description = "Make a move worth over 1000 points";
		super.imgPath = "images/wpi-achievement.png";
	}

	@Override
	public boolean isAchieved(SixesWild model) {
		
		AbstractLevel level = model.getLevel();
		Stack<AbstractGameMove> moveStack = level.getMoveStack();
		
		
		if (!moveStack.isEmpty() && moveStack.peek() instanceof StandardMove) {
			StandardMove latestMove = (StandardMove) moveStack.peek();
			
			int scoreForMove =  latestMove.getScore();
			
			if (scoreForMove >= 1000) {
				super.achieved = true;
				super.dateAchieved = new Date();
				return true;
			}
		}
		
		return false;
	}


}
