package hackstreet;

import static org.junit.Assert.*;
import hackstreet.sixeswild.SixesWild;
import hackstreet.sixeswild.SixesWildRunner;
import hackstreet.sixeswild.achievement.AbstractAchievement;
import hackstreet.sixeswild.achievement.AchievementAllLevelsCompleted;
import hackstreet.sixeswild.achievement.AchievementAllOnes;
import hackstreet.sixeswild.achievement.AchievementAllStars;
import hackstreet.sixeswild.achievement.AchievementFirstLevelCompleted;
import hackstreet.sixeswild.achievement.AchievementOneOfEachLevel;
import hackstreet.sixeswild.achievement.AchievementTenThousandPoints;
import hackstreet.sixeswild.achievement.AchievementThousandPointMove;
import hackstreet.sixeswild.config.SavedLevelData;
import hackstreet.sixeswild.controller.SwipeController;
import hackstreet.sixeswild.controller.ToGameScreenController;
import hackstreet.sixeswild.controller.ToLevelSelectScreenController;
import hackstreet.sixeswild.game.Location;
import hackstreet.sixeswild.gui.SWApplication;
import hackstreet.sixeswild.gui.game.ActiveGameScreen;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import org.junit.Test;

public class TestLightningLevel {

	@Test
	public void testStandardMove() {
	
		/*======================================================================================*/
		/*								MIMIC RUNNER											*/
		/*======================================================================================*/
		
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} 
		catch (Exception e) { 
			// none
		}

		SixesWildRunner.loadFonts();

		//SplashScreen splash = new SplashScreen(5000, "images/SixesWildSplashScreen.png");
		//---------PlaceHolder Fake Stuff that needs to be corrected some time soon-----
		ArrayList<AbstractAchievement> achievements = new ArrayList<AbstractAchievement>();
		achievements.add(new AchievementFirstLevelCompleted());
		achievements.add(new AchievementOneOfEachLevel());
		achievements.add(new AchievementAllOnes());
		achievements.add(new AchievementAllLevelsCompleted());
		achievements.add(new AchievementThousandPointMove());
		achievements.add(new AchievementAllStars());
		achievements.add(new AchievementTenThousandPoints());
		//------------------------------------------------------------------------------
		//splash.showSplash();
		ArrayList<SavedLevelData> savedLevelData = SixesWildRunner.LoadManifest();
		SixesWild model = new SixesWild(savedLevelData,achievements);

		SWApplication application = new SWApplication(model);
		application.setVisible(true);
		
		/*======================================================================================*/
		/*								NAVIGATION 												*/
		/*======================================================================================*/

		// Enter Level Select Screen
		ToLevelSelectScreenController toLevelSelectScreenController = new ToLevelSelectScreenController(application);
		toLevelSelectScreenController.actionPerformed(null);
		
		// Enter Game Screen
		ToGameScreenController toGameScreenController = new ToGameScreenController(application, 2);
		toGameScreenController.actionPerformed(null);
		
		// verify puzzle level initial conditions
		assertTrue(model.getLevel().getSavedLevelData().config.getType().compareTo("Lightning") == 0);
		assertTrue(model.getLevel().getPointsEarned() == 0);

		/*======================================================================================*/
		/*								Normal Moves											*/
		/*======================================================================================*/
		
		SwipeController swipeController = (SwipeController) ((ActiveGameScreen) (application.getActiveScreen())).getGridView().getMouseListeners()[0];
		
		int tempScore = model.getLevel().getPointsEarned();
		while (model.getLevel().getPointsEarned() == tempScore){
			ArrayList<Location> validStandardMove= model.getLevel().getAi().calculateValidMove();
			int x1 = 10+48*validStandardMove.get(0).getX();
			int y1 = 10+48*validStandardMove.get(0).getY();
			
			swipeController.mousePressed(new MouseEvent(((ActiveGameScreen) (application.getActiveScreen())).getGridView(), 0, 0, 0, x1, y1, 0, false));
			for (Location loc : validStandardMove){
				x1 = 10 + (48*loc.getX());
				y1 = 10 + (48*loc.getY());
				swipeController.mouseDragged(new MouseEvent(((ActiveGameScreen) (application.getActiveScreen())).getGridView(), 0, 0, 0, x1, y1, 0, false));
			}
			swipeController.mouseReleased(new MouseEvent(((ActiveGameScreen) (application.getActiveScreen())).getGridView(), 0, 0, 0, x1, y1, 0, false));
		}
		assertTrue(model.getLevel().getPointsEarned() > tempScore);
		
	}

}
