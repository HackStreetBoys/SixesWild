package hackstreet.sixeswild.move;

import hackstreet.sixeswild.SixesWild;
import hackstreet.sixeswild.game.Tile;
import hackstreet.sixeswild.level.AbstractLevel;

/**
 * Move: Swap two Tiles given their Slots.
 * 
 * @author Nicholas
 *
 */
public class SwapTilesMove extends AbstractGameMove {

	/**
	 * SwapTilesMove constructor.
	 * @param level The current level being played.
	 */
	public SwapTilesMove(SixesWild model, AbstractLevel level) {
		super(model,level);
	}

	@Override
	public boolean isValid() {
		return (level.getSelectedSlots().size() == 2);
	}

	@Override
	public void doMove() {
		if (this.isValid()){
			Tile tempTile;
			tempTile = level.getSelectedSlots().get(0).getTile();
			level.getSelectedSlots().get(0).setTile(level.getSelectedSlots().get(1).getTile());
			level.getSelectedSlots().get(1).setTile(tempTile);
		}
		level.getSelectedSlots().clear();
		super.manageAchievements();
	}

}
