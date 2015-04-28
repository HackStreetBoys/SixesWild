package hackstreet.sixeswild.gui;


import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import hackstreet.sixeswild.game.Location;
import hackstreet.sixeswild.game.Tile;

@SuppressWarnings("serial")
public class ActiveSlotView extends JPanel{

	private Location loc;
	private TileView tileView;
	
	public ActiveSlotView(Location loc){
		this.loc = loc;
		super.setLayout(null);
		super.setBackground(new Color(0,0,0,0));
		
		int val = 1 + (int)(6*Math.random());
		int mult = 1 + (int)(100*Math.random());
		if(mult<70)
			mult = 1;
		else if(mult<90)
			mult = 2;
		else
			mult = 3;
		Tile tile = new Tile(val,mult);
		this.tileView = new TileView(tile);
		this.tileView.setSize(48,48);
		this.tileView.setLocation(1,1);
		super.add(tileView);
	}
	
	public Location getLoc(){
		return this.loc;
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.black);
		g.drawRect(0,0, super.getWidth()-1, super.getHeight()-1);
	}
	
	public boolean equals(Object o){
		if(o instanceof ActiveSlotView){
			ActiveSlotView other = (ActiveSlotView)o;
			return other.loc.equals(this.loc);
		}
		return false;

	}
}
