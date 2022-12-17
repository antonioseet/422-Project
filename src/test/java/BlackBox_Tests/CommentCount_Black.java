package BlackBox_Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.spy;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.DetailAST;

import MyPack.BCheck;
import TestSuite.TreeWalker2;

public class CommentCount_Black {

	@Test
	void testThreeComments() throws IOException, CheckstyleException {
		
		BCheck checkSpy = spy(BCheck.class);
		doNothing().when(checkSpy).log(any(DetailAST.class), any(String.class));
		String path = "src/main/java/TestSuite/ThreeComments.java";
		new TreeWalker2(path, checkSpy);
		assertEquals(3, checkSpy.getCounter());
	}
	
	@Test
	void testOneComment() throws IOException, CheckstyleException {
		
		BCheck checkSpy = spy(BCheck.class);
		doNothing().when(checkSpy).log(any(DetailAST.class), any(String.class));
		String path = "src/main/java/TestSuite/OneComment.java";
		new TreeWalker2(path, checkSpy);
		assertEquals(expectedString(1), checkSpy.CatchMsg());	
	}
	
	public String expectedString(int x) {
		return "You've used a total of: " + x + " comment(s)";
	}
}
