package hackstreet.sixeswild.level;

import java.util.ArrayList;

import hackstreet.sixeswild.config.ReleaseLevelConfig;
import hackstreet.sixeswild.config.SavedLevelData;
import hackstreet.sixeswild.game.BucketSlot;
import hackstreet.sixeswild.game.InertSlot;
import hackstreet.sixeswild.game.Location;
import hackstreet.sixeswild.game.Slot;
import hackstreet.sixeswild.game.Tile;

public class ReleaseLevel extends AbstractLevel {

	private boolean initializing = true;
	private int numMovesLeft;
	
	public ReleaseLevel(SavedLevelData savedLevelData) {
		super(savedLevelData);
		if (savedLevelData.getLevelConfig() instanceof ReleaseLevelConfig){
			numMovesLeft = (((ReleaseLevelConfig) savedLevelData.getLevelConfig()).getNumMoves());
		}
		else
			throw new IllegalArgumentException();
	}

	public int getNumMovesLeft() {
		return numMovesLeft;
	}

	public void decreaseNumMovesLeft() {
		this.numMovesLeft--;
	}

	@Override
	public void handlePostMove() {
		this.decreaseNumMovesLeft();
		//TODO Win/Lose conditions
	}

	@Override
	protected void initBoard(ArrayList<Location> inertLocs){
		ReleaseLevelConfig config = (ReleaseLevelConfig)super.getSavedLevelData().getLevelConfig();
		for(int row=0; row<9; row++){
			for(int col=0; col<9; col++){
				Location loc = new Location(col,row);
				if(inertLocs.contains(loc))
					super.getBoard().put(loc, new InertSlot(loc));
				else if(config.getBucketLocations().contains(loc))
					super.getBoard().put(loc, new BucketSlot(loc));
				else
					super.getBoard().put(loc, new Slot(loc));
			}
		}
	}

	@Override
	public void populateBoard(){
		// go over each column
		for (int col = 0; col < 9; col++) {

			// repopulate each cell
			for (int row = 0; row < 9; row++) {

				Location loc = new Location(col,row);

				// if slot is not inert and does not have tile, give it a new tile
				Slot slot = super.getBoard().get(loc);
				if (!(slot instanceof InertSlot) && !(slot instanceof BucketSlot) && !(slot.hasTile())) {

					int val = this.generateRandomValue();
					ReleaseLevelConfig config = (ReleaseLevelConfig)super.getSavedLevelData().getLevelConfig();
					if(this.initializing && config.getSixLocations().contains(loc))
						val=6;
					
					int mult = this.generateRandomMultiplier();

					Tile t = new Tile(val, mult);
					super.getBoard().get(loc).setTile(t);

				}
			}
		}	
		this.initializing = false;
	}
}