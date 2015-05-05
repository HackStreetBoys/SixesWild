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
import hackstreet.sixeswild.controller.HintController;
import hackstreet.sixeswild.controller.RemoveController;
import hackstreet.sixeswild.controller.ShuffleController;
import hackstreet.sixeswild.controller.SwapController;
import hackstreet.sixeswild.controller.SwipeController;
import hackstreet.sixeswild.controller.ToAchievementsScreenController;
import hackstreet.sixeswild.controller.ToGameScreenController;
import hackstreet.sixeswild.controller.ToLevelSelectScreenController;
import hackstreet.sixeswild.controller.ToMainScreenController;
import hackstreet.sixeswild.game.InertSlot;
import hackstreet.sixeswild.game.Location;
import hackstreet.sixeswild.game.Slot;
import hackstreet.sixeswild.game.Tile;
import hackstreet.sixeswild.gui.SWApplication;
import hackstreet.sixeswild.gui.game.ActiveGameScreen;
import hackstreet.sixeswild.move.SwapTilesMove;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import org.junit.Test;

/**
 * I wrote code structured this way for the government, and they successfully loaded it onto 
 * a plane and flew it 
 * (go to http://www.af.mil/News/ArticleDisplay/tabid/223/Article/558801/boeing-completes-successful-first-flight-in-kc-46-program.aspx),
 * so I figure that this approach must be the pinnacle of proper practice.
 * 
 * @author Nicholas
 *
 */
public class TestPuzzleLevel {

	@Test
	public void testNavigation() {
	
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
		
		// Enter Achievements screen
		ToAchievementsScreenController toAchievementsScreenController = new ToAchievementsScreenController(application);
		toAchievementsScreenController.actionPerformed(null);
		
		// Enter Main Screen
		ToMainScreenController toMainScreenController = new ToMainScreenController(application);
		toMainScreenController.actionPerformed(null);

		// Enter Level Select Screen
		ToLevelSelectScreenController toLevelSelectScreenController = new ToLevelSelectScreenController(application);
		toLevelSelectScreenController.actionPerformed(null);
		
		// Enter Game Screen
		ToGameScreenController toGameScreenController = new ToGameScreenController(application, 1);
		toGameScreenController.actionPerformed(null);
		
		// verify puzzle level initial conditions
		assertTrue(model.getLevel().getSavedLevelData().config.getType().compareTo("Puzzle") == 0);
		assertTrue(model.getLevel().getPointsEarned() == 0);
	}
	
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
		ToGameScreenController toGameScreenController = new ToGameScreenController(application, 1);
		toGameScreenController.actionPerformed(null);
		
		// verify puzzle level initial conditions
		assertTrue(model.getLevel().getSavedLevelData().config.getType().compareTo("Puzzle") == 0);
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
	
	@Test
	public void testSpecialHint() {
	
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
		ToGameScreenController toGameScreenController = new ToGameScreenController(application, 1);
		toGameScreenController.actionPerformed(null);
		
		// verify puzzle level initial conditions
		assertTrue(model.getLevel().getSavedLevelData().config.getType().compareTo("Puzzle") == 0);
		assertTrue(model.getLevel().getPointsEarned() == 0);

		/*======================================================================================*/
		/*								Hint													*/
		/*======================================================================================*/
		
		// Hint
		HintController hintController = new HintController(application);
		hintController.actionPerformed(null);
		// make sure the AI actually works
		for (int i=0; i<100; i++){
			System.out.println(i);
			ArrayList<Location> recommendation = model.getLevel().getAi().calculateValidMove();
			int sum = 0;
			if (recommendation != null){
				for (Location loc : recommendation){
					sum += model.getLevel().getBoard().get(loc).getTile().getValue();
				}
				assertTrue(sum == 6);
				
			}
			else
				System.out.println("	NULL");		
		}
	}
	
	@Test
	public void testSpecialShuffle() {
	
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
		ToGameScreenController toGameScreenController = new ToGameScreenController(application, 1);
		toGameScreenController.actionPerformed(null);
		
		// verify puzzle level initial conditions
		assertTrue(model.getLevel().getSavedLevelData().config.getType().compareTo("Puzzle") == 0);
		assertTrue(model.getLevel().getPointsEarned() == 0);
		
		/*======================================================================================*/
		/*								Shuffle													*/
		/*======================================================================================*/
		
		// Shuffle - assert that at least some of the Tile values are different
		ArrayList<Integer> prevList = new ArrayList<Integer>();
		for (Slot slot : model.getLevel().getBoard().values()){
			if (!(slot instanceof InertSlot))
				prevList.add(slot.getTile().getValue());
		}
		ShuffleController shuffleController = new ShuffleController(application);
		shuffleController.actionPerformed(null);
		// check that at least 50 tiles had their values changed  
		int numShuffled = 0;
		int i = 0;
		for (Slot slot: model.getLevel().getBoard().values()){
			if (!(slot instanceof InertSlot)){
				if (slot.getTile().getValue() != prevList.get(i)){
					numShuffled++;
				}
				i++;
			}
		}
		assertTrue(numShuffled > 20);
	}
	
