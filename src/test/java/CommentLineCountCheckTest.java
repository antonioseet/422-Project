import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.DetailAstImpl;

import MyPack.CommentLineCountCheck;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

class CommentLineCountCheckTest {

	
	@Test
	void testBeginTree() {
		CommentLineCountCheck a = new CommentLineCountCheck();
		a.beginTree(null);
		assertEquals(expectedString(0), a.CatchMsg());
	}
	
	@Test
	void testFinishTree() {
		CommentLineCountCheck obj = new CommentLineCountCheck();
		CommentLineCountCheck checkMock = mock(CommentLineCountCheck.class);
		
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
		CommentLineCountCheck a = new CommentLineCountCheck();
		assertEquals(3, a.getDefaultTokens().length);
	}
	
	@Test
	void testVisitToken() {
		CommentLineCountCheck a = new CommentLineCountCheck();
		a.visitToken(null);
		assertEquals(expectedString(1), a.CatchMsg());
	}
	
	@Test
	void testGetAcceptableTokens() {
		CommentLineCountCheck a = new CommentLineCountCheck();
		assertEquals(2, a.getAcceptableTokens().length);
	}
	
	@Test
	void testGetRequiredTokens() {
		CommentLineCountCheck a = new CommentLineCountCheck();
		assertEquals(a.getRequiredTokens().length, 0);
	}
	
	@Test
	void testIsCommentNodesRequired() {
		CommentLineCountCheck a = new CommentLineCountCheck();
		assertTrue(a.isCommentNodesRequired());
	}

	// SPY
	@Test
	void testCatchMsg() {
		
		CommentLineCountCheck HalLength = new CommentLineCountCheck();
		
		CommentLineCountCheck spy = spy(HalLength);
		when(spy.getCounter()).thenReturn(5);
		String expected = expectedString(5);
		String actual = spy.CatchMsg();
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testGetCounter() {
		CommentLineCountCheck obj = new CommentLineCountCheck();
		assertEquals(0, obj.getCounter());
	}
	
	public String expectedString(int x) {
		return "You've used a total of: " + x + " comment line(s)";
	}

}
