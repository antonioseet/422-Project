package MyPack;
 
import com.puppycrawl.tools.checkstyle.api.*;
import java.util.HashSet; // Import the HashSet class
 
public class HalsteadVocabularyCheck extends AbstractCheck {
 
    private HashSet<Integer> usedTokenSet = new HashSet<Integer>();
    
    @Override
    public void beginTree(DetailAST rootAST) {
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
	
	public String CatchMsg() {
		return "The Halstead Vocabulary is: " + getCounter();
	}
	
	public int getCounter() {
		return this.usedTokenSet.size();
	}
 
}