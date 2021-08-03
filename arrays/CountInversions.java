package arrays;
// count pairs such as a[i] > a[j] && i < j


// Interesting variation:
// given an array of size n, task is to count triplets in array such that a[i] > a[j] > a[k]
// and i < j < k
// Approach :
//Find the greater_left array. greater_left[i] represents the number of elements greater than
//a[i] and in left side of it ( from 0 to i-1 ).

//Find the smaller_right array. smaller_right[i] represents the number of elements smaller than 
//a[i] and in right side to it ( from i+1 to n-1 )

// can be solved using BIT Or fenwick tree

//The final answer will be the sum of the product of greater_left[i] and smaller_right[i] for
//every index.
public class CountInversions {
	static int invCount = 0;
	static int count(int a[], int start, int end)
	{
		int inv_count = 0;
		if(start < end)
		{
			int mid = (start + end)/2;
			
			inv_count += count(a, start, mid);
			inv_count += count(a, mid+1, end);
			
			inv_count += merge(a, start, end);
		}
		return inv_count;
	}
	
	static int merge(int a[],int start, int end)
	{
		int inv_count = 0;
		int mid = (start + end)/2;
		int temp[] = new int[a.length];
		
		int i = start;
		int j = mid+1;
		int k = start;
		
		while(i<=mid && j <=end)
		{
			if(a[i] < a[j])
			{
				temp[k] = a[i];
				i++;
				k++;
			}
			else
			{
				// this is the main point different from merge sort that gives answer
				if(a[i] > a[j])
				{
					invCount += (mid - i)+1;
					inv_count += (mid - i) + 1;
				}
				temp[k] = a[j];
				j++;
				k++;
			}
		}
		
		while(i<=mid)
		{
			temp[k] = a[i];
			i++;
			k++;
		}
		while(j<=end)
		{
			temp[k] = a[j];
			j++;
			k++;
		}
		
		for(int s = start;s<=end;s++)
		{
			a[s] = temp[s];
		}
		return inv_count;
	}

	public static void main(String[] args) {
		int a[] = {8, 4, 2, 1};
		System.out.println(count(a, 0, a.length-1));
		//System.out.println(invCount);
		invCount = 0;
		
		int a1[] = {3, 1, 2};
		System.out.println(count(a1, 0, a1.length-1));
		//System.out.println(invCount);
		invCount = 0;
		
		int a2[] = {1, 9, 6, 4, 5};
		System.out.println(count(a2, 0, a2.length-1));
		//System.out.println(invCount);
		invCount = 0;
		
		int a3[] = {50, 52, 49, 55};
		System.out.println(count(a3, 0, a3.length - 1));

	}

}
