package code;

public class MultibrotSet {
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
	
	public MultibrotSet(){
		_xStart = -1.0;
		_xEnd = 1.0;
		_noOfRows = 512;
		_yStart = -1.3;
		_yEnd = 1.3;
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
		_xCalc = i*i*i - (3*(j*j*i)) +_currentX;
		_yCalc = (3*(j*i*i))- (j*j*j) + _currentY;
	}
	
	public int escapeTime(double x, double y){
		_currentX = x;
		_currentY = y;
		_xCalc = _currentX;
		_yCalc = _currentY;
		double dist = Math.sqrt(_xCalc*_xCalc + _yCalc*_yCalc);		
		int passes = 0;
		while(dist <= 2 && passes < 255){
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
