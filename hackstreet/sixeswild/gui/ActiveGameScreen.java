package hackstreet.sixeswild.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ActiveGameScreen extends AbstractScreen {

	private JLabel scoreLabel;
	private JLabel movesLeftLabel;
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
	
	public ActiveGameScreen(SWApplication application) {
		super(application, "Level 1"); //TODO adjust to actual level

		this.scoreLabel = new JLabel("Score: ");
		this.scoreLabel.setSize(100,35);
		this.scoreLabel.setLocation(25,25);
		
		this.movesLeftLabel = new JLabel("Moves left: ");
		this.movesLeftLabel.setSize(100,35);
		this.movesLeftLabel.setLocation(25,85);
	
		this.progressView = new ProgressView();
		this.progressView.setLocation(25,145);
		
		this.backButton = new JButton();
		this.backButton.setSize(100,50);
		this.backButton.setLocation(25,725);
		
		this.gridView = new GridView();
		this.gridView.setLocation(400 - gridView.getWidth()/2,125);
		
		this.removeTileButton = new JButton();
		this.removeTileButton.setSize(50,50);
		this.removeTileButton.setLocation(600,150);
		this.removeTileLabel = new JLabel("Remove Tile");
		this.removeTileLabel.setSize(150,50);
		this.removeTileLabel.setLocation(650,150);
		
		this.switchTilesButton = new JButton();
		this.switchTilesButton.setSize(50,50);
		this.switchTilesButton.setLocation(600,225);
		this.switchTilesLabel = new JLabel("Switch Tiles");
		this.switchTilesLabel.setSize(150,50);
		this.switchTilesLabel.setLocation(650,225);
		
		this.shuffleBoardButton = new JButton();
		this.shuffleBoardButton.setSize(50,50);
		this.shuffleBoardButton.setLocation(600,300);
		this.shuffleBoardLabel = new JLabel("Shuffle Board");
		this.shuffleBoardLabel.setSize(150,50);
		this.shuffleBoardLabel.setLocation(650,300);
		
		this.hintButton = new JButton();
		this.hintButton.setSize(50,50);
		this.hintButton.setLocation(600,375);
		this.hintLabel = new JLabel("Get Hint");
		this.hintLabel.setSize(150,50);
		this.hintLabel.setLocation(650,375);
		
		super.add(this.scoreLabel);
		super.add(this.movesLeftLabel);
		super.add(this.progressView);
		super.add(this.gridView);
		super.add(this.removeTileButton);
		super.add(this.removeTileLabel);
		super.add(this.switchTilesButton);
		super.add(this.switchTilesLabel);
		super.add(this.shuffleBoardButton);
		super.add(this.shuffleBoardLabel);
		super.add(this.hintButton);
		super.add(this.hintLabel);
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.black);
		g.drawLine(200, 0, 200, 600);
		
		
	}

}
