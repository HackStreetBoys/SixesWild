package hackstreet.sixeswild.achievement;

import hackstreet.sixeswild.SixesWild;

import java.util.Date;

/**
 * Abstract class for an achievement.
 * 
 * @author Tim 
 *
 */
public abstract class AbstractAchievement {
	protected String name;
	protected boolean achieved;
	protected Date dateAchieved;
	
	public abstract boolean isAchieved(SixesWild model);
	
	public AbstractAchievement(boolean achieved, Date dateAchieved) {
		// names are set in subclasses
		this.achieved = achieved;
		this.dateAchieved = dateAchieved;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String s) {
		this.name = s;
	}
	
	public boolean getAchieved() {
		return this.achieved;
	}
	
	public void setAchieved(boolean b) {
		this.achieved = b;
	}
	
	public Date getDateAchieved() {
		return this.dateAchieved;
	}
	
	public void setDateAchieved(Date d) {
		this.dateAchieved = d;
	}
	
	
	
	
	
}
