//3580034 SIBANDA THABISANI
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;public class minEditDistance
{
         public static void main(String[] args)
        {
                         minEditDistance bob = new  minEditDistance();
                        bob.run();
        }
        public void run()
	{
		Scanner keyboard = new Scanner(System.in);
                System.out.println("Enter first string");
                String first = keyboard.nextLine();
                System.out.println("Enter second string");
                String second = keyboard.nextLine();
                System.out.println("The minimum edit distance between the strings you entered is: "+editDistance(first, second));
                
		String xDNA = getString("/export/home/notes/ds/xDNA.txt");
		String yDNA = getString("/export/home/notes/ds/yDNA.txt");
               
		
		System.out.println("\nThe minimum edit distance between the strings in files xDNA and yDNA is: "+editDistance(xDNA, yDNA));
               

	}
	public String getString(String path)
	{
	   	String out = "";
		try
		{
			Scanner inputStream = new Scanner(new File(path)); 
			
		    while(inputStream.hasNextLine())
			{
				out += inputStream.nextLine();
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		return out;
	}
    public int editDistance(String X, String Y)
	{
		String x = " "+X, y = " "+Y;
		int n = x.length(), m = y.length();
		int L[][] = new int [n][m];
		for(int i = 0; i< m; i++)
		{
			L[0][i]  = i;
		}
		for(int i = 0; i< n; i++)
		{
			L[i][0]  = i;
		}
		for(int row = 1; row < n; row++)
		{
			for(int col = 1; col < m; col++)
			{
				if(x.charAt(row)== y.charAt(col))
				{
					L[row][col] = L[row-1][col-1];
				}
				else
				{
				    int min = Math.min(L[row-1][col], L[row][col-1]);
					L[row][col] = Math.min(min, L[row-1][col-1]) + 1;
				}
			}
		}
		
		return L[n-1][m-1];
	}
}
