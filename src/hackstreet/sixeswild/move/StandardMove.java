package hackstreet.sixeswild.move;

import java.util.ArrayList;

import hackstreet.sixeswild.game.Slot;
import hackstreet.sixeswild.level.AbstractLevel;

/**
 * Move: If the selected tiles add up to 6, then remove them,
 * adjust the score, and repopulate the board.
 * 
 * @author Tim, Nicholas
 *
 */
public class StandardMove extends AbstractGameMove {

	/** Slots involved with move. */
	ArrayList<Slot> slotsInvolvedInMove;
	
	/**
	 * StandardMove constructor.
	 * @param level
	 */
	public StandardMove(AbstractLevel level) {
		super(level);
		this.slotsInvolvedInMove = new ArrayList<Slot>();
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
		if (this.isValid()){
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
				slotsInvolvedInMove.add(slot);
				slot.setTile(null);
			}
			level.repopulateSlots();
		}

		level.getSelectedSlots().clear();
	}
	
	public ArrayList<Slot> getSlotsInMove() {
		return this.slotsInvolvedInMove;
	}

}
