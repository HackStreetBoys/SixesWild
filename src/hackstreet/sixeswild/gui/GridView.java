package hackstreet.sixeswild.gui;

import hackstreet.sixeswild.controller.SwipeController;
import hackstreet.sixeswild.game.Location;
import hackstreet.sixeswild.game.Slot;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GridView extends JPanel {

	public GridView(SWApplication application){
		super.setLayout(new GridLayout(9,9));
		super.setBackground(new Color(0,0,0,0));
		this.addController(application);
		
		for(int y=0; y<9; y++){
			for(int x=0; x<9; x++){
				Location loc = new Location(x,y);
				Slot slot = application.getModel().getLevel().getBoard().get(loc);
				ActiveSlotView slotView = new ActiveSlotView(slot);
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
	
	private void addController(SWApplication application){
		SwipeController sl = new SwipeController(application);
		super.addMouseListener(sl);
		super.addMouseMotionListener(sl);
	}
}
