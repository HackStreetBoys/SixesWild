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
	
	/** Name of achievement. */
	protected String name;
	
	/** Description of achievement. */
	protected String description;
	
	/** Has the achievement been achieved. */
	protected boolean achieved;
	
	/** Date achievement was achieved. */
	protected Date dateAchieved;
	
	/** Name of image that corresponds to this achievement */
	protected String imgPath;
	
	
	public abstract boolean isAchieved(SixesWild model);
	
	public AbstractAchievement(boolean achieved, Date dateAchieved) {
		// names are set in subclasses
		this.achieved = achieved;
		this.dateAchieved = dateAchieved;
		this.imgPath = "images/heineman-achievement.png";
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

	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String d) {
		this.description = d;
	}
	
	public String getImgPath() {
		return this.imgPath;
	}
	
	
	
	
}
