package hackstreet.sixeswild.move;

import hackstreet.sixeswild.SixesWild;
import hackstreet.sixeswild.game.EliminationSlot;
import hackstreet.sixeswild.game.Slot;
import hackstreet.sixeswild.level.AbstractLevel;

/**
 * Move: Remove the selected Tile, then repopulate.
 * @author Nicholas, Pat
 *
 */
public class RemoveTileMove extends AbstractGameMove {

	/**
	 * RemoveTileMove constructor.
	 * @param level The current level being played.
	 */
	public RemoveTileMove(SixesWild model, AbstractLevel level) {
		super(model,level);
	}

	@Override
	public boolean isValid() {
		return level.getSelectedSlots().size()==1;
	}

	@Override
	public boolean doMove() {
		boolean valid = this.isValid();
		if (valid) {
			Slot slot = level.getSelectedSlots().get(0);
			if(slot instanceof EliminationSlot){
				EliminationSlot eSlot = (EliminationSlot)slot;
				eSlot.setEliminated();
			}
			slot.setTile(null);
			level.repopulateSlots();
			level.setRemoveMoveSelected(false);
		}
		level.getSelectedSlots().clear();
		return valid;
	}
}
