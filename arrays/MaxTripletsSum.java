package arrays;
// find the maximum sum of triplets in an array such that i<j<k  and a[i] <= a[j] <= a[k]

import java.util.TreeSet;

public class MaxTripletsSum {
	// TC : O(nlogn)
	// SC : O(n)
	
	// idea is that by considering each element as jth element we will try to find optimum value of i and k
	// to find k we can simply use maximum value from end using suffix array
	// to find i we must have a sorted array from a[0...j] and than we can apply binary search on that
	static int solve(int[] a) {
        int n = a.length;

        int suff[] = new int[n];

        suff[n-1] = 0;

        for(int i=n-2;i>=0;i--)
        {
            suff[i] = Math.max(suff[i+1], a[i+1]);
        }

        // int sa[] = new int[n];
        // for(int i=0;i<n;i++)
        // {
        //     sa[i] = a[i];
        // }
        
        // tree set will maintain a sorted set and will find an element in O(logn)
        TreeSet<Integer> set = new TreeSet<>();
        set.add(a[0]);
        int ans = 0;
        for(int i=0;i<n;i++)
        {
            if(suff[i] >= a[i] && set.lower(a[i]+1) != null)
            {
               // System.out.println(a[i]+" "+i);
                int nans = set.lower(a[i]+1) + a[i] + suff[i];
                ans = Math.max(ans, nans);
                
            }
            set.add(a[i]);
        }
        return ans;
        
    }
	
	////////////////////////////////////////////////////////////////////////////////
	// return true if such a triplet exists
	
	static boolean increasingTriplet(int[] nums) {
        // start with two smallest values, as soon as we find a number bigger than both, while both have 
		// been updated, return true.
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= small) { small = n; } // update small if n is smaller than both
            
            else if (n <= big) { big = n; } // update big only if greater than small but smaller than big
            
            else return true; // return if you find a number bigger than both
        }
        return false;
    }

	public static void main(String[] args) {
		int na[] = {9, 1, 5, 3, 4};
		System.out.println(solve(na));
		int na1[] = {1, 3, 3};
		System.out.println(solve(na1));
		int na2[] = {1, 2, 2, 1};
		System.out.println(solve(na2));
		int na3[] = {2, 3, 3};
		System.out.println(increasingTriplet(na3));
	}

}
