package hackstreet.sixeswild;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.util.ArrayList;

import hackstreet.sixeswild.achievement.*;
import hackstreet.sixeswild.config.AbstractLevelConfig;
import hackstreet.sixeswild.config.EliminationLevelConfig;
import hackstreet.sixeswild.config.SavedLevelData;
import hackstreet.sixeswild.game.Location;
import hackstreet.sixeswild.gui.SWApplication;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class SixesWildRunner {

	public static void main(String[] args){
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
	}

	private static void addFakeLevel(ArrayList<SavedLevelData> data){
		AbstractLevelConfig config = new EliminationLevelConfig(100);
		config.setFreq1(.4);
		config.setFreq2(.2);
		config.setFreq3(.2);
		config.setFreq4(.1);
		config.setFreq5(.05);
		config.setFreq6(.05);
		config.setFreqMult2(.1);
		config.setFreqMult3(.1);
		config.setName("Our Fake Level 1");
		ArrayList<Location> inertLocs = new ArrayList<Location>();
		for(int n=3;n<=5;n++){
			for(int m=3;m<=5;m++){
				inertLocs.add(new Location(n,m));
			}
		}
		inertLocs.add(new Location(0,0));
		inertLocs.add(new Location(0,8));
		inertLocs.add(new Location(8,8));
		inertLocs.add(new Location(8,0));
		inertLocs.add(new Location(4,2));
		inertLocs.add(new Location(2,4));
		inertLocs.add(new Location(4,6));
		inertLocs.add(new Location(6,4));
		//-----
		inertLocs.add(new Location(0,1));
		inertLocs.add(new Location(1,0));
		inertLocs.add(new Location(0,7));
		inertLocs.add(new Location(1,8));
		inertLocs.add(new Location(7,8));
		inertLocs.add(new Location(8,7));
		inertLocs.add(new Location(7,0));
		inertLocs.add(new Location(8,1));
		config.setNullLocations(inertLocs);
		config.setNumHint(1);
		config.setNumRemove(1);
		config.setNumShuffle(1);
		config.setNumSwap(1);
		config.setPointsStar1(800);
		config.setPointsStar2(1600);
		config.setPointsStar3(4000);
		SavedLevelData d = new SavedLevelData(config);
		d.setStarsEarned(0);
		d.setUnlocked(true);
		data.add(d);
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
