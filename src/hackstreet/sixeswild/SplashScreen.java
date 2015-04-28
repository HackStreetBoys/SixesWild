package hackstreet.sixeswild;
import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

/**
 * 
 * @author timpetri
 * Class for splash screens, most code found online
 */
public class SplashScreen extends JWindow {

	private int duration;
	private String path;
	
	public SplashScreen(int d, String p) {
		this.duration = d;
		this.path = p;
	}

	// A simple little method to show a title screen in the center
	// of the screen for the amount of time given in the constructor
	public void showSplash() {
		JPanel content = (JPanel)getContentPane();
		content.setBackground(Color.white);

		// Set the window's bounds, centering the window
		int width = 630;
		int height = 300;
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width-width)/2;
		int y = (screen.height-height)/2;
		setBounds(x,y,width,height);

		// Build the splash screen
		JLabel label = new JLabel(new ImageIcon(this.path));
		content.add(label, BorderLayout.CENTER);
		content.setBorder(BorderFactory.createLineBorder(Color.BLACK , 1));

		// Display it
		setVisible(true);

		// Wait a little while
		try { Thread.sleep(duration); } catch (Exception e) {}

		setVisible(false);
	}
	
	public void showSplashAndExit() {
		showSplash();
		System.exit(0);
	}




	public static void main(String[] args) {
	    // Throw a nice little title page up on the screen first
	    SplashScreen splash = new SplashScreen(10000, "LevelBuilderSplashScreen.png");
	    // Normally, we'd call splash.showSplash() and get on with the program.
	    splash.showSplashAndExit();
	}

}
