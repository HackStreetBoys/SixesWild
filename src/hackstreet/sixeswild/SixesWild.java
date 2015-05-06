package hackstreet.sixeswild;

import hackstreet.sixeswild.achievement.AbstractAchievement;
import hackstreet.sixeswild.config.EliminationLevelConfig;
import hackstreet.sixeswild.config.LightningLevelConfig;
import hackstreet.sixeswild.config.PuzzleLevelConfig;
import hackstreet.sixeswild.config.ReleaseLevelConfig;
import hackstreet.sixeswild.config.SavedLevelData;
import hackstreet.sixeswild.level.AbstractLevel;
import hackstreet.sixeswild.level.EliminationLevel;
import hackstreet.sixeswild.level.LightningLevel;
import hackstreet.sixeswild.level.PuzzleLevel;
import hackstreet.sixeswild.level.ReleaseLevel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

/**
 * Over-arching master class which will contain all data, 
 * and handle file I/O.
 * 
 * @author Nicholas, Tim, Pat
 *
 */
public class SixesWild {

	/**
	 * All the stored information about all levels
	 */
	ArrayList<SavedLevelData> savedLevelData;
	
	/**
	 * All information about achievements
	 */
	ArrayList<AbstractAchievement> achievements;

	/**
	 * The current level being played
	 */
	AbstractLevel activeLevel;

	public SixesWild(ArrayList<SavedLevelData> savedLevelData, ArrayList<AbstractAchievement> achievements){
		this.savedLevelData = savedLevelData;
		this.achievements = achievements;
	}

	
		
		public void winLevel() throws IOException
		{
			int i = savedLevelData.indexOf(activeLevel);
			SavedLevelData activesld = new SavedLevelData(savedLevelData.get(i).file);
			
			
//		String filebuffer = "";
//			FileReader fr = new FileReader(System.getProperty("user.dir")+"/data/"+savedLevelData.get(i).file.getName());
//			try (InputStream in = Files.newInputStream( new File(System.getProperty("user.dir")+"/data/"+savedLevelData.get(i).file.getName()).toPath());
//				    BufferedReader reader =
//				      new BufferedReader(new InputStreamReader(in))) {
//				    String line = null;
//				    while ((line = reader.readLine()) != null) {
//				        filebuffer = line;
//				    }
//				} 
//			catch (IOException x) {
//				    System.err.println(x);
//				}
			Gson gson = new Gson();
			
			if (activeLevel.getPointsEarned() > activesld.config.getPointsStar1()  )
			{
				activesld.setStarsEarned(1);
				if (i > savedLevelData.size())
					savedLevelData.get(i++).isUnlocked(true);
			}
			else if (activeLevel.getPointsEarned() > activesld.config.getPointsStar2()  )
				activesld.setStarsEarned(2);
			else if (activeLevel.getPointsEarned() > activesld.config.getPointsStar3()  )
				activesld.setStarsEarned(3);


			SavedLevelData sld = new SavedLevelData(savedLevelData.get(i).file);

			sld.setStarsEarned(3);
			sld.setUnlocked( true);

			FileWriter fw = null;
			try {
				fw = new FileWriter(new File(System.getProperty("user.dir")+"/data/"+activesld.file.getName()).toPath().toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fw.write(gson.toJson(sld));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return;
			 
	}

	public void prepareLevel(int level){
		SavedLevelData levelData = this.savedLevelData.get(level-1);
		
		if(levelData.getLevelConfig().getType().equals( "Elimination"))
			this.activeLevel = new EliminationLevel(levelData);
		else if(levelData.getLevelConfig().getType().equals("Lightning"))
			this.activeLevel = new LightningLevel(levelData);
		else if(levelData.getLevelConfig().getType().equals("Puzzle"))
			this.activeLevel = new PuzzleLevel(levelData);
		else if(levelData.getLevelConfig().getType().equals( "Release"))
			this.activeLevel = new ReleaseLevel(levelData);
	}

	public AbstractLevel getLevel(){
		return this.activeLevel;
	}

	public ArrayList<SavedLevelData> getSavedLevelDataList(){
		return this.savedLevelData;
	}

	public ArrayList<AbstractAchievement> getAchievements() {
		return this.achievements;
	}

	public List<AbstractAchievement> updateAchievements() {


		List<AbstractAchievement> achievementList = new ArrayList<AbstractAchievement>();

		for (AbstractAchievement a: this.achievements) {
			if (a.isAchieved(this))
				achievementList.add(a);
		}

		return achievementList;
	}


}
