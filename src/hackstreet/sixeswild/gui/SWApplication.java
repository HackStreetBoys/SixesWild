package hackstreet.sixeswild.gui;

import hackstreet.sixeswild.SixesWild;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class SWApplication extends JFrame{

	private SixesWild model;

	private SWMainScreen mainScreen;
	private LevelSelectScreen levelSelectScreen;
	private AchievementScreen achievementScreen;

	private AbstractScreen activeScreen;

	public SWApplication(SixesWild model){
		this.model = model;

		this.mainScreen = new SWMainScreen(this);
		this.levelSelectScreen = new LevelSelectScreen(this);
		this.achievementScreen = new AchievementScreen(this);

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

	public void enterGameScreen(int level){
		this.enterScreen(new ActiveGameScreen(this,level));
	}
	
	public void enterAchievementsScreen() {
		this.enterScreen(this.achievementScreen);
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
