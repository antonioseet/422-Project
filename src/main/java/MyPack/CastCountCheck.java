package MyPack;
 

import com.puppycrawl.tools.checkstyle.api.*;
 

// Number of Comments
public class CastCountCheck extends AbstractCheck {
 
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
        return tokens();
    }
 
    @Override
    public void visitToken(DetailAST aAST) {
        this.counter++;
    }

	@Override
	public int[] getAcceptableTokens() {
		// Auto-generated method stub
		return tokens(); 
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
	public String CatchMsg() {
		return "You've used a total of: " + this.getCounter() + " typecast(s)";
	}
	
	private int[] tokens() {
		return new int[] {
        		TokenTypes.TYPECAST
        		};
	}
	
	public int getCounter() {
		return this.counter;
	}
 
}