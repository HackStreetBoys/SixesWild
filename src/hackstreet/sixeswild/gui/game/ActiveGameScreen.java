package hackstreet.sixeswild.gui.game;

import hackstreet.sixeswild.achievement.AbstractAchievement;
import hackstreet.sixeswild.controller.HintController;
import hackstreet.sixeswild.controller.RemoveController;
import hackstreet.sixeswild.controller.ShuffleController;
import hackstreet.sixeswild.controller.SwapController;
import hackstreet.sixeswild.controller.ToLevelSelectScreenController;
import hackstreet.sixeswild.gui.AbstractScreen;
import hackstreet.sixeswild.gui.GridView;
import hackstreet.sixeswild.gui.ProgressView;
import hackstreet.sixeswild.gui.SWApplication;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * 
 * @author Patrick
 *
 */
@SuppressWarnings("serial")
public abstract class ActiveGameScreen extends AbstractScreen {

	private JLabel scoreLabel;
	private ProgressView progressView;
	private JButton backButton;

	private GridView gridView;

	private JButton removeTileButton;
	private JButton switchTilesButton;
	private JButton shuffleBoardButton;
	private JButton hintButton;

	private JLabel removeTileLabel;
	private JLabel switchTilesLabel;
	private JLabel shuffleBoardLabel;
	private JLabel hintLabel;
	
	private BufferedImage selectedImage;

	public ActiveGameScreen(SWApplication application, int level) {
		super(application, "Level " + level); //TODO adjust to actual level

		this.scoreLabel = new JLabel("Score: 0");
		this.scoreLabel.setSize(100,35);
		this.scoreLabel.setLocation(15,25);

		this.progressView = new ProgressView();
		int star1 = application.getModel().getLevel().getSavedLevelData().getLevelConfig().getPointsStar1();
		int star2 = application.getModel().getLevel().getSavedLevelData().getLevelConfig().getPointsStar2();
		int star3 = application.getModel().getLevel().getSavedLevelData().getLevelConfig().getPointsStar3();
		this.progressView.setCaps(star1,star2,star3);
		this.progressView.setLocation(15,145);

		this.backButton = new JButton("Back");
		this.backButton.setSize(100,50);
		this.backButton.setLocation(10,500);
		this.backButton.setFocusable(false);
		this.backButton.addActionListener(new ToLevelSelectScreenController(super.getApplication()));

		this.gridView = new GridView(application);
		this.gridView.setSize(450,450);
		this.gridView.setLocation(400 - gridView.getWidth()/2,100);


		setupRemoveTileButton();
		setupSwitchTilesButton();
		setupShuffleBoardButton();
		setupHintButton();

		super.add(this.scoreLabel);
		super.add(this.progressView);
		super.add(this.backButton);
		super.add(this.gridView);
		super.add(this.removeTileButton);
		super.add(this.removeTileLabel);
		super.add(this.switchTilesButton);
		super.add(this.switchTilesLabel);
		super.add(this.shuffleBoardButton);
		super.add(this.shuffleBoardLabel);
		super.add(this.hintButton);
		super.add(this.hintLabel);
		
		try {
			this.selectedImage = ImageIO.read(new File("images/select-special-move.png"));
		} catch(IOException e) {
			System.out.println("Error: " + e);
		}
	}

	private void setupRemoveTileButton(){
		this.removeTileButton = new JButton();
		this.removeTileButton.setSize(40,40);
		this.removeTileButton.setLocation(650,230);
		this.removeTileButton.setFocusable(false);
		this.removeTileButton.addActionListener(new RemoveController(getApplication()));
		this.removeTileButton.setIcon(new ImageIcon("images/remove-unpressed.png"));
		this.removeTileButton.setPressedIcon(new ImageIcon("images/remove-pressed.png"));
		this.removeTileLabel = new JLabel("Remove Tile");
		this.removeTileLabel.setSize(150,50);
		this.removeTileLabel.setLocation(this.removeTileButton.getX()+this.removeTileButton.getWidth()+10,
				this.removeTileButton.getY()-10);
		this.removeTileLabel.setVerticalAlignment(SwingConstants.CENTER);
	}

