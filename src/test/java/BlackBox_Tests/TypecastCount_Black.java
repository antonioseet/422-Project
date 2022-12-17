package BlackBox_Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.spy;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.DetailAST;

import MyPack.CastCountCheck;
import TestSuite.TreeWalker2;

public class TypecastCount_Black {

	@Test
	void testThreeComments() throws IOException, CheckstyleException {
		
		CastCountCheck checkSpy = spy(CastCountCheck.class);
		doNothing().when(checkSpy).log(any(DetailAST.class), any(String.class));
		String path = "src/main/java/TestSuite/ThreeComments.java";
		new TreeWalker2(path, checkSpy);
		assertEquals(1, checkSpy.getCounter());
	}
	
	public String expectedString(int x) {
		return "You've used a total of: " + x + " typecast(s)";
	}
}
