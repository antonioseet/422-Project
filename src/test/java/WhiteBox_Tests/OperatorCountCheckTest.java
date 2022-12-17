package WhiteBox_Tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.DetailAstImpl;

import MyPack.CastCountCheck;
import MyPack.OperatorCountCheck;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

class OperatorCountCheckTest {

	
	@Test
	void testBeginTree() {
		OperatorCountCheck a = new OperatorCountCheck();
		a.beginTree(null);
		assertEquals(expectedString(0), a.CatchMsg());
	}
	
	@Test
	void testFinishTree() {
		OperatorCountCheck obj = new OperatorCountCheck();
		OperatorCountCheck checkSpy = spy(OperatorCountCheck.class);
		doNothing().when(checkSpy).log(null, expectedString(0));
		checkSpy.finishTree(null);
		verify(checkSpy).finishTree(null);
		
		String expected = expectedString(0);
		String actual = obj.CatchMsg();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetDefaultTokens() {
		OperatorCountCheck a = new OperatorCountCheck();
		assertEquals(11, a.getDefaultTokens().length);
	}
	
	@Test
	void testVisitToken() {
		OperatorCountCheck a = new OperatorCountCheck();
		a.visitToken(null);
		assertEquals(expectedString(1), a.CatchMsg());
	}
	
	@Test
	void testGetAcceptableTokens() {
		OperatorCountCheck a = new OperatorCountCheck();
		assertEquals(11, a.getAcceptableTokens().length);
	}
	
	@Test
	void testGetRequiredTokens() {
		OperatorCountCheck a = new OperatorCountCheck();
		assertEquals(a.getRequiredTokens().length, 0);
	}
	
	@Test
	void testIsCommentNodesRequired() {
		OperatorCountCheck a = new OperatorCountCheck();
		assertTrue(a.isCommentNodesRequired());
	}

	// SPY
	@Test
	void testCatchMsg() {
		
		OperatorCountCheck HalLength = new OperatorCountCheck();
		
		OperatorCountCheck spy = spy(HalLength);
		when(spy.getCounter()).thenReturn(5);
		String expected = expectedString(5);
		String actual = spy.CatchMsg();
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testGetCounter() {
		OperatorCountCheck obj = new OperatorCountCheck();
		assertEquals(0, obj.getCounter());
	}
	
	public String expectedString(int x) {
		return "Operator Count: " + x;
	}

}
