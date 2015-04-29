package hackstreet.sixeswild;

import hackstreet.sixeswild.achievement.AbstractAchievement;
import hackstreet.sixeswild.config.SavedLevelData;
import hackstreet.sixeswild.level.AbstractLevel;
import hackstreet.sixeswild.level.EliminationLevel;
import hackstreet.sixeswild.level.LightningLevel;
import hackstreet.sixeswild.level.PuzzleLevel;
import hackstreet.sixeswild.level.ReleaseLevel;

import java.util.ArrayList;

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
		String type = levelData.getLevelConfig().getType();
		if(type.equals("Elimination")){
			this.activeLevel = new EliminationLevel(levelData);
		}
		else if(type.equals("Lightning")){
			this.activeLevel = new LightningLevel(levelData);
		}
		else if(type.equals("Puzzle")){
			this.activeLevel = new PuzzleLevel(levelData);
		}
		else if(type.equals("Release")){
			this.activeLevel = new ReleaseLevel(levelData);
		}
	}
	
	public AbstractLevel getLevel(){
		return this.activeLevel;
	}
	
	public ArrayList<SavedLevelData> getSavedLevelDataList(){
		return this.savedLevelData;
	}
}
