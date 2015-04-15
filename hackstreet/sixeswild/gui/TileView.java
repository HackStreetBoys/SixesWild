<<<<<<< HEAD
package hackstreet.sixeswild.gui;

import java.awt.Color;
import java.awt.Font;

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
		
		super.add(value);
	}
	
	public Tile getTile(){
		return this.tile;
	}
}
=======
package hackstreet.sixeswild.gui;

import hackstreet.sixeswild.game.Tile;

import javax.swing.JPanel;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class TileView extends JPanel{
	public TileView(Tile tile) {
		
		setLayout(null);
		
		JLabel labelNum = new JLabel("");
		labelNum.setBounds(74, 93, 46, 14);
		add(labelNum);
		
		JLabel labelMultiplier = new JLabel("");
		labelMultiplier.setBounds(144, 175, 46, 14);
		add(labelMultiplier);

	
	}
}
>>>>>>> 297fb6f6cef36080039dd44c6b952de5629e76d8
