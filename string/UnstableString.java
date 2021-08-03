import java.util.Scanner;



public class UnstableString {
	
	
/////////////////////////////////////////////////////////
//Let's call a string unstable if it consists of the characters
//0 and 1 and any two adjacent characters are different (i. e. it has the form 010101... or 101010...).

// count number of substring following pattern 0s1s Or 1s0s(unstable strings)

static void solve() 
{
	Scanner sc = new Scanner(System.in);
	String s = sc.next();
	
	int x[] = new int[2];
	x[0] = x[1] = -1;
	
	int ans = 0;
	int n = s.length();
	for(int i=0;i<n;i++)
	{
		int c = s.charAt(i) - '0';
		if(c == 1 || c == 0)
		{
			x[(i%2) ^ c] = i;
		}
		int min = Math.min(x[0], x[1]);
		
		//System.out.println(s.substring(min, i+1));
		ans += i - min;
		//System.out.println(ans);
	}
	System.out.println(ans);
}

	public static void main(String[] args) {
		//solve();
		
		Scanner fs=new Scanner(System.in);

		int T=fs.nextInt();

		for (int tt=0; tt<T; tt++) {

		char[] line=fs.next().toCharArray(); for (int i=1; i<line.length; i+=2) {

		if (line[i]=='1')

		line[i]='0'; else if (line [i]=='0') line[i]='1';

		} 
		long count=0;

		int zCount=0, oCount=0, lPtr=0, rPtr=-1; 
		while (rPtr+1<line.length)
		{ 
			rPtr++;

			if (line [rPtr]=='1') 
				oCount++;
			else if (line [rPtr] == '0') 
				zCount++;
			while (oCount >0 && zCount > 0) { 
	
				if (line [lPtr] == '1') oCount --;
				else if (line [lPtr]=='0') zCount--; 
				lPtr++;
			}
			count+=rPtr-lPtr+1;

		}
		System.out.println(count);

	}

}
}
