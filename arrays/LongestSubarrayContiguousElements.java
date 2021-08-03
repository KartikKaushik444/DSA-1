package arrays;

import java.util.HashSet;

// find the length of longest subarray with contiguous elements but no duplicate

public class LongestSubarrayContiguousElements {
// idea is to update ans when
	// max - min = j - i in that window there are contiguous elements
	
	// TC : O(n^2)
	static void solve(int a[])
	{
		int n = a.length;
		int ans = 0;
		
		for(int i=0;i < n-1;i++)
		{
			int min = a[i];
			int max = a[i];
			HashSet<Integer> cd = new HashSet<>();
			cd.add(a[i]);
			for(int j=i+1 ; j < n;j++)
			{
				if(cd.contains(a[j]))        // duplicate present
					break;
				cd.add(a[j]);
				min = Math.min(min, a[j]);
				max = Math.max(max, a[j]);
				
				if(max - min == j - i)
				{
					int len = j-i+1;
					ans = Math.max(ans, len);
				}
			}
		}
		System.out.println(ans);
	}
	public static void main(String[] args) {
		int a[] = {2, 1, 5, 6, 7, 9, 8, 4};
		solve(a);

	}

}
