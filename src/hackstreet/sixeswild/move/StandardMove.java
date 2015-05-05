package hackstreet.sixeswild.move;

import java.util.ArrayList;

import hackstreet.sixeswild.SixesWild;
import hackstreet.sixeswild.game.EliminationSlot;
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
	
	/** Points associated with the move. */
	private int score;
	
	/**
	 * StandardMove constructor.
	 * @param level
	 */
	public StandardMove(SixesWild model, AbstractLevel level) {
		super(model,level);
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
	public boolean doMove() {
		boolean valid = this.isValid();
		if (valid){
			// adjust the score
			int scoreIncrease = 1;
			int scoreMultiplier = 1;
			for (Slot slot : level.getSelectedSlots()){
				scoreIncrease *= 2;
				scoreMultiplier *= slot.getTile().getMultiplier();
			}
			this.score = scoreIncrease*scoreMultiplier;
			level.addPointsEarned(this.score);
			
			// remove tiles
			for (Slot slot : level.getSelectedSlots()){
				slotsInvolvedInMove.add(slot);
				slot.setTile(null);
				if(slot instanceof EliminationSlot){
					EliminationSlot eSlot = (EliminationSlot)slot;
					eSlot.setEliminated();
				}
			}
			level.repopulateSlots();
		}		
		level.getSelectedSlots().clear();
		return valid;
	}
	
	public ArrayList<Slot> getSlotsInMove() {
		return this.slotsInvolvedInMove;
	}
	
	public int getScore() {
		return this.score;
	}

}
