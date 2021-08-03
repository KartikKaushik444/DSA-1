import java.util.Collection;
import java.util.HashMap;

// Number of substrings with exactly k distinct characters
public class NoOfSubstringsWithCountK {

	static int substring(String s, int k)
	{
		int n = s.length();
		HashMap<Character, Integer> m = new HashMap<>();
		int ans = 0;

		for(int i=0;i<n;i++)
		{
			int j = i;
			m.clear();
			while(j<n)
			{
				if(m.containsKey(s.charAt(j)))
				{
					if(m.get(s.charAt(j)) < k)
					{
						int a = m.get(s.charAt(j));
						m.put(s.charAt(j), ++a);
						if(a == k)
						{
							// for checking

							Collection<Integer> arr = m.values();

							boolean flag = true;
							for(int x : arr)
							{
								if(x != 0 && x!=k)
								flag = false;
							}
						
							if(flag == true)
							{
								ans++;
							}
						}
					}
					else
					{
						m.clear();
						break;
					}
				}
				else
				{
					m.put(s.charAt(j), 1);
				}
				j++;
			}
			
		}
		return ans;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////
	// longest substring with exactly k distinct characters
	// Or print all substrings with exactly k unique characters
	
	// IMP: This will not print all substring with k distinct characters because when it acquires
	// on right side of string than it only releases from left side which skips a lot of strings
	static void solve(String s, int k)
	{
		int ans = 0;
		
		int i = -1;
		int j = -1; 
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		while(true)
		{
			boolean f1 = false;
			boolean f2 = false;
			// acquire
			while(i < s.length() - 1)
			{
				f1 = true;
				i++;
				char ch = s.charAt(i);
				map.put(ch, map.getOrDefault(ch, 0)+1);
				
				if(map.size() < k)   // still need more characters, hence keep on acquiring
				{
					continue;
				}
				
				else if(map.size() == k)
				{
					
					int len = i-j;
					System.out.println(s.substring(j+1, i+1));
					ans = Math.max(ans, len);
					
				}
				else          // now you must release character 
				{
					break;
				}
			}
			
			// release
			while(j < i)
			{
				f2 = true;
				j++;
				char ch = s.charAt(j);
				
				if(map.get(ch) == 1)
					map.remove(ch);
				else
				{
					map.put(ch, map.get(ch)-1);
				}
				if(map.size() > k)
					continue;
				
				else if(map.size() == k)
				{
					int len = i-j;
					System.out.println(s.substring(j+1, i+1));
					ans = Math.max(ans, len);
					//break;         // IMP
				}
				else
				{
					break;
				}
			}
			if(f1 == false && f2 == false)
				break;
		}
		System.out.println(ans);
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	// To print all substrings
	// The idea is to use hashmaps, one small and one large
	// small means it will store values for k-1 characters at the farthest point possible
	// and large will store answer for k valid substrings at the farthest point possible
	// Than all the substrings between these will be of k distinct characters
	
	static void solve1(String s, int k)
	{
		// This method only works for k >= 2
		
		int ans = 0;
		HashMap<Character, Integer> mapb = new HashMap<>();      // big
		HashMap<Character, Integer> maps = new HashMap<>();      // small
		
		int is = -1;
		int ib = -1;
		
		int j = -1;  // it will be same for both maps
		while(true)
		{
			boolean f1 = false;
			boolean f2 = false;
			boolean f3 = false;
			
			// acquire in bigmap
			while(ib < s.length()-1)
			{
				f1 = true;
				ib++;
				char ch = s.charAt(ib);
				mapb.put(ch, mapb.getOrDefault(ch, 0)+1);
				
				// if more than k characters are present after acquiring this character than remove this 
				// character
				if(mapb.size() == k+1)
				{
					removeInMap(mapb, ch);
					ib--;
					break;
				}
			}
			// acquire in small map
			while(is < ib)
			{
				f2 = true;
				is++;
				char ch = s.charAt(is);
				maps.put(ch, maps.getOrDefault(ch, 0)+1);
				
				if(maps.size() == k)
				{
					removeInMap(maps, ch);
					is--;
					break;
				}
			}
			// print result and release from both maps
			while(j < is)
			{
				f3 = true;
				// print result
				if(mapb.size() == k && maps.size() == k-1)
				{
					for(int n = is+1; n<=ib;n++)
					{
						System.out.println(s.substring(j+1, n+1));
					}
					ans += (ib - is);
				}
				j++;
				char ch = s.charAt(j);
				removeInMap(mapb, ch);
				removeInMap(maps, ch);
				
				// if any of them looses their property than break
				if(maps.size() < k-1 || mapb.size() < k )
					break;
			}
			if(f1 == false && f2 == false && f3 == false)
				break;
		}
		System.out.println(ans);
	}
	
	static void removeInMap(HashMap<Character, Integer> map, char ch)
	{
		if(map.get(ch) == 1)
			map.remove(ch);
		else
			map.put(ch, map.get(ch)-1);
	}
	
	////////////////////////////////////////////////////////////////////////////////////////
	// Longest substring with atmost k distinct characters
	
	static void longSolve(String s,int k)
	{
		int ans = 0;
		
		HashMap<Character, Integer> map = new HashMap<>();
		int i = -1;
		int j = -1;
		
		while(true)
		{
			boolean f1 = false;
			boolean f2 = false;
			//System.out.println(i+" "+j);
			while(i < s.length() - 1)
			{
				//System.out.println(i+" i "+ j);
				f1 = true;
				i++;
				char ch = s.charAt(i);
				map.put(ch, map.getOrDefault(ch, 0)+1);
				
				if(map.size() <= k)
				{
					int len = i-j;
					System.out.println(s.substring(j+1, i+1));
					ans = Math.max(ans, len);
				}
				else
					break;
			}
			
			while(j < i)
			{
				f2 = true;
				//System.out.println(i+" i "+ j);
				j++;
				char ch = s.charAt(j);
				
				if(map.get(ch) == 1)
					map.remove(ch);
				else
					map.put(ch, map.get(ch) -1);
				
				if(map.size() > k)
					continue;
				
				else
				{
					int len = i-j;
					System.out.println(s.substring(j+1, i+1));
					ans = Math.max(ans, len);
					break;              // IMP
				}
			}
			
			if(f1 == false && f2 == false)
				break;
		}
		System.out.println(ans);
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////
	// count of substring with at most k characters
	static void countSolve(String s, int k)
	{
		int ans = 0 ;
		int i = -1;
		int j = -1;
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		while(true)
		{
			while(i < s.length() - 1)
			{
				i++;
				char ch = s.charAt(i);
				map.put(ch, map.getOrDefault(ch, 0)+1);
				
				if(map.size() <= k)
				{
					ans += (i-j);
					for(int n = j+1; n<=i;n++)
					{
						System.out.println( s.substring(n, i+1));
					}
					
				}
				else
					break;
			}
			
			if(i == s.length() - 1 && map.size() <= k)
				break;
			while(j < i)
			{
				
				//System.out.println(i+" i "+ j);
				j++;
				char ch = s.charAt(j);
				
				if(map.get(ch) == 1)
					map.remove(ch);
				else
					map.put(ch, map.get(ch) -1);
				
				if(map.size() > k)
					continue;
				
				else
				{
					ans += i-j;
					for(int n = j+1; n<=i;n++)
					{
						System.out.println( s.substring(n, i+1));
					}
					break;              // IMP
				}
			
			}
		}
		
		System.out.println(ans);
	}
	
	////////////////////////////////////////////////////////////////////////////////////////
	static void test(String s, int k)
	{
		int ans = 0;
		
		int i = -1;
		int j = -1; 
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		while(true)
		{
			boolean f1 = false;
			boolean f2 = false;
			while(i < s.length() - 1)
			{
				f1 = true;
				i++;
				char ch = s.charAt(i);
				map.put(ch, map.getOrDefault(ch, 0)+1);
				
				if(map.size() < k)   // still need more characters, hence keep on acquiring
				{
					continue;
				}
				
				else if(map.size() == k)
				{
					
					int len = i-j;
					System.out.println(s.substring(j+1, i+1));
					ans = Math.max(ans, len);
					
				}
				else          // now you must release character 
				{
					if(map.get(ch) == 1)
						map.remove(ch);
					else
					{
						map.put(ch, map.get(ch)-1);
					}
					i--;
					break;
				}
			}
			
			while(j < i)
			{
				f2 = true;
				j++;
				char ch = s.charAt(j);
				
				if(map.get(ch) == 1)
					map.remove(ch);
				else
				{
					map.put(ch, map.get(ch)-1);
				}
				if(map.size() > k)
					continue;
				
				else if(map.size() == k)
				{
					int len = i-j;
					System.out.println(s.substring(j+1, i+1));
					ans = Math.max(ans, len);
					//break;         // IMP
				}
				else
				{
					break;
				}
			}
			if(f1 == false && f2 == false)
				break;
		}
		System.out.println(ans);
	}
	
	public static void main(String[] args) {

//		String s = "abc";
//		String s1 = "aabccc";
//		System.out.println(substring(s, 2));
//		System.out.println(substring(s1, 2));
//		System.out.println(substring("aba", 2));
		
//		solve("aabcbcdbca", 2);
//		solve("abcc", 2);
//		solve("aba", 2);
//		solve("aa",1);
//		solve("abcabdabbcfa", 3);   // In this example this method will not print all substrings
		// but will give length of longest substring
		solve1("abcabdabbcfa", 3);  
//		test("abcabdabbcfa", 3);  
		
		//longSolve("ddacbbaccdedacebb", 3);
		//countSolve("aabcbcdbca", 2);

	}

}
