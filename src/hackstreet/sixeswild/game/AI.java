package hackstreet.sixeswild.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * Generates a list of board moves (a max of one from each origin Location)
 * and then picks one from the list to return.
 * 
 * Handles automatic move calculations.
 * 
 * @author Nicholas
 *
 */
public class AI {

	/** A copy of the ActiveLevel's board of Slots. */
	HashMap<Location, Slot> board;
	
	/** A list of possible moves to choose from */
	ArrayList<ArrayList<Location>> moveList;
	
	/**
	 * AI constructor.
	 * @param board The game board from the ActiveLevel.
	 */
	public AI(HashMap<Location, Slot> board){
		this.board = board;
		this.moveList = new ArrayList<ArrayList<Location>>();
	}
	
	/**
	 * Calculates a valid move and returns all of the slots included in it.
	 *  
	 * @return ArrayList<Slot>
	 */
	public ArrayList<Location> calculateValidMove(){

		
		System.out.println("============| AI |============");
		
		ArrayList<Location> answer = null;
		
		// each time you want a different order.
		ArrayList<Location> keyList = new ArrayList<Location>();
		keyList.addAll(board.keySet());
		Collections.shuffle(keyList);
		
		// run starting on each tile, and return first answer found
		for (Location loc : keyList){
			if (!(board.get(loc) instanceof BucketSlot) && !(board.get(loc) instanceof InertSlot)){
				answer = findValidMoveFromLoc(loc, new ArrayList<Location>(Arrays.asList(loc)));
				if (answer != null){
					if (!moveList.contains(answer)){
						moveList.add(answer);
						break;
					}
				}
			}
		}
		
		// print out answer
		
		if (answer == null){
			System.out.println("AI ERROR: No valid moves in board");
			//return null;
		}
		else{
			/*
			for (ArrayList<Location> list : moveList){
				for (Location loc : list){
					System.out.println(loc.toString());
				}
			}
			*/
		}
		
		return moveList.get(moveList.size()-1);
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
		
		System.out.println("Analyze: " + inLoc.toString());
		ArrayList<Location> answer = null;
		
		// calculate the current value of all the selected slots
		int currentValue = this.sumLocations(alreadySelected);
		
		// explore every path in the adjacent locations
		for (Location adj : this.getAllAdjacentLocations(inLoc, alreadySelected)){
			
			System.out.println("	Analyze adj: " + adj.toString());
			
			int adjValue = board.get(adj).getTile().getValue();
			currentValue = this.sumLocations(alreadySelected);
			
			// Found a valid move: RETURN
			if (currentValue + adjValue == 6){
				System.out.println("	Move discovered!");
				alreadySelected.add(adj);
				answer = alreadySelected;
				break;
			}
			// Found a possible path to a valid move: CONTINUE RECURSION
			else if (currentValue + adjValue < 6){
				System.out.println("		Add: " + adj.toString());
				alreadySelected.add(adj);
				answer = findValidMoveFromLoc(adj, alreadySelected);
				if (this.sumLocations(alreadySelected)==6)
					break;
				else{
					alreadySelected.remove(adj);
					continue;
				}
					
			}
			// Found a dead path: keep searching through the list
			else{
				System.out.println("		Dead: " + adj.toString());
				answer = null;
				continue;
			}
			
		}
		System.out.println();
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
			if ( !(board.get(loc) instanceof InertSlot) && !(board.get(loc) instanceof BucketSlot) && 
					!alreadySelected.contains(loc) && !answer.contains(loc)){
				answer.add(loc);
			}
		}
		
		return answer;
	}
	
	/**
	 * Sums all the values of a Location list.
	 * @param list
	 * @return int
	 */
	private int sumLocations(ArrayList<Location> list){
		int currentValue = 0;
		for (Location selectedLoc : list){
			currentValue += board.get(selectedLoc).getTile().getValue();
		}
		return currentValue;
	}
}
