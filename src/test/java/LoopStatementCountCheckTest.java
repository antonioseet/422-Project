import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.DetailAstImpl;

import MyPack.LoopStatementCountCheck;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

class LoopStatementCountCheckTest {

	
	@Test
	void testBeginTree() {
		LoopStatementCountCheck a = new LoopStatementCountCheck();
		a.beginTree(null);
		assertEquals(expectedString(0), a.CatchMsg());
	}
	
	@Test
	void testFinishTree() {
		LoopStatementCountCheck obj = new LoopStatementCountCheck();
		LoopStatementCountCheck checkMock = mock(LoopStatementCountCheck.class);
		
		doNothing().when(checkMock).log(null, expectedString(0));
		
		
		DetailAstImpl ast = new DetailAstImpl();
		ast.setType(2);
		checkMock.finishTree(null);
		
		String expected = expectedString(0);
		String actual = obj.CatchMsg();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetDefaultTokens() {
		LoopStatementCountCheck a = new LoopStatementCountCheck();
		assertEquals(4, a.getDefaultTokens().length);
	}
	
	@Test
	void testVisitToken() {
		LoopStatementCountCheck a = new LoopStatementCountCheck();
		a.visitToken(null);
		assertEquals(expectedString(1), a.CatchMsg());
	}
	
	@Test
	void testGetAcceptableTokens() {
		LoopStatementCountCheck a = new LoopStatementCountCheck();
		assertEquals(2, a.getAcceptableTokens().length);
	}
	
	@Test
	void testGetRequiredTokens() {
		LoopStatementCountCheck a = new LoopStatementCountCheck();
		assertEquals(a.getRequiredTokens().length, 0);
	}
	
	@Test
	void testIsCommentNodesRequired() {
		LoopStatementCountCheck a = new LoopStatementCountCheck();
		assertTrue(a.isCommentNodesRequired());
	}

	// SPY
	@Test
	void testCatchMsg() {
		
		LoopStatementCountCheck HalLength = new LoopStatementCountCheck();
		
		LoopStatementCountCheck spy = spy(HalLength);
		when(spy.getCounter()).thenReturn(5);
		String expected = expectedString(5);
		String actual = spy.CatchMsg();
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testGetCounter() {
		LoopStatementCountCheck obj = new LoopStatementCountCheck();
		assertEquals(0, obj.getCounter());
	}
	
	public String expectedString(int x) {
		return "You've used a total of: " + x + " loop statement(s)";
	}

}
