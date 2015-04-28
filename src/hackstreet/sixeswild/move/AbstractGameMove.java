package hackstreet.sixeswild.move;

import hackstreet.sixeswild.level.AbstractLevel;

/**
 * Different game moves have different implementations,
 * but each of them have validation, execution, and a 
 * list of slots the move is performed on.
 * 
 * @author Nicholas
 *
 */
public abstract class AbstractGameMove {
	
	/** Current level being played. */
	AbstractLevel level;
	
	/**
	 * Different game moves have different implementations,
	 * but each of them have validation, execution, and a 
	 * list of slots the move is performed on.
	 * @param level The current level being played.
	 */
	public AbstractGameMove(AbstractLevel level){
		this.level = level;
	}
	
	public abstract boolean isValid();
	public abstract void doMove();
}
