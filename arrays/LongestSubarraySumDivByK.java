package arrays;
// variation of zero sum subarray

// given an array and an integer k , output length of longest subarray whose sum is divisible by k
// Approach:
// if prefix sum till i = s1
// (s1 % k) = x
// => s1 = k*a + x
// if another prefix till j = s2 and (s2 % k = x)
// => s2 = k*b + x
//than s2 - s1 = k *(a - b)
// which implies it is divisible by k
// Hence, subarray sum between i and j is divisible by k

import java.util.HashMap;

// One important observation is if remainder is negative than add k to it

public class LongestSubarraySumDivByK {
	
	static void solve(int a[], int k)
	{
		int n = a.length;
		int ans = 0;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		map.put(0, -1);  // IMP : if whole subarray's sum is 0
		int sum = 0;
		
		for(int i=0;i<n;i++)
		{
			sum += a[i];
			int rem = sum%k;
			if(rem < 0)
				rem += k;
			
			
			if(map.containsKey(rem))
			{
				int idx = map.get(rem);
				int len = i-idx;
				ans = Math.max(ans, len);
			}
			else
				map.put(rem, i);
		}
		System.out.println(ans);
	}

	public static void main(String[] args) {
		int a[] = {-3, -9, -4, 8, 5, 2, 4, 6};
		solve(a, 7);

	}

}
