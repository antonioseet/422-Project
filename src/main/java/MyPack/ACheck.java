package MyPack;
 
import com.puppycrawl.tools.checkstyle.api.*;
 
// Halstead Length
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
		HalsteadArrayMaster ml = new HalsteadArrayMaster();
		return ml.getMasterList();
    }
 
    @Override
    public void visitToken(DetailAST aAST) {
        this.counter++;
    }

	@Override
	public int[] getAcceptableTokens() {
		HalsteadArrayMaster ml = new HalsteadArrayMaster();
		return ml.getMasterList();
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
		return "The Halstead Length is: " + getCounter();
	}
	
	public int getCounter() {
		return this.counter;
	}
 
}