

import java.io.File;

import edu.duke.*;


public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        System.out.println(prevPt);
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            System.out.println(currDist);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints(Shape s) {
        // Put code here
    	int numPoints = 0;
    	for(Point p : s.getPoints())
    	{
    		numPoints +=1;
    		System.out.println(numPoints);
    	}
        return numPoints;
    }

    public double getAverageLength(Shape s) {
        // Put code here
    	double length = getPerimeter(s);
    	double numSides = (double) getNumPoints(s);
        double avgLength = length / numSides;  
     	return avgLength;
    }

    public double getLargestSide(Shape s) {
        // Put code here
    	Point lastPoint = s.getLastPoint();
    	double largestSide = 0.0;
    	for(Point p : s.getPoints())
    	{
    		double dist = lastPoint.distance(p);
    		if(dist > largestSide)
    		{
    			largestSide = dist;
    		}
    		lastPoint = p;
    	}
        return largestSide;
    }

    public double getLargestX(Shape s) {
        // Put code here
    	Point lastPoint = s.getLastPoint();
    	int lastPointX = lastPoint.getX();
    	double largestX = (double) lastPointX;
    	
    	for(Point p : s.getPoints())
    	{
    		int newX = p.getX();
    		if(newX > largestX)
    		{
    			largestX = (double) newX;
    		}
    	}
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        return 0.0;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int numPoints = getNumPoints(s);
        double avgLength = getAverageLength(s); 
        double largestSide = getLargestSide(s);
        double largestX = getLargestX(s);
        System.out.println("perimeter = " + length);
        System.out.println("Number of Points: " + numPoints);
        System.out.println("Average Side Length : " + avgLength);
        System.out.println("Longest Side : " + largestSide);
        System.out.println("Longest X point : " + largestX);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