	private void setupSwitchTilesButton(){
		this.switchTilesButton = new JButton();
		this.switchTilesButton.setSize(40,40);
		this.switchTilesButton.setLocation(650,280);
		this.switchTilesButton.setFocusable(false);
		this.switchTilesButton.addActionListener(new SwapController(getApplication()));

		this.switchTilesButton.setIcon(new ImageIcon("images/swap-unpressed.png"));
		this.switchTilesButton.setPressedIcon(new ImageIcon("images/swap-pressed.png"));
		this.switchTilesLabel = new JLabel("Switch Tiles");
		this.switchTilesLabel.setSize(150,50);
		this.switchTilesLabel.setLocation(this.switchTilesButton.getX()+this.switchTilesButton.getWidth()+10,
				this.switchTilesButton.getY()-10);
		this.switchTilesLabel.setVerticalAlignment(SwingConstants.CENTER);
	}

	private void setupShuffleBoardButton(){
		this.shuffleBoardButton = new JButton();
		this.shuffleBoardButton.setSize(40,40);
		this.shuffleBoardButton.setLocation(650,330);
		this.shuffleBoardButton.setFocusable(false);
		this.shuffleBoardButton.addActionListener(new ShuffleController(getApplication()));
		this.shuffleBoardButton.setIcon(new ImageIcon("images/shuffle-unpressed.png"));
		this.shuffleBoardButton.setPressedIcon(new ImageIcon("images/shuffle-pressed.png"));
		this.shuffleBoardLabel = new JLabel("Shuffle Board");
		this.shuffleBoardLabel.setSize(150,50);
		this.shuffleBoardLabel.setLocation(this.shuffleBoardButton.getX()+this.shuffleBoardButton.getWidth()+10,
				this.shuffleBoardButton.getY()-10);
		this.shuffleBoardLabel.setVerticalAlignment(SwingConstants.CENTER);
	}

	private void setupHintButton(){
		this.hintButton = new JButton();
		this.hintButton.setSize(40,40);
		this.hintButton.setLocation(650,380);
		this.hintButton.setFocusable(false);
		this.hintButton.addActionListener(new HintController(getApplication()));
		this.hintButton.setIcon(new ImageIcon("images/hint-unpressed.png"));
		this.hintButton.setPressedIcon(new ImageIcon("images/hint-pressed.png"));
		this.hintLabel = new JLabel("Get Hint");
		this.hintLabel.setSize(150,50);
		this.hintLabel.setLocation(this.hintButton.getX()+this.hintButton.getWidth()+10,
				this.hintButton.getY()-10);
		this.hintLabel.setVerticalAlignment(SwingConstants.CENTER);
	}

	public void popupAchievements(List<AbstractAchievement> newAchievements){
		//TODO Show that you got an achievement!
		System.out.println("---------------------");
		for(AbstractAchievement a:newAchievements)
			System.out.println("You unlocked an achievenemt!");
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.black);
		g.drawLine(120, 0, 120, 600);
		
		if (super.getApplication().getModel().getLevel().isSwapMoveSelected()) {
			g.drawImage(this.selectedImage, this.switchTilesButton.getX()-3, this.switchTilesButton.getY()-3, null);
		}
		if (super.getApplication().getModel().getLevel().isRemoveMoveSelected()) {
			g.drawImage(this.selectedImage, this.removeTileButton.getX()-3, this.removeTileButton.getY()-3, null);
			
		}
	}

	public GridView getGridView(){
		return this.gridView;
	}

	public ProgressView getProgressView(){
		return this.progressView;
	}

	public JLabel getScoreLabel(){
		return this.scoreLabel;
	}

}