import java.io.BufferedReader;
import java.io.InputStreamReader;
/* Just to find the cost of multiplication not the exact multipication of two matrices*/

public class MatrixChainMultiply {

	public static void main(String[] args) throws Exception
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int No_Of_Matrices = Integer.parseInt(reader.readLine());
		Integer[] arr = new Integer[No_Of_Matrices+1];
		/*
		 * A1 = 2 * 3
		 * A2 = 3 * 6
		 * A3 = 6 * 4
		 * A4 = 4 * 5
		 * 
		 * arr[] = {2,3,6,4,5}
		 */
		for(int i=0;i<No_Of_Matrices+1;i++)
		{
			arr[i] = Integer.parseInt(reader.readLine());
		}
		int res = MiniCost(arr);
		System.out.println();
		System.out.println(res);
}

	private static int MiniCost(Integer[] arr) 
	{
		int n = arr.length;
		Integer[][] c = new Integer[n][n];
		Integer[][] s = new Integer[n][n];
		for(int i=0;i<n;i++)
			c[i][i] = 0;
		// M[i][j] = min (i<= k < j) { M[i][k] + M[k+1][j] + arr[i-1]*arr[k]*arr[j] } 
		for(int l=2;l<=n;l++)
		{
			for(int i = 1;i < n-l+1;i++)
			{
				int j=i+l-1;
				c[i][j] = Integer.MAX_VALUE;
				for(int k=i;k<j;k++)
				{
					int q = c[i][k]+c[k+1][j]+arr[i-1]*arr[k]*arr[j];
					if(q<c[i][j])
					{
						c[i][j] = q;
						s[i][j] = k;
					}
				}
			}
		}
		
		GenerateOrder(s,1,n-1);
		return c[1][n-1];
	}
// Print the sequence of multiplication
	private static void GenerateOrder(Integer[][] s, int i, int j)
	{
		if(i==j) 
			System.out.print("A"+i);
		else
		{
			System.out.print("(");
			GenerateOrder(s,i,s[i][j]);
			GenerateOrder(s, s[i][j]+1, j);
			System.out.print(")");
		}
	}
}
