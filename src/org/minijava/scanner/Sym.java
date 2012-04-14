package org.minijava.scanner;

import java_cup.runtime.Symbol;
import JFlex.*;

public class Sym implements sym {
	
	public static final int WORD_RETURN 	= 48;
	public static final int WORD_CLASS 		= 49;
	public static final int WORD_PUBLIC 	= 50;
	public static final int WORD_STATIC 	= 51;
	public static final int WORD_VOID 		= 52;
	public static final int WORD_MAIN 		= 53;
	public static final int WORD_EXTENDS 	= 54;
	public static final int WORD_THIS 		= 55;
	public static final int WORD_NEW 		= 56;
	public static final int WORD_LENGTH 	= 57;
	public static final int WORD_PRINTLN 	= 58;

	public static final int TYPE_INT 		= 59;
	public static final int TYPE_BOOL 		= 60;
	public static final int TYPE_STRING 	= 61;

	public static final int COND_IF 		= 62;
	public static final int COND_ELSE 		= 63;
	public static final int COND_WHILE 		= 64;

	public static final int BOOL_TRUE 		= 65;
	public static final int BOOL_FALSE		= 66;

	public static final int IDENTIFIER 		= 67;
	public static final int INTEGER_LITERAL = 68;

	public static final int OP_PLUS 		= 69;
	public static final int OP_MINUS 		= 70;
	public static final int OP_EQUAL		= 71;
	public static final int OP_NOT 			= 72;
	public static final int OP_MULT 		= 73;
	public static final int OP_AND 			= 74;
	public static final int OP_LT 			= 75;

	public static final int DEL_LPAREN 		= 76;
	public static final int DEL_RPAREN 		= 77;
	public static final int DEL_SEMICOLON 	= 78;
	public static final int DEL_COMMA 		= 79;
	public static final int DEL_DOT 		= 80;
	public static final int DEL_LBRACE 		= 81;
	public static final int DEL_RBRACE 		= 82;
	public static final int DEL_LBRACK 		= 83;
	public static final int DEL_RBRACK 		= 84;
	
	public static final String toString(Symbol symbol){
		switch (symbol.sym){
			case WORD_RETURN: 	  return "<RETURN>";
			case WORD_CLASS: 	  return "<CLASS>";
			case WORD_PUBLIC: 	  return "<PUBLIC>";
			case WORD_STATIC: 	  return "<STATIC>";
			case WORD_VOID: 	  return "<VOID>";
			case WORD_MAIN: 	  return "<MAIN>";
			case WORD_EXTENDS: 	  return "<EXTENDS>";
			case WORD_THIS: 	  return "<THIS>";
			case WORD_NEW:		  return "<NEW>";
			case WORD_LENGTH: 	  return "<LENGTH>";
			case WORD_PRINTLN: 	  return "<PRINTLN>";
			case TYPE_INT:		  return "<INT>";
			case TYPE_BOOL: 	  return "<BOOL>";
			case TYPE_STRING: 	  return "<STRING>";
			case COND_IF:		  return "<IF>";
			case COND_ELSE: 	  return "<ELSE>";
			case COND_WHILE: 	  return "<WHILE>";
			case BOOL_TRUE: 	  return "<TRUE>";
			case BOOL_FALSE: 	  return "<FALSE>";
			case IDENTIFIER: 	  return "<ID("+(String)symbol.value+")>";
			case INTEGER_LITERAL: return "<INT("+(String)symbol.value+")>";
			case OP_PLUS: 		  return "<PLUS>";
			case OP_MINUS: 		  return "<MINUS>";
			case OP_EQUAL: 	   	  return "<EQUAL>";
			case OP_NOT: 		  return "<NOT>";
			case OP_MULT: 		  return "<MULT>";
			case OP_AND: 		  return "<AND>";
			case OP_LT: 		  return "<LT>";
			case DEL_LPAREN: 	  return "<LPAREN>";
			case DEL_RPAREN: 	  return "<RPAREN>";
			case DEL_SEMICOLON:   return "<SEMICOLON>";
			case DEL_COMMA: 	  return "<COMMA>";
			case DEL_DOT : 		  return "<DOT>";
			case DEL_LBRACE: 	  return "<LBRACE>";
			case DEL_RBRACE: 	  return "<RBRACE>";
			case DEL_LBRACK: 	  return "<LBRACK>";
			case DEL_RBRACK: 	  return "<RBRACK>";
			default: return "<UNEXPECTED TOKEN " + symbol.toString() + ">";
		}
	}
}
