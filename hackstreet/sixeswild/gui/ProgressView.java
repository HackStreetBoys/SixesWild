package hackstreet.sixeswild.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ProgressView extends JPanel{

	public ProgressView(){
		super.setSize(50,150);
		super.setBackground(new Color(0,0,0,0));
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.black);
		
		int offset = 10;
		
		g.drawRoundRect(0,offset,super.getWidth()-1,super.getHeight()-1-offset,25,25);
		g.drawLine(0,super.getHeight()/2+offset,super.getWidth()-1,super.getHeight()/2+offset);
		this.drawStar(g,super.getWidth()/2,super.getHeight()/2+offset,5);
		g.drawLine(0,super.getHeight()/4+offset,super.getWidth()-1,super.getHeight()/4+offset);
		this.drawStar(g, super.getWidth()/2, super.getHeight()/4+offset, 5);
		this.drawStar(g, super.getWidth()/2, offset, 5);
	}
	
	private void drawStar(Graphics g,int midX, int midY, int radius){
	    g.setColor(Color.black);
	    g.fillRect(midX-radius,midY-radius,radius*2,radius*2);
	}
}
