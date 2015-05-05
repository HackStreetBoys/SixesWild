package hackstreet;

import static org.junit.Assert.*;
import hackstreet.sixeswild.SixesWild;
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
import hackstreet.sixeswild.game.Location;
import hackstreet.sixeswild.game.Slot;
import hackstreet.sixeswild.game.Tile;
import hackstreet.sixeswild.gui.SWApplication;
import hackstreet.sixeswild.gui.game.ActiveGameScreen;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.util.ArrayList;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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
	public void test() {
	
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

		loadFonts();

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
		ArrayList<SavedLevelData> savedLevelData = LoadManifest();
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
		
		/*======================================================================================*/
		/*								SPECIAL MOVES											*/
		/*======================================================================================*/
		
		// Hint
		HintController hintController = new HintController(application);
		hintController.actionPerformed(null);
		// make sure the AI actually works
		for (int i=0; i<100; i++){
			ArrayList<Location> recommendation = model.getLevel().getAi().calculateValidMove();
			int sum = 0;
			for (Location loc : recommendation){
				sum += model.getLevel().getBoard().get(loc).getTile().getValue();
			}
			assertTrue(sum == 6);
			System.out.println(i);
		}
		
		// Shuffle - assert that at least some of the Tile values are different
		ArrayList<Integer> prevList = new ArrayList<Integer>();
		for (Slot slot : model.getLevel().getBoard().values()){
			prevList.add(slot.getTile().getValue());
		}
		ShuffleController shuffleController = new ShuffleController(application);
		shuffleController.actionPerformed(null);
		// check that at least 50 tiles had their values changed  
		int numShuffled = 0;
		int i = 0;
		for (Slot slot: model.getLevel().getBoard().values()){
			if (slot.getTile().getValue() != prevList.get(i)){
				numShuffled++;
			}
			i++;
		}
		assertTrue(numShuffled > 20);
		
		// Remove - must pass MouseEvent. Assert that the file is not referencing the old tile.
		Tile removedTile = model.getLevel().getBoard().get(new Location(1,1)).getTile();
		RemoveController removeController = new RemoveController(application);
		removeController.actionPerformed(null);
		SwipeController swipeController = (SwipeController) ((ActiveGameScreen) (application.getActiveScreen())).getGridView().getMouseListeners()[0];
		swipeController.mousePressed(new MouseEvent(((ActiveGameScreen) (application.getActiveScreen())).getGridView(), 0, 0, 0, 60, 60, 0, false));
		Tile newTile = model.getLevel().getBoard().get(new Location (1,1)).getTile();
		assertTrue(removedTile != newTile);
		removedTile = newTile;
		swipeController.mousePressed(new MouseEvent(((ActiveGameScreen) (application.getActiveScreen())).getGridView(), 0, 0, 0, 60, 60, 0, false));
		assertTrue(removedTile == newTile);
		
		// Swap Location(1,1) and (1,2)
		Tile tile1 = model.getLevel().getBoard().get(new Location(1,1)).getTile();
		Tile tile2 = model.getLevel().getBoard().get(new Location(1,2)).getTile();
		SwapController swapController = new SwapController(application);
		swapController.actionPerformed(null);
		swipeController.mousePressed(new MouseEvent(((ActiveGameScreen) (application.getActiveScreen())).getGridView(), 0, 0, 0, 60, 60, 0, false));
		swipeController.mouseDragged(new MouseEvent(((ActiveGameScreen) (application.getActiveScreen())).getGridView(), 0, 0, 0, 61, 61, 0, false));
		swipeController.mouseDragged(new MouseEvent(((ActiveGameScreen) (application.getActiveScreen())).getGridView(), 0, 0, 0, 60, 100, 0, false));
		assertTrue(tile1 == model.getLevel().getBoard().get(new Location(1,2)).getTile());
		assertTrue(tile2 == model.getLevel().getBoard().get(new Location(1,1)).getTile());
		
		System.exit(0); // close the application
}
	
	private static void loadFonts(){
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, new File("images/RioGrande.ttf"));
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(font);
		} catch (IOException|FontFormatException e) {
			System.out.println("Nopes");
		}
	}	
	
	private static ArrayList<SavedLevelData> LoadManifest(){

		String filebuffer = "";

		File manifestFile = new File(System.getProperty("user.dir")+ "/data/manifest.json");
		
		if ( manifestFile.exists() == true ){


			try (InputStream in = Files.newInputStream(manifestFile.toPath());
					BufferedReader reader =
							new BufferedReader(new InputStreamReader(in))) {
				String line = null;
				while ((line = reader.readLine()) != null) {
					filebuffer += line;
				}
			} catch (IOException x) {
				System.err.println(x);
			}

			Gson gson = new Gson();

			Type collectionType = new TypeToken<ArrayList<SavedLevelData>>() {
			}.getType();


			ArrayList<SavedLevelData> savedLevelData = gson.fromJson(filebuffer,collectionType);
			savedLevelData = gson.fromJson(filebuffer, collectionType);

			for (int i = 0; i < savedLevelData.size();i++)
			{
				savedLevelData.get(i).getLevelConfig();

			}
			return savedLevelData;
		}
		else
		{
			System.err.println("No manifest");
		}
		//		System.exit(1);
		return null;

	}

}
