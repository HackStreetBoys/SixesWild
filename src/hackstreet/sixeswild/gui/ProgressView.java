package hackstreet.sixeswild.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ProgressView extends JPanel{

	BufferedImage currentImage;
	BufferedImage noStars;
	BufferedImage oneStars;
	BufferedImage twoStars;
	BufferedImage threeStars;

	private int oneCap;
	private int twoCap;
	private int threeCap;
	private int value;

	public ProgressView(){
		super.setSize(50,200);
		super.setBackground(new Color(0,0,0,0));

		try {
			noStars = ImageIO.read(new File("images/0-stars-attained.png"));
			oneStars = ImageIO.read(new File("images/1-star-attained.png"));
			twoStars = ImageIO.read(new File("images/2-stars-attained.png"));
			threeStars = ImageIO.read(new File("images/3-stars-attained.png"));
		} catch (IOException e) {
		}

		this.currentImage = this.noStars;
	}

	public void setCaps(int one, int two, int three){
		this.oneCap = one;
		this.twoCap = two;
		this.threeCap = three;
	}

	public void setValue(int value){
		this.value = value;
		if(value>=threeCap)
			setNumStars(3);
		else if(value>=twoCap)
			setNumStars(2);
		else if(value>=oneCap)
			setNumStars(1);
	}

	public void setNumStars(int numStars){
		if(numStars==0)
			this.currentImage = this.noStars;
		else if(numStars==1)
			this.currentImage = this.oneStars;
		else if(numStars==2)
			this.currentImage = this.twoStars;
		else
			this.currentImage = this.threeStars;
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.black);

		int baseY = 190;
		int oneY = 120;
		int twoY = 75;
		int threeY = 20;
		int width = 30;

		if(value<=oneCap){
			g.setColor(Color.green);
			double ratio = (double)value/oneCap;
			double height = ratio * (190-oneY); 
			g.fillRect(10, baseY-(int)height, width , (int)height);
		}
		else if(value<=twoCap){
			g.setColor(Color.yellow);
			double ratio = (double)(value-oneCap)/(twoCap-oneCap);
			double height = ratio * (oneY-twoY) + baseY-oneY; 
			g.fillRect(10, baseY-(int)height, width , (int)height);
		}
		else if(value<=threeCap){
			g.setColor(Color.red);
			double ratio = (double)(value-twoCap)/(threeCap-twoCap);
			double height = ratio * (twoY-threeY) + baseY - twoY; 
			g.fillRect(10, baseY-(int)height, width , (int)height);
		}
		else{
			g.setColor(Color.blue);
			g.fillRect(10,20,30,170);
		}
		g.drawImage(this.currentImage,0,0,null);
	}
}
