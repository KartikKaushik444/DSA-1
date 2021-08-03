package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

class Interval
{
	int start, end;
	Interval(int start, int end)
	{
		this.start = start;
		this.end = end;
	}
	void print()
	{
		System.out.print(start +" " +end);
		System.out.println();
	}
}
public class MergeOverlappingIntervals {
	
// Time complexity: O(nlogn)	
	
	// here intervals is a 2D array with 2 columns where 1st represents start and other the end
	static int[][] mergeIntervals(int intervals[][])
	{
		// Sort intervals in increasing order of start time

		 Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
	        
	        LinkedList<int[]> merged = new LinkedList<>();
	       
	       for(int[] interval : intervals)
	       {
	           if(merged.isEmpty() || merged.getLast()[1] < interval[0])
	               merged.add(interval);
	           
	           else
	               merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
	               
	       }
	        
	        return merged.toArray(new int[merged.size()][]);
	        
	}
	
	// O(1) space solution
	static void solve(Interval arr[])
	{
		// Sort intervals in increasing order of start time
				Arrays.sort(arr, new Comparator<Interval>() {// using anonymous class
					public int compare(Interval i1, Interval i2) 
					{
						
						//return i1.start - i2.start;
						//OR
						return Integer.compare(i1.start, i2.start);
					}
				});
				
			int index = 0;  //stores index of last element in modified array
			for(int i=1;i<arr.length;i++)
			{
				// if overlaps with the previous one
				if(arr[index].end >= arr[i].start)
				{
					arr[index].end = Math.max(arr[index].end, arr[i].end);
					arr[index].start = Math.min(arr[index].start, arr[i].start);
				}
				else
				{
					index++;
					arr[index] = arr[i];
				}
			}
			
			for(int i=0;i<=index;i++)
			{
				System.out.println(arr[i].start+" "+arr[i].end);
			}
	}

	public static void main(String[] args) {
		
		Interval arr[] = new Interval[6];
//		arr[0] = new Interval(6, 8);
//		arr[1] = new Interval(1, 9);
//		arr[2] = new Interval(2, 4);
//		arr[3] = new Interval(4, 7);
		
		arr[0] = new Interval(1, 3);
		arr[1] = new Interval(2, 6);
		arr[2] = new Interval(5, 7);
		arr[3] = new Interval(6, 8);
     	arr[4] = new Interval(7, 10);
     	arr[5] = new Interval(11, 12);
     	
//		mergeIntervals(arr);
		
		solve(arr);

	}

}
