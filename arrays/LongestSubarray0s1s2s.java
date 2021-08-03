package arrays;

import java.util.HashMap;

// count length of longest subarray containing equal number of 0s 1s and 2s

public class LongestSubarray0s1s2s {

	// idea is to keep storage of number of 0s-1s and 1s-2s, if this repeats than it tells that
	// the number of 0s and 1s increased in same quantity and similarly for 1s and 2s
	// which means 0s 1s and 2s are present in same quantity in this subarray
	static void solve(int a[])
	{
		int n = a.length;
		int ans = 0;
		HashMap<String, Integer> map = new HashMap<>();
		
		int count1 = 0;
		int count0 = 0;
		int count2 = 0;
		int delta01 = count0 - count1;
		int delta12 = count1 - count2;
		
		String key = delta01 +"#"+ delta12;
		map.put(key, -1);
		
		for(int i=0;i<n;i++)
		{
			if(a[i] == 0)
			{
				count0++;
			}
			if(a[i] == 1)
			{
				count1++;
			}
			if(a[i] == 2)
			{
				count2++;
			}
			
			delta01 = count0 - count1;
			delta12 = count1 - count2;
			
			key = delta01 +"#"+ delta12;
			
			if(map.containsKey(key))
			{
				int idx = map.get(key);
				int len = i -idx;
				if(len > ans)
					ans = len;
			}
			else
			{
				map.put(key, i);
			}
			
		}
		System.out.println(ans);
	}
	
	//////////////////////////////////////////////////////////////////////////////////////
	// count of subarrays of equal 0s 1s and 2s
	
	
	static void solveCount(int a[])
	{
		int n = a.length;
		int ans = 0;
		HashMap<String, Integer> map = new HashMap<>();
		
		int count1 = 0;
		int count0 = 0;
		int count2 = 0;
		int delta01 = count0 - count1;
		int delta12 = count1 - count2;
		
		String key = delta01 +"#"+ delta12;
		map.put(key, 1);
		
		for(int i=0;i<n;i++)
		{
			if(a[i] == 0)
			{
				count0++;
			}
			if(a[i] == 1)
			{
				count1++;
			}
			if(a[i] == 2)
			{
				count2++;
			}
			
			delta01 = count0 - count1;
			delta12 = count1 - count2;
			
			key = delta01 +"#"+ delta12;
			
			if(map.containsKey(key))
			{
				ans += map.get(key);
				map.put(key, map.get(key) + 1);
			}
			else
			{
				map.put(key, 1);
			}
			
		}
		System.out.println(ans);
	}
	
	
	public static void main(String[] args) {
		int a[] = {1,1, 2, 0,1,0,1,2,1,2,2,0,1};
		solve(a);
		solveCount(a);

	}

}
