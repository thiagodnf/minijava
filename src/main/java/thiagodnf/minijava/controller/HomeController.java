package thiagodnf.minijava.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import thiagodnf.minijava.util.ScannerTest;

public class HomeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	@FXML
	private Button compileButton;
	
	@FXML
	private TextArea codeTextArea;
	
	@FXML
	private TextArea consoleTextArea;
	
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
}
