package hackstreet.sixeswild.gui;

import hackstreet.sixeswild.controller.ToLevelSelectScreenController;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

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
	
	public ActiveGameScreen(SWApplication application, int level) {
		super(application, "Level " + level); //TODO adjust to actual level

		this.scoreLabel = new JLabel("Score: ");
		this.scoreLabel.setSize(100,35);
		this.scoreLabel.setLocation(15,25);
		
		this.movesLeftLabel = new JLabel("Moves left: ");
		this.movesLeftLabel.setSize(100,35);
		this.movesLeftLabel.setLocation(15,85);
	
		this.progressView = new ProgressView();
		this.progressView.setLocation(15,145);
		
		this.backButton = new JButton("Back");
		this.backButton.setSize(100,50);
		this.backButton.setLocation(10,500);
		this.backButton.setFocusable(false);
		this.backButton.addActionListener(new ToLevelSelectScreenController(super.getApplication()));
		
		this.gridView = new GridView(application);
		this.gridView.setSize(450,450);
		this.gridView.setLocation(400 - gridView.getWidth()/2,100);
		
		this.removeTileButton = new JButton();
		this.removeTileButton.setSize(30,30);
		this.removeTileButton.setLocation(640,150);
		this.removeTileButton.setFocusable(false);
		this.removeTileLabel = new JLabel("Remove Tile");
		this.removeTileLabel.setSize(150,50);
		this.removeTileLabel.setLocation(this.removeTileButton.getX()+this.removeTileButton.getWidth()+20,
				this.removeTileButton.getY()-10);
		this.removeTileLabel.setVerticalAlignment(SwingConstants.CENTER);
		
		this.switchTilesButton = new JButton();
		this.switchTilesButton.setSize(30,30);
		this.switchTilesButton.setLocation(640,225);
		this.switchTilesButton.setFocusable(false);
		this.switchTilesLabel = new JLabel("Switch Tiles");
		this.switchTilesLabel.setSize(150,50);
		this.switchTilesLabel.setLocation(this.switchTilesButton.getX()+this.switchTilesButton.getWidth()+20,
				this.switchTilesButton.getY()-10);
		this.switchTilesLabel.setVerticalAlignment(SwingConstants.CENTER);
		
		this.shuffleBoardButton = new JButton();
		this.shuffleBoardButton.setSize(30,30);
		this.shuffleBoardButton.setLocation(640,300);
		this.shuffleBoardButton.setFocusable(false);
		this.shuffleBoardLabel = new JLabel("Shuffle Board");
		this.shuffleBoardLabel.setSize(150,50);
		this.shuffleBoardLabel.setLocation(this.shuffleBoardButton.getX()+this.shuffleBoardButton.getWidth()+20,
				this.shuffleBoardButton.getY()-10);
		this.shuffleBoardLabel.setVerticalAlignment(SwingConstants.CENTER);
		
		this.hintButton = new JButton();
		this.hintButton.setSize(30,30);
		this.hintButton.setLocation(640,375);
		this.hintButton.setFocusable(false);
		this.hintLabel = new JLabel("Get Hint");
		this.hintLabel.setSize(150,50);
		this.hintLabel.setLocation(this.hintButton.getX()+this.hintButton.getWidth()+20,
				this.hintButton.getY()-10);
		this.hintLabel.setVerticalAlignment(SwingConstants.CENTER);
		
		super.add(this.scoreLabel);
		super.add(this.movesLeftLabel);
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
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.black);
		g.drawLine(120, 0, 120, 600);
	}
	
	public GridView getGridView(){
		return this.gridView;
	}

}
