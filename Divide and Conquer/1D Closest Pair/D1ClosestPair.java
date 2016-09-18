/**
 *<br>Author : Thabisani Sibanda
 *<br>Contacts :thabisonsibz@gmail.com
 *<br>Last updated on 20/08/2016
 *<br>
 *<br>The algorithm uses divide and conquer with 8-way merge sort to compute the distance between closest points on the x-axis.
 *<br>Input of points is read from a file
 
 */
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.PriorityQueue;
public class D1ClosestPair
{
	public static void main(String[] args)
	{
		D1ClosestPair bob = new D1ClosestPair();
		bob.run();
	}
	public void run()
	{
		try
		{
			Scanner inputStream = new Scanner(new File("/export/home/notes/ds/Xlinepoints.text"));
			String line ="";
                        System.out.println("Wait while reading the text file");
			while(inputStream.hasNextLine())
			{
				line += " " + inputStream.nextLine().trim();
			}
			line = line.trim();
			String[] stringArray = line.split(" ");
			int len = stringArray.length;
			double[] pointsArray = new double[len];
			for(int i = 0; i < len; i++ )
			{
				pointsArray[i] = Double.parseDouble(stringArray[i].trim());
			}
                        System.out.println("Sorting points");
			mergeSort.sort(pointsArray);
			System.out.println("The closest points have distance "+closestPair(pointsArray, 0, len-1) + " between them.");
			
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
	}
	private double minimum(double[] X,int m, int a, int b)
	{
		int len = X.length;
		if(b >= len)
		{
			return X[m] - X[a];
		}
		else if(a<0)
		{
			return X[b] - X[m];
		}
		else
		{
		     return Math.min((X[m] - X[a]), (X[b] - X[m]));
	 	}
		
	}
	public double validMin(double x, double y)
	{
		if(x <= 0.0)
		{
			return y;
		}
		if(y <= 0.0)
		{
			return x;
		}
		return Math.min(x, y);
		
	}
	public double closestPair(double[] X, int low, int high)
	{
		if(high - low == 2)
		{
			return X[high] - X[low];
		}
		else if(high - low <= 0)
		{
			return 77875676758.09;
		}
		else
		{
			int m = (high + low)/2;
			double L = closestPair(X, low, m-1);
			double R = closestPair(X, m+1, high);
			double delta = minimum(X, m, m-1, m+1);//Math.min((X[m] - X[m-1]), (X[m+1] - X[m]));
			double interMed = validMin(L, R);
			return validMin(interMed, delta);
		}
	}
}