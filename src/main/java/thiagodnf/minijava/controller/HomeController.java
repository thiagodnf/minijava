package thiagodnf.minijava.controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import thiagodnf.minijava.util.ScannerTest;

public class HomeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	@FXML
	private Button compileButton;
	
	@FXML
	private TextArea codeTextArea;
	
	@FXML
	private TextArea consoleTextArea;
	
	@FXML
	private Pane parent;
	
	public void compile() {
		
		LOGGER.debug("Compiling");
		
		String code = codeTextArea.getText();
		
		if(code.isEmpty()) {
			consoleTextArea.appendText("ERROR! Code is empty\n");
		}else {
			code = code.trim();
			
			ScannerTest scanner = new ScannerTest(code);
			scanner.setConsole(consoleTextArea);
			scanner.run();
		}
	}
	
	public void openFile() {
		
		LOGGER.debug("Opening File");
		
		Stage stage = (Stage) parent.getScene().getWindow();
		
		FileChooser fileChooser = new FileChooser();
		
		fileChooser.setTitle("Open File");
		fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
		
		File file = fileChooser.showOpenDialog(stage);
		
		try {
			String content = FileUtils.readFileToString(file, Charset.defaultCharset());
			
			codeTextArea.setText(content);
		} catch (IOException e) {
			consoleTextArea.appendText(e.getMessage());
			LOGGER.error(e.getMessage(), e);
		}
	}
	
	public void clearConsole() {
		LOGGER.debug("Clearing Console");
		consoleTextArea.clear();
	}
	
	public void newFile() {
		LOGGER.debug("Creating New File");
		codeTextArea.clear();
	}
	
	public void quit() {
		LOGGER.debug("Quiting the app");
		System.exit(1);
	}
		
}
