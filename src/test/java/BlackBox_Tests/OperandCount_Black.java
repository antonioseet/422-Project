package BlackBox_Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.spy;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.DetailAST;

import MyPack.OperandCountCheck;
import TestSuite.TreeWalker2;

public class OperandCount_Black {

	@Test
	void testTwoOperators() throws IOException, CheckstyleException {
		
		OperandCountCheck checkSpy = spy(OperandCountCheck.class);
		doNothing().when(checkSpy).log(any(DetailAST.class), any(String.class));
		String path = "src/main/java/TestSuite/Oper.java";
		new TreeWalker2(path, checkSpy);
		assertEquals(2, checkSpy.getCounter());
	}
	
	public String expectedString(int x) {
		return "Operand Count: " + x;
	}
}
