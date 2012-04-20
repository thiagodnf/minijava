package org.minijava.scanner;

import java_cup.sym;
import java_cup.runtime.*;
//import org.minijava.throwables.*;
import org.minijava.util.*;
import java.util.*;


%%

%public
%final
%class Scanner
/*%yylexthrow MiniJavaException */
%unicode
%cup
%line
%column

%{
	// note that these Symbol constructors are abusing the Symbol
	// interface to use Symbol's left and right fields as line and column
	// fields instead

	private List<Log> log = new LinkedList<Log>();
	
	public List<Log> getLogs(){
		return log;
	}

	private Symbol symbol(int type) {
		return new Symbol(type, yyline+1, yycolumn+1);
	}
	private Symbol symbol(int type, Object value) {
		return new Symbol(type, yyline+1, yycolumn+1, value);
	}
	
 	// print out a symbol (aka token) nicely
	public String symbolToString(Symbol symbol) {
		return Sym.toString(symbol);
	}
  
%}

/* Helper definitions */
LETTER = [a-zA-Z]
DIGIT = [0-9]
eol = [\r|\n|\r\n]
WHITE = {eol}|[ \t]
INTEGER_LITERAL = 0 | [1-9][0-9]*
IDENTIFIER = {LETTER}({LETTER}|{DIGIT}|_)*

/*Comentários alinhandos (um comentário dentro do outro) não são permitidos*/
COMMENT_MULTILINE = "/*" [^*] ~"*/" | "/*" "*"+ "/"
COMMENT_SIMPLELINE = "//" [^\r\n]* {eol}?
COMMENT_DOCUMENTATION = "/*" "*"+ [^/*] ~"*/"
COMMENT = {COMMENT_MULTILINE}|{COMMENT_SIMPLELINE}|{COMMENT_DOCUMENTATION}

%%
/* Token definitions */

/* Palavras reservadas da linguagem */
"return"			 { return symbol(Sym.WORD_RETURN); 	}
"class"   			 { return symbol(Sym.WORD_CLASS); 	}
"public"  			 { return symbol(Sym.WORD_PUBLIC); 	} 
"static"  			 { return symbol(Sym.WORD_STATIC); 	}
"void"    			 { return symbol(Sym.WORD_VOID); 	}
"main"    			 { return symbol(Sym.WORD_MAIN);	}
"extends" 			 { return symbol(Sym.WORD_EXTENDS); } 
"this"				 { return symbol(Sym.WORD_THIS); 	}
"new"				 { return symbol(Sym.WORD_NEW); 	}
"length"			 { return symbol(Sym.WORD_LENGTH); 	}
"System.out.println" { return symbol(Sym.WORD_PRINTLN); }

/* Tipos de Dados*/
"int"	  { return symbol(Sym.TYPE_INT);	}
"boolean" { return symbol(Sym.TYPE_BOOL);	}
"String"  { return symbol(Sym.TYPE_STRING);	}

/* Condicionais */
"if"	{ return symbol(Sym.COND_IF);	}
"else"  { return symbol(Sym.COND_ELSE); }
"while" { return symbol(Sym.COND_WHILE);}

/* Valores Booleanos */
"true"	{ return symbol(Sym.BOOL_LITERAL,new Boolean(true));  }
"false" { return symbol(Sym.BOOL_LITERAL,new Boolean(false)); }

/* Identificadores */
{IDENTIFIER} 	  { return symbol(Sym.IDENTIFIER, yytext()); 	  }
{INTEGER_LITERAL} { return symbol(Sym.INTEGER_LITERAL, new Integer(yytext())); }

/* Espaços em Branco */
{WHITE}+ { /* Ignore os espaços em branco */ }

/* Comentários */
{COMMENT} { /* Ignore os comentários */ }



/* Operadores */
"+"  { return symbol(Sym.OP_PLUS);	}
"-"	 { return symbol(Sym.OP_MINUS); }
"="  { return symbol(Sym.OP_EQUAL); }
"!"  { return symbol(Sym.OP_NOT);	}
"*"	 { return symbol(Sym.OP_MULT);	}
"&&" { return symbol(Sym.OP_AND);   }
"<"  { return symbol(Sym.OP_LT);    }

/* Separadores */
"(" { return symbol(Sym.DEL_LPAREN); 	}
")" { return symbol(Sym.DEL_RPAREN); 	}
";" { return symbol(Sym.DEL_SEMICOLON); }
"," { return symbol(Sym.DEL_COMMA);		}
"." { return symbol(Sym.DEL_DOT); 		}
"{" { return symbol(Sym.DEL_LBRACE); 	}
"}" { return symbol(Sym.DEL_RBRACE); 	}  
"[" { return symbol(Sym.DEL_LBRACK); 	}   
"]" { return symbol(Sym.DEL_RBRACK); 	}

/* lexical errors (put last so other matches take precedence) */
.|\n { 
	log.add(new LexicalLog(yytext(),yyline,yycolumn));	
}
