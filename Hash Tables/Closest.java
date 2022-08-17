import java.util.Scanner;
import java.lang.Math.*;

public class Closest {

  private static Node [][] grid;
  private static double minDist;

  private static double dist(double x1, double y1, double x2, double y2) {
    return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
  }

  private static void compare(int i, int j, double x, double y) {
    for (Node curr = grid[i][j]; curr != null; curr = curr.next) {
			double newDist = dist(x, y, curr.x, curr.y);
			if (newDist < minDist)
				 minDist = newDist;
    }
  } 

  public static void main(String [] args) {

    int b = 1000;	// grid size is 1/b x 1/b.
    double x, y;

    Scanner s = new Scanner(System.in);
    grid = new Node[b][b];

    minDist = 1.0;

    while (s.hasNextDouble()) {
      x = s.nextDouble();
      y = s.nextDouble();

      int i = (int) (x * b);
      int j = (int) (y * b);

      // Compare against all the points in grid[i][j]
      compare(i, j, x, y);
      
      // Compare against all neighboring grid cells
      if (i-1 >= 0)
				compare(i-1, j, x, y);
      if (i+1 < b)
				compare(i+1, j, x, y);
      if (j-1 >= 0)
				compare(i, j-1, x, y);
      if (j+1 < b)
				compare(i, j+1, x, y);

      if (i-1 >= 0 && j-1 >= 0)
				compare(i-1, j-1, x, y);
      if (i-1 >= 0 && j+1 < b)
 				compare(i-1, j+1, x, y);
      if (i+1 < b && j-1 >= 0)
 				compare(i+1, j-1, x, y);
      if (i+1 < b && j+1 < b)
				compare(i+1, j+1, x, y);
 
      // insert the new point into the grid.
      grid[i][j] = new Node(x, y, grid[i][j]);

    }
    System.out.println("The closest pair of points is: " + minDist);

  }

}
