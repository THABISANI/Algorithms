/**
 *<br>Author : Thabisani Sibanda
 *<br>Contacts :thabisonsibz@gmail.com
 *<br>Last updated on 20/08/2016

 *<br>The algorithm uses dynamic programing to calculate the
 *<br>maximum number of combinations to give a change given a set of coins
 
 */
import java.util.Scanner;
public class ChangeMaker
{
    private int[] coins;
	private int[][] T;
	public static void main(String[] args)
	{
		ChangeMaker bob = new ChangeMaker();
		bob.run();
	}
	private void run()
	{
		Scanner sibz = new Scanner(System.in);
		System.out.println("Enter the amount of change:");
		int change = sibz.nextInt();
		System.out.println("Enter the number of coins you have:");
		int coinN  = sibz.nextInt();
		coins = new int[coinN];
		T = new int[coinN][change + 1];
		for(int i = 0; i < coinN; i++)
		{
			System.out.println("Enter coin "+(i+1));
			coins[i] = sibz.nextInt();
		}
		System.out.println("Number of ways to give change "+getWays());
		//display();
	}
	public void display()
	{
	    int colLen = T[0].length;
		int rowLen = T.length;
		for(int row = 0; row < rowLen; row++)
		{
			for(int col = 0; col < colLen; col++)
			{
				System.out.print(T[row][col]+ "  ");
			}
			System.out.println();
		}
		
	}
	private int getWays()
	{
	    int colLen = T[0].length;
		int rowLen = T.length;
		if(rowLen <= 1)
		{
			return 1;
		}
		for(int i = 0; i< colLen; i++)
		{
			T[0][i] = coins[0];
		}
		
		for(int i = 0; i< rowLen; i++)
		{
			T[i][0] = coins[0];
		}
		
		for(int row = 1; row < rowLen; row++)
		{
			for(int col = 1; col < colLen; col++)
			{
				if(col >= coins[row])
				{
					T[row][col] = T[row-1][col] + T[row][col - coins[row]];
				}
				else
				{
				    T[row][col] = T[row-1][col] ;
				}
			}
		}
		
		return T[rowLen-1][colLen-1];
	}
	
}