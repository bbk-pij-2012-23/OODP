/**
 * 
 */
package poker;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Mockito.*;

/**
 * @author eleanormann
 *
 */
public class TestCalculator {

	@Test
	public void test() {
		Calculator testCal = new Calculator();
		assertTrue(testCal!=null);

	}
	
	@Test
	public void testCountValue(){
		Hand mockedHand = mock(Hand.class);
		when(mockedHand.getValue(1).thenReturn(1));
		
	}

}
