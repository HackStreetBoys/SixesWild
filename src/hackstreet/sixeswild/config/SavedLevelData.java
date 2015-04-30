package hackstreet.sixeswild.config;

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

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Stores a player's accomplishments on a specific level
 * (whether it is unlocked, and how many stars were earned).
 * <p>
 * This class is saved to disk.
 * @author Nicholas, Ben
 *
 */
public class SavedLevelData {

	public File file;
	public AbstractLevelConfig config;
	public boolean isUnlocked;
	public int starsEarned;
	
	/**
	 * SavedLevelData constructor;
	 * @param config
	 */
	public SavedLevelData(File f){
		this.file = f;
		this.isUnlocked = false;
		this.starsEarned = 0;
	}
	
	public SavedLevelData(AbstractLevelConfig config){
		this.config = config;
		this.isUnlocked = false;
		this.starsEarned = 0;
	}
	
	public AbstractLevelConfig getLevelConfig() {
		if (config == null)
		{
			
			String filebuffer = "";
			try {
				FileReader fr = new FileReader(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try (InputStream in = Files.newInputStream(file.toPath());
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
			JsonParser parser = new JsonParser();
			
			JsonObject obj = parser.parse(filebuffer).getAsJsonObject();
			String type = obj.get("Type").getAsString();
			
			System.out.println("Loading Config");
			
			if(type.equals("Elimination")){
				
				config = gson.fromJson(filebuffer, EliminationLevelConfig.class);
				return config;
			}
			else if(type.equals("Lightning")){
				config =  gson.fromJson(filebuffer, LightningLevelConfig.class);
				return config;
			}
			else if(type.equals("Puzzle")){
				config = gson.fromJson(filebuffer, PuzzleLevelConfig.class);
				return config;
			}
			else if(type.equals("Release")){
				config = 	gson.fromJson(filebuffer, ReleaseLevelConfig.class);
				return config;
			}

			System.out.println(type);
		}

		return config;
	}

	public void setConfig(AbstractLevelConfig config) {
		this.config = config;
	}

	public boolean isUnlocked() {
		return isUnlocked;
	}

	public void setUnlocked(boolean isUnlocked) {
		this.isUnlocked = isUnlocked;
	}

	public int getStarsEarned() {
		return starsEarned;
	}

	public void setStarsEarned(int starsEarned) {
		this.starsEarned = starsEarned;
	}

	public File getFile() {
		// TODO Auto-generated method stub
		return file;
	}

}
