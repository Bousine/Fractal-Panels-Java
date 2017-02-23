package code;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class JuliaTest {
	private JuliaSet obj;
	
	//Added tests except the first two. One of the tests below is failing. 
	@Before
	public void setup(){
		obj = new JuliaSet();		
	}

	@Test
	public void distanceNotPassedTest(){
		//Test for the escape time for a coordinate whose distance from the origin never exceeds the escape distance 
		int result = obj.calcEscapeTime(1.0492187499999897, -0.234375);
		assertEquals(255, result);
	}
	
	@Test
	public void distancePassedTest(){
		//Test for the escape time for a coordinate whose distance from the origin never exceeds the escape distance 
		int result = obj.calcEscapeTime(1.6933593749999853, 0.9765625);
		assertEquals(1, result);
	}
	
	
	@Test
	public void fractalArrayReturnCheck(){
		//Test that the fractal returns a 2-d array
		int[][] result = obj.getFractal();
		assertEquals(512, result.length);
		assertEquals(512, result[0].length);
	}
}


