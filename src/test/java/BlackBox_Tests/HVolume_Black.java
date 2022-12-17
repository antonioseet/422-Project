package BlackBox_Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.spy;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.DetailAST;

import MyPack.HalsteadVocabularyCheck;
import MyPack.HalsteadVolumeCheck;
import TestSuite.TreeWalker2;

public class HVolume_Black {
	
	private double expected = 8.0;
	
	@Test
	void testVolume() throws IOException, CheckstyleException {
		
		HalsteadVolumeCheck checkSpy = spy(HalsteadVolumeCheck.class);
		doNothing().when(checkSpy).log(any(DetailAST.class), any(String.class));
		String path = "src/main/java/TestSuite/ThreeComments.java";
		new TreeWalker2(path, checkSpy);
		assertEquals(expected, checkSpy.getVolume());
	}

	@Test
	void testVolumeMsg() throws IOException, CheckstyleException {
		
		HalsteadVolumeCheck checkSpy = spy(HalsteadVolumeCheck.class);
		doNothing().when(checkSpy).log(any(DetailAST.class), any(String.class));
		String path = "src/main/java/TestSuite/ThreeComments.java";
		new TreeWalker2(path, checkSpy);
		assertEquals(expectedString(expected), checkSpy.CatchMsg());
	}
	
	public String expectedString(double x) {
		return "The Halstead Volume is: " + x;
	}
}
