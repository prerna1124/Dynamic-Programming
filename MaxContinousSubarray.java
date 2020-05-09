import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxContinousSubarray
{

	public static void main(String[] args) throws IOException 
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] a = reader.readLine().trim().split("\\s+");
		Integer[] arr = new Integer[a.length];
		for(int i=0;i<a.length;i++)
		{
			arr[i] = Integer.parseInt(a[i]);
		}
		CalculateMaxSum(arr);
	}

	private static void CalculateMaxSum(Integer[] arr) 
	{
		Integer[] sum = new Integer[arr.length];
		sum[0] = arr[0];
		for(int i=1;i<arr.length;i++)
		{
			sum[i] = Math.max(arr[i],arr[i]+sum[i-1]); 
		}
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(sum[i]+" ");
		}
		int max = sum[0];
		System.out.println();
		for(int i=1;i<sum.length;i++)
		{
			if(max<sum[i])
				max = sum[i];
		}
		System.out.println(max);
	}
}
