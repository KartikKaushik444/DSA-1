import java.util.ArrayList;

// minimum swaps required to balance bracket if only adjacent brackets can be swapped.

public class MinSwapsToBalanceBracket {
	
	
	// idea is to store position of open brackets, than whenever we encounter faulty close bracket than we can 
	// balance it using stored positions of brackets in O(1) time 
	
	// TC : O(n)
	// SC : O(n)
	// it will only work if brackets can be balanced 
	static void solve(String s)
	{
		int n = s.length();
		ArrayList<Integer> pos = new ArrayList<>();
		
		for(int i=0;i<n;i++)
		{
			if(s.charAt(i) == '[')
				pos.add(i);
		}
		
		int count = 0;          // this will help in finding faulty bracket
		int idx = 0;            // for pointing to pos array
		int ans = 0;
		char[] a = s.toCharArray();
		
		for(int i=0;i<n;i++)
		{
			if(a[i] == '[')
			{
				count++;
				idx++;
			}
			else
			{
				count--;
			}
			
			// now if faluty closed bracket is present
			if(count < 0)
			{
				ans += pos.get(idx) - i;       // these many swaps will be required to balance this bracket
				// now swap
				char temp = a[i];
				a[i] = a[pos.get(idx)];
				a[pos.get(idx)] = temp;
				
				idx++;
				
				// reset count to 1 because this bracket is now open
				count = 1;
			}
		}
		
		System.out.println(ans);
		
	}
	
	//////////////////////////////////////////////////////////
	
	// can also be done without storing positions of open braces
	// TC : O(n)
	// SC : O(1)
	static int swapCount(String s)
	{	
		int open = 0;
		int close = 0;
		int swaps = 0;
		int imbalance = 0;
		
		for(int i = 0;i< s.length();i++)
		{
			if(s.charAt(i) == '[')
			{
				open++;
				if(imbalance > 0)
				{
					// swaps count is last swap count + total number of imbalanced brackets
					swaps += imbalance;
					// imbalance is decremented by 1 because this open bracket solved only one 
					// imbalance
					imbalance--;
				}
			}
			
			else if(s.charAt(i) == ']')
			{
				close++;
				imbalance = close - open;
			}
		}
		
		return swaps;
	}

	public static void main(String[] args) {
		
		String s = "[]][][][][";
		System.out.println(swapCount(s));
		solve(s);
		
		String s1 = "[]][[][]";
		System.out.println(swapCount(s1));
		solve(s1);
		
		String s2 = "[]][";           
		System.out.println(swapCount(s2));
		solve(s2);
		
		String s3 = "[]][][";
		System.out.println(swapCount(s3));
		solve(s3);
		
		String s4 = "[[][]]";
		System.out.println(swapCount(s4));
		solve(s4);

	}

}
