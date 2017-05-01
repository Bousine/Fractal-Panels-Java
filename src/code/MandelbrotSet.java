package code;


import java.awt.geom.Point2D;



/**
 * Class which calculates escape-time for a Mandelbrot fractal 
 * 
 * @author Mark Kayutkin
 * @author Asif Hasan
 * @author Xiangshuai Gao 
 */

public class MandelbrotSet {
	
	/** 
	 * this is the array that contains all 262144 escape time for the pixels.
	 */
	private int[][] _escapeTime;
	/** Escape Distance */
	private double _escDist;
	/** Escape Time */
	private double _escTime;
	
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
	/** 
	 * Constructor
	 */
	public MandelbrotSet(double escDist, double escTime){
		_noOfRows = 2048;
		_noOfCols = 2048;
		_escDist = escDist;
		_escTime = escTime;
		_escapeTime = new int[_noOfRows][_noOfCols];
		for(int y = 0; y < _noOfRows; y+=1){
			for(int x = 0; x<_noOfRows; x+=1){
				Point2D.Double point = this.getCoordinates(x, y);
				_escapeTime[x][y] = this.getEscapeTime(point.x, point.y);
			}
		}	
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
				int escTime = getEscapeTime(resultX, resultY);
				grid[row][col] = escTime;
			}
		}
		return grid;
	}
	
	
	/** 
	 * this calculates distance
	 */
	public double distanceCalculator(double x, double y){
		return Math.sqrt((x*x) + (y*y)); 
	}
	
	
	/**
	 * this calculates new x position
	 */
	public double newPositionX(double x, double y, double currentx){ 
		return (x*x)-(y*y)+currentx; 
	}
	/**
	 *this calculates new y position
	 */
	public double newPositionY(double x, double y, double currenty){
		return 2*x*y+currenty; 
	}
	
	
	/**
	 * this returns the coordinate at _escapeTime[innerIndex] [outerIndex]
	 */
	public Point2D.Double getCoordinates(int x, int y){
		Point2D.Double point = new Point2D.Double();
	    point.x = (x * (2.15+0.6)/_noOfRows)-2.15;	
		point.y = (y * (1.3+1.3)/_noOfRows)-1.3;
		return point;
	}
	
	/**
	 * this is the algorithm from the project instruction 
	 */
	public int getEscapeTime(double currentx, double currenty){
		double dist = this.distanceCalculator(currentx, currenty);
		int passes = 0;
		double xCal = currentx;
	    double yCal = currenty;
		while(dist <= _escDist && passes < _escTime){
			double tempx = xCal;
		    double tempy = yCal;
			xCal = this.newPositionX(tempx, tempy, currentx);
			yCal = this.newPositionY(tempx, tempy, currenty);
			dist = this.distanceCalculator(xCal, yCal);
			passes += 1;
		}
		
		return passes;
		
	}
	
	/**
	 * returning the final result
	 */
	public int[][] returnResult(){
		return _escapeTime;
	}
	/**
	 * Acquires Escape Distance
	 * @return
	 */
	public double getEscapeDistance(){
		return _escDist;
	}
	/**
	 * Changes fractal coordinates for zooming
	 * @param rowStart- beginning of new row
	 * @param rowEnd- end of new row
	 * @param colStart- beginning of new column
	 * @param colEnd- end of new column
	 */
	public void zoomInitialize(int rowStart, int rowEnd, int colStart, int colEnd){
		_xStart = arrayToCoordinate(rowStart, -2.15, 0.6, _noOfRows); 
		//System.out.println(_xStart);
		_xEnd = arrayToCoordinate(rowEnd, -2.15, 0.6, _noOfRows);
		//System.out.println(_xEnd);
		_yStart = arrayToCoordinate(colStart, -1.3, 1.3, _noOfCols);
		//System.out.println(_yStart);
		_yEnd = arrayToCoordinate(colEnd, -1.3, 1.3, _noOfCols);
		//System.out.println(_yEnd);
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

}