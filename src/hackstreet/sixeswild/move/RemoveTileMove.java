package hackstreet.sixeswild.move;

import hackstreet.sixeswild.game.Slot;

import java.util.ArrayList;

public class RemoveTileMove extends AbstractGameMove {

	public RemoveTileMove(ArrayList<Slot> selectedSlots) {
		super(selectedSlots);
	}

	@Override
	public boolean isValid() {
		return (this.selectedSlots.size() == 1);
	}

	@Override
	public void doMove() {
		if (this.isValid()){
			// TODO update board with gravity
		}
	}
}
