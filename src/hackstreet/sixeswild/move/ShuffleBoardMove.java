package hackstreet.sixeswild.move;

import java.util.ArrayList;
import java.util.List;

import hackstreet.sixeswild.SixesWild;
import hackstreet.sixeswild.game.BucketSlot;
import hackstreet.sixeswild.game.InertSlot;
import hackstreet.sixeswild.game.Slot;
import hackstreet.sixeswild.game.Tile;
import hackstreet.sixeswild.level.AbstractLevel;

/**
 * 
 * @author Nicholas, Pat
 *
 */
public class ShuffleBoardMove extends AbstractGameMove {

	/**
	 * ShuffleBoardMove constructor.
	 * @param level The current level being played.
	 */
	public ShuffleBoardMove(SixesWild model, AbstractLevel level) {
		super(model,level);
	}

	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public boolean doMove() {
		if (this.isValid()){
			// set all Slots that are not Bucket Slot or InertSlot to have a NULL tile
			List<Slot> sixSlotCheck = new ArrayList<Slot>();
			List<Tile> tileList = new ArrayList<Tile>();
			for (Slot slot: level.getBoard().values()){
				if(slot.hasTile() && slot.getTile().getValue()==6)
					sixSlotCheck.add(slot);
				else if (!(slot instanceof InertSlot || slot instanceof BucketSlot)){
					tileList.add(slot.getTile());
					slot.setTile(null);
				}
			}

			int numSwaps = 200;
			for(int n=0; n<numSwaps; n++){
				int randomIndex = (int)(tileList.size()*Math.random());
				Tile temp = tileList.get(randomIndex);
				tileList.set(randomIndex,tileList.get(0));
				tileList.set(0,temp);
			}

			for (Slot slot: level.getBoard().values()){
				if(!(slot instanceof InertSlot || slot instanceof BucketSlot) && !sixSlotCheck.contains(slot))
					slot.setTile(tileList.remove(0));
			}
		}
		return this.isValid();
	}

}
