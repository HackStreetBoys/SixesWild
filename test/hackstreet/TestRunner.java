package hackstreet;

import static org.junit.Assert.*;
import hackstreet.sixeswild.SixesWildRunner;

import org.junit.Test;

public class TestRunner {

	@Test
	public void testRunner() {
		
		// assert True if Runner doesn't throw any exceptions
		try{
			SixesWildRunner.main(null);
		}
		catch (Exception e){
			assertTrue(false);
		}
		assertTrue(true);
	}

}
