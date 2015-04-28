package hackstreet.sixeswild.move;

import java.util.ArrayList;
import hackstreet.sixeswild.game.Slot;

/**
 * Different game moves have different implementations,
 * but each of them have validation, execution, and a 
 * list of slots the move is performed on.
 * 
 * @author Nicholas
 *
 */
public abstract class AbstractGameMove {
	
	/** List of selected Slots. */
	ArrayList<Slot> selectedSlots;
	
	public AbstractGameMove(ArrayList<Slot> selectedSlots){
		this.selectedSlots = selectedSlots;
	}
	
	public abstract boolean isValid();
	public abstract void doMove();
}
