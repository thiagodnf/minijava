import java.io.File;
import org.minijava.gui.MiniJavaGUI;
import org.minijava.tests.ScannerTest;
import org.apache.commons.cli.*;

public class MiniJava {

	private static void printHeader() {
		System.out.println("===========================================");
		System.out.println("MiniJava Compiler");
		System.out.println("Version:  1.0");
		System.out.println("Authors: Débora Martins e Thiago Nascimento");
		System.out.println("===========================================");
		System.out.println("Welcome");
	}
	
	private static void printVersion(){
		System.out.println("MiniJava Compiler Version: 1.0");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Options options = new Options();
		File code = null;
		options.addOption("gui", false, "Load Graphics Interface");
		options.addOption("d", true, "Code's path");
		options.addOption("v", false, "MiniJava Compiler Version");

		CommandLineParser parser = new PosixParser();
		try {
			CommandLine cmd = parser.parse(options, args);	
			
			if (cmd.hasOption("d")){
				code = new File(cmd.getOptionValue("d"));
			}
			if(cmd.hasOption("v")){
				printVersion();
			}
			if (cmd.hasOption("gui")){
				printHeader();
				MiniJavaGUI gui = new MiniJavaGUI(code);
				gui.run();
			}else{
				if( code != null){
					printHeader();
					ScannerTest scanner = new ScannerTest(code);
					scanner.run();
				}else
					throw new ParseException("");
			}	
		} catch (ParseException e) {
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("MiniJava Compiler",options);
		}				
	}

}
