import org.minijava.scanner.Scanner;

import java_cup.runtime.Symbol;
import JFlex.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		showHeader();
		System.out.println("Iniciando...");

		try {
			// Cria o Scanner para o arquivo
			Scanner s = new Scanner(new java.io.StringReader("return a;"));
			Symbol t = s.next_token();
			while (t.sym != sym.EOF) {
				// Imprime cada token lido na tela
				System.out.print(s.symbolToString(t) + " ");
				t = s.next_token();
			}
			System.out.println("\nAnálise Léxica terminou com sucesso!");
		} catch (Exception e) {
			//Quando algum caracter inválido foi encontrado
			System.out.println();			
			System.err.println("Compiler Error:");
			e.printStackTrace();
		}
	}

	private static void showHeader(){
		System.out.println(
			"==========================================="	+ "\n"+
			"Compilador para a linguagem MiniJava"			+ "\n"+
			"Versão:  1.0" 			   						+ "\n"+
			"Autores: Débora Martins e Thiago Nascimento" 	+ "\n"+			
			"==========================================="					
		);
	}
}
