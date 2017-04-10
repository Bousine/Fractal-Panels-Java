package code;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

/**
 * Class which tests escape-time for Multibrot fractal 
 * 
 * @author Mark Kayutkin
 * @author Asif Hasan
 * @author Xiangshuai Gao 
 */


public class MultibrotTest {
	/**
	 * The class object being tested.
	 */
	private MultibrotSet obj;
	
	/**
	 * Setup
	 */
	@Before
	public void SetUp(){
		obj = new MultibrotSet(2, 255);
	}
	
	/**
	 * The method called to calculate the fractal returns a 2-d array with 512 rows and 512 columns.
	 */
	@Test
	public void fractalArrayReturnCheck(){
		assertFalse(obj.fractalCalc()==null);
		assertEquals(512, obj.fractalCalc().length);
		assertEquals(512, obj.fractalCalc()[0].length);
		
	}
	/**
	 *Translate a pixel's row to the associated x-coordinate in the fractal 
	 */
	@Test
	public void RowToXTest() {
		int row1 = 0;		
		int row2 = 255;
		int row3 = 511;
		
		int rows = 512;
		double start = -1.0;
		double end = 1.0;
	
		assertEquals(-1.0, obj.arrayToCoordinate(row1, start, end, rows), 0.01);
		assertEquals(-0.0039, obj.arrayToCoordinate(row2, start, end, rows), 0.01);
		assertEquals(1.0, obj.arrayToCoordinate(row3, start, end, rows), 0.01);
	}
	
	/**
	 * Translate a pixel's column to the associated y-coordinate in the fractal
	 */ 
	@Test
	public void ColtoYTest() {
		int row1 = 0;		
		int row2 = 255;
		int row3 = 511;
		
		int cols = 512;
		double start = -1.3;
		double end = 1.3;
	
		assertEquals(-1.3, obj.arrayToCoordinate(row1, start, end, cols), 0.01);
		assertEquals(-0.0051, obj.arrayToCoordinate(row2, start, end, cols), 0.01);
		assertEquals(1.3, obj.arrayToCoordinate(row3, start, end, cols), 0.01);
	}
	
	/**
	 * Test for the escape time for a coordinate whose distance from the origin never exceeds the escape distance
	 */
	@Test
	public void distanceNotPassedTest(){
		int result = obj.escapeTime(0.5859375, 0.24375000000000108);
		assertEquals(255, result);
	}
	
	/**
	 * Calculates the escape time for a coordinate whose distance from the origin exceeds the escape distance after a single loop pass
	 */
	@Test
	public void distancePassedTest(){
		int result = obj.escapeTime(0.9921875, 1.05625);
		assertEquals(1, result);
	}
	
	@Test
	public void escapeDistanceChange(){
		obj = new MultibrotSet(3, 255);
		assertEquals(obj.getEscapeDistance(), 3, 0.0);
		obj = new MultibrotSet(10.55, 255);
		assertEquals(obj.getEscapeDistance(), 10.55, 0.0);
	}
	
	@Test
	public void escapeTimeforNewEscDist(){
		obj = new MultibrotSet(3, 255);
		int result = obj.escapeTime(0.7025440313111545, -0.5520547945205528);
		assertEquals(result, 10);
	}
	
	@Test
	public void escapeTimeforNewEscDistAndTime(){
		obj = new MultibrotSet(2, 135);
		int result = obj.escapeTime(0.5859375, 0.24375000000000108);
		assertEquals(result, 135);
	}
	
}
