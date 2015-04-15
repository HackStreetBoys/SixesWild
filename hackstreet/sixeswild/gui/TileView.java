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
