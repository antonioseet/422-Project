package MyPack;
 
import com.puppycrawl.tools.checkstyle.api.*;
import java.util.HashSet; // Import the HashSet class
 
public class HalsteadDifficultyCheck extends AbstractCheck {
 
	//Unique operators and operands
	private HashSet<Integer> uniqueOperands= new HashSet<Integer>();
	private HashSet<Integer> uniqueOperators= new HashSet<Integer>();
    private HashSet<Integer> operandTokenSet= new HashSet<Integer>(); // To check for increasing operand and operator (!operand) counts.
    private int operandCounter;
    
    @Override
    public void beginTree(DetailAST rootAST) {
    	this.operandCounter = 0;
    	
    	// operand set, EVERYTHING ELSE IS AN OPERATOR
		int[] operandArray = {	
        		TokenTypes.CHAR_LITERAL,
        		TokenTypes.NUM_INT,
        		TokenTypes.NUM_LONG,
        		TokenTypes.NUM_FLOAT,
        		TokenTypes.NUM_DOUBLE,
        		TokenTypes.STRING_LITERAL,
        		TokenTypes.PATTERN_VARIABLE_DEF,
        		TokenTypes.PARAMETER_DEF,
        		TokenTypes.PARAMETERS
        }; 
		
		for(int n : operandArray) {
			this.operandTokenSet.add(n);
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
		return "The Halstead Difficulty is: " + getDifficulty();
	}
	
	public double getDifficulty() {
		
		if(this.uniqueOperands.size() == 0) {
			return 0;
		}
		
		double difficulty 	= this.uniqueOperators.size() / 2.0; 
		difficulty 			*= this.operandCounter;
		difficulty 			/= this.uniqueOperands.size();
		
		return difficulty;
	}

}
