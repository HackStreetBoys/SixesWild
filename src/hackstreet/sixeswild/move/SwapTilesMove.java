package hackstreet.sixeswild.move;

import java.util.ArrayList;
import hackstreet.sixeswild.game.Slot;
import hackstreet.sixeswild.game.Tile;

/**
 * Move: Swap two Tiles given their Slots.
 * 
 * @author Nicholas
 *
 */
public class SwapTilesMove extends AbstractGameMove {

	public SwapTilesMove(ArrayList<Slot> selectedSlots){
		super(selectedSlots);
	}

	@Override
	public boolean isValid() {
		return (this.selectedSlots.size() == 2);
	}

	@Override
	public void doMove() {
		if (this.isValid()){
			Tile tempTile;
			tempTile = selectedSlots.get(0).getTile();
			selectedSlots.get(0).setTile(selectedSlots.get(1).getTile());
			selectedSlots.get(1).setTile(tempTile);
			// TODO repaint grid;
		}
		else
			throw new IllegalStateException();
	}

}
