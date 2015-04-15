package hackstreet.sixeswild.gui;

import hackstreet.sixeswild.game.Location;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GridView extends JPanel {

	public GridView(){
		super.setLayout(new GridLayout(9,9));
		super.setBackground(new Color(0,0,0,0));
		
		for(int y=0; y<9; y++){
			for(int x=0; x<9; x++){
				Location loc = new Location(x+1,y+1);
				ActiveSlotView slotView = new ActiveSlotView(loc);
				super.add(slotView, new Dimension(x,y));
			}
		}
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.black);
		g.drawRect(1,1,super.getWidth()-3,super.getHeight()-3);
	}
}
