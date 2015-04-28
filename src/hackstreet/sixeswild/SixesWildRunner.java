package hackstreet.sixeswild;

import hackstreet.sixeswild.gui.SWApplication;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class SixesWildRunner {

	public static void main(String[] args){

		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} 
		catch (Exception e) { 
			// none
		}

		SplashScreen splash = new SplashScreen(5000, "images/SixesWildSplashScreen.png");
		splash.showSplash();

		SixesWild model = new SixesWild();

		SWApplication application = new SWApplication(model);
		application.setVisible(true);
	}

}
