package hackstreet.sixeswild.gui;

<<<<<<< HEAD
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
=======
import javax.swing.JPanel;

public abstract class AbstractScreen extends JPanel {
>>>>>>> 07050e1f4ec669beae4ab0e2fc4eac50cbc9718f

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public abstract class AbstractScreen extends JPanel{

	private SWApplication application;
	private JLabel title;
	
	public AbstractScreen(SWApplication application, String title){
		this.application = application;
		
		super.setLayout(null);
		
		this.title = new JLabel(title);
		this.title.setVerticalAlignment(SwingConstants.CENTER);
		this.title.setFont(new Font("SansSerif",Font.BOLD,48));
		this.title.setSize(300,100);
		this.title.setLocation(250,0);
		this.title.setBackground(new Color(0,0,0,0));
		super.add(this.title);
	}
	
	public SWApplication getApplication(){
		return this.application;
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.black);
		g.drawRect(this.title.getX(), this.title.getY(), this.title.getWidth(), this.title.getHeight());
	}
}
