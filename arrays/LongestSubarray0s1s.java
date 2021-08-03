package arrays;

import java.util.HashMap;

//a variation of zero sum subarray using hashmap

//return the length of largest subarray containing equal number of 0s and 1s

public class LongestSubarray0s1s {

	// idea is to count 0 as -1 and 1 as 1 , so whenever we encounter same sum in hashmap it indicates
	// that the sum of in between subarray is 0 meaning equal 0s and 1s
		
	static void solve(int a[])
	{
		int n = a.length;
		int ans = 0;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		map.put(0, -1);  // IMP : if whole subarray's sum is 0
		int sum = 0;
		
		for(int i=0;i<n;i++)
		{
			int x = a[i];
			if(x == 0)
				sum += -1;
			else
				sum += 1;
			
			if(map.containsKey(sum))
			{
				int idx = map.get(sum);
				int len = i-idx;
				ans = Math.max(ans, len);
			}
			else
				map.put(sum, i);
		}
		System.out.println(ans);
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////
	// count of subarrays with equal 0s and 1s
	
	static void solveCount(int a[])
	{
		int n = a.length;
		int ans = 0;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		map.put(0, 1);  // IMP : if whole subarray's sum is 0 initialize frequency with 1
		int sum = 0;
		
		for(int i=0;i<n;i++)
		{
			int x = a[i];
			if(x == 0)
				sum += -1;
			else
				sum += 1;
			
			if(map.containsKey(sum))
			{
				ans += map.get(sum);
				map.put(sum, map.get(sum) +1);
			}
			else
				map.put(sum, 1);
		}
		System.out.println(ans);
		
	}
	
	
	////////////////////////////////////////////////////////////////
	

	public static void main(String[] args) {
		int a[] = {1, 0, 1,1,1,0,0};
		int a1[]= {1, 1, 1, 1};
		int a2[] = {0, 0, 1, 1, 0};
		
		solve(a);

		solve(a1);
		solve(a2);
		
		solveCount(a);
		solveCount(a1);
		solveCount(a2);
		
		System.out.println(2%6);

	}

}
