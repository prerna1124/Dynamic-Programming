//Calculate nth number in fibonacci series


public class Fibonacci_dynamic
{
	public static void main(String[] args)
	{
		System.out.println(Fib_dynamic(15));
		System.out.println(Fib_recursive(15));

	}

// It is slower version as it recalculates last two term every time
// It stuck for the number greater than 60	
	static int Fib_recursive(int n) 
	{
		if(n==0 || n==1)
			return n;
		else
			return Fib_recursive(n-1)+Fib_recursive(n-2);
	}
	
// It is dynamic approach it stores last two values and use them to calculate next value
	
	static int Fib_dynamic(int n) 
	{
		if(n==0 || n==1)
			return n;
		int n1 = 0,n2 = 1,sum = 0;
		for(int i=2;i<=n;i++)
		{
			sum = n1 + n2;
			n1 = n2;
			n2 = sum;
		}
		return sum;
	}
}
