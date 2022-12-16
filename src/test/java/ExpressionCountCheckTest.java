import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.DetailAstImpl;

import MyPack.CastCountCheck;
import MyPack.ExpressionCountCheck;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

class ExpressionCountCheckTest {

	
	@Test
	void testBeginTree() {
		ExpressionCountCheck a = new ExpressionCountCheck();
		a.beginTree(null);
		assertEquals(expectedString(0), a.CatchMsg());
	}
	
	@Test
	void testFinishTree() {
		CastCountCheck obj = new CastCountCheck();
		CastCountCheck checkSpy = spy(CastCountCheck.class);
		doNothing().when(checkSpy).log(null, expectedString(0));
		checkSpy.finishTree(null);
		verify(checkSpy).finishTree(null);
		
		String expected = expectedString(0);
		String actual = obj.CatchMsg();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetDefaultTokens() {
		ExpressionCountCheck a = new ExpressionCountCheck();
		assertEquals(1, a.getDefaultTokens().length);
	}
	
	@Test
	void testVisitToken() {
		ExpressionCountCheck a = new ExpressionCountCheck();
		a.visitToken(null);
		assertEquals(expectedString(1), a.CatchMsg());
	}
	
	@Test
	void testGetAcceptableTokens() {
		ExpressionCountCheck a = new ExpressionCountCheck();
		assertEquals(1, a.getAcceptableTokens().length);
	}
	
	@Test
	void testGetRequiredTokens() {
		ExpressionCountCheck a = new ExpressionCountCheck();
		assertEquals(a.getRequiredTokens().length, 0);
	}
	
	@Test
	void testIsCommentNodesRequired() {
		ExpressionCountCheck a = new ExpressionCountCheck();
		assertTrue(a.isCommentNodesRequired());
	}

	// SPY
	@Test
	void testCatchMsg() {
		
		ExpressionCountCheck HalLength = new ExpressionCountCheck();
		
		ExpressionCountCheck spy = spy(HalLength);
		when(spy.getCounter()).thenReturn(5);
		String expected = expectedString(5);
		String actual = spy.CatchMsg();
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testGetCounter() {
		ExpressionCountCheck obj = new ExpressionCountCheck();
		assertEquals(0, obj.getCounter());
	}
	
	public String expectedString(int x) {
		return "You've used a total of: " + x + " expression(s)";
	}

}
