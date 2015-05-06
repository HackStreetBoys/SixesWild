package hackstreet.sixeswild.move;

import java.util.ArrayList;

import hackstreet.sixeswild.SixesWild;
import hackstreet.sixeswild.game.Location;
import hackstreet.sixeswild.gui.GridView;
import hackstreet.sixeswild.gui.SWApplication;
import hackstreet.sixeswild.level.AbstractLevel;
import hackstreet.sixeswild.gui.game.ActiveGameScreen;

/**
 * Move: display a tile that can be used in a move.
 * @author Nicholas, Pat
 *
 */
public class HintMove extends AbstractGameMove {

	SWApplication application;
	
	/**
	 * HintMove constructor.
	 * @param level The current level being played.
	 */
	public HintMove(SixesWild model, AbstractLevel level, SWApplication application) {
		super(model,level);
		this.application = application;
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
	public boolean doMove() {
		System.out.println("Attempting to execute HINT move");
		if (this.isValid()) {
			System.out.println("Move is valid");
			
			ArrayList<Location> anyValidMove = new ArrayList<Location>();
			anyValidMove = level.getAi().calculateValidMove();
			
			GridView gridView = ((ActiveGameScreen) (application.getActiveScreen())).getGridView();
			
			// change display of tile briefly
			for (Location hintLoc : anyValidMove){
				gridView.getSlotView(hintLoc).blink();
			}
			
			
			level.setAISelected(false);
		}
		else{
			System.out.println("Move is not valid");
			return false;
		}
		level.getSelectedSlots().clear();
		return true;
	}

}
