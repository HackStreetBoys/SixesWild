package hackstreet.sixeswild.move;

import hackstreet.sixeswild.game.EliminationSlot;
import hackstreet.sixeswild.game.InertSlot;
import hackstreet.sixeswild.game.Location;
import hackstreet.sixeswild.game.Slot;
import hackstreet.sixeswild.level.AbstractLevel;
import java.util.Map;

/**
 * 
 * @author Nicholas
 *
 */
public class ShuffleBoardMove extends AbstractGameMove {

	/**
	 * ShuffleBoardMove constructor.
	 * @param level The current level being played.
	 */
	public ShuffleBoardMove(AbstractLevel level) {
		super(level);
	}

	@Override
	public boolean isValid() {
		return (level.getSelectedSlots().size() == 0);
	}

	@Override
	public void doMove() {
		if (this.isValid()){
			// set all Slots that are not EliminationSlot or InertSlot to have a NULL tile
			for (Map.Entry<Location, Slot> entry : level.getBoard().entrySet()){
				if (!(entry instanceof EliminationSlot || entry instanceof InertSlot)){
					entry.getValue().setTile(null);
				}
			}
			level.repopulateSlots();
			
			// TODO repaint
		}
		else
			throw new IllegalStateException();
	}

}
