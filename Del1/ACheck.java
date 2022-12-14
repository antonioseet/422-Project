package MyPack;
 
import com.puppycrawl.tools.checkstyle.api.*;
 
public class ACheck extends AbstractCheck {
 
    private int counter = 0;
    
    @Override
    public void beginTree(DetailAST rootAST) {
    	this.counter = 0;
    }
    
    @Override
    public void finishTree(DetailAST rootAST) {
    	log(rootAST, CatchMsg());
    }
    
    @Override
    public int[] getDefaultTokens() {
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
        		TokenTypes.GT
        		};
    }
 
    @Override
    public void visitToken(DetailAST aAST) {
        this.counter++;
    }

	@Override
	public int[] getAcceptableTokens() {
		// Auto-generated method stub
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
        		TokenTypes.GT
        		}; 
	}

	@Override
	public int[] getRequiredTokens() {
		// Auto-generated method stub
		return new int[0];
	}
	
	@Override
	public boolean isCommentNodesRequired() {
		return true;
	}
	
	// Returns the total number of comments in the program's
	private String CatchMsg() {
		return "The Halstead Length is: " + this.counter;
	}
 
}