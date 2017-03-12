package code;



/**
 * Class which calculates escape-time in its methods to generate a Multibrot fractal 
 * 
 * @author Mark Kayutkin
 * @author Asif Hasan
 * @author Xiangshuai Gao 
 */

public class MultibrotSet {
	/** Stores the current x-coordinate of the point */
	private double _currentX;
	/** Stores the current y-coordinate of the point */
	private double _currentY;
	/** Stores updated value of x */
	private double _xCalc;
	/** Stores updated value of y */
	private double _yCalc;
	/** Minimum x-coordinate */
	private double _xStart;
	/** Maximum x-coordinate */
	private double _xEnd;
	/** Number of rows */
	private int _noOfRows;
	/** Minimum y-coordinate */
	private double _yStart;
	/** Maximum y-coordinate */
	private double _yEnd;
	/** Number of columns */
	private int _noOfCols;
	/** Escape Distance */
	private double _escDist;
	/**Menu*/
	
	
	/** Constructor to instantiate instance variables */
	public MultibrotSet(){
		_xStart = -1.0;
		_xEnd = 1.0;
		_noOfRows = 512;
		_yStart = -1.3;
		_yEnd = 1.3;
		_noOfCols = 512;
		_escDist = 2;
	}
	
	/**
	 * Calculates the escape-times of all points in the fractal
	 * 
	 * @return 2-d array which contains the respective escape-time of the points
	 */
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
	
	/**
	 * Updates the values of _xCalc and _yCalc
	 */
	public void update(){
		double i = _xCalc;
		double j = _yCalc;
		_xCalc = i*i*i - (3*(j*j*i)) +_currentX;
		_yCalc = (3*(j*i*i))- (j*j*j) + _currentY;
	}
	
	/**
	 * Uses escape-time algorithm to calculate the escape time of a point
	 * @param x-coordinate of the point
	 * @param y-coordinate of the point
	 * @return Escape-time for the corresponding point
	 */
	public int escapeTime(double x, double y){
		_currentX = x;
		_currentY = y;
		_xCalc = _currentX;
		_yCalc = _currentY;
		double dist = Math.sqrt(_xCalc*_xCalc + _yCalc*_yCalc);		
		int passes = 0;
		while(dist <= _escDist && passes < 255){
			update();
			passes++;
			dist = Math.sqrt(_xCalc*_xCalc + _yCalc*_yCalc);
		}
		int escTime = passes;
		return escTime;
	}
	
	/**
	 * Calculates increment of coordinates for each increment of row or column in 2-d array
	 * @param start- minimum coordinate
	 * @param end - maximum coordinate
	 * @param div - number of row or column in 2-d array
	 * @return increment of coordinates
	 */
	public double rangeInc(double start, double end, int div){
		double inc = (end - start) / div;
		return inc;
	}
	
	/**
	 * Translates array to coordinates
	 * @param i- row or column number in 2-d array
	 * @param start- minimum coordinate
	 * @param end - maximum coordinate
	 * @param div - number of row or column in 2-d array
	 * @return The corresponding x or y coordinate
	 */
	public double arrayToCoordinate(int i, double start, double end, int div){
		double result = start + i * rangeInc(start, end, div);
		return result;
	}
	
	public void setEscapeDistance(double i){
		_escDist = i;
	}
	
/*	public void addObserver(MenuPanel g){
		_menu = g;
	}*/

}
