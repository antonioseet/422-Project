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
        		TokenTypes.NUM_LONG};
    }
 
    @Override
    public void visitToken(DetailAST aAST) {
        this.counter++;
    }

	@Override
	public int[] getAcceptableTokens() {
		// Auto-generated method stub
		return new int[] {	TokenTypes.SINGLE_LINE_COMMENT,
							TokenTypes.BLOCK_COMMENT_BEGIN}; 
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
		return "The Halstead Length is: X";
	}
 
}