package thiagodnf.minijava;

import java.net.URL;

import javax.swing.ImageIcon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.codecentric.centerdevice.MenuToolkit;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import thiagodnf.minijava.util.FXMLUtil;
import thiagodnf.minijava.util.OSUtil;

public class Launcher extends Application {

	private static final Logger LOGGER = LoggerFactory.getLogger(Launcher.class);

	public static void main(String[] args) throws Exception {

		LOGGER.info("====================================");
		LOGGER.info("MiniJava");
		LOGGER.info("====================================");
		LOGGER.info("User Directory: {}", System.getProperty("user.dir"));
		LOGGER.info("Operational System Name: {}", System.getProperty("os.name"));
		LOGGER.info("Operational System Arch: {}", System.getProperty("os.arch"));
		LOGGER.info("Operational System Version: {}", System.getProperty("os.version"));
		LOGGER.info("Java Home: {}", System.getProperty("java.home"));
		LOGGER.info("Java Vendor: {}", System.getProperty("java.vendor"));
		LOGGER.info("Java Vendor URL: {}", System.getProperty("java.vendor.url"));
		LOGGER.info("Java Version: {}", System.getProperty("java.version"));
		
		launch(args);
	}
	
	public void start(Stage stage) throws Exception {
		
		if (OSUtil.isMac()) {
			
			System.setProperty("apple.awt.graphics.EnableQ2DX", "true");
			System.setProperty("apple.laf.useScreenMenuBar", "true");
			System.setProperty("com.apple.mrj.application.apple.menu.about.name", "MiniJava");
			System.setProperty("apple.awt.application.name", "MiniJava");
			
			try {
				URL iconURL = Launcher.class.getResource("/images/icon.png");
				java.awt.Image image = new ImageIcon(iconURL).getImage();
				com.apple.eawt.Application.getApplication().setDockIconImage(image);
			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}
			
			MenuToolkit tk = MenuToolkit.toolkit();
			
			// Create the default Application menu
			Menu defaultApplicationMenu = tk.createDefaultApplicationMenu("MiniJava");
			
			// Update the existing Application menu
			tk.setApplicationMenu(defaultApplicationMenu);
		}else {
			stage.getIcons().add(new Image(this.getClass().getResourceAsStream("/images/icon.png")));
		}
		
		Parent rootNode = (Parent) FXMLUtil.load("/fxml/home.fxml");

		Scene scene = new Scene(rootNode);
		scene.getStylesheets().add("/styles/styles.css");

		stage.setTitle("MiniJava");
		stage.setScene(scene);
		
		stage.show();
	}
}
