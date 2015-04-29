package hackstreet.sixeswild.move;

import hackstreet.sixeswild.game.Slot;
import hackstreet.sixeswild.level.AbstractLevel;

/**
 * Move: If the selected tiles add up to 6, then remove them,
 * adjust the score, and repopulate the board.
 * 
 * @author Nicholas
 *
 */
public class StandardMove extends AbstractGameMove {

	/**
	 * StandardMove constructor.
	 * @param level
	 */
	public StandardMove(AbstractLevel level) {
		super(level);
	}

	@Override
	public boolean isValid() {
		int sum = 0;
		for (Slot slot : level.getSelectedSlots()){
			sum += slot.getTile().getValue();
		}
		return (sum == 6);
	}

	@Override
	public void doMove() {
		System.out.println("Attempting to execute standard move");
		if (this.isValid()){
			System.out.println("Move is Valid");
			// adjust the score
			int scoreIncrease = 0;
			int scoreMultiplier = 1;
			for (Slot slot : level.getSelectedSlots()){
				scoreIncrease += slot.getTile().getValue();
				scoreMultiplier *= slot.getTile().getMultiplier();
			}
			level.addPointsEarned(scoreIncrease * scoreMultiplier);
			
			// remove tiles
			for (Slot slot : level.getSelectedSlots()){
				slot.setTile(null);
			}
			level.repopulateSlots();
		}
		else
			System.out.println("Move is not valid");

		level.getSelectedSlots().clear();
	}

}
