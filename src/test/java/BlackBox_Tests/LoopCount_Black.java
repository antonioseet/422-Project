package BlackBox_Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.spy;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.DetailAST;

import MyPack.LoopStatementCountCheck;
import TestSuite.TreeWalker2;

public class LoopCount_Black {

	@Test
	void testNoLoop() throws IOException, CheckstyleException {
		
		LoopStatementCountCheck checkSpy = spy(LoopStatementCountCheck.class);
		doNothing().when(checkSpy).log(any(DetailAST.class), any(String.class));
		String path = "src/main/java/TestSuite/NoLoop.java";
		new TreeWalker2(path, checkSpy);
		assertEquals(0, checkSpy.getCounter());
	}
	
	@Test
	void testThreeLoop() throws IOException, CheckstyleException {
		
		LoopStatementCountCheck checkSpy = spy(LoopStatementCountCheck.class);
		doNothing().when(checkSpy).log(any(DetailAST.class), any(String.class));
		String path = "src/main/java/TestSuite/ThreeLoop.java";
		new TreeWalker2(path, checkSpy);
		//4 because of the second while in do while.
		assertEquals(expectedString(4), checkSpy.CatchMsg());	
	}
	
	public String expectedString(int x) {
		return "You've used a total of: " + x + " loop statement(s)";
	}
}
