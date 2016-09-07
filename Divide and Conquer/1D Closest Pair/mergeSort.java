//3580034 SIBANDA THABISANI
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.PriorityQueue;
public class mergeSort
{
    
	public static void main(String[] args)
	{
		
		
	}
	public void run()
	{
		try
		{
			Scanner inputStream = new Scanner(new File("/export/home/notes/ds/shuffledints.data"));
			String line ="";
			while(inputStream.hasNextLine())
			{
				line += " " + inputStream.nextLine().trim();
			}
			String[] stringArray = line.split(" ");
			int len = stringArray.length;
			double[] integerArray = new double[len];
			for(int i = 0; i < len; i++ )
			{
				integerArray[i] = Double.parseDouble(stringArray[i].trim());
			}
			sort(integerArray);
			display(integerArray);
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
	}
	public void display(double[] A)
	{
	        
		
			String out = "["+A[0];
			for(int i = 1; i<= A.length-1; i++)
			{
				out += ", "+A[i];
			}
			out += "]";
			System.out.println(out);
		
	}
	public static void insertionSort(double[] a)
	{
		int n = a.length;
		for(int i = 1; i < n; i++)
		{
			double cur = a[i];
			int j = i -1;
			while((j>=0)&&(a[j] > cur))
			{
				a[j+1] = a[j--];
			}
			a[j+1] = cur;
		}
	}
	public static void sort(double[] a)
    {
	  // System.out.println("Here");
		if(a.length >=8)
		{
			int equalLength = a.length/8;
			double[] arr1 = new double[equalLength], arr2 = new double[equalLength], arr3 = new double[equalLength], arr4 = new double[equalLength], arr5 = new double[equalLength], arr6 = new double[equalLength], arr7 = new double[equalLength];
			double[] arr8 = new double[a.length -(equalLength*7)];
			divide(a,  arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8);
			sort(arr1);
			sort(arr2);
			sort(arr3);
			sort(arr4);
			sort(arr5);
			sort(arr6);
			sort(arr7);
			sort(arr8);
			merge(a, arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8);
		}
		else
		{
			insertionSort(a);
		}
	}
	
	public static void divide(double[] a, double[] arr1, double[] arr2, double[] arr3, double[] arr4, double[] arr5, double[] arr6, double[] arr7, double[] arr8)
	{
	    int len = 0;
		for (int i = 0; i < arr1.length; i++)
		{
			arr1[i] = a[len + i];
		}
		len+= arr1.length;		
		
		for (int i = 0; i < arr2.length; i++)
		{
			arr2[i] = a[len + i];
		}
		len+= arr2.length;	
		
		for (int i = 0; i < arr3.length; i++)
		{
			arr3[i] = a[len + i];
		}
		len+= arr3.length;	
		for (int i = 0; i < arr4.length; i++)
		{
			arr4[i] = a[len + i];
		}
		len+= arr4.length;			
		for (int i = 0; i < arr5.length; i++)
		{
			arr5[i] = a[len + i];
		}
		len+= arr5.length;			
					
		for (int i = 0; i < arr6.length; i++)
		{
			arr6[i] = a[len + i];
		}
		len+= arr6.length;			
		for (int i = 0; i < arr7.length; i++)
		{
			arr7[i] = a[len + i];
		}
		len+= arr7.length;	
		for (int i = 0; i < arr8.length; i++)
		{
			arr8[i] = a[len + i];
		}
									
	}	
	
	
	public static void merge(double[] merged, double[] arr1, double[] arr2, double[] arr3, double[] arr4, double[] arr5, double[] arr6, double[] arr7, double[] arr8)
	{
		double[][] table = {arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8};
		PriorityQueue<QueueNode> pq = new PriorityQueue<QueueNode>();
		int size = 0;
		for(int i = 0; i < table.length; i++)
		{
			size += table[i].length;
			if(table[i].length >0)
			{
				pq.add(new QueueNode(i, 0, table[i][0]));
			}
		}
		
		for(int i = 0; !pq.isEmpty(); i++)
		{
			QueueNode n = pq.poll();
			merged[i] = n.getValue();
			int newIndex = n.getIndex() + 1;
			if(newIndex < table[n.getArray()].length)
			{
				pq.add(new QueueNode(n.getArray(), newIndex, table[n.getArray()][newIndex]));
			}
		}
		
	}
	

}