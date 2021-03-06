package hackstreet.sixeswild.gui;


import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;

import javax.swing.JPanel;

import hackstreet.sixeswild.game.BucketSlot;
import hackstreet.sixeswild.game.EliminationSlot;
import hackstreet.sixeswild.game.InertSlot;
import hackstreet.sixeswild.game.Location;
import hackstreet.sixeswild.game.Slot;

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
		if(this.tileView != null && this.tileView.isBlink())
			return;
		if(slot.getTile() == null)
			return;
		this.tileView = new TileView(application,slot,slot.getTile());
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
		HashMap<Location,Slot> board = application.getModel().getLevel().getBoard();
		Slot up = board.get(this.slot.getLoc().pullNearbyLocation(0,-1));
		Slot right = board.get(this.slot.getLoc().pullNearbyLocation(1,0));
		Slot down = board.get(this.slot.getLoc().pullNearbyLocation(0,1));
		Slot left = board.get(this.slot.getLoc().pullNearbyLocation(-1,0));
		if(tileView==null){
			if(up != null && !(up instanceof InertSlot))
				g.drawLine(0, 0, super.getWidth()-1, 0);
			if(right != null && !(right instanceof InertSlot))
				g.drawLine(super.getWidth()-1, 0, super.getWidth()-1, super.getHeight()-1);
			if(down != null && !(down instanceof InertSlot))
				g.drawLine(0, super.getHeight()-1, super.getWidth()-1, super.getHeight()-1);
			if(left != null && !(left instanceof InertSlot))
				g.drawLine(0, 0, 0, super.getHeight()-1);
		}
		else
			g.drawRect(0,0, super.getWidth()-1, super.getHeight()-1);
		if(this.slot instanceof BucketSlot)
			this.drawBucket(g);
	}

	private void drawBucket(Graphics g){
		g.setColor(new Color(0,0,0,50));
		g.fillRect(0,0,super.getWidth(),super.getHeight());
		g.setColor(Color.black);
		g.drawRect(0, 0, super.getWidth()-1, super.getHeight()-1);HashMap<Location,Slot> board = application.getModel().getLevel().getBoard();
		Slot up = board.get(this.slot.getLoc().pullNearbyLocation(0,-1));
		Slot right = board.get(this.slot.getLoc().pullNearbyLocation(1,0));
		Slot down = board.get(this.slot.getLoc().pullNearbyLocation(0,1));
		Slot left = board.get(this.slot.getLoc().pullNearbyLocation(-1,0));
		if(up == null)
			g.drawLine(0, 1, super.getWidth()-1, 1);
		if(right ==null)
			g.drawLine(super.getWidth()-2, 0, super.getWidth()-2, super.getHeight()-1);
		if(down == null)
			g.drawLine(0, super.getHeight()-2, super.getWidth()-1, super.getHeight()-2);
		if(left == null)
			g.drawLine(1, 0, 1, super.getHeight()-1);
		if(((BucketSlot)this.slot).isOccupied()){
			g.setColor(new Color(255,100,255));
			g.fillOval(super.getWidth()/4,super.getHeight()/4,super.getWidth()/2,super.getHeight()/2);
		}
		else{
			g.setColor(new Color(255,255,255,50));
			g.fillOval(super.getWidth()/4,super.getHeight()/4,super.getWidth()/2,super.getHeight()/2);
		}
	}

	public boolean equals(Object o){
		if(o instanceof ActiveSlotView){
			ActiveSlotView other = (ActiveSlotView)o;
			return other.slot.equals(this.slot);
		}
		return false;

	}

	public TileView getTileView(){
		return this.tileView;
	}

	public void blink(){
		this.tileView.blink();
	}

	public Slot getSlot(){
		return this.slot;
	}
}
