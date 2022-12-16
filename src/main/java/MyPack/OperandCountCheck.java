package MyPack;
 
import com.puppycrawl.tools.checkstyle.api.*;
import java.util.HashSet; // Import the HashSet class
 
public class OperandCountCheck extends AbstractCheck {
 
    private HashSet<Integer> operandTokenSet;
    private int operandCounter;
    
    @Override
    public void beginTree(DetailAST rootAST) {
    	this.operandTokenSet = new HashSet<Integer>();
    	this.operandCounter = 0;
    	
		for(int n : opArray()) {
			operandTokenSet.add(n);
		}
		
    }
    
    @Override
    public void finishTree(DetailAST rootAST) {
    	log(rootAST, CatchMsg());
    }
    
    @Override
    public int[] getDefaultTokens() {
		return this.opArray();
    }
 
    // check to see which tokens are found and if we find a match to anything in our list we can add it to the set.
    @Override
    public void visitToken(DetailAST aAST) {
    	this.operandCounter++;
    }

	@Override
	public int[] getAcceptableTokens() {
		return this.opArray();
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
		return "Operand Count: " + getCounter();
	}
	
	public int getCounter() {
		return this.operandCounter;
	}
	
	private int[] opArray() {
		return new int[] {	
        		TokenTypes.CHAR_LITERAL,
        		TokenTypes.NUM_INT,
        		TokenTypes.NUM_LONG,
        		TokenTypes.NUM_FLOAT,
        		TokenTypes.NUM_DOUBLE,
        		TokenTypes.STRING_LITERAL
        }; 
	}
	
 
}