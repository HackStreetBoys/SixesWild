package hackstreet.sixeswild.move;

import hackstreet.sixeswild.SixesWild;
import hackstreet.sixeswild.level.AbstractLevel;

/**
 * Move: Remove the selected Tile, then repopulate.
 * @author Nicholas
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
		if (this.isValid()) {
			level.getSelectedSlots().get(0).setTile(null);
			level.repopulateSlots();
			level.setRemoveMoveSelected(false);
		}
		level.getSelectedSlots().clear();
		return this.isValid();
	}
}
