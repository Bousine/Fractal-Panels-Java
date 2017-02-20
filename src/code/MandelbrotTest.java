package code;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MandelbrotTest {
	private MandelbrotSet object;
	
	
	@Before
	public void setup(){
		object = new MandelbrotSet();
	}

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
	
	
	

	@Test
	public void test_newPositionX() {
		double x1 = 4586.254;
		double y1 = 78569.266;
		double x2 = 459.22;
		double y2 = (-657.22);
		double x3 = (-996.11);
		double y3 = (1000.05);
		assertEquals((-6152091248.0), object.newPositionX(x1, y1), 1);
		assertEquals((-220595.9), object.newPositionX(x2, y2), 0.0001);
		assertEquals((-8860.9804), object.newPositionX(x3, y3), 0.0001);
	}
	
	
	
	@Test
	public void test_newPositionY() {
		double x1 = 4586.254;
		double y1 = 78569.266;
		double x2 = 459.22;
		double y2 = (-657.22);
		double x3 = (-996.11);
		double y3 = (1000.05);
		assertEquals((720755790.2), object.newPositionY(x1, y1), 1);
		assertEquals((-604274.3568), object.newPositionY(x2, y2),0.0001);
		assertEquals((-1991319.561), object.newPositionY(x3, y3),0.0001);
	}
	
	
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
	
	@Test
	public void test_getEscapeTime() {
		double xCal = 0.3207031250000001;
		double yCal = -0.07109374999999386;
		double distanceOrigin = object.distanceCalculator(xCal, yCal);
		double escapeDistance = distanceOrigin;
		int passes = 0;
		boolean neverExceeds = false;
		while(escapeDistance <= 2 && passes <255){
			double tempX = xCal;
			double tempY = yCal;
			xCal = object.newPositionX(tempX, tempY);
			yCal = object.newPositionY(tempX, tempY);
			escapeDistance = object.distanceCalculator(xCal, yCal);
			passes += 1;
			neverExceeds = distanceOrigin <= escapeDistance;
			if(neverExceeds == false){
				break;
			}
		}
		
		assertTrue(neverExceeds);
		
	}

}
