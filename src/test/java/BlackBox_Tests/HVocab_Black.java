package BlackBox_Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.spy;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.DetailAST;

import MyPack.ACheck;
import MyPack.HalsteadVocabularyCheck;
import TestSuite.TreeWalker2;

public class HVocab_Black {

	private int expected = 4;
	
	@Test
	void testVocab() throws IOException, CheckstyleException {
		
		HalsteadVocabularyCheck checkSpy = spy(HalsteadVocabularyCheck.class);
		doNothing().when(checkSpy).log(any(DetailAST.class), any(String.class));
		String path = "src/main/java/TestSuite/ThreeComments.java";
		new TreeWalker2(path, checkSpy);
		assertEquals(expected, checkSpy.getCounter());
	}
	

	@Test
	void testVocabMsg() throws IOException, CheckstyleException {
		
		HalsteadVocabularyCheck checkSpy = spy(HalsteadVocabularyCheck.class);
		doNothing().when(checkSpy).log(any(DetailAST.class), any(String.class));
		String path = "src/main/java/TestSuite/ThreeComments.java";
		new TreeWalker2(path, checkSpy);
		assertEquals(expectedString(expected), checkSpy.CatchMsg());
	}
	
	public String expectedString(int x) {
		return "The Halstead Vocabulary is: " + x;
	}
}
