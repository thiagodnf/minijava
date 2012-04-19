/* The following code was generated by JFlex 1.4.3 on 4/19/12 12:08 AM */

package org.minijava.scanner;

import java_cup.sym;
import java_cup.runtime.*;
//import org.minijava.throwables.*;
import org.minijava.util.*;
import java.util.*;



/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 4/19/12 12:08 AM from the specification file
 * <tt>minijava.jflex</tt>
 */
public final class Scanner implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\3\1\10\2\0\1\10\22\0\1\3\1\44\4\0\1\45"+
    "\1\0\1\47\1\50\1\7\1\41\1\52\1\42\1\37\1\6\1\4"+
    "\11\2\1\0\1\51\1\46\1\43\3\0\22\1\1\35\7\1\1\55"+
    "\1\0\1\56\1\0\1\5\1\0\1\20\1\23\1\16\1\27\1\12"+
    "\1\40\1\34\1\32\1\24\2\1\1\17\1\30\1\15\1\26\1\22"+
    "\1\1\1\11\1\21\1\13\1\14\1\25\1\33\1\31\1\36\1\1"+
    "\1\53\1\3\1\54\uff82\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\3\1\1\1\5"+
    "\16\2\1\6\1\2\1\7\1\10\1\11\1\12\1\1"+
    "\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22"+
    "\1\23\1\24\1\0\14\2\1\25\6\2\1\26\1\24"+
    "\1\0\5\2\1\27\5\2\1\30\7\2\1\31\1\2"+
    "\1\32\1\33\5\2\1\34\1\35\6\2\1\36\4\2"+
    "\1\37\2\2\1\40\1\41\1\2\1\42\1\43\1\44"+
    "\1\2\1\45\1\2\1\46\1\47\13\0\1\50";

  private static int [] zzUnpackAction() {
    int [] result = new int[129];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\57\0\136\0\215\0\274\0\57\0\353\0\57"+
    "\0\u011a\0\u0149\0\u0178\0\u01a7\0\u01d6\0\u0205\0\u0234\0\u0263"+
    "\0\u0292\0\u02c1\0\u02f0\0\u031f\0\u034e\0\u037d\0\57\0\u03ac"+
    "\0\57\0\57\0\57\0\57\0\u03db\0\57\0\57\0\57"+
    "\0\57\0\57\0\57\0\57\0\57\0\57\0\u040a\0\u0439"+
    "\0\u0468\0\u0497\0\u04c6\0\u04f5\0\u0524\0\u0553\0\u0582\0\u05b1"+
    "\0\u05e0\0\u060f\0\u063e\0\u066d\0\136\0\u069c\0\u06cb\0\u06fa"+
    "\0\u0729\0\u0758\0\u0787\0\57\0\57\0\u07b6\0\u07e5\0\u0814"+
    "\0\u0843\0\u0872\0\u08a1\0\136\0\u08d0\0\u08ff\0\u092e\0\u095d"+
    "\0\u098c\0\136\0\u09bb\0\u09ea\0\u0a19\0\u0a48\0\u0a77\0\u0aa6"+
    "\0\u0ad5\0\136\0\u0b04\0\136\0\136\0\u0b33\0\u0b62\0\u0b91"+
    "\0\u0bc0\0\u0bef\0\136\0\136\0\u0c1e\0\u0c4d\0\u0c7c\0\u0cab"+
    "\0\u0cda\0\u0d09\0\136\0\u0d38\0\u0d67\0\u0d96\0\u0dc5\0\136"+
    "\0\u0df4\0\u0e23\0\136\0\136\0\u0e52\0\136\0\136\0\136"+
    "\0\u0e81\0\136\0\u0eb0\0\136\0\136\0\u0edf\0\u0f0e\0\u0f3d"+
    "\0\u0f6c\0\u0f9b\0\u0fca\0\u0ff9\0\u1028\0\u1057\0\u1086\0\u10b5"+
    "\0\57";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[129];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\2\1\7\1\10"+
    "\1\5\1\11\1\12\1\13\1\3\1\14\1\15\1\16"+
    "\1\3\1\17\1\20\1\21\1\22\1\23\2\3\1\24"+
    "\2\3\1\25\1\3\1\26\1\3\1\27\1\30\1\31"+
    "\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41"+
    "\1\42\1\43\1\44\1\45\1\46\60\0\2\3\1\0"+
    "\2\3\3\0\26\3\1\0\1\3\20\0\1\4\1\0"+
    "\1\4\55\0\1\5\4\0\1\5\54\0\1\47\1\50"+
    "\50\0\2\3\1\0\2\3\3\0\1\3\1\51\24\3"+
    "\1\0\1\3\17\0\2\3\1\0\2\3\3\0\6\3"+
    "\1\52\11\3\1\53\5\3\1\0\1\3\17\0\2\3"+
    "\1\0\2\3\3\0\1\54\20\3\1\55\4\3\1\0"+
    "\1\3\17\0\2\3\1\0\2\3\3\0\1\3\1\56"+
    "\24\3\1\0\1\3\17\0\2\3\1\0\2\3\3\0"+
    "\6\3\1\57\17\3\1\0\1\3\17\0\2\3\1\0"+
    "\2\3\3\0\1\3\1\60\24\3\1\0\1\3\17\0"+
    "\2\3\1\0\2\3\3\0\2\3\1\61\23\3\1\0"+
    "\1\3\17\0\2\3\1\0\2\3\3\0\3\3\1\62"+
    "\22\3\1\0\1\3\17\0\2\3\1\0\2\3\3\0"+
    "\15\3\1\63\10\3\1\0\1\3\17\0\2\3\1\0"+
    "\2\3\3\0\4\3\1\64\21\3\1\0\1\65\17\0"+
    "\2\3\1\0\2\3\3\0\15\3\1\66\10\3\1\0"+
    "\1\3\17\0\2\3\1\0\2\3\3\0\7\3\1\67"+
    "\16\3\1\0\1\3\17\0\2\3\1\0\2\3\3\0"+
    "\21\3\1\70\4\3\1\0\1\3\17\0\2\3\1\0"+
    "\2\3\3\0\2\3\1\71\22\3\1\72\1\0\1\3"+
    "\17\0\2\3\1\0\2\3\3\0\7\3\1\73\16\3"+
    "\1\0\1\3\63\0\1\74\11\0\10\47\1\75\46\47"+
    "\7\50\1\76\47\50\1\0\2\3\1\0\2\3\3\0"+
    "\2\3\1\77\23\3\1\0\1\3\17\0\2\3\1\0"+
    "\2\3\3\0\10\3\1\100\15\3\1\0\1\3\17\0"+
    "\2\3\1\0\2\3\3\0\2\3\1\101\23\3\1\0"+
    "\1\3\17\0\2\3\1\0\2\3\3\0\3\3\1\102"+
    "\22\3\1\0\1\3\17\0\2\3\1\0\2\3\3\0"+
    "\13\3\1\103\12\3\1\0\1\3\17\0\2\3\1\0"+
    "\2\3\3\0\22\3\1\104\3\3\1\0\1\3\17\0"+
    "\2\3\1\0\2\3\3\0\7\3\1\105\16\3\1\0"+
    "\1\3\17\0\2\3\1\0\2\3\3\0\4\3\1\106"+
    "\21\3\1\0\1\3\17\0\2\3\1\0\2\3\3\0"+
    "\7\3\1\107\16\3\1\0\1\3\17\0\2\3\1\0"+
    "\2\3\3\0\12\3\1\110\13\3\1\0\1\3\17\0"+
    "\2\3\1\0\2\3\3\0\15\3\1\111\10\3\1\0"+
    "\1\3\17\0\2\3\1\0\2\3\3\0\2\3\1\112"+
    "\23\3\1\0\1\3\17\0\2\3\1\0\2\3\3\0"+
    "\13\3\1\113\12\3\1\0\1\3\17\0\2\3\1\0"+
    "\2\3\3\0\13\3\1\114\12\3\1\0\1\3\17\0"+
    "\2\3\1\0\2\3\3\0\13\3\1\115\12\3\1\0"+
    "\1\3\17\0\2\3\1\0\2\3\3\0\1\116\25\3"+
    "\1\0\1\3\17\0\2\3\1\0\2\3\3\0\10\3"+
    "\1\117\15\3\1\0\1\3\17\0\2\3\1\0\2\3"+
    "\3\0\6\3\1\120\17\3\1\0\1\3\16\0\6\50"+
    "\1\75\1\76\47\50\1\0\2\3\1\0\2\3\3\0"+
    "\3\3\1\121\22\3\1\0\1\3\17\0\2\3\1\0"+
    "\2\3\3\0\1\3\1\122\24\3\1\0\1\3\17\0"+
    "\2\3\1\0\2\3\3\0\1\3\1\123\24\3\1\0"+
    "\1\3\17\0\2\3\1\0\2\3\3\0\1\3\1\124"+
    "\24\3\1\0\1\3\17\0\2\3\1\0\2\3\3\0"+
    "\10\3\1\125\15\3\1\0\1\3\17\0\2\3\1\0"+
    "\2\3\3\0\10\3\1\126\15\3\1\0\1\3\17\0"+
    "\2\3\1\0\2\3\3\0\23\3\1\127\2\3\1\0"+
    "\1\3\17\0\2\3\1\0\2\3\3\0\2\3\1\130"+
    "\23\3\1\0\1\3\17\0\2\3\1\0\2\3\3\0"+
    "\6\3\1\131\17\3\1\0\1\3\17\0\2\3\1\0"+
    "\2\3\3\0\6\3\1\132\17\3\1\0\1\3\17\0"+
    "\2\3\1\0\2\3\3\0\16\3\1\133\7\3\1\0"+
    "\1\3\17\0\2\3\1\0\2\3\3\0\4\3\1\134"+
    "\21\3\1\0\1\3\17\0\2\3\1\0\2\3\3\0"+
    "\6\3\1\135\17\3\1\0\1\3\17\0\2\3\1\0"+
    "\2\3\3\0\13\3\1\136\12\3\1\0\1\3\17\0"+
    "\2\3\1\0\2\3\3\0\2\3\1\137\23\3\1\0"+
    "\1\3\17\0\2\3\1\0\2\3\3\0\10\3\1\140"+
    "\15\3\1\0\1\3\17\0\2\3\1\0\2\3\3\0"+
    "\1\141\25\3\1\0\1\3\17\0\2\3\1\0\2\3"+
    "\3\0\4\3\1\142\21\3\1\0\1\3\17\0\2\3"+
    "\1\0\2\3\3\0\10\3\1\143\15\3\1\0\1\3"+
    "\17\0\2\3\1\0\2\3\3\0\2\3\1\144\23\3"+
    "\1\0\1\3\17\0\2\3\1\0\2\3\3\0\13\3"+
    "\1\145\12\3\1\0\1\3\17\0\2\3\1\0\2\3"+
    "\3\0\13\3\1\146\12\3\1\0\1\3\17\0\2\3"+
    "\1\0\2\3\3\0\1\3\1\147\24\3\1\0\1\3"+
    "\17\0\2\3\1\0\2\3\3\0\1\3\1\150\24\3"+
    "\1\0\1\3\17\0\2\3\1\0\2\3\3\0\4\3"+
    "\1\151\21\3\1\0\1\3\17\0\2\3\1\0\2\3"+
    "\3\0\1\3\1\152\24\3\1\0\1\3\17\0\2\3"+
    "\1\0\2\3\3\0\1\3\1\153\24\3\1\0\1\3"+
    "\17\0\2\3\1\0\2\3\3\0\4\3\1\154\21\3"+
    "\1\0\1\3\17\0\2\3\1\0\2\3\3\0\16\3"+
    "\1\155\7\3\1\0\1\3\17\0\2\3\1\0\2\3"+
    "\3\0\21\3\1\156\4\3\1\0\1\3\17\0\2\3"+
    "\1\0\2\3\3\0\5\3\1\157\20\3\1\0\1\3"+
    "\17\0\2\3\1\0\2\3\3\0\5\3\1\160\20\3"+
    "\1\0\1\3\17\0\2\3\1\0\2\3\3\0\7\3"+
    "\1\161\16\3\1\0\1\3\17\0\2\3\1\0\2\3"+
    "\3\0\23\3\1\162\2\3\1\0\1\3\17\0\2\3"+
    "\1\0\2\3\3\0\17\3\1\163\6\3\1\0\1\3"+
    "\17\0\2\3\1\0\2\3\3\0\10\3\1\164\15\3"+
    "\1\0\1\3\17\0\2\3\1\0\2\3\3\0\4\3"+
    "\1\165\21\3\1\0\1\3\17\0\2\3\1\0\2\3"+
    "\3\0\26\3\1\166\1\3\44\0\1\167\44\0\1\170"+
    "\55\0\1\171\102\0\1\172\41\0\1\173\45\0\1\174"+
    "\71\0\1\175\47\0\1\176\54\0\1\177\62\0\1\200"+
    "\54\0\1\201\41\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[4324];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\3\1\1\11\1\1\1\11\16\1\1\11"+
    "\1\1\4\11\1\1\11\11\1\1\1\0\23\1\2\11"+
    "\1\0\67\1\13\0\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[129];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  @SuppressWarnings("unused")
private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  @SuppressWarnings("unused")
private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
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
  


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Scanner(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public Scanner(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 128) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 12: 
          { return symbol(Sym.DEL_LPAREN);
          }
        case 41: break;
        case 1: 
          { log.add(new LexicalLog(yytext(),yyline,yycolumn));
          }
        case 42: break;
        case 17: 
          { return symbol(Sym.DEL_RBRACE);
          }
        case 43: break;
        case 38: 
          { return symbol(Sym.WORD_EXTENDS);
          }
        case 44: break;
        case 40: 
          { return symbol(Sym.WORD_PRINTLN);
          }
        case 45: break;
        case 29: 
          { return symbol(Sym.WORD_MAIN);
          }
        case 46: break;
        case 28: 
          { return symbol(Sym.WORD_VOID);
          }
        case 47: break;
        case 36: 
          { return symbol(Sym.WORD_PUBLIC);
          }
        case 48: break;
        case 3: 
          { return symbol(Sym.INTEGER_LITERAL, new Integer(yytext()));
          }
        case 49: break;
        case 15: 
          { return symbol(Sym.DEL_COMMA);
          }
        case 50: break;
        case 31: 
          { return symbol(Sym.COND_WHILE);
          }
        case 51: break;
        case 9: 
          { return symbol(Sym.OP_EQUAL);
          }
        case 52: break;
        case 30: 
          { return symbol(Sym.WORD_CLASS);
          }
        case 53: break;
        case 27: 
          { return symbol(Sym.WORD_THIS);
          }
        case 54: break;
        case 34: 
          { return symbol(Sym.WORD_LENGTH);
          }
        case 55: break;
        case 39: 
          { return symbol(Sym.TYPE_BOOL);
          }
        case 56: break;
        case 19: 
          { return symbol(Sym.DEL_RBRACK);
          }
        case 57: break;
        case 8: 
          { return symbol(Sym.OP_MINUS);
          }
        case 58: break;
        case 13: 
          { return symbol(Sym.DEL_RPAREN);
          }
        case 59: break;
        case 2: 
          { return symbol(Sym.IDENTIFIER, yytext());
          }
        case 60: break;
        case 10: 
          { return symbol(Sym.OP_NOT);
          }
        case 61: break;
        case 22: 
          { return symbol(Sym.OP_AND);
          }
        case 62: break;
        case 6: 
          { return symbol(Sym.DEL_DOT);
          }
        case 63: break;
        case 33: 
          { return symbol(Sym.WORD_RETURN);
          }
        case 64: break;
        case 16: 
          { return symbol(Sym.DEL_LBRACE);
          }
        case 65: break;
        case 26: 
          { return symbol(Sym.BOOL_LITERAL,new Boolean(true));
          }
        case 66: break;
        case 37: 
          { return symbol(Sym.TYPE_STRING);
          }
        case 67: break;
        case 21: 
          { return symbol(Sym.COND_IF);
          }
        case 68: break;
        case 35: 
          { return symbol(Sym.WORD_STATIC);
          }
        case 69: break;
        case 20: 
          { /* Ignore os comentários */
          }
        case 70: break;
        case 4: 
          { /* Ignore os espaços em branco */
          }
        case 71: break;
        case 25: 
          { return symbol(Sym.COND_ELSE);
          }
        case 72: break;
        case 7: 
          { return symbol(Sym.OP_PLUS);
          }
        case 73: break;
        case 14: 
          { return symbol(Sym.DEL_SEMICOLON);
          }
        case 74: break;
        case 24: 
          { return symbol(Sym.TYPE_INT);
          }
        case 75: break;
        case 32: 
          { return symbol(Sym.BOOL_LITERAL,new Boolean(false));
          }
        case 76: break;
        case 11: 
          { return symbol(Sym.OP_LT);
          }
        case 77: break;
        case 18: 
          { return symbol(Sym.DEL_LBRACK);
          }
        case 78: break;
        case 23: 
          { return symbol(Sym.WORD_NEW);
          }
        case 79: break;
        case 5: 
          { return symbol(Sym.OP_MULT);
          }
        case 80: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return new java_cup.runtime.Symbol(sym.EOF); }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
