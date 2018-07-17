package thiagodnf.minijava.util;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.fxml.FXMLLoader;
import thiagodnf.minijava.Launcher;

public class FXMLUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(FXMLUtil.class);

	public static Object load(String fxmlFile) {

		LOGGER.info("Loading FXML: {}", fxmlFile);

		FXMLLoader loader = new FXMLLoader();

		try {
			return loader.load(Launcher.class.getResourceAsStream(fxmlFile));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
