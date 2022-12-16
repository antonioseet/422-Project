import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.DetailAstImpl;
import com.puppycrawl.tools.checkstyle.api.DetailAST;

import MyPack.HalsteadVocabularyCheck;
import MyPack.HalsteadArrayMaster;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

class HalsteadVocabularyTest {

	
	@Test
	void testBeginTree() {
		HalsteadVocabularyCheck a = new HalsteadVocabularyCheck();
		a.beginTree(null);
		assertEquals(expectedString(0), a.CatchMsg());
	}
	
	@Test
	void testFinishTree() {
		HalsteadVocabularyCheck obj = new HalsteadVocabularyCheck();
		HalsteadVocabularyCheck checkMock = mock(HalsteadVocabularyCheck.class);
		
		doNothing().when(checkMock).log(null, expectedString(0));
		
		checkMock.finishTree(null);
		
		String expected = expectedString(0);
		String actual = obj.CatchMsg();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetDefaultTokens() {
		HalsteadVocabularyCheck a = new HalsteadVocabularyCheck();
		HalsteadArrayMaster tokens = new HalsteadArrayMaster();
		assertEquals(a.getDefaultTokens().length, tokens.getMasterList().length);
	}
	
	@Test
	void testVisitToken() {
		HalsteadVocabularyCheck obj = new HalsteadVocabularyCheck();
		obj.visitToken(new DetailAstImpl());
		assertEquals(expectedString(1), obj.CatchMsg());
	}
	
	@Test
	void testGetAcceptableTokens() {
		HalsteadVocabularyCheck a = new HalsteadVocabularyCheck();
		HalsteadArrayMaster tokens = new HalsteadArrayMaster();
		assertEquals(a.getAcceptableTokens().length, tokens.getMasterList().length);
	}
	
	@Test
	void testGetRequiredTokens() {
		HalsteadVocabularyCheck a = new HalsteadVocabularyCheck();
		assertEquals(a.getRequiredTokens().length, 0);
	}
	
	@Test
	void testIsCommentNodesRequired() {
		HalsteadVocabularyCheck a = new HalsteadVocabularyCheck();
		assertTrue(a.isCommentNodesRequired());
	}

	// SPY
	@Test
	void testCatchMsg() {
		
		HalsteadVocabularyCheck HalLength = new HalsteadVocabularyCheck();
		
		HalsteadVocabularyCheck spy = spy(HalLength);
		when(spy.getCounter()).thenReturn(5);
		String expected = expectedString(5);
		String actual = spy.CatchMsg();
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testGetCounter() {
		HalsteadVocabularyCheck obj = new HalsteadVocabularyCheck();
		assertEquals(0, obj.getCounter());
	}
	
	public String expectedString(int x) {
		return "The Halstead Vocabulary is: " + x;
	}

}
