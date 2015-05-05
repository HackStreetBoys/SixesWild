package hackstreet.sixeswild.gui;

import hackstreet.sixeswild.SixesWild;
import hackstreet.sixeswild.gui.game.ActiveGameScreen;
import hackstreet.sixeswild.gui.game.EliminationGameScreen;
import hackstreet.sixeswild.gui.game.LightningGameScreen;
import hackstreet.sixeswild.gui.game.PuzzleGameScreen;
import hackstreet.sixeswild.gui.game.ReleaseGameScreen;
import hackstreet.sixeswild.level.AbstractLevel;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class SWApplication extends JFrame{

	private SixesWild model;

	private SWMainScreen mainScreen;
	private LevelSelectScreen levelSelectScreen;
	private AchievementScreen achievementScreen;
	private VictoryScreen victoryScreen;
	private LossScreen lossScreen;

	private AbstractScreen activeScreen;

	public SWApplication(SixesWild model){
		this.model = model;

		this.mainScreen = new SWMainScreen(this);
		this.levelSelectScreen = new LevelSelectScreen(this);
		this.achievementScreen = new AchievementScreen(this);
		this.victoryScreen = new VictoryScreen(this);
		this.lossScreen = new LossScreen(this);

		super.setLocation(50,50);
		super.setSize(800,600);
		super.setResizable(false);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.activeScreen = this.mainScreen;
		super.add(this.activeScreen);
		this.enterMainScreen();
	}

	public void enterMainScreen(){
		this.enterScreen(this.mainScreen);
	}

	public void enterLevelSelectScreen(){
		this.enterScreen(this.levelSelectScreen);
	}

	public void enterGameScreen(int levelNumber){
		AbstractLevel level = this.model.getLevel();
		String type = level.getSavedLevelData().getLevelConfig().getType();
		if(type.equals("Elimination"))
			this.enterScreen(new EliminationGameScreen(this,levelNumber));
		else if(type.equals("Lightning"))
			this.enterScreen(new LightningGameScreen(this,levelNumber));
		else if(type.equals("Puzzle"))
			this.enterScreen(new PuzzleGameScreen(this,levelNumber));
		else if(type.equals("Release"))
			this.enterScreen(new ReleaseGameScreen(this,levelNumber));
	}

	public void enterAchievementsScreen() {
		this.enterScreen(this.achievementScreen);
	}
	
	public void enterVictoryScreen() {
		this.enterScreen(this.victoryScreen);
	}
	
	public void enterLossScreen() {
		this.enterScreen(this.lossScreen);
	}

	public SixesWild getModel(){
		return this.model;
	}

	private void enterScreen(AbstractScreen screen){
		super.remove(this.activeScreen);
		this.activeScreen = screen;
		super.add(this.activeScreen);
		super.revalidate();
		super.repaint();
	}

	public AbstractScreen getActiveScreen(){
		return this.activeScreen;
	}
}
