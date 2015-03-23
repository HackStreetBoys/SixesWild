package hackstreet.sixeswild;

import java.awt.Graphics2D;
import java.awt.SplashScreen;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class SixesWildRunner {
	
	public static void main(String[] args){
		
		splashScreenInit();
		
	}
	
	//Requires Import Graphics2D and SplashScreen
	//Splash Screen should be a .gif in the same folder as the code that calls it.
	
	private static void splashScreenInit()
	{
		JFrame f = new JFrame("Splash!");
		// No resize
		f.setResizable(false);
		// No decoration (like the red x for example)
		f.setUndecorated(true);
		// Show the frame centered
		f.setLocationRelativeTo(null);
		// Make it visible
		f.setVisible(true);
		f.setSize(200, 100);
		
		//TODO add an actual graphic and a progress-bar to make this look shiny and awesome.
		
		//Load Image
		//Update bar.
		
        
        
	}
}
