/* Calculate total numbers in the binary representation from 0 to 2^n - 1 (if n is given) which 
  do not contain two consecutive 1's
  
   It forms a pattern as fibonacci
   
    n=1        n=2       n=3        n=4
    								                -----   
    0          00        000       0|000|	1000
    1          01        001       0|001|	1001
   ---         10		     010       0|010|	1010
    2          11		     011       0|011|	1011
             ------		   100       0|100|	1100
                3        101       0|101|	1101
                		     110       0|110|	1110
                		     111       0|111|	1111
                	      -------     -----  ------
                	        5	          5	  +	  3   = 8
                F(4) = F(3) + F(2);
                F(n) = F(n-1) + F(n-2);
*/
public class WithoutConsecutiveOnes
{
	public static void main(String[] args)
	{
		System.out.println(CountNum(2));
		System.out.println(CountNum(3));
		System.out.println(CountNum(4));
		System.out.println(CountNum(5));
	}

	static int CountNum(int n) 
	{
		int a = 1,b = 1,sum = 0;
		for(int i=1;i<=n;i++)
		{
			sum = a+b;
			a = b;
			b = sum;
		}
		return sum;
	}
}
