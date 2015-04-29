package hackstreet.sixeswild.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Handles automatic move calculations.
 * 
 * @author Nicholas
 *
 */
public class AI {

	/** A copy of the ActiveLevel's board of Slots. */
	HashMap<Location, Slot> board;
	
	/**
	 * AI constructor.
	 * @param board The game board from the ActiveLevel.
	 */
	public AI(HashMap<Location, Slot> board){
		this.board = board;
	}
	
	/**
	 * Calculates a valid move and returns all of the slots included in it.
	 *  
	 * @return ArrayList<Slot>
	 */
	public ArrayList<Location> calculateValidMove(){
		ArrayList<Location> answer = null;
		
		// run starting on each tile, and return first answer found
		for (Location loc : board.keySet()){
			if (!(board.get(loc) instanceof EliminationSlot) && !(board.get(loc) instanceof InertSlot)){
				answer = findValidMoveFromLoc(loc, new ArrayList<Location>(Arrays.asList(loc)));
				if (answer != null)
					break;
			}
		}
		
		// print out answer
		System.out.println("============| AI |============");
		for (Location loc : answer){
			System.out.println(loc.toString());
		}
		
		return answer;
	}
	
	/**
	 * If the passed Location can be part of a valid StandardMove, then return
	 * a set of Slots that constitute a valid move.
	 * 
	 * @param inLoc The Location in question.
	 * @param alreadySelected The Location list already part of the move.
	 * @return ArrayList<Location>
	 */
	public ArrayList<Location> findValidMoveFromLoc(Location inLoc, ArrayList<Location> alreadySelected){
		
		ArrayList<Location> answer = null;
		
		// calculate the current value of all the selected slots
		int currentValue = 0;
		for (Location selectedLoc : alreadySelected){
			currentValue += board.get(selectedLoc).getTile().getValue();
		}
		
		// explore every path in the adjacent locations
		for (Location adj : this.getAllAdjacentLocations(inLoc, alreadySelected)){
			
			int adjValue = board.get(adj).getTile().getValue();
			
			// Found a valid move: RETURN
			if (currentValue + adjValue == 6){
				alreadySelected.add(adj);
				answer = alreadySelected;
				break;
			}
			// Found a possible path to a valid move: CONTINUE RECURSION
			else if (currentValue + adjValue < 6){
				alreadySelected.add(adj);
				answer = findValidMoveFromLoc(adj, alreadySelected);
			}
			// Found a dead path: return null
			else{
				answer = null;
				break;
			}
		}
		return answer;
	}
	
	/**
	 * Gets the raw adjacent locations of a loc, and then filters to make sure
	 * that none of them are Inert, Elimination, or already added.
	 * 
	 * @param inLoc The Location in question.
	 * @param alreadySelected The Location list already part of the move.
	 * @return a list of all valid adjacent Locations to the selected Location
	 */
	private ArrayList<Location> getAllAdjacentLocations(Location inLoc, ArrayList<Location> alreadySelected){

		ArrayList<Location> answer = new ArrayList<Location>();
		ArrayList<Location> candidates = inLoc.getRawAdjacentLocations();

		for (Location loc : candidates){

			// do not add location to answer if the loc is Inert, Elimination, or already added
			if ( !(board.get(loc) instanceof InertSlot) && !(board.get(loc) instanceof EliminationSlot) && 
					!alreadySelected.contains(loc) && !answer.contains(loc)){
				answer.add(loc);
			}
		}
		
		return answer;
	}
}
