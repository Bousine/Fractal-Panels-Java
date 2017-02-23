package code;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BurningShipTest {
	private BurningShipSet obj;
	
	
	@Before
	public void setup(){
		obj = new BurningShipSet();		
	}
	
	@Test
	public void RowToXTest() {
		//Test for translating row to x
		int row1 = 0;		
		int row2 = 255;
		int row3 = 511;
		
		int rows = 512;
		double start = -1.8;
		double end = -1.7;
	
		assertEquals(-1.8, obj.arrayToCoordinate(row1, start, end, rows), 0.001);
		assertEquals(-1.7502, obj.arrayToCoordinate(row2, start, end, rows), 0.001);
		assertEquals(-1.7, obj.arrayToCoordinate(row3, start, end, rows), 0.001);
	}
	
	@Test
	public void ColtoYTest() {
		//Test for translating column to y
		int row1 = 0;		
		int row2 = 255;
		int row3 = 511;
		
		int cols = 512;
		double start = -0.08;
		double end = 0.025;
	
		assertEquals(-0.08, obj.arrayToCoordinate(row1, start, end, cols), 0.001);
		assertEquals(-0.028, obj.arrayToCoordinate(row2, start, end, cols), 0.001);
		assertEquals(0.025, obj.arrayToCoordinate(row3, start, end, cols), 0.001);
	}	
	
	@Test
	public void distNotPassedTest(){
		//Test for the escape time for a coordinate whose distance from the origin never exceeds the escape distance 
		int result = obj.escapeTime(-1.7443359374999874, -0.017451171875000338);
		assertEquals(255, result);
	}
	
	@Test
	public void fractalCalcTest(){
		//Test that none of the pixels in the Burning Ship set have an escape time of 0 or 1
		int[][] result = obj.fractalCalc();
		for(int i = 0; i < result.length; i++){
			for(int j = 0; j < result[i].length; j++){
				int escapeTime = result[i][j];
				if(escapeTime == 0 || escapeTime ==1){
					assertTrue(false);
				}
			}
		}
	}
	
	@Test
	public void fractalArrayReturnCheck(){
		//Test that the fractal returns a 2-d array
		int[][] result = obj.fractalCalc();
		assertEquals(512, result.length);
		assertEquals(512, result[0].length);
	}
}
