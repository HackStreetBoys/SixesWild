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
		if(level == null)
			System.out.println("LEVEL NULL");
		else if(level.getSelectedSlots() == null)
			System.out.println("SELECTED NULL");
		else
			System.out.println("NEITHER NULL");
		return level.getSelectedSlots().size()==1;
	}

	@Override
	public void doMove() {
		System.out.println("Attempting to execute remove move");
		if (this.isValid()) {
			System.out.println("Move is valid");
			level.getSelectedSlots().get(0).setTile(null);
			level.repopulateSlots();
			level.setRemoveMoveSelected(false);
		}
		else
			System.out.println("Move is not valid");
		level.getSelectedSlots().clear();
	}
}
