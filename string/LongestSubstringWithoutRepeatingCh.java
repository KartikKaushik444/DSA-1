import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCh {
	
	static void solve(String s)
	{
		//int n = s.length();
		int ans = 0;
		
		HashMap<Character, Integer> map = new HashMap<>();
		int i = -1;
		int j = -1;
		while(true)
		{
			boolean f1, f2 ;
			f1 = f2 = false;
			//acquire
			while(i < s.length()-1)
			{
				f1 = true;
				i++;
				char ch = s.charAt(i);
				map.put(ch, map.getOrDefault(ch, 0)+1);
				
				if(map.get(ch) == 2)
				{
					break;
				}
				else
				{
					int len = i - j;
					if(len > ans)
					{
						ans = len;
					}
				}
			}
			
			// release
			while(j < i)
			{
				f2 = true;
				j++;
				char ch = s.charAt(i);
				
				map.put(ch, map.get(ch)-1);
				
				if(map.get(ch) == 1)
					break;
			}
			
			if(f1 == false && f2 == false)
				break;
		}
		
		
		
		System.out.println(ans);
	}

	public static void main(String[] args) {
		String s = "abbacbcdbadbdbbdcb";
		solve(s);

	}

}
