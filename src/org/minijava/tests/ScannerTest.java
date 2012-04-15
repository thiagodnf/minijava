package org.minijava.tests;

import java.io.*;
import javax.swing.JTextArea;
import java_cup.runtime.Symbol;
import org.minijava.scanner.Scanner;
import JFlex.sym;

public class ScannerTest {
	
	private java.io.Reader reader;
	private JTextArea console = null;
	
	/**
	 * Construtor
	 * @param reader Cadeia de caracter para validar
	 */
	public ScannerTest(String reader){
		this.reader = new java.io.StringReader(reader);
	}
	
	/**
	 * Construtor
	 * @param path Diretório do código .java
	 */
	public ScannerTest(File file){
		try {
			this.reader = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void setConsole(JTextArea console){
		this.console = console;
	}
	
	public void run(){
		println("=========================");
		println("Scanner: Starting");
		try {
			// Cria o Scanner para o arquivo
			Scanner s = new Scanner(this.reader);
			Symbol t = s.next_token();
			while (t.sym != sym.EOF) {
				// Imprime cada token lido na tela
				println("  "+s.symbolToString(t));
				t = s.next_token();
			}
			println("Scanner: Done.");
		} catch (Exception e) {
			//Quando algum caracter inválido foi encontrado
			println("");
			println("Compiler Error:");
			print("\t"+e.getMessage());
		}
		
	}
	
	private void print(String stream){
		if(this.console == null){
			System.out.print(stream + " ");
		}else{	
			console.append(stream);
		}
	}
	
	private void println(String stream){
		print(stream);
		print("\n");
	}
}
