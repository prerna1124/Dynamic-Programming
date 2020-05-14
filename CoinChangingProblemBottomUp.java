// Complexity - O(no. of coins * total)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CoinChangingProblemBottomUp {

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
		int res = MinimumCoins(a,num);
		System.out.println(res);

	}

	static int MinimumCoins(int[] coins, int total) 
	{
		int T[] = new int[total + 1];
        int R[] = new int[total + 1];
        T[0] = 0;
        for(int i=1; i <= total; i++){
            T[i] = Integer.MAX_VALUE-1;
            R[i] = -1;
        }
        for(int j=0; j < coins.length; j++){
            for(int i=1; i <= total; i++){
                if(i >= coins[j]){
                    if (T[i - coins[j]] + 1 < T[i]) {
                        T[i] = 1 + T[i - coins[j]];
                        R[i] = j;
                    }
                }
            }
        }
        printCoinCombination(R, coins);
        return T[total];
	}

	private static void printCoinCombination(int[] r, int[] a)
	{		ArrayList<Integer> ar = new ArrayList<>();
		int k = r.length-1;
		if(r[k]==-1)
		{
			System.out.println("No Solution Exists");
			return;
		}
		while(k!=0)
		{
			ar.add(a[r[k]]);
			k = k-a[r[k]];
		}
		System.out.println(ar);
	}
	
}
