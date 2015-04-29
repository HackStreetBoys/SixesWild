package hackstreet.sixeswild.move;

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
	public RemoveTileMove(AbstractLevel level) {
		super(level);
	}

	@Override
	public boolean isValid() {
		return level.getSelectedSlots().size()==1;
	}

	@Override
	public void doMove() {
		if (this.isValid()) {
			level.getSelectedSlots().get(0).setTile(null);
			level.repopulateSlots();
			level.setRemoveMoveSelected(false);
		}
		level.getSelectedSlots().clear();
	}
}
