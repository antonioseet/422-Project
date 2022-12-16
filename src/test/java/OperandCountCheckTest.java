import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.DetailAstImpl;

import MyPack.OperandCountCheck;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

class OperandCountCheckTest {

	
	@Test
	void testBeginTree() {
		OperandCountCheck a = new OperandCountCheck();
		a.beginTree(null);
		assertEquals(expectedString(0), a.CatchMsg());
	}
	
	@Test
	void testFinishTree() {
		OperandCountCheck obj = new OperandCountCheck();
		OperandCountCheck checkMock = mock(OperandCountCheck.class);
		
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
		OperandCountCheck a = new OperandCountCheck();
		assertEquals(6, a.getDefaultTokens().length);
	}
	
	@Test
	void testVisitToken() {
		OperandCountCheck a = new OperandCountCheck();
		a.visitToken(null);
		assertEquals(expectedString(1), a.CatchMsg());
	}
	
	@Test
	void testGetAcceptableTokens() {
		OperandCountCheck a = new OperandCountCheck();
		assertEquals(6, a.getAcceptableTokens().length);
	}
	
	@Test
	void testGetRequiredTokens() {
		OperandCountCheck a = new OperandCountCheck();
		assertEquals(a.getRequiredTokens().length, 0);
	}
	
	@Test
	void testIsCommentNodesRequired() {
		OperandCountCheck a = new OperandCountCheck();
		assertTrue(a.isCommentNodesRequired());
	}

	// SPY
	@Test
	void testCatchMsg() {
		
		OperandCountCheck HalLength = new OperandCountCheck();
		
		OperandCountCheck spy = spy(HalLength);
		when(spy.getCounter()).thenReturn(5);
		String expected = expectedString(5);
		String actual = spy.CatchMsg();
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testGetCounter() {
		OperandCountCheck obj = new OperandCountCheck();
		assertEquals(0, obj.getCounter());
	}
	
	public String expectedString(int x) {
		return "Operand Count: " + x;
	}

}
