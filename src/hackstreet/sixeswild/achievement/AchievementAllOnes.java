package hackstreet.sixeswild.achievement;

import hackstreet.sixeswild.SixesWild;
import hackstreet.sixeswild.level.AbstractLevel;
import hackstreet.sixeswild.move.AbstractGameMove;
import hackstreet.sixeswild.move.StandardMove;

import java.util.Date;
import java.util.Stack;

/**
 * Achievement class for achievement achieved a move of just ones has been made.
 * Completed here means that it is unlocked and at least one star has been earned.
 * 
 * @author Tim 
 *
 */
public class AchievementAllOnes extends AbstractAchievement {

	public AchievementAllOnes(boolean achieved, Date dateAchieved) {
		super(achieved, dateAchieved);
		super.name = "Six ones in one move";
	}

	@Override
	public boolean isAchieved(SixesWild model) {
		
		AbstractLevel level = model.getLevel();
		Stack<AbstractGameMove> moveStack = level.getMoveStack();
		
		// if latest move was a standard move determine if it used 6 slots (i.e 6 1-tiles)
		if (moveStack.peek() instanceof StandardMove) {
			StandardMove latestMove = (StandardMove) moveStack.peek();
			
			if (latestMove.getSlotsInMove().size() == 6) {
				super.achieved = true;
				super.dateAchieved = new Date();
				return super.achieved;
			}
		}
		
		return false;
	}

}
