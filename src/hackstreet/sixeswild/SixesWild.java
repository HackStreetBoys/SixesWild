package hackstreet.sixeswild;

import hackstreet.sixeswild.achievement.AbstractAchievement;
import hackstreet.sixeswild.config.SavedLevelData;
import hackstreet.sixeswild.level.AbstractLevel;
import java.util.ArrayList;

/**
 * Over-arching master class which will contain all data, 
 * and handle file I/O.
 * 
 * @author Nicholas
 *
 */
public class SixesWild {

	ArrayList<AbstractAchievement> achievements;
	ArrayList<SavedLevelData> savedLevelData;
	AbstractLevel activeLevel;

	public SixesWild(){
		// empty
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
	
	public AbstractLevel getLevel(){
		return this.activeLevel;
	}
}
