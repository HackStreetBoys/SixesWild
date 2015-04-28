package hackstreet.sixeswild.move;

import hackstreet.sixeswild.game.Slot;

/**
 * Move: Swap two Tiles given their Slots.
 * 
 * @author Nicholas
 *
 */
public class SwapTilesMove extends AbstractGameMove {

	public SwapTilesMove(Slot selectedSlots[]){
		super(selectedSlots);
	}

	@Override
	public boolean isValid() {
		return (selectedSlots.length == 2);
	}

	@Override
	public void doMove() {
		if (this.isValid()){
			Tile tempTile = new Tile();
			tempTile = selectedSlots.get(0).getTile();
			selectedSlots.get(0).setTile(selectedSlots.get(1).getTile());
			selectedSlots.get(1).setTile(tempTile);
			// repaint grid;
		}
		else
			throw new IllegalStateException();
	}

}
