package org.minijava.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java_cup.runtime.Symbol;

import org.minijava.scanner.Scanner;

import JFlex.sym;

public class ScannerTest {
	
	private java.io.Reader reader;
	
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
	
	public void run(){
		System.out.println("Iniciando...Scanner");
		try {
			// Cria o Scanner para o arquivo
			Scanner s = new Scanner(this.reader);
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
}
