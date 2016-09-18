/**
 *<br>Author : Thabisani Sibanda
 *<br>Contacts :thabisonsibz@gmail.com
 *<br>Last updated on 20/08/2016
 *<br>
 *<br>The algorithm uses the big integer class to compute the nth catalan numbers
 
 */
import java.util.Scanner;
import java.math.BigInteger;
public class Catalan
{
	public static void main(String[] args)
	{
		Catalan bob = new Catalan();
		bob.run();
	}
	private void run()
	{
		Scanner sibz = new Scanner(System.in);
		System.out.println("Enter the position of the catalan number:");
		int n = sibz.nextInt();
		
		System.out.println("The "+n+"th catalan number is "+ catalan(new BigInteger(""+n)));
		
	}
	public BigInteger catalan(BigInteger n)
	{
		BigInteger cat = new BigInteger("1"), j = new BigInteger("2"), upper = j.multiply(n);
		
		for(BigInteger i = n.add(j); i.compareTo(upper) <=0; i = i.add(BigInteger.ONE))
		{
			cat = cat.multiply(i);
			while( (j.compareTo(n)<=0)&&(cat.remainder(j).compareTo(BigInteger.ZERO) == 0 ) )
			{
			    cat = cat.divide(j);
				j = j.add(BigInteger.ONE);
			}
		}
		return cat;
	}
}