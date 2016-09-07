//3580034 SIBANDA THABISANI
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.PriorityQueue;
public class merge8Sort
{
    
	public static void main(String[] args)
	{
		merge8Sort sibz = new merge8Sort();
		sibz.run();
	}
	public void run()
	{
		try
		{
			Scanner inputStream = new Scanner(new File("/export/home/notes/ds/shuffledints.text"));
			String line ="";
                        System.out.println("Reading the text file wait");
			while(inputStream.hasNextLine())
			{
                               String read = inputStream.nextLine().trim();
                               if(read.length() > 0)
                               {
				                       line += " " + read;
                               }
                               
                                
			}
            line = line.trim();
			String[] stringArray = line.split(" ");
			int len = stringArray.length;
			int[] integerArray = new int[len];
			for(int i = 0; i < len; i++ )
			{
				integerArray[i] = Integer.parseInt(stringArray[i].trim());
			}
                        System.out.println("Sorting the array");
			sort(integerArray);
			System.out.println("Smallest :"+integerArray[0]);
                        System.out.println("Largest :"+integerArray[len-1]);
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
	}
	public void display(int[] A)
	{
	        
		
			System.out.print( "["+A[0]);
			for(int i = 1; i<= A.length-1; i++)
			{
				System.out.print(", "+A[i]);
			}
			System.out.println("]");
		
	}
	public static void insertionSort(int[] a)
	{
		int n = a.length;
		for(int i = 1; i < n; i++)
		{
			int cur = a[i];
			int j = i -1;
			while((j>=0)&&(a[j] > cur))
			{
				a[j+1] = a[j--];
			}
			a[j+1] = cur;
		}
	}
	public static void sort(int[] a)
       {
		if(a.length >=8)
		{
			int equalLength = a.length/8;
			int[] arr1 = new int[equalLength], arr2 = new int[equalLength], arr3 = new int[equalLength], arr4 = new int[equalLength], arr5 = new int[equalLength], arr6 = new int[equalLength], arr7 = new int[equalLength];
			int[] arr8 = new int[a.length -(equalLength*7)];
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
	
	public static void divide(int[] a, int[] arr1, int[] arr2, int[] arr3, int[] arr4, int[] arr5, int[] arr6, int[] arr7, int[] arr8)
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
	
	
	public static void merge(int[] merged, int[] arr1, int[] arr2, int[] arr3, int[] arr4, int[] arr5, int[] arr6, int[] arr7, int[] arr8)
	{
		int[][] table = {arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8};
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
