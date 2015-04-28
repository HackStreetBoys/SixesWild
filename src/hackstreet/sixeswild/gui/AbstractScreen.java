package hackstreet.sixeswild.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
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
		//super.setBackground(Color.yellow); //TODO
		
		this.title = new JLabel(title);
		this.title.setSize(200,75);
		this.title.setLocation(300,0);
		this.title.setHorizontalAlignment(SwingConstants.CENTER);
		this.title.setFont(new Font("Serif",Font.BOLD,48));
		this.setupFont();
		this.title.setBackground(new Color(0,0,0,0));
		super.add(this.title);
	}
	
	public SWApplication getApplication(){
		return this.application;
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
//		g.setColor(Color.black);
//		Color cornsilk = new Color(255,248,220);
//		Color blanchedalmond = new Color(255,235,205);
//		Color bisque = new Color(255,228,196);
//		Color navajowhite = new Color(255,222,173);
//		Color wheat = new Color(245,222,179);
//		Color burlywood = new Color(222,184,135);
//		Color tan = new Color(210,180,140);
//		Color[] colors = {
//				cornsilk,
//				blanchedalmond,
//				bisque,
//				navajowhite,
//				wheat,
//				burlywood,
//				tan};
//		for(int x=0; x<800; x+=10){
//			for(int y=0; y<600; y+=10){
//				g.setColor(colors[(int)(7*Math.random())]);
//				g.fillRect(x,y,10,10);
//			}
//		}
	}
	
	private void setupFont(){
		Font titleFont = this.title.getFont();
		String titleText = this.title.getText();

		int stringWidth = this.title.getFontMetrics(titleFont).stringWidth(titleText);
		int componentWidth = this.title.getWidth();

		// Find out how much the font can grow in width.
		double widthRatio = (double)componentWidth / (double)stringWidth;

		int newFontSize = (int)(titleFont.getSize() * widthRatio);
		int componentHeight = this.title.getHeight();

		// Pick a new font size so it will not be larger than the height of this.title.
		int fontSizeToUse = Math.min(newFontSize, componentHeight);

		// Set the this.title's font size to the newly determined size.
		this.title.setFont(new Font(titleFont.getName(), Font.PLAIN, fontSizeToUse));
	}
}