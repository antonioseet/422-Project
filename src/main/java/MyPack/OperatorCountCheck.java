package MyPack;
 
import com.puppycrawl.tools.checkstyle.api.*;
import java.util.HashSet; // Import the HashSet class
 
public class OperatorCountCheck extends AbstractCheck {
 
    private HashSet<Integer> operandTokenSet = new HashSet<Integer>();
    private int operatorCounter = 0;
    
    private HalsteadArrayMaster ar = new HalsteadArrayMaster();
    
    @Override
    public void beginTree(DetailAST rootAST) {
		
		for(int n : this.ar.getOperands()) {
			operandTokenSet.add(n);
		}
		
    }
    
    @Override
    public void finishTree(DetailAST rootAST) {
    	log(rootAST, CatchMsg());
    }
    
    @Override
    public int[] getDefaultTokens() {
		return this.ar.getOperands();
    }
 
    // check to see which tokens are found and if we find a match to anything in our list we can add it to the set.
    @Override
    public void visitToken(DetailAST aAST) {
    	this.operatorCounter++;
    }

	@Override
	public int[] getAcceptableTokens() {
		return this.ar.getOperands();
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
		return "Operator Count: " + getCounter();
	}
	
	public int getCounter() {
		return this.operatorCounter;
	}
 
}