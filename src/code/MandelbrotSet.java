package code;


import java.awt.geom.Point2D;

public class MandelbrotSet {
	
	//this is the array that contains all 262144 pairs for the pixels.
	int[][] _escapeTime;
	
	// Constructor
	public MandelbrotSet(){
		_escapeTime = new int[512][512];
		for(int y = 0; y < 512; y+=1){
			for(int x = 0; x<512; x+=1){
				Point2D.Double point = this.getCoordinates(x, y);
				_escapeTime[x][y] = this.getEscapeTime(point.x, point.y);
			}
		}
		
	}
	
	
	// this calculates distance
	public double distanceCalculator(double x, double y){
		return Math.sqrt((x*x) + (y*y)); 
	}
	
	
	//this calculates new x position
	public double newPositionX(double x, double y, double currentx){ 
		return (x*x)-(y*y)+currentx; 
	}
	
	//this calculates new y position
	public double newPositionY(double x, double y, double currenty){
		return 2*x*y+currenty; 
	}
	
	
	
	// this returns the coordinate at _escapeTime[innerIndex] [outerIndex]
	public Point2D.Double getCoordinates(int x, int y){
		Point2D.Double point = new Point2D.Double();
	    point.x = (x * (2.15+0.6)/512)-2.15;	
		point.y = (y * (1.3+1.3)/512)-1.3;
		return point;
	}
	
	// this is from the project instruction 
	public int getEscapeTime(double currentx, double currenty){
		double dist = this.distanceCalculator(currentx, currenty);
		int passes = 0;
		double xCal = currentx;
	    double yCal = currenty;
		while(dist <= 2 && passes <255){
			double tempx = xCal;
		    double tempy = yCal;
			xCal = this.newPositionX(tempx, tempy, currentx);
			yCal = this.newPositionY(tempx, tempy, currenty);
			dist = this.distanceCalculator(xCal, yCal);
			passes += 1;
		}
		
		return passes;
		
	}
	
	// Returning the final result
 public int[][] returnResult(){
	 return _escapeTime;
 }

	


}