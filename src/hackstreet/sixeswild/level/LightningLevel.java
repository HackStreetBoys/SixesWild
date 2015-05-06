package hackstreet.sixeswild.level;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import hackstreet.sixeswild.config.LightningLevelConfig;
import hackstreet.sixeswild.config.SavedLevelData;

/**
 * 
 * @author Nicholas, Pat
 *
 */
public class LightningLevel extends AbstractLevel {

	private int secondsLeft;
	
	/**
	 * 
	 * @param savedLevelData
	 */
	public LightningLevel(SavedLevelData savedLevelData) {
		super(savedLevelData);
		if (savedLevelData.getLevelConfig() instanceof LightningLevelConfig){
			this.secondsLeft =  ((LightningLevelConfig) savedLevelData.getLevelConfig()).getSeconds();
			
		}
		else
			throw new IllegalArgumentException();
	}
	
	public void decrementTime(){
		this.secondsLeft--;
	}
	
	public int getTimeLeft() {
		return this.secondsLeft;
	}
	

	@Override
	public int handlePostMove() {
		if(this.secondsLeft<=0){
			int points1 = super.getSavedLevelData().getLevelConfig().getPointsStar1();
			if(super.getPointsEarned()>=points1){
				return 1;
			}
			else
				return -1;
		}
		return 0;
	}
}
