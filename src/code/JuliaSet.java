package code;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

public class JuliaSet {
	private double _xCalc;
	private double _yCalc;
	private int _row;
	private int _col;
	int[][] _fractal;
	private double _xHigh;
	private double _xLow;
	private double _yHigh;
	private double _yLow;
	private double _xConstant;
	private double _yConstant;
	private double _xCurr;
	private double _yCurr;
	
	public JuliaSet(){
		_row = 512;
		_col = 512;
		_fractal = new int[_row][_col];
		_xHigh = 1.7;
		_xLow = -1.7;
		_yHigh = 1.0;
		_yLow = -1.0;
		_xConstant = -0.72689;
		_yConstant = 0.188887;
		
	}
	
	public int calcEscapeTime(double x, double y){
		int esc = 0;
		int passes = 0;
		_xCurr = calcCoords(x, y).x;
		_yCurr = calcCoords(x, y).y;
		_xCalc = _xCurr;
		_yCalc = _yCurr;
		double dist = Math.sqrt((_xCalc*_xCalc) +(_yCalc*_yCalc));
		while (dist <= 4 && passes < 255){
				updateCoords(_xCalc, _yCalc);
				passes++;
				dist = Math.sqrt((_xCalc*_xCalc) +(_yCalc*_yCalc));
			
		}
		esc = passes;
		return esc;
	}
	
	//This method is failing the test. Hardcoded numbers the problem.
	public void updateCoords(double x, double y){
		_xCurr = (x*x)-(y*y)+_xConstant; //Use the current value of the point because you are looping through points for fractalCalc.
		_yCurr = (2*x*y)+_yConstant;
	}
	
	public Point2D.Double calcCoords(double x, double y){
		Point2D.Double p = new Point2D.Double();
		double xRange = _xHigh - _xLow;
		double yRange = _yHigh - _yLow;
		p.x = ((xRange/ _row)*x) - _xHigh;
		p.y = ((yRange/ _col)*y) - _yHigh;
		return p;
	}
	
	//Method Below added by me
	public int[][] getFractal(){
		for (int r = 0; r < _row; r++){
			for (int c = 0; c < _col; c++){
				_fractal[c][r] = calcEscapeTime(c,r);
			}
		}
		return _fractal;
	}
	

}
