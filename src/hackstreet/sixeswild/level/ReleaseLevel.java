package hackstreet.sixeswild.level;

import java.util.ArrayList;
import java.util.List;

import hackstreet.sixeswild.config.AbstractLevelConfig;
import hackstreet.sixeswild.config.ReleaseLevelConfig;
import hackstreet.sixeswild.config.SavedLevelData;
import hackstreet.sixeswild.game.BucketSlot;
import hackstreet.sixeswild.game.InertSlot;
import hackstreet.sixeswild.game.Location;
import hackstreet.sixeswild.game.Slot;
import hackstreet.sixeswild.game.Tile;

public class ReleaseLevel extends AbstractLevel {

	private boolean initializing;
	private int numMovesLeft;

	public ReleaseLevel(SavedLevelData savedLevelData) {
		super(savedLevelData);
		if (savedLevelData.getLevelConfig() instanceof ReleaseLevelConfig){
			numMovesLeft = (((ReleaseLevelConfig) savedLevelData.getLevelConfig()).getNumMoves());
			super.clearTiles();
			this.initializing = true;
			this.populateBoard();
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
	public int handlePostMove() {
		this.decreaseNumMovesLeft();
		ReleaseLevelConfig config = (ReleaseLevelConfig)super.getSavedLevelData().getLevelConfig();
		List<Location> buckets = config.getBucketLocations();
		boolean levelCleared = true;
		for(Location loc:buckets){
			BucketSlot slot = (BucketSlot)super.getBoard().get(loc);
			if(!slot.isOccupied())
				levelCleared = false;
		}
		int points1 = super.getSavedLevelData().getLevelConfig().getPointsStar1();
		if(levelCleared){
			if(super.getPointsEarned()>=points1){
				return 1;
			}
			else
				return -1;
		}
		
		if(this.numMovesLeft<=0){
			return -1;
		}
		return 0;
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
			for(int row = 0; row < 9; row++){
				Location loc = new Location(col,row);
				Slot slot = super.getBoard().get(loc);
				if(!(slot instanceof InertSlot || slot instanceof BucketSlot) && !slot.hasTile()){
					ReleaseLevelConfig config = (ReleaseLevelConfig)super.getSavedLevelData().getLevelConfig();
					double f1 = config.getFreq1();
					double f2 = config.getFreq2();
					double f3 = config.getFreq3();
					double f4 = config.getFreq4();
					double f5 = config.getFreq5();
					
					double mult2 = config.getFreqMult2();
					double mult3 = config.getFreqMult3();
					
					int value = 0;
					double rand = Math.random();
					if(rand<f1)
						value = 1;
					else if(rand<f1+f2)
						value = 2;
					else if(rand<f1+f2+f3)
						value = 3;
					else if(rand<f1+f2+f3+f4)
						value = 4;
					else if(rand<f1+f2+f3+f4+f5)
						value = 5;
					else
						value = 6;
				
					if(config.getSixLocations().contains(loc) && this.initializing)
						value = 6;
					
					rand = Math.random();
					int mult = 1;
					if(rand<mult2)
						mult = 2;
					else if(rand<mult2+mult3)
						mult = 3;
					
					Tile tile = new Tile(value,mult);
					slot.setTile(tile);
				}
			}
		}
		this.initializing = false;
	}

	@Override
	public void applyGravityInColumn(int col) {

		/*
		 * Handle InertSlots the same way plus following:
		 * Move sixes down to empty slots unless a bucket has been encountered in which case the sixes 
		 * are ignored and tiles above are used. When at a bucket, move six down if it is in the first
		 * non-empty slot. If other tile is found above, move focus to empty  slot above bucket.
		 */



		for (int row = 8; row > 0; row--) {
			Location loc = new Location(col, row);

			// if slot is not inert and does not have a tile, find one in column above to move down
			if (!(getBoard().get(loc) instanceof BucketSlot) && !(super.getBoard().get(loc) instanceof InertSlot) && !(super.getBoard().get(loc).hasTile())) {
				
				boolean noBucketAbove = true;

				// look through slots above
				for (int row2 = row-1; row2 >= 0; row2--) {
					Location loc2 = new Location(col, row2);

					// if this slot has a tile, move it down
					if (!(getBoard().get(loc2) instanceof InertSlot) && (super.getBoard().get(loc2).hasTile())) {
						
						// if no bucket has been encountered above, any tile can be moved (including six)
						if (noBucketAbove) {
							// copy down value to first slot
							super.getBoard().get(loc).setTile(super.getBoard().get(loc2).getTile());	
							// set tile in slot over to null
							super.getBoard().get(loc2).setTile(null);
							break;
						
						// if bucket has been encountered, only non-six tile can be moved down
						} else if (super.getBoard().get(loc2).getTile().getValue() != 6) {
							// copy down value to slot
							super.getBoard().get(loc).setTile(super.getBoard().get(loc2).getTile());	
							// set tile in slot over to null
							super.getBoard().get(loc2).setTile(null);
							break;
						}
					}
					// if slot is bucket, set noBucketAbove to false
					else if ((getBoard().get(loc2) instanceof BucketSlot)) {
						noBucketAbove = false;
					}
				}
			}
			else if ((super.getBoard().get(loc) instanceof BucketSlot) && !(((BucketSlot)super.getBoard().get(loc)).isOccupied())) {

				// look through slots above
				for (int row2 = row-1; row2 >= 0; row2--) {
					Location loc2 = new Location(col, row2);

					// if this slot has a tile, move it down
					if (!(getBoard().get(loc2) instanceof InertSlot) && (super.getBoard().get(loc2).hasTile())) {

						// Slot with tile has been found, if 6 move down, else stop all this shit
						if (super.getBoard().get(loc2).getTile().getValue() == 6) {
							// copy down value to first slot
							((BucketSlot)super.getBoard().get(loc)).setOccupied();	
							// set tile in slot over to null
							super.getBoard().get(loc2).setTile(null);
						}
						break;
					}
				}
			}
			
		}

	}
}