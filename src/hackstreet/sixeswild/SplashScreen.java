package hackstreet.sixeswild;
import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

/**
 * Splash screen that will display the given image for a given duration.
 * 
 * @author Tim Petri
 * 
 */
public class SplashScreen extends JWindow {
	
	/** Sleep duration in milliseconds. */
	private int duration;
	
	/** Relative path for image to display (should be 630*300px.) */
	private String path;
	
	/** Constructor */
	public SplashScreen(int d, String p) {
		this.duration = d;
		this.path = p;
	}
	
	/**
	 * Show the splash screen.
	 */
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
	
	/**
	 * Show the splash screen and exit.
	 * 
	 * Used for testing.
	 */
	public void showSplashAndExit() {
		showSplash();
		System.exit(0);
	}
}
