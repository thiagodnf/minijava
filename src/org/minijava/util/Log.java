package org.minijava.util;

public class Log {
	
	private String text;
	private String message;
	private int line;
	private int column;
	
	public Log(String message,String text,int line,int column){
		this.text = text;
		this.message = message;
		this.line = line;
		this.column = column;
	}
	
	public Log(String message,String text){
		this(text,message,-1,-1);
	}
	
	public String toString(){
		return "Line:"+line+"; Column:"+column+"; "+message+"'"+text+"'";
	}

}
