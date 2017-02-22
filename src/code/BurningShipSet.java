package code;

import java.awt.Point;

public class BurningShipSet {
	
	private double _currentX;
	private double _currentY;
	private double _xCalc;
	private double _yCalc;
	
	private double _xStart;
	private double _xEnd;
	private int _noOfRows;
	private double _yStart;
	private double _yEnd;
	private int _noOfCols;
	
	public BurningShipSet(){
		_xStart = -1.8;
		_xEnd = -1.7;
		_noOfRows = 512;
		_yStart = -0.08;
		_yEnd = 0.025;
		_noOfCols = 512;
	}
	
	public int[][] fractalCalc(){
		int[][] grid = new int[_noOfRows][_noOfCols];
		for(int row = 0; row < _noOfRows; row++){
			for(int col = 0; col < _noOfCols; col++){
				double resultX = arrayToCoordinate(row, _xStart, _xEnd, _noOfRows);
				double resultY = arrayToCoordinate(col, _yStart, _yEnd, _noOfCols);
				int escTime = escapeTime(resultX, resultY);
				grid[row][col] = escTime;
			}
		}
		return grid;
	}
	
	public void update(){
		double i = _xCalc;
		double j = _yCalc;
		_xCalc = i*i - j*j +_currentX;
		_yCalc = Math.abs(2*i*j) + _currentY;
	}
	
	public int escapeTime(double x, double y){
		_currentX = x;
		_currentY = y;
		_xCalc = _currentX;
		_yCalc = _currentY;
		double dist = Math.sqrt(_xCalc*_xCalc + _yCalc*_yCalc);		
		int passes = 0;
		while(dist <= 4 && passes < 255){
			update();
			passes++;
			dist = Math.sqrt(_xCalc*_xCalc + _yCalc*_yCalc);
		}
		int escTime = passes;
		return escTime;
	}
	
	public double rangeInc(double start, double end, int div){
		double inc = (end - start) / div;
		return inc;
	}
	
	public double arrayToCoordinate(int i, double start, double end, int div){
		double result = start + i * rangeInc(start, end, div);
		return result;
	}	
}
