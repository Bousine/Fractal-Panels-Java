package code;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class MultibrotTest {
	private MultibrotSet object;
	
	@Before
	public void SetUp(){
		object = new MultibrotSet();
	}
	
	// The method called to calculate the fractal returns a 2-d array with 512 rows and 512 columns
	@Test
	public void test_returnResult(){
		assertFalse(object.fractalCalc()==null);
		assertEquals(512, object.fractalCalc().length);
		assertEquals(512, object.fractalCalc()[0].length);
		
	}
	
	
	// Translate a pixel's row to the associated x-coordinate in the fractal
	@Test
	public void test1(){
		double actual0 = object.arrayToCoordinate(0, -1, 1, 512);
		double actual256 = object.arrayToCoordinate(256, -1, 1, 512);
		double actual512 = object.arrayToCoordinate(512, -1, 1, 512);
		assertEquals(-1, actual0, 0.0001);
		assertEquals(0, actual256, 0.0001);
		assertEquals(1, actual512, 0.0001);
		
	}
	
	// Translate a pixel's column to the associated y-coordinate in the fractal
	@Test
	public void test2(){
		double actual0 = object.arrayToCoordinate(0, -1.3, 1.3, 512);
		double actual256 = object.arrayToCoordinate(256, -1.3, 1.3, 512);
		double actual512 = object.arrayToCoordinate(512, -1.3, 1.3, 512);
		assertEquals(-1.3, actual0, 0.0001);
		assertEquals(0, actual256, 0.0001);
		assertEquals(1.3, actual512, 0.0001);
		
	}

}
