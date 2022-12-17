package WhiteBox_Tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.DetailAstImpl;

import MyPack.ACheck;
import MyPack.CastCountCheck;
import MyPack.HalsteadArrayMaster;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

class HalsteadLengthTest {

	
	@Test
	void testBeginTree() {
		DetailAstImpl ast = new DetailAstImpl();
		ACheck a = new ACheck();
		a.beginTree(ast);
		assertEquals(expectedString(0), a.CatchMsg());
	}
	
	@Test
	void testFinishTree() {
		ACheck obj = new ACheck();
		ACheck checkSpy = spy(ACheck.class);
		doNothing().when(checkSpy).log(null, expectedString(0));
		checkSpy.finishTree(null);
		verify(checkSpy).finishTree(null);
		
		String expected = expectedString(0);
		String actual = obj.CatchMsg();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetDefaultTokens() {
		ACheck a = new ACheck();
		HalsteadArrayMaster tokens = new HalsteadArrayMaster();
		assertEquals(a.getDefaultTokens().length, tokens.getMasterList().length);
	}
	
	@Test
	void testVisitToken() {
		ACheck a = new ACheck();
		a.visitToken(null);
		assertEquals(expectedString(1), a.CatchMsg());
	}
	
	@Test
	void testGetAcceptableTokens() {
		ACheck a = new ACheck();
		HalsteadArrayMaster tokens = new HalsteadArrayMaster();
		assertEquals(a.getAcceptableTokens().length, tokens.getMasterList().length);
	}
	
	@Test
	void testGetRequiredTokens() {
		ACheck a = new ACheck();
		assertEquals(a.getRequiredTokens().length, 0);
	}
	
	@Test
	void testIsCommentNodesRequired() {
		ACheck a = new ACheck();
		assertTrue(a.isCommentNodesRequired());
	}

	// SPY
	@Test
	void testCatchMsg() {
		
		ACheck HalLength = new ACheck();
		
		ACheck spy = spy(HalLength);
		when(spy.getCounter()).thenReturn(5);
		String expected = expectedString(5);
		String actual = spy.CatchMsg();
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testGetCounter() {
		ACheck obj = new ACheck();
		assertEquals(0, obj.getCounter());
	}
	
	public String expectedString(int x) {
		return "The Halstead Length is: " + x;
	}

}
