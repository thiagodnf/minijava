import java.io.File;
import org.minijava.gui.MiniJavaGUI;
import org.minijava.tests.ScannerTest;
import org.apache.commons.cli.*;

public class MiniJava {

	private static void printVersion(){
		System.out.println("This is MiniJava Compiler 1.0");
	}
	
	private static void printAbout(){
		System.out.println("MiniJava Compiler 1.0");
		System.out.println("By Débora Martins and Thiago Nascimento");						
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File code = null;
		Options options = new Options();		
		options.addOption("c","console",false, "MODE: Console Application Mode");
		options.addOption("gui", false, "MODE: GUI Application Mode");
		options.addOption("d","directory", true, "File Directory");
		options.addOption("v","version", false, "Print the Version Information");
		options.addOption("a","about", false, "About the MiniJava Compiler");

		CommandLineParser parser = new PosixParser();
		try {
			CommandLine cmd = parser.parse(options, args);	
			
			if (cmd.hasOption("d")){
				code = new File(cmd.getOptionValue("d"));
			}
			if(cmd.hasOption("v")){
				printVersion();
			}
			if(cmd.hasOption("a")){
				printAbout();
			}
			if (cmd.hasOption("gui")){
				MiniJavaGUI gui = new MiniJavaGUI(code);
				gui.run();
			}else if(cmd.hasOption("c")){
				if( code != null){
					ScannerTest scanner = new ScannerTest(code);
					scanner.run();
				}
			}else
				throw new ParseException("");				
		} catch (ParseException e) {
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("MiniJava.jar <mode> <option>",options);
		}				
	}

}
