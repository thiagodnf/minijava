import java.io.File;

import org.minijava.gui.MiniJavaGUI;
import org.minijava.tests.ScannerTest;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		header();
		
		if(args[0].equals("-gui")){
			
		}else if(args[0].equals("-d")){
			ScannerTest scanner = new ScannerTest(new File(args[1]));
			scanner.run();
		}else{
			MiniJavaGUI gui = new MiniJavaGUI();
			gui.run();
		}
	}

	private static void header() {
		System.out.println("===========================================");
		System.out.println("Compilador para a linguagem MiniJava");
		System.out.println("Versão:  1.0");
		System.out.println("Autores: Débora Martins e Thiago Nascimento");
		System.out.println("===========================================");
	}
}
