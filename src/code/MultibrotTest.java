package code;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class MultibrotTest {
	private MultibrotSet obj;
	
	@Before
	public void SetUp(){
		obj = new MultibrotSet();
	}
	
	// The method called to calculate the fractal returns a 2-d array with 512 rows and 512 columns
	@Test
	public void fractalArrayReturnCheck(){
		assertFalse(obj.fractalCalc()==null);
		assertEquals(512, obj.fractalCalc().length);
		assertEquals(512, obj.fractalCalc()[0].length);
		
	}
	
	
	@Test
	public void RowToXTest() {
		//Test for translating row to x
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
	
	@Test
	public void ColtoYTest() {
		//Test for translating column to y
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
	
	@Test
	public void distanceNotPassedTest(){
		//Test for the escape time for a coordinate whose distance from the origin never exceeds the escape distance 
		int result = obj.escapeTime(0.5859375, 0.24375000000000108);
		assertEquals(255, result);
	}
	
	@Test
	public void distancePassedTest(){
		//Test for the escape time for a coordinate whose distance from the origin never exceeds the escape distance 
		int result = obj.escapeTime(0.9921875, 1.05625);
		assertEquals(1, result);
	}

}
