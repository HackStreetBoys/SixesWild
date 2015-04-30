package hackstreet.sixeswild.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import hackstreet.sixeswild.game.Location;
import hackstreet.sixeswild.game.Slot;
import hackstreet.sixeswild.game.Tile;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class TileView extends JPanel {

	private SWApplication application;

	private Slot modelContainer;
	private Tile tile;
	private boolean selected;
	
	private Timer timer;
	private boolean blink;

	public TileView(SWApplication application, Slot modelContainer, Tile tile){
		this.application = application;
		this.modelContainer = modelContainer;
		this.tile = tile;
		this.timer = null;
		this.blink = false;

		JLabel value = new JLabel(tile.getValue() + "");
		value.setBackground(new Color(0,0,0,0));
		value.setFont(new Font("Serif",Font.BOLD,24));
		value.setHorizontalAlignment(SwingConstants.CENTER);

		this.setBackgroundColor();

		super.add(value);
	}

	public Tile getTile(){
		return this.tile;
	}

	public void setSelected(boolean selected){
		this.selected = selected;
	}

	private void setBackgroundColor(){
		if(tile.getValue() == 1)
			super.setBackground(new Color(255,100,100));
		else if(tile.getValue() == 2)
			super.setBackground(new Color(255,170,100));
		else if(tile.getValue() == 3)
			super.setBackground(new Color(255,255,100));
		else if(tile.getValue() == 4)
			super.setBackground(new Color(100,255,100));
		else if(tile.getValue() == 5)
			super.setBackground(new Color(100,100,255));
		else
			super.setBackground(new Color(255,100,255));
	}
	
	public void blink(){
		this.timer = new Timer(200,new ActionListener(){
			int numBlinks = 20; // divided by 2
			@Override
			public void actionPerformed(ActionEvent e){
				if(numBlinks%2==0)
					setBlink(false);
				else
					setBlink(true);
				if(numBlinks==0)
					timer.stop();
				numBlinks--;

				application.revalidate();
				application.repaint();
			}
		});
		this.timer.start();
	}
	
	private void setBlink(boolean blink){
		this.blink = blink;
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setColor(Color.black);
		if(this.tile.getMultiplier()>1){
			int mult = this.tile.getMultiplier();
			g.setFont(new Font("Serif",Font.BOLD,10));
			g.drawString(mult + "x", super.getWidth()-15,super.getHeight()-5);
		}
		this.renderSelectionGraphic(g);
		this.renderBordering(g);
	}

	private void renderSelectionGraphic(Graphics g){
		if(this.selected){
			int total = 0;
			for(Slot slot:application.getModel().getLevel().getSelectedSlots())
				total += slot.getTile().getValue();

			if(total<6)
				g.setColor(new Color(255,255,255));
			else if(total==6)
				g.setColor(new Color(0,255,0));
			else
				g.setColor(new Color(255,0,0));

			int thickness = 3; //pixels
			for(int n=0;n<thickness;n++){
				g.drawRect(0+n,0+n,super.getWidth()-n*2-1,super.getHeight()-n*2-1);
			}
			g.setColor(Color.black);
			g.drawRect(0+thickness,0+thickness,super.getWidth()-thickness*2-1,super.getHeight()-thickness*2-1);
		}
		else if(this.blink){
			g.setColor(Color.yellow);
			int thickness = 3; //pixels
			for(int n=0;n<thickness;n++){
				g.drawRect(0+n,0+n,super.getWidth()-n*2-1,super.getHeight()-n*2-1);
			}
			g.setColor(Color.black);
			g.drawRect(0+thickness,0+thickness,super.getWidth()-thickness*2-1,super.getHeight()-thickness*2-1);
		}
	}

	private void renderBordering(Graphics g){
		g.setColor(Color.black);
		HashMap<Location,Slot> board = application.getModel().getLevel().getBoard();
		Slot up = board.get(this.modelContainer.getLoc().pullNearbyLocation(0,-1));
		Slot right = board.get(this.modelContainer.getLoc().pullNearbyLocation(1,0));
		Slot down = board.get(this.modelContainer.getLoc().pullNearbyLocation(0,1));
		Slot left = board.get(this.modelContainer.getLoc().pullNearbyLocation(-1,0));
		if(up == null)
			g.drawLine(0, 0, super.getWidth(), 0);
		if(right == null)
			g.drawLine(super.getWidth()-1, 0, super.getWidth()-1, super.getHeight()-1);
		if(down == null)
			g.drawLine(0, super.getHeight()-1, super.getWidth()-1, super.getHeight()-1);
		if(left == null)
			g.drawLine(0, 0, 0, super.getHeight()-1);
	}
}