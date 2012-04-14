import org.minijava.scanner.Scanner;

import java_cup.runtime.Symbol;
import JFlex.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Starting...");

		try {
			//Cria o Scanner para o arquivo
			Scanner s = new Scanner(new java.io.StringReader("return a;d"));
			Symbol t = s.next_token();
			while (t.sym != sym.EOF) {
				//Imprime cada token lido na tela
				System.out.print(s.symbolToString(t) + " ");
				t = s.next_token();
			}
			System.out.print("\nLexical analysis successfull");
		} catch (Exception e) {
			System.out.println();
			// Some kind of error in the compiler implementation that we're not expecting (a bug!)
			System.err.println("Compiler Error:");
			e.printStackTrace();
		}

	}

}
