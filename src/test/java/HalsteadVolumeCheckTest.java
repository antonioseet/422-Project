import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.DetailAstImpl;
import com.puppycrawl.tools.checkstyle.api.DetailAST;

import MyPack.HalsteadVolumeCheck;
import MyPack.HalsteadArrayMaster;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

class HalsteadVolumeCheckTest {

	
	@Test
	void testBeginTree() {
		HalsteadVolumeCheck a = new HalsteadVolumeCheck();
		a.beginTree(null);
		assertEquals(expectedString(0), a.CatchMsg());
	}
	
	@Test
	void testFinishTree() {
		HalsteadVolumeCheck obj = new HalsteadVolumeCheck();
		HalsteadVolumeCheck checkMock = mock(HalsteadVolumeCheck.class);
		
		doNothing().when(checkMock).log(null, expectedString(0));
		
		checkMock.finishTree(null);
		
		String expected = expectedString(0);
		String actual = obj.CatchMsg();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetDefaultTokens() {
		HalsteadVolumeCheck a = new HalsteadVolumeCheck();
		HalsteadArrayMaster tokens = new HalsteadArrayMaster();
		assertEquals(a.getDefaultTokens().length, tokens.getMasterList().length);
	}
	
	@Test
	void testVisitToken() {
		HalsteadVolumeCheck obj = new HalsteadVolumeCheck();
		obj.visitToken(new DetailAstImpl());
		DetailAstImpl testAST = new DetailAstImpl();
		testAST.setType(5);
		obj.visitToken(testAST);
		assertEquals(expectedString(2), obj.CatchMsg());
	}
	
	@Test
	void testGetAcceptableTokens() {
		HalsteadVolumeCheck a = new HalsteadVolumeCheck();
		HalsteadArrayMaster tokens = new HalsteadArrayMaster();
		assertEquals(a.getAcceptableTokens().length, tokens.getMasterList().length);
	}
	
	@Test
	void testGetRequiredTokens() {
		HalsteadVolumeCheck a = new HalsteadVolumeCheck();
		assertEquals(a.getRequiredTokens().length, 0);
	}
	
	@Test
	void testIsCommentNodesRequired() {
		HalsteadVolumeCheck a = new HalsteadVolumeCheck();
		assertTrue(a.isCommentNodesRequired());
	}

	// SPY
	@Test
	void testCatchMsg() {
		
		HalsteadVolumeCheck HalLength = new HalsteadVolumeCheck();
		
		HalsteadVolumeCheck spy = spy(HalLength);
		when(spy.getVolume()).thenReturn(5.0);
		String expected = expectedString(5.0);
		String actual = spy.CatchMsg();
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testGetCounter() {
		HalsteadVolumeCheck obj = new HalsteadVolumeCheck();
		assertEquals(0, obj.getVolume());
	}
	
	public String expectedString(double x) {
		return "The Halstead Volume is: " + x;
	}

}
