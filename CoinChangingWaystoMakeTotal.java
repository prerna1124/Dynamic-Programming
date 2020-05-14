import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CoinChangingWaystoMakeTotal {

	public static void main(String[] args) throws IOException 
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] st = reader.readLine().trim().split("\\s+");
		int[] a = new int[st.length];
		for(int i=0;i<st.length;i++)
		{
			a[i] = Integer.parseInt(st[i]);
		}
		int num = Integer.parseInt(reader.readLine());
		int res = CoinChangingWays(a,num);
		System.out.println(res);
		
		res = CoinChangingWaysSpaceEff(a,num);
		System.out.println(res);
		
		printActual(a,num);
	}

	private static void printActual(int[] a, int num) 
	{
		ArrayList<Integer> arr = new ArrayList<>();
		print(arr,num,a,0);
		
	}

	private static void print(ArrayList<Integer> arr, int num, int[] a, int pos) 
	{
		if(num == 0)
		{
			for(Integer r : arr)
			{
				System.out.print(r+" ");
			}
			System.out.println();
		}
		for(int i=pos;i<a.length;i++)
		{
			if(num>=a[i])
			{
				arr.add(a[i]);
				print(arr,num-a[i],a,i);
				arr.remove(arr.size()-1);
			}
		}
		
	}

	private static int CoinChangingWaysSpaceEff(int[] a, int num)
	{
		int[] t = new int[num+1];
		t[0] = 1;
		for(int i=0;i<a.length;i++)
		{
			for(int j=1;j<=num;j++)
			{
				if(j>=a[i])
					t[j] += t[j-a[i]];  
			}
		}
		return t[num];
	}

	private static int CoinChangingWays(int[] coins, int total) 
	{
        int temp[][] = new int[coins.length+1][total+1];
        for(int i=0; i <= coins.length; i++){
            temp[i][0] = 1;
        }
        for(int i=1; i <= coins.length; i++){
            for(int j=1; j <= total ; j++){
                if(coins[i-1] > j){
                    temp[i][j] = temp[i-1][j];
                }
                else{
                    temp[i][j] = temp[i][j-coins[i-1]] + temp[i-1][j];
                }
            }
        }
        return temp[coins.length][total];
    }
	
}
