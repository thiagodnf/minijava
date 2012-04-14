package org.minijava.scanner;

import java_cup.sym;
import java_cup.runtime.*;
import org.minijava.symbol.*;
import org.minijava.throwables.*;

%%

%public
%final
%class Scanner
%yylexthrow MiniJavaException 
%unicode
%cup
%line
%column

%{
  // note that these Symbol constructors are abusing the Symbol
  // interface to use Symbol's left and right fields as line and column
  // fields instead
  
  private Symbol symbol(int type) {
    return new Symbol(type, yyline+1, yycolumn+1);
  }
  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline+1, yycolumn+1, value);
  }
	
  // print out a symbol (aka token) nicely
  public String symbolToString(Symbol s) {
    switch (s.sym) {
      case Sym.EQUAL: return "EQUAL";
      case Sym.SEMICOLON: return "SEMICOLON";
      case Sym.PLUS: return "PLUS";
      case Sym.LPAREN: return "LPAREN";
      case Sym.RPAREN: return "RPAREN";
      case Sym.RETURN: return "RETURN";
      case Sym.IDENTIFIER: return "ID(" + (String)s.value + ")";
      case Sym.EOF: return "<EOF>";
      case Sym.error: return "<ERROR>";
      default: return "<UNEXPECTED TOKEN " + s.toString() + ">";
    }
  }
  
%}

/* Helper definitions */
letter = [a-zA-Z]
digit = [0-9]
eol = [\r\n]
white = {eol}|[ \t]

%%

/* Token definitions */

/* reserved words */
/* (put here so that reserved words take precedence over identifiers) */
"return" { return symbol(Sym.RETURN); }

/* operators */
"+" { return symbol(Sym.PLUS); }
"=" { return symbol(Sym.EQUAL); }

/* delimiters */
"(" { return symbol(Sym.LPAREN); }
")" { return symbol(Sym.RPAREN); }
";" { return symbol(Sym.RPAREN); }

/* identifiers */
{letter} ({letter}|{digit}|_)* { return symbol(Sym.IDENTIFIER, yytext()); }


/* whitespace */
{white}+ { /* ignore whitespace */ }

/* lexical errors (put last so other matches take precedence) */
. { 
	throw new LexicalException("Caracter Invalido: '"+yytext()+"'");	
}
