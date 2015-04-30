package hackstreet.sixeswild;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import hackstreet.sixeswild.achievement.AbstractAchievement;
import hackstreet.sixeswild.config.AbstractLevelConfig;
import hackstreet.sixeswild.config.EliminationLevelConfig;
import hackstreet.sixeswild.config.SavedLevelData;
import hackstreet.sixeswild.game.Location;
import hackstreet.sixeswild.gui.SWApplication;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class SixesWildRunner {

	public static void main(String[] args){
		loadNimbus();
		loadFonts();

		SplashScreen splash = new SplashScreen(5000, "images/SixesWildSplashScreen.png");
		//---------PlaceHolder Fake Stuff that needs to be corrected some time soon-----
		ArrayList<SavedLevelData> savedLevelData = new ArrayList<SavedLevelData>();
		savedLevelData.add(getFakeLevel());
		ArrayList<AbstractAchievement> achievements = new ArrayList<AbstractAchievement>();
		//------------------------------------------------------------------------------
		splash.showSplash();


		SixesWild model = new SixesWild(savedLevelData,achievements);

		SWApplication application = new SWApplication(model);
		application.setVisible(true);
	}

	private static void loadNimbus(){
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

	private static SavedLevelData getFakeLevel(){
		AbstractLevelConfig config = new EliminationLevelConfig(40);
		config.setFreq1(.8);
		config.setFreq2(.2);
		config.setFreq3(.0);
		config.setFreq4(.0);
		config.setFreq5(.0);
		config.setFreq6(.0);
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
		config.setPointsStar1(10);
		config.setPointsStar2(20);
		config.setPointsStar3(30);
		SavedLevelData data = new SavedLevelData(config);
		data.setStarsEarned(0);
		data.setUnlocked(true);
		return data;
	}

}
