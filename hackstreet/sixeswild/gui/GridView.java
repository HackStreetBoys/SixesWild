package hackstreet.sixeswild.gui;

import java.awt.GridLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GridView extends JPanel {

	public GridView(){
		super.setLayout(new GridLayout(9,9));
	}
}
