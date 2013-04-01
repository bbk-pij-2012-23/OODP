/**
 * 
 */
package poker;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.*;

/**
 * @author eleanormann
 *
 */
public class TestCalculator {
	Calculator testCal;
	
	@Test
	public void test() {
		Calculator testCal = new Calculator();
		assertTrue(testCal!=null);

	}
	
	
	
	@Test
	public void testCountSameValue(){
		int [] cardValues = {3,3,10,12,12};
		int [] output = {2,1,2};
		
		
		assertEquals(output, testCal.countSameValues(cardValues));
	
	}

}
