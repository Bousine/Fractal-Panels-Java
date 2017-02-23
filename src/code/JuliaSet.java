package code;


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
	
	public int[][] fractalCalc(){
		int[][] grid = new int[_row][_col];
		for(int row = 0; row < _row; row++){
			for(int col = 0; col < _col; col++){
				double resultX = arrayToCoordinate(row, _xLow, _xHigh, _row);
				double resultY = arrayToCoordinate(col, _yLow, _yHigh, _col);
				int escTime = escapeTime(resultX, resultY);
				grid[row][col] = escTime;
			}
		}
		return grid;
	}
	
	public void update(){
		double i = _xCalc;
		double j = _yCalc;
		_xCalc = i*i - j*j +_xConstant;
		_yCalc = (2*i*j) + _yConstant;
	}
	
	public int escapeTime(double x, double y){
		_xCurr = x;
		_yCurr = y;
		_xCalc = _xCurr;
		_yCalc = _yCurr;
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
