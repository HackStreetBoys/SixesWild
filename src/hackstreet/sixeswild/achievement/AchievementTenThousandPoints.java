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
 * @author Tim
 */
public class AchievementTenThousandPoints extends AbstractAchievement {

	public AchievementTenThousandPoints() {
		this(false,null);
	}
	
	public AchievementTenThousandPoints(boolean achieved, Date dateAchieved) {
		super(achieved, dateAchieved);
		super.name = "That's a metric fuck-ton of points";
		super.description = "Make a move worth over 10000 points";
	}

	@Override
	public boolean isAchieved(SixesWild model) {
		
		AbstractLevel level = model.getLevel();
		Stack<AbstractGameMove> moveStack = level.getMoveStack();
		
		
		if (moveStack.peek() instanceof StandardMove) {
			StandardMove latestMove = (StandardMove) moveStack.peek();
			
			int scoreForMove =  latestMove.getScore();
			
			if (scoreForMove >= 10000) {
				super.achieved = true;
				super.dateAchieved = new Date();
				return true;
			}
		}
		
		return false;
	}


}
