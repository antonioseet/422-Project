package MyPack;

import com.puppycrawl.tools.checkstyle.api.TokenTypes;

public class HalsteadArrayMaster {

		public HalsteadArrayMaster() {
			
		}
	
		public int[] getMasterList() {
			return new int[] {	
	        		TokenTypes.CHAR_LITERAL,
	        		TokenTypes.NUM_INT,
	        		TokenTypes.NUM_LONG,
	        		TokenTypes.NUM_FLOAT,
	        		TokenTypes.NUM_DOUBLE,
	        		TokenTypes.STRING_LITERAL,
	        		TokenTypes.ASSIGN,
	        		TokenTypes.DIV_ASSIGN,
	        		TokenTypes.DIV,
	        		TokenTypes.DOT,
	        		TokenTypes.EQUAL,
	        		TokenTypes.GE,
	        		TokenTypes.INC,
	        		TokenTypes.INDEX_OP,
	        		TokenTypes.LAND,
	        		TokenTypes.LE,
	        		TokenTypes.LITERAL_INSTANCEOF,
	        		TokenTypes.LITERAL_VOID,
	        		TokenTypes.LITERAL_BOOLEAN,
	        		TokenTypes.LITERAL_BYTE,
	        		TokenTypes.LITERAL_CHAR,
	        		TokenTypes.LITERAL_SHORT,
	        		TokenTypes.LITERAL_INT,
	        		TokenTypes.LITERAL_LONG,
	        		TokenTypes.LITERAL_FLOAT,
	        		TokenTypes.LITERAL_DOUBLE,
	        		TokenTypes.LITERAL_PRIVATE,
	        		TokenTypes.LITERAL_PUBLIC,
	        		TokenTypes.LITERAL_PROTECTED,
	        		TokenTypes.LITERAL_STATIC,
	        		TokenTypes.LITERAL_TRANSIENT,
	        		TokenTypes.LITERAL_NATIVE,
	        		TokenTypes.LITERAL_SYNCHRONIZED,
	        		TokenTypes.LITERAL_VOLATILE,
	        		TokenTypes.LITERAL_CLASS,
	        		TokenTypes.LITERAL_INTERFACE,
	        		TokenTypes.LITERAL_THIS,
	        		TokenTypes.LITERAL_SUPER,
	        		// LOOPS
	        		TokenTypes.LITERAL_FOR,
	        		TokenTypes.LITERAL_WHILE,
	        		TokenTypes.LITERAL_DO,
	        		TokenTypes.DO_WHILE,
	        		
	        		TokenTypes.LITERAL_BREAK,
	        		TokenTypes.LITERAL_CONTINUE,
	        		TokenTypes.LITERAL_RETURN,
	        		TokenTypes.LITERAL_FINALLY,
	        		TokenTypes.LITERAL_CATCH,


	        		TokenTypes.LNOT,
	        		TokenTypes.LOR,
	        		TokenTypes.LT,
	        		TokenTypes.MINUS,
	        		TokenTypes.MOD,
	        		TokenTypes.MOD_ASSIGN,
	        		TokenTypes.NOT_EQUAL,
	        		TokenTypes.PLUS,
	        		TokenTypes.PLUS_ASSIGN,
	        		TokenTypes.POST_DEC,
	        		TokenTypes.POST_INC,
	        		TokenTypes.QUESTION,
	        		TokenTypes.STAR,
	        		TokenTypes.STAR_ASSIGN,
	        		TokenTypes.UNARY_MINUS,
	        		TokenTypes.UNARY_PLUS,
	        		TokenTypes.RBRACK,
	        		TokenTypes.RCURLY,
	        		TokenTypes.VARIABLE_DEF,
	        		TokenTypes.METHOD_REF,
	        		TokenTypes.BNOT,
	        		TokenTypes.BOR,
	        		TokenTypes.COLON,
	        		TokenTypes.COMMA,
	        		TokenTypes.GT,
	        		TokenTypes.INC,
	        		TokenTypes.DEC,
	        		TokenTypes.LITERAL_TRUE,
	        		TokenTypes.LITERAL_FALSE,
	        		TokenTypes.LITERAL_NULL,

	        		
	        		TokenTypes.MODIFIERS,
	        		TokenTypes.VARIABLE_DEF,
	        		TokenTypes.METHOD_CALL,
	        		TokenTypes.EXPR,
	        		TokenTypes.ARRAY_INIT,
	        		TokenTypes.FOR_INIT,
	        		TokenTypes.FOR_CONDITION,
	        		TokenTypes.FOR_ITERATOR,
	        		TokenTypes.FINAL,
	        		TokenTypes.ABSTRACT,

	        		TokenTypes.PATTERN_VARIABLE_DEF,
	        		TokenTypes.PARAMETER_DEF,
	        		TokenTypes.PARAMETERS
	        		
	        		}; 
		}
		
		public int[] getCommentList() {
			return new int[] {
					TokenTypes.COMMENT_CONTENT,
					TokenTypes.BLOCK_COMMENT_BEGIN,
					TokenTypes.BLOCK_COMMENT_END,
					TokenTypes.SINGLE_LINE_COMMENT
			};
		}
		
		public int [] getOperands() {
			return new int[] {	
	        		TokenTypes.CHAR_LITERAL,
	        		TokenTypes.NUM_INT,
	        		TokenTypes.NUM_LONG,
	        		TokenTypes.NUM_FLOAT,
	        		TokenTypes.NUM_DOUBLE,
	        		TokenTypes.STRING_LITERAL,
	        		TokenTypes.PATTERN_VARIABLE_DEF,
	        		TokenTypes.PARAMETER_DEF,
	        		TokenTypes.PARAMETERS,
	        		TokenTypes.LITERAL_TRUE,
	        		TokenTypes.LITERAL_FALSE,
	        }; 
		}
}
