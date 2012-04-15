package org.minijava.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

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
		println("Iniciando...Scanner");
		try {
			// Cria o Scanner para o arquivo
			Scanner s = new Scanner(this.reader);
			Symbol t = s.next_token();
			while (t.sym != sym.EOF) {
				// Imprime cada token lido na tela
				print(s.symbolToString(t));
				t = s.next_token();
			}
			println("\nAnálise Léxica terminou com sucesso!");
		} catch (Exception e) {
			//Quando algum caracter inválido foi encontrado
			println("");
			print("Compiler Error:");
			print(e.getMessage());
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
