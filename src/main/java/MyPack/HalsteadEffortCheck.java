package MyPack;
 
import com.puppycrawl.tools.checkstyle.api.*;
import java.util.HashSet; // Import the HashSet class
 
public class HalsteadEffortCheck extends AbstractCheck {
 
	//Unique operators and operands
	private HashSet<Integer> uniqueOperands = new HashSet<Integer>();
	private HashSet<Integer> uniqueOperators = new HashSet<Integer>();
	private HashSet<Integer> usedTokens = new HashSet<Integer>();
	private HashSet<Integer> operandTokenSet = new HashSet<Integer>();
	
	private int operandCounter;
    private int length;
    
    @Override
    public void beginTree(DetailAST rootAST) {
    	this.operandTokenSet = new HashSet<Integer>();
    	this.usedTokens = new HashSet<Integer>();
    	this.operandCounter = 0;
    	this.length = 0;
    	
    	HalsteadArrayMaster ar = new HalsteadArrayMaster();
		
		for(int n : ar.getOperands()) {
			operandTokenSet.add(n);
		}
		
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
 
    // check to see which tokens are found and if we find a match to anything in our list we can add it to the set.
    @Override
    public void visitToken(DetailAST aAST) {
    	if(operandTokenSet.contains(aAST.getType())){
    		this.operandCounter++;
    		this.uniqueOperands.add(aAST.getType());
    	}else{
    		this.uniqueOperators.add(aAST.getType());
    	}
    	this.usedTokens.add(aAST.getType());
    	length++;
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
		return "The Halstead Effort is: " + getEffort();
	}
	
	public double getEffort() {
		
		double volume = this.getVolume();
		
		if(volume == 0 || this.uniqueOperands.size() == 0) {
			return 0;
		}
		
		double difficulty 	= this.uniqueOperators.size() / 2.0; 
		difficulty 			*= this.operandCounter;
		difficulty 			/= this.uniqueOperands.size();
		
		return difficulty * volume;
	}
	
	// Halstead Length times log base 2 of the vocab size
	public double getVolume() {
		
		if(usedTokens() == 0) {
			return 0;
		}
		
		return this.length * (Math.log(usedTokens())) / Math.log(2);
	}

	public int usedTokens() {
		return this.usedTokens.size();
	}

}
