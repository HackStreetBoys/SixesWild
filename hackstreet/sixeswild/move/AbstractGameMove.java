package hackstreet.sixeswild.move;

import hackstreet.sixeswild.game.Slot;

/**
 * 
 * 
 * @author Nicholas
 *
 */
public abstract class AbstractGameMove {
	
	/** List of selected Slots. */
	ArrayList<Slot> selectedSlots;
	
	public AbstractGameMove(Slot selectedSlots[]){
		this.selectedSlots = selectedSlots;
	}
	
	public abstract boolean isValid();
	public abstract void doMove();
}
