import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*         BITONIC SEQUENCE
 * Ex - 2 -1 4 3 5 -1 3 2
 * It is a sequence which first increases and then decreases 
 * we first count the increasing sequence from left to right 
 * find longest increasing sequence from right to left 
 * add both values and subtract 1 Bcoz at each point we have add that particular element twice
 * runs in O(n^2) and takes space of O(n)
 */
public class BitonicSequence {

	public static void main(String[] args) throws  IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] st = reader.readLine().trim().split("\\s+");
		int[] a = new int[st.length];
		for(int i=0;i<st.length;i++)
		{
			a[i] = Integer.parseInt(st[i]);
		}
		
		int res = bitonicSequence(a);
		System.out.println(res);
	}

	private static int bitonicSequence(int[] a)
	{
		int[] left_to_right = new int[a.length];
		int[] right_to_left = new int[a.length];
		for(int i=0;i<a.length;i++)
			left_to_right[i] = right_to_left[i] = 1;
		for(int i=1;i<a.length;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(a[j]<a[i])
					left_to_right[i] = Math.max(left_to_right[j]+1,left_to_right[i]);
			}
		}
		print(left_to_right);
		for(int i=a.length-2;i>=0;i--)
		{
			for(int j=a.length-1;j>i;j--)
			{
				if(a[j]<a[i])
					right_to_left[i] = Math.max(right_to_left[j]+1,right_to_left[i]);
			}
		}
		print(right_to_left);
		int max = left_to_right[0]+right_to_left[0]-1;
		for(int i=1;i<a.length;i++)
		{
			if(max<left_to_right[i]+right_to_left[i]-1)
				max = left_to_right[i]+right_to_left[i]-1;
		}
		return max;
	}

	private static void print(int[] left_to_right) 
	{
		for(int i=0;i<left_to_right.length;i++)
			System.out.print(left_to_right[i]+" ");
		System.out.println();
	}
}
