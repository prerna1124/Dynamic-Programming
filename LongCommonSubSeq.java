import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LongCommonSubSeq
{
	// read both the strings from console
	public static void main(String[] args) throws Exception
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = reader.readLine();
		String p = reader.readLine();
		int res = LComSubSeq(s,p);
		System.out.println(res);
	}
  
	//Find the length of longest common subsequence
	private static int LComSubSeq(String s, String p)
	{
		int slen = s.length();
		int plen = p.length();
		Integer[][] t = new Integer[slen+1][plen+1];
		for(int i=0;i<slen+1;i++)
			t[i][0] = 0;
		for(int i=0;i<plen+1;i++)
			t[0][i]=0;
		for(int i = 1;i<=slen;i++)
		{
			for(int j=1;j<=plen;j++)
			{
				if(s.charAt(i-1)==p.charAt(j-1))
				{
					t[i][j] = t[i-1][j-1]+1;
				}
				else
					t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
			}
		}
		FindString(s,p,t);
		return t[slen][plen];
	}
  
// Find the longest common subsequence
	private static void FindString(String s, String p, Integer[][] t) 
	{
		int start = s.length();
		int end = p.length();
		String st="";
		while(start!=0 && end!=0)
		{
			if(t[start][end] == t[start-1][end])
			{
				start--;
			}
			else if(t[start][end]==t[start][end-1])
				end--;
			else
			{
				st = st + s.charAt(start-1);
				start--;
				end--;
			}
		}
		StringBuilder sb = new StringBuilder(st);
		sb.reverse();
		System.out.println(sb);
	}
}