	@Test
	public void testSpecialRemove() {
	
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
		ToGameScreenController toGameScreenController = new ToGameScreenController(application, 1);
		toGameScreenController.actionPerformed(null);
		
		// verify puzzle level initial conditions
		assertTrue(model.getLevel().getSavedLevelData().config.getType().compareTo("Puzzle") == 0);
		assertTrue(model.getLevel().getPointsEarned() == 0);
		
		/*======================================================================================*/
		/*								Remove													*/
		/*======================================================================================*/

		
		// Remove - must pass MouseEvent. Assert that the file is not referencing the old tile.
		ArrayList<Location> validRemoveMove = model.getLevel().getAi().calculateValidMove();
		int xRem1 = 10+48*validRemoveMove.get(0).getX();
		int yRem1 = 10+48*validRemoveMove.get(0).getY();
		
		Tile removedTile = model.getLevel().getBoard().get(new Location(3,3)).getTile();
		RemoveController removeController = new RemoveController(application);
		removeController.actionPerformed(null);
		SwipeController swipeController = (SwipeController) ((ActiveGameScreen) (application.getActiveScreen())).getGridView().getMouseListeners()[0];
		swipeController.mousePressed(new MouseEvent(((ActiveGameScreen) (application.getActiveScreen())).getGridView(), 0, 0, 0, xRem1, yRem1, 0, false));
		Tile newTile = model.getLevel().getBoard().get(validRemoveMove.get(0)).getTile();
		assertTrue(removedTile != newTile);
		removedTile = newTile;
		swipeController.mousePressed(new MouseEvent(((ActiveGameScreen) (application.getActiveScreen())).getGridView(), 0, 0, 0, 60, 60, 0, false));
		assertTrue(removedTile == newTile);
	}

	@Test
	public void testSpecialSwap() {
	
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
		ToGameScreenController toGameScreenController = new ToGameScreenController(application, 1);
		toGameScreenController.actionPerformed(null);
		
		// verify puzzle level initial conditions
		assertTrue(model.getLevel().getSavedLevelData().config.getType().compareTo("Puzzle") == 0);
		assertTrue(model.getLevel().getPointsEarned() == 0);
		
		/*======================================================================================*/
		/*								Swap													*/
		/*======================================================================================*/

		SwipeController swipeController = (SwipeController) ((ActiveGameScreen) (application.getActiveScreen())).getGridView().getMouseListeners()[0];
		
		// Swap adjacent locations (luckily, we have an AI that will give us those locations)
		ArrayList<Location> validSwapMove= model.getLevel().getAi().calculateValidMove();
		System.out.println(validSwapMove.get(0).toString() + validSwapMove.get(1).toString());
		int xSwap1 = 10+48*validSwapMove.get(0).getX();
		int ySwap1 = 10+48*validSwapMove.get(0).getY();
		int xSwap2 = 10+48*validSwapMove.get(1).getX();
		int ySwap2 = 10+48*validSwapMove.get(1).getY();
		// gives consistency to test
		xSwap1 = 10+48*3;
		ySwap1 = 10+48*3;
		xSwap2 = 10+48*3;
		ySwap2 = 10+48*4;
		
		//Tile tile1 = model.getLevel().getBoard().get(validSwapMove.get(0)).getTile();
		//Tile tile2 = model.getLevel().getBoard().get(validSwapMove.get(1)).getTile();
		SwapController swapController = new SwapController(application);
		swapController.actionPerformed(null);
		swipeController.mousePressed(new MouseEvent(((ActiveGameScreen) (application.getActiveScreen())).getGridView(), 0, 0, 0, xSwap1, ySwap1, 0, false));
		swipeController.mouseDragged(new MouseEvent(((ActiveGameScreen) (application.getActiveScreen())).getGridView(), 0, 0, 0, xSwap1, ySwap1, 0, false));
		swipeController.mouseDragged(new MouseEvent(((ActiveGameScreen) (application.getActiveScreen())).getGridView(), 0, 0, 0, xSwap2, ySwap2, 0, false));
		swipeController.mouseReleased(new MouseEvent(((ActiveGameScreen) (application.getActiveScreen())).getGridView(), 0, 0, 0, xSwap2, ySwap2, 0, false));
		//Tile tile1new = model.getLevel().getBoard().get(validSwapMove.get(1)).getTile();
		//Tile tile2new = model.getLevel().getBoard().get(validSwapMove.get(0)).getTile();
		assertTrue(model.getLevel().getMoveStack().isEmpty() || model.getLevel().getMoveStack().peek() instanceof SwapTilesMove);
		//assertTrue(tile1 == tile1new);
		//assertTrue(tile2 == tile2new);
		
		SwapTilesMove swapTilesMove = new SwapTilesMove(model, model.getLevel());
		swapTilesMove.doMove();
		
	}

	@Test
	public void testVictoryLossScreen(){
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
		
		application.enterVictoryScreen();
		
		application.enterLossScreen();
		
	}
	
}
