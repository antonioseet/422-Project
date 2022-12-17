package TestSuite;

import java.io.File;
import java.io.IOException;
import com.puppycrawl.tools.checkstyle.DefaultConfiguration;
import com.puppycrawl.tools.checkstyle.DefaultContext;
import com.puppycrawl.tools.checkstyle.JavaParser;
import com.puppycrawl.tools.checkstyle.JavaParser.Options;
import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.FileContents;
import com.puppycrawl.tools.checkstyle.api.FileText;

public class TreeWalker2 {

		
	public AbstractCheck check;
	public String path;
	public DetailAST ast;
	
	public TreeWalker2(String path, AbstractCheck check) throws IOException, CheckstyleException {
		
		this.path = path;
		this.check = check;

		String filePath = path;
		File file = new File(filePath);
		FileText text = new FileText(file,"UTF-8");
		FileContents content = new FileContents(text);
		
		if (check.isCommentNodesRequired()) 
			 ast = JavaParser.parseFile(file, Options.WITH_COMMENTS);
		else
			 ast = JavaParser.parse(content);
		
		this.check.contextualize(new DefaultContext());
		this.check.configure(new DefaultConfiguration("Local"));
		this.check.beginTree(ast);
		helper(this.check,ast);
		this.check.finishTree(ast);
	}
	
	public void helper(AbstractCheck check, DetailAST astNode) {
		
		int[] tok = check.getAcceptableTokens();
		int[] defTok = check.getDefaultTokens();
		int[] reqTok = check.getRequiredTokens();
		 while (astNode != null) {
			 if (contains(tok, astNode.getType()) || contains(defTok, astNode.getType()) || contains(reqTok, astNode.getType()))
					check.visitToken(astNode);
			 
			  DetailAST toVisit = astNode.getFirstChild();
			   while (astNode != null && toVisit == null) {
				   check.leaveToken(astNode);
			       toVisit = astNode.getNextSibling();
			       astNode = astNode.getParent();
			  }
			   
			   astNode = toVisit;
		}
	}
	
	
	public boolean contains(int[] array, int key) {
		boolean contain = false;
	    for (final int i : array) {
	        if (i == key)
	            return true;
	    }
	    return contain;
	}

}

