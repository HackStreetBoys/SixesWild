package hackstreet.sixeswild.move;

import java.util.ArrayList;
import hackstreet.sixeswild.game.Location;
import hackstreet.sixeswild.level.AbstractLevel;

/**
 * Move: display a tile that can be used in a move.
 * @author Nicholas
 *
 */
public class HintMove extends AbstractGameMove {

	/**
	 * HintMove constructor.
	 * @param level The current level being played.
	 */
	public HintMove(AbstractLevel level) {
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
		return level.getSelectedSlots().size()==0;
	}

	@Override
	public void doMove() {
		System.out.println("Attempting to execute HINT move");
		if (this.isValid()) {
			System.out.println("Move is valid");
			
			ArrayList<Location> anyValidMove = new ArrayList<Location>();
			anyValidMove = level.getAi().calculateValidMove();
			// change display of tile
			// anyValidMove.get(0)
			
			level.setAISelected(false);
		}
		else
			System.out.println("Move is not valid");
		level.getSelectedSlots().clear();
	}

}
