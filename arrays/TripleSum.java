//return true if the sum of three elements is equal to zero   

package arrays;
import java.util.*;


public class TripleSum {
	
	
	// This method is used to find two sum in O(n) time and O(1) space
	 public int[] twoSum(int[] nums, int target) {
	       
         HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        
        for(int i=0;i<n;i++)
        {
            if(map.containsKey(target - nums[i]))
            {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[2];
    }
	
	 // this needs sorted array 
	 // TC : O(nlogn)  if array is not sorted
	 // SC: O(1)
	public static boolean twoSum(int []a,int x,int i)
	{
		int j=a.length-1;
		while(i<j)
		{
			if(a[i]+a[j]<x)
				i++;
			else if(a[i]+a[j]>x)
				j--;
			else 
				return true;
		}
		return false;
	}
	
	static boolean threesum(int []a)
	{
		
		Arrays.sort(a);
		for(int i=0;i<a.length;i++)
		{
			if(twoSum(a,-a[i],i+1))
			{
				//System.out.println("True");
				return true;
//				flag=1;
//				break;
			}
			
		}
		return false;
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////
	// return all the triplets (no duplicates tuples allowed)
	
	static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res  = new HashSet<>();
        if(nums.length==0) return new ArrayList<>(res);
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2;i++){
            int j =i+1;
           int  k = nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==0)res.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                else if ( sum >0) k--;
                else if (sum<0) j++;
            }

        }
        return new ArrayList<>(res);

    }

	public static void main(String[] args) {
		int[] a= {1,-3,-2,4,6,8,11,-10};
		System.out.println(threesum(a));
//		int flag=0;
//		Arrays.sort(a);
//		for(int i=0;i<a.length;i++)
//		{
//			if(twoSum(a,-a[i],i+1))
//			{
//				System.out.println("True");
//				flag=1;
//				break;
//			}
//			
//		}
//		if(flag==0)
//		{
//			System.out.println("false");
//		}
		
		
		Set<List<Integer>> res  = new HashSet<>();
		res.add(Arrays.asList(2, 19, 3, 1, 1, 1,1 ,58934, 384, 394));
		res.add(Arrays.asList(2, 19, 3, 1, 1, 1,1 ,58934, 384, 394));
		System.out.println(res);
		int a1[] = {1, 2, 2, -3, -3};
		System.out.println(threeSum(a1));
	}

}
