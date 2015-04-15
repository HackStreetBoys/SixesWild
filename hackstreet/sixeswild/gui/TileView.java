package hackstreet.sixeswild.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import hackstreet.sixeswild.game.Tile;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class TileView extends JPanel {
	
	private Tile tile;
	
	public TileView(Tile tile){
		this.tile = tile;
		
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
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.black);
		if(this.tile.getMultiplier()>1){
			int mult = this.tile.getMultiplier();
			g.setFont(new Font("Serif",Font.BOLD,10));
			g.drawString(mult + "x", super.getWidth()-15,super.getHeight()-5);
		}
	}
}
