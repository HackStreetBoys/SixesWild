package hackstreet.sixeswild.gui;


import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

import hackstreet.sixeswild.game.Location;
import hackstreet.sixeswild.game.Slot;
import hackstreet.sixeswild.level.AbstractLevel;

@SuppressWarnings("serial")
public class ActiveSlotView extends JPanel{

	private SWApplication application;
	private Slot slot;
	private TileView tileView;

	public ActiveSlotView(SWApplication application, Slot slot){
		this.application = application;
		this.slot = slot;
		super.setLayout(null);
		super.setBackground(new Color(0,0,0,0));

		refreshTileView();
	}

	public void refreshTileView(){
		if(slot.getTile() == null)
			return;
		this.tileView = new TileView(application,slot.getTile());
		this.tileView.setSize(48,48);
		this.tileView.setLocation(1,1);
		super.removeAll();
		super.add(tileView);
	}

	public Location getLoc(){
		return this.slot.getLoc();
	}

	@Override
	public void paintComponent(Graphics g){
		if(tileView!=null)
			this.tileView.setSelected(this.application.getModel().getLevel().getSelectedSlots().contains(this.slot));
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
