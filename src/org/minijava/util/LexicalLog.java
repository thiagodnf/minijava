package org.minijava.util;

public class LexicalLog extends Log{
	
	private static String message = "Invalid Character:";

	public LexicalLog(String text, int line, int column) {
		super(message,text,line, column);		
	}
	
	public LexicalLog(String text) {
		super(message,text);		
	}
	
	public String toString(){
		return super.toString();
	}
	

}
