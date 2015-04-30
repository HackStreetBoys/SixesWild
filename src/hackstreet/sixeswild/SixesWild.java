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
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

/**
 * Over-arching master class which will contain all data, 
 * and handle file I/O.
 * 
 * @author Nicholas
 *
 */
public class SixesWild {

	ArrayList<SavedLevelData> savedLevelData;
	ArrayList<AbstractAchievement> achievements;
	
	AbstractLevel activeLevel;

	public SixesWild(ArrayList<SavedLevelData> savedLevelData, ArrayList<AbstractAchievement> achievements){
		this.savedLevelData = savedLevelData;
		this.achievements = achievements;
	}
	
	private void winLevel(SixesWild sw)
	{
		/*
	String filebuffer = "";
		FileReader fr = new FileReader(sw.activeLevel.File);
		try (InputStream in = Files.newInputStream(sw.activeLevel.File.toPath());
			    BufferedReader reader =
			      new BufferedReader(new InputStreamReader(in))) {
			    String line = null;
			    while ((line = reader.readLine()) != null) {
			        filebuffer = line;
			    }
			} 
		catch (IOException x) {
			    System.err.println(x);
			}
		
		Gson gson = new Gson();
		gson.fromJson(filebuffer, sw.activeLevel.class)
		
		SavedLevelData sld = new SavedLevelData(sw.activeLevel);

		sld.setStars( WHATEVER VARIABLE GOES IN HERE)
		sld.setUnlocked( WHATEVER VARIABLE GOES IN HERE);s
	
		FileWriter fw = new FileWriter(sw.activeLevel.File);
		fw.write(gson.toJson(sld));
		
		return true;
		*/
	}
	
	public void prepareLevel(int level){

		SavedLevelData levelData = this.savedLevelData.get(level-1);
		

		System.out.println(levelData.getLevelConfig().getType());
		if(levelData.getLevelConfig().getType().equals( "Elimination")){
			this.activeLevel = new EliminationLevel(levelData);
			System.out.println("E");
			}
			else if(levelData.getLevelConfig().getType().equals("Lightning")){
			this.activeLevel = new LightningLevel(levelData);
			System.out.println("L");
			}
			else if(levelData.getLevelConfig().getType().equals("Puzzle")){
				
				System.out.println("P");
				this.activeLevel = new PuzzleLevel(levelData);
			
			}
			else if(levelData.getLevelConfig().getType().equals( "Release")){
			this.activeLevel = new ReleaseLevel(levelData);
			System.out.println("R");
			}

	}
	
	public AbstractLevel getLevel(){
		return this.activeLevel;
	}
	
	public ArrayList<SavedLevelData> getSavedLevelDataList(){
		return this.savedLevelData;
	}
	

}
