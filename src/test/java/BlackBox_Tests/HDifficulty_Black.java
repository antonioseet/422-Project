package BlackBox_Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.spy;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.DetailAST;

import MyPack.HalsteadDifficultyCheck;
import MyPack.HalsteadVolumeCheck;
import TestSuite.TreeWalker2;

public class HDifficulty_Black {
	
	private double expected = 7.5;
	
	@Test
	void testExpression() throws IOException, CheckstyleException {
		
		HalsteadDifficultyCheck checkSpy = spy(HalsteadDifficultyCheck.class);
		doNothing().when(checkSpy).log(any(DetailAST.class), any(String.class));
		String path = "src/main/java/TestSuite/Oper.java";
		new TreeWalker2(path, checkSpy);
		assertEquals(expected, checkSpy.getDifficulty());
	}

	@Test
	void testLengthMsg() throws IOException, CheckstyleException {
		
		HalsteadDifficultyCheck checkSpy = spy(HalsteadDifficultyCheck.class);
		doNothing().when(checkSpy).log(any(DetailAST.class), any(String.class));
		String path = "src/main/java/TestSuite/Oper.java";
		new TreeWalker2(path, checkSpy);
		assertEquals(expectedString(expected), checkSpy.CatchMsg());
	}
	
	public String expectedString(double x) {
		return "The Halstead Difficulty is: " + x;
	}
}
