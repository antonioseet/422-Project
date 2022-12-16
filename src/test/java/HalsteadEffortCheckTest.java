import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.DetailAstImpl;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import MyPack.HalsteadArrayMaster;
import MyPack.HalsteadEffortCheck;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

class HalsteadEffortCheckTest {

	
	@Test
	void testBeginTree() {
		HalsteadEffortCheck a = new HalsteadEffortCheck();
		a.beginTree(null);
		assertEquals(expectedString(0), a.CatchMsg());
	}
	
	@Test
	void testFinishTree() {
		HalsteadEffortCheck obj = new HalsteadEffortCheck();
		HalsteadEffortCheck checkMock = mock(HalsteadEffortCheck.class);
		
		doNothing().when(checkMock).log(null, expectedString(0));
		
		checkMock.finishTree(null);
		
		String expected = expectedString(0);
		String actual = obj.CatchMsg();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetDefaultTokens() {
		HalsteadEffortCheck a = new HalsteadEffortCheck();
		HalsteadArrayMaster tokens = new HalsteadArrayMaster();
		assertEquals(a.getDefaultTokens().length, tokens.getMasterList().length);
	}
	
	@Test
	void testVisitToken() {
		HalsteadEffortCheck obj = new HalsteadEffortCheck();
		obj.beginTree(null);
		
		DetailAstImpl testAST = new DetailAstImpl();
		testAST.setType(TokenTypes.NUM_INT);
		obj.visitToken(testAST);
		testAST.setType(TokenTypes.CHAR_LITERAL);
		obj.visitToken(testAST);
		testAST.setType(TokenTypes.DIV);
		obj.visitToken(testAST);
		
		/*
		 * uniqueOps = 1
		 * operands = 2
		 * unique operands = 2
		 * 
		 * len = 3
		 * log(3)/log(2)
		 * 
		 * {[uniqueOps/2] * operands * uniqueOperands} * [len * log(3)/log(2)]
		 *  Effort should equal ~2.377
		 */
		
		double diff = (0.5 * 2)/2;
		double volume = 3 * (Math.log(3)/Math.log(2));
		
		assertEquals(expectedString(diff * volume), obj.CatchMsg());
	}
	
	@Test
	void testGetAcceptableTokens() {
		HalsteadEffortCheck a = new HalsteadEffortCheck();
		HalsteadArrayMaster tokens = new HalsteadArrayMaster();
		assertEquals(a.getAcceptableTokens().length, tokens.getMasterList().length);
	}
	
	@Test
	void testGetRequiredTokens() {
		HalsteadEffortCheck a = new HalsteadEffortCheck();
		assertEquals(a.getRequiredTokens().length, 0);
	}
	
	@Test
	void testIsCommentNodesRequired() {
		HalsteadEffortCheck a = new HalsteadEffortCheck();
		assertTrue(a.isCommentNodesRequired());
	}

	// SPY
	@Test
	void testCatchMsg() {
		
		HalsteadEffortCheck HalLength = new HalsteadEffortCheck();
		
		HalsteadEffortCheck spy = spy(HalLength);
		when(spy.getEffort()).thenReturn(5.0);
		String expected = expectedString(5.0);
		String actual = spy.CatchMsg();
		
		assertEquals(expected, actual);
		
	}
	
	// SPY2
	@Test
	void testCatchMsg_NonZeroVolume() {
		
		HalsteadEffortCheck effort = new HalsteadEffortCheck();
		
		HalsteadEffortCheck spy = spy(effort);
		when(spy.getVolume()).thenReturn(5.0);
		String actual = spy.CatchMsg();
		
		assertEquals(expectedString(0.0), actual);
		
	}
	
	@Test
	void testGetCounter() {
		HalsteadEffortCheck obj = new HalsteadEffortCheck();
		assertEquals(0, obj.getEffort());
	}
	
	public String expectedString(double x) {
		return "The Halstead Effort is: " + x;
	}

}
