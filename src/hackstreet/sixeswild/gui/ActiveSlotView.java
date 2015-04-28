package hackstreet.sixeswild.gui;


import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import hackstreet.sixeswild.game.Location;
import hackstreet.sixeswild.game.Slot;

@SuppressWarnings("serial")
public class ActiveSlotView extends JPanel{

	private Slot slot;
	private TileView tileView;
	
	public ActiveSlotView(Slot slot){
		this.slot = slot;
		super.setLayout(null);
		super.setBackground(new Color(0,0,0,0));
		
		this.tileView = new TileView(slot.getTile());
		this.tileView.setSize(48,48);
		this.tileView.setLocation(1,1);
		super.add(tileView);
	}
	
	public Location getLoc(){
		return this.slot.getLoc();
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
			return other.slot.equals(this.slot);
		}
		return false;

	}
}
