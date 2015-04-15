package hackstreet.sixeswild;

import hackstreet.sixeswild.gui.SWApplication;


public class SixesWildRunner {
	
	public static void main(String[] args){
		/*
		SplashScreen splash = new SplashScreen(5000, "images/SixesWildSplashScreen.png");
		splash.showSplash();
		*/
		
		SixesWild model = new SixesWild();
		
		SWApplication application = new SWApplication(model);
		application.setVisible(true);
	}
	
}
