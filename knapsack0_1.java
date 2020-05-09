import java.util.*;
import java.io.*;
public class knapsack0_1 
{
	
// Find the items added into the Bag
	static void getItems(Integer[][] t,Integer[] weight,int Total_Weight)
	{
		ArrayList<Integer> arr = new ArrayList<>();
		int start = weight.length;
		int end = Total_Weight; 
		while(start!=0 && end !=0)
		{
			if(t[start][end]==t[start-1][end])
			{
				start--;
			}
			else
			{
				arr.add(start);
				int k = weight[start-1];
				start--;
				while(k>0)
				{
					end--;
					k--;
				}
			}
		}
		System.out.println(arr);
	}
	
// Calculate Maximum profit
	static int Zero_One(Integer[] weight,Integer[] value,int No_Of_Items,int Total_Weight)
	{
		Integer[][] t = new Integer[No_Of_Items+1][Total_Weight+1];
		for(int i=0;i<=No_Of_Items;i++)
			t[i][0]=0;
		for(int i=0;i<=Total_Weight;i++)
			t[0][i]=0;
		for(int i=1;i<=No_Of_Items;i++)
		{
			for(int j=1;j<=Total_Weight;j++)
			{
				if(j>=weight[i-1])
				{
					t[i][j]=Math.max(value[i-1]+t[i-1][j-weight[i-1]], t[i-1][j]);
				}
				else
				{
					t[i][j]= t[i-1][j];
				}
			}
		}
		getItems(t,weight,Total_Weight);
		return t[No_Of_Items][Total_Weight];
	}
  
	public static void main(String[] args) throws Exception
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//Enter total number of items
		int No_Of_Items = Integer.parseInt(reader.readLine());
		Integer[] weight = new Integer[No_Of_Items];
		Integer[] value = new Integer[No_Of_Items];
		String st1 = reader.readLine();
		String[] a = st1.trim().split("\\s+");
		
		// Enter Weight of each element
		for(int i=0;i<a.length;i++)
		{
			weight[i] = Integer.parseInt(a[i]);
		}
		st1 = reader.readLine();
		a = st1.trim().split("\\s+");
		
		// Enter Value of each element
		for(int i=0;i<a.length;i++)
		{
			value[i] = Integer.parseInt(a[i]);
		}
		
		//Enter total weight of the Bag
		int Total_Weight = Integer.parseInt(reader.readLine());
		int res = Zero_One(weight,value,No_Of_Items,Total_Weight);
		System.out.println(res);
	}
}
