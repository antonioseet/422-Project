package MyPack;
 
import com.puppycrawl.tools.checkstyle.api.*;
 
public class SemicolonCountCheck extends AbstractCheck {
 
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
        return new int[] {TokenTypes.SEMI};
    }
 
    @Override
    public void visitToken(DetailAST aAST) {
        this.counter++;
    }

	@Override
	public int[] getAcceptableTokens() {
		// TODO Auto-generated method stub
		return new int[] {TokenTypes.SEMI}; 
	}

	@Override
	public int[] getRequiredTokens() {
		// TODO Auto-generated method stub
		return new int[0];
	}
	
	private String CatchMsg() {
		return "You've used a total of " + this.counter + " semicolons";
	}
 
}