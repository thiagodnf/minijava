package thiagodnf.minijava.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;

import javax.swing.JTextArea;

import JFlex.sym;
import java_cup.runtime.Symbol;
import javafx.scene.control.TextArea;
import thiagodnf.minijava.log.Log;
import thiagodnf.minijava.scanner.Scanner;

public class ScannerTest {

	private Reader reader;
	private TextArea console = null;

	/**
	 * Construtor
	 * 
	 * @param reader Cadeia de caracter para validar
	 */
	public ScannerTest(String reader) {
		this.reader = new java.io.StringReader(reader);
	}

	/**
	 * Construtor
	 * 
	 * @param path Diretório do código .java
	 */
	public ScannerTest(File file) {
		try {
			this.reader = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void setConsole(TextArea console) {
		this.console = console;
	}

	public void run() {
		println("=========================");
		println("Scanner: Starting");
		try {
			// Cria o Scanner para o arquivo
			Scanner s = new Scanner(this.reader);
			Symbol t = s.next_token();
			while (t.sym != sym.EOF) {
				// Imprime cada token lido na tela
				println("  " + s.symbolToString(t));
				t = s.next_token();
			}

			//Print Lexical Logs
			List<Log> log = s.getLogs();
			if (!log.isEmpty()) {
				println("Lexical Errors:");
				for (int i = 0; i < log.size(); i++)
					println("\t"+log.get(i).toString());				
			}
			println("Scanner: Done.");
		} catch (Exception e) {
			println("Compiler Error:");
			print("\t" + e.getMessage());
		}

	}

	private void print(String stream) {
		if (this.console == null) {			
			System.out.print(stream + " ");
		}else{
			console.appendText(stream);
			
			//console.setCaretPosition(console.getText().length());
		}		
	}

	private void println(String stream) {
		print(stream);
		print("\n");
	}
}
