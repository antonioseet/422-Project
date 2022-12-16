import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.DetailAstImpl;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import MyPack.HalsteadArrayMaster;
import MyPack.HalsteadDifficultyCheck;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

class HalsteadDifficultyCheckTest {

	
	@Test
	void testBeginTree() {
		HalsteadDifficultyCheck a = new HalsteadDifficultyCheck();
		a.beginTree(null);
		assertEquals(expectedString(0), a.CatchMsg());
	}
	
	@Test
	void testFinishTree() {
		HalsteadDifficultyCheck obj = new HalsteadDifficultyCheck();
		HalsteadDifficultyCheck checkMock = mock(HalsteadDifficultyCheck.class);
		
		doNothing().when(checkMock).log(null, expectedString(0));
		
		checkMock.finishTree(null);
		
		String expected = expectedString(0);
		String actual = obj.CatchMsg();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetDefaultTokens() {
		HalsteadDifficultyCheck a = new HalsteadDifficultyCheck();
		HalsteadArrayMaster tokens = new HalsteadArrayMaster();
		assertEquals(a.getDefaultTokens().length, tokens.getMasterList().length);
	}
	
	@Test
	void testVisitToken() {
		HalsteadDifficultyCheck obj = new HalsteadDifficultyCheck();
		obj.beginTree(null);
		
		DetailAstImpl testAST = new DetailAstImpl();
		testAST.setType(TokenTypes.NUM_INT);
		obj.visitToken(testAST);
		testAST.setType(TokenTypes.CHAR_LITERAL);
		obj.visitToken(testAST);
		testAST.setType(TokenTypes.DIV);
		obj.visitToken(testAST);
		assertEquals(expectedString(0), obj.CatchMsg());
	}
	
	@Test
	void testGetAcceptableTokens() {
		HalsteadDifficultyCheck a = new HalsteadDifficultyCheck();
		HalsteadArrayMaster tokens = new HalsteadArrayMaster();
		assertEquals(a.getAcceptableTokens().length, tokens.getMasterList().length);
	}
	
	@Test
	void testGetRequiredTokens() {
		HalsteadDifficultyCheck a = new HalsteadDifficultyCheck();
		assertEquals(a.getRequiredTokens().length, 0);
	}
	
	@Test
	void testIsCommentNodesRequired() {
		HalsteadDifficultyCheck a = new HalsteadDifficultyCheck();
		assertTrue(a.isCommentNodesRequired());
	}

	// SPY
	@Test
	void testCatchMsg() {
		
		HalsteadDifficultyCheck HalLength = new HalsteadDifficultyCheck();
		
		HalsteadDifficultyCheck spy = spy(HalLength);
		when(spy.getDifficulty()).thenReturn(5.0);
		String expected = expectedString(5.0);
		String actual = spy.CatchMsg();
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testGetCounter() {
		HalsteadDifficultyCheck obj = new HalsteadDifficultyCheck();
		assertEquals(0, obj.getDifficulty());
	}
	
	public String expectedString(double x) {
		return "The Halstead Difficulty is: " + x;
	}

}
