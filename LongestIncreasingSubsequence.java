
public class LongestIncreasingSubsequence
{

	public static void main(String[] args) 
	{
		int[] arr = {3,4,-1,0,6,2,3};
		int res = FindLongestIncreasingSubsequence(arr);
		System.out.println(res);
	}

	 static int FindLongestIncreasingSubsequence(int[] arr) 
	 {
		int[] t = new int[arr.length];
		int[] solution = new int[arr.length];
		
    /* 
		 * initially single element is considered as increasing sequence
		 * store indexes in solution array
		 */
		for(int i=0;i<arr.length;i++)
		{
			t[i] =1;
			solution[i]=i;
		}
		
		/* 
		 * 1.)  update the values if they form increasing sequence upto that index
		 * 2.)  store the index that contribute to the increasing sequence in solution array at index [i]
		 */
		for(int i=1;i<arr.length;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(arr[j]<arr[i])
				{
					if(t[j]+1>t[i])
					{
						t[i] = t[j]+1;
						solution[i] = j;
					}
				}
			}
		}
		
    int max = t[0],index=0;
		
    // find maximum value and index of that max value
		for(int i=1;i<t.length;i++)
		{
			if(max<t[i])
			{
				max = t[i];
				index = i;
			}
		}
		
    int p = index , newp = index;
		
    //print the sequence
		do
		{
			p = newp;
			System.out.print(arr[p]+" ");
			newp = solution[p];
		}while(p!=newp);
		System.out.println();
		
    return max;
		}
}
