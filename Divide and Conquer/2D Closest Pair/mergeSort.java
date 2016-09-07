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
	
	public void display(Coordinate[] A)
	{
	        
		
			String out = "["+A[0];
			for(int i = 1; i<= A.length-1; i++)
			{
				out += ", "+A[i];
			}
			out += "]";
			System.out.println(out);
		
	}
	public static void insertionSort(Coordinate[] a)
	{
		int n = a.length;
		for(int i = 1; i < n; i++)
		{
			Coordinate cur = a[i];
			int j = i -1;
			while((j>=0)&&(a[j].compareTo(cur) >1))
			{
				a[j+1] = a[j--];
			}
			a[j+1] = cur;
		}
	}
	public static void sort(Coordinate[] a)
    {
	   //System.out.println("Here");
		if(a.length >=8)
		{
			int equalLength = a.length/8;
			Coordinate[] arr1 = new Coordinate[equalLength], arr2 = new Coordinate[equalLength], arr3 = new Coordinate[equalLength], arr4 = new Coordinate[equalLength], arr5 = new Coordinate[equalLength], arr6 = new Coordinate[equalLength], arr7 = new Coordinate[equalLength];
			Coordinate[] arr8 = new Coordinate[a.length -(equalLength*7)];
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
	
	public static void divide(Coordinate[] a, Coordinate[] arr1, Coordinate[] arr2, Coordinate[] arr3, Coordinate[] arr4, Coordinate[] arr5, Coordinate[] arr6, Coordinate[] arr7, Coordinate[] arr8)
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
	
	
	public static void merge(Coordinate[] merged, Coordinate[] arr1, Coordinate[] arr2, Coordinate[] arr3, Coordinate[] arr4, Coordinate[] arr5, Coordinate[] arr6, Coordinate[] arr7, Coordinate[] arr8)
	{
		Coordinate[][] table = {arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8};
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