package MyPack;
 
import com.puppycrawl.tools.checkstyle.api.*;
import java.util.HashSet; // Import the HashSet class
 
public class HalsteadVolumeCheck extends AbstractCheck {
 
    private HashSet<Integer> usedTokenSet = new HashSet<Integer>();

    private int lengthCounter = 0;
    
    @Override
    public void beginTree(DetailAST rootAST) {
    	this.lengthCounter = 0;
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
    	this.lengthCounter++;
    	this.usedTokenSet.add(aAST.getType());
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
		return "The Halstead Volume is: " + getVolume();
	}
	
	// Halstead Length times log base 2 of the vocab size
	public double getVolume() {
		
		if(usedTokens() == 0) {
			return 0;
		}
		
		return getLength() * (Math.log(usedTokens()) / Math.log(2));
	}
	
	public int getLength() {
		return this.lengthCounter;
	}
	
	public int usedTokens() {
		return this.usedTokenSet.size();
	}
 
}