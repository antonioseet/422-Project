package WhiteBox_Tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.DetailAstImpl;

import MyPack.BCheck;
import MyPack.HalsteadArrayMaster;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

class NumberOfCommentsCheckTest {

	
	@Test
	void testBeginTree() {
		BCheck a = new BCheck();
		a.beginTree(null);
		assertEquals(expectedString(0), a.CatchMsg());
	}
	
	@Test
	void testFinishTree() {
		BCheck obj = new BCheck();
		BCheck checkSpy = spy(BCheck.class);
		doNothing().when(checkSpy).log(null, expectedString(0));
		checkSpy.finishTree(null);
		verify(checkSpy).finishTree(null);
		
		String expected = expectedString(0);
		String actual = obj.CatchMsg();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetDefaultTokens() {
		BCheck a = new BCheck();
		assertEquals(2, a.getDefaultTokens().length);
	}
	
	@Test
	void testVisitToken() {
		BCheck a = new BCheck();
		a.visitToken(null);
		assertEquals(expectedString(1), a.CatchMsg());
	}
	
	@Test
	void testGetAcceptableTokens() {
		BCheck a = new BCheck();
		assertEquals(2, a.getAcceptableTokens().length);
	}
	
	@Test
	void testGetRequiredTokens() {
		BCheck a = new BCheck();
		assertEquals(a.getRequiredTokens().length, 0);
	}
	
	@Test
	void testIsCommentNodesRequired() {
		BCheck a = new BCheck();
		assertTrue(a.isCommentNodesRequired());
	}

	// SPY
	@Test
	void testCatchMsg() {
		
		BCheck HalLength = new BCheck();
		
		BCheck spy = spy(HalLength);
		when(spy.getCounter()).thenReturn(5);
		String expected = expectedString(5);
		String actual = spy.CatchMsg();
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testGetCounter() {
		BCheck obj = new BCheck();
		assertEquals(0, obj.getCounter());
	}
	
	public String expectedString(int x) {
		return "You've used a total of: " + x + " comment(s)";
	}

}
