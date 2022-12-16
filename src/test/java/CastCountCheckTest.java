import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.DetailAstImpl;

import MyPack.CastCountCheck;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

class CastCountCheckTest {

	
	@Test
	void testBeginTree() {
		CastCountCheck a = new CastCountCheck();
		a.beginTree(null);
		assertEquals(expectedString(0), a.CatchMsg());
	}
	
	@Test
	void testFinishTree() {
		CastCountCheck obj = new CastCountCheck();
		CastCountCheck checkMock = mock(CastCountCheck.class);
		
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
		CastCountCheck a = new CastCountCheck();
		assertEquals(1, a.getDefaultTokens().length);
	}
	
	@Test
	void testVisitToken() {
		CastCountCheck a = new CastCountCheck();
		a.visitToken(null);
		assertEquals(expectedString(1), a.CatchMsg());
	}
	
	@Test
	void testGetAcceptableTokens() {
		CastCountCheck a = new CastCountCheck();
		assertEquals(1, a.getAcceptableTokens().length);
	}
	
	@Test
	void testGetRequiredTokens() {
		CastCountCheck a = new CastCountCheck();
		assertEquals(a.getRequiredTokens().length, 0);
	}
	
	@Test
	void testIsCommentNodesRequired() {
		CastCountCheck a = new CastCountCheck();
		assertTrue(a.isCommentNodesRequired());
	}

	// SPY
	@Test
	void testCatchMsg() {
		
		CastCountCheck HalLength = new CastCountCheck();
		
		CastCountCheck spy = spy(HalLength);
		when(spy.getCounter()).thenReturn(5);
		String expected = expectedString(5);
		String actual = spy.CatchMsg();
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testGetCounter() {
		CastCountCheck obj = new CastCountCheck();
		assertEquals(0, obj.getCounter());
	}
	
	public String expectedString(int x) {
		return "You've used a total of: " + x + " typecast(s)";
	}

}
