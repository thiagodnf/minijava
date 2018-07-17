package thiagodnf.minijava.util;

import com.apple.eawt.AboutHandler;
import com.apple.eawt.AppEvent.AboutEvent;
import com.apple.eawt.AppEvent.PreferencesEvent;
import com.apple.eawt.AppEvent.QuitEvent;
import com.apple.eawt.PreferencesHandler;
import com.apple.eawt.QuitHandler;
import com.apple.eawt.QuitResponse;

@SuppressWarnings({ "restriction" })
public class MacOSManager implements AboutHandler, QuitHandler, PreferencesHandler{

	public MacOSManager() {
		com.apple.eawt.Application app = com.apple.eawt.Application.getApplication();
		app.setAboutHandler(this);
		app.setPreferencesHandler(this);
		app.setQuitHandler(this);
	}
	
	public void handlePreferences(PreferencesEvent arg0) {
		//new OpenPreferencesAction().actionPerformed(null);
	}

	public void handleQuitRequestWith(QuitEvent arg0, QuitResponse arg1) {
		System.exit(0);
	}

	public void handleAbout(AboutEvent e) {
		//new OpenAboutAction().actionPerformed(null);
	}
}
