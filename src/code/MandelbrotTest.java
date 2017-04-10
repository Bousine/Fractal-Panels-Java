package code;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Class which tests escape-time for Mandelbrot fractal 
 * 
 * @author Mark Kayutkin
 * @author Asif Hasan
 * @author Xiangshuai Gao 
 */



public class MandelbrotTest {
	/**
	 * The class object being tested.
	 */
	private MandelbrotSet object;
	
	/**
	 * Setup
	 */
	@Before
	public void setup(){
		object = new MandelbrotSet(2, 255);
	}
    
	/**
	 * My distance test. Not required but nice when debugging
	 */
	@Test
	public void test_distanceCalculator() {
		double x1 = 4586.254;
		double y1 = 78569.266;
		double x2 = 459.22;
		double y2 = (-657.22);
		double x3 = (-996.11);
		double y3 = (1000.05);
		assertEquals(78703.00684, object.distanceCalculator(x1, y1), 0.00001);
		assertEquals(801.7612717, object.distanceCalculator(x2, y2), 0.00001);
		assertEquals(1411.501022, object.distanceCalculator(x3, y3), 0.00001);
	}
	
	/**
	 * Translate a pixel's row to the associated x-coordinate in the fractal 
	 * Translate a pixel's column to the associated y-coordinate in the fractal
	 */
	@Test
	public void test_getCoordinates() {
		double y512 = object.getCoordinates(512, 512).y;
		double x512 = object.getCoordinates(512, 512).x;
		double y0 = object.getCoordinates(0, 0).y;
		double x0 = object.getCoordinates(0, 0).x;
		double y256 = object.getCoordinates(256, 256).y;
		double x256 = object.getCoordinates(256, 256).x;
		assertEquals(1.3, y512, 0.0001);
		assertEquals(0.6, x512, 0.0001);
		assertEquals(-1.3, y0, 0.0001);
		assertEquals(-2.15, x0, 0.0001);
		assertEquals(0, y256, 0.0001);
		assertEquals(-0.775, x256, 0.0001);
	}
	
	
	/**
	 * Test for the escape time for a coordinate whose distance from the origin never exceeds the escape distance
	 */
	@Test
	public void distanceNotPassedTest(){ 
		int result = object.getEscapeTime(0.3207031250000001, -0.07109374999999386);
		assertEquals(255, result);
	}
	
	/**
	 * Calculates the escape time for a coordinate whose distance from the origin exceeds the escape distance after a single loop pass
	 */
	@Test
	public void distancePassedTest(){
		int result = object.getEscapeTime(0.5946289062500001, 1.2949218750000122);
		assertEquals(1, result);
	}
	
	/**
	 * The method called to calculate the fractal returns a 2-d array with 512 rows and 512 columns.
	 */
	@Test
	public void fractalArrayReturnCheck(){
		//Test that the fractal returns a 2-d array
		int[][] result = object.returnResult();
		assertEquals(512, result.length);
		assertEquals(512, result[0].length);
	}
	
	@Test
	public void escapeDistanceChange(){
		object = new MandelbrotSet(3, 255);
		assertEquals(object.getEscapeDistance(), 3, 0.0);
		object = new MandelbrotSet(10.55, 255);
		assertEquals(object.getEscapeDistance(), 10.55, 0.0);
	}
	
	@Test
	public void escapeTimeforNewEscDist(){
		object = new MandelbrotSet(3, 255);
		int result = object.getEscapeTime(0.46007827788650374, -0.3383561643835661);
		assertEquals(result, 10);
	}
	
	@Test
	public void escapeTimeforNewEscDistAndTime(){
		object = new MandelbrotSet(2, 135);
		int result = object.getEscapeTime(0.3207031250000001, -0.07109374999999386);
		assertEquals(result, 135);
	}


}
