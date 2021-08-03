import java.util.Arrays;

public class NextGreaterElementWithSameSetOfDigit {
	
	static void next(String s)
	{
		// I step is to find the rightmost digit which is smaller than digit next to it
		int n = s.length();
		int i = n-2;
	
		for(i = n-2;i>=0;i--)
		{
			if(s.charAt(i) < s.charAt(i+1))
			{
				break;
			}
				
		}
		// if not found than not possible like 4321
		if(i == -1)
		{
			System.out.println("Not Possible");
		}
		else
		{
			// II step is to find the next greater number than ith number so that we can make 
			// a number greater than the provided input
			int x = s.charAt(i);
			
			int minPos = i+1;
			for(int j = i+1 ; j<n;j++)
			{
				if(s.charAt(j) > x && s.charAt(j) < s.charAt(minPos))
				{
					minPos = j;
				}
			}
			
			s = swap(s, i, minPos);
			
			// III step is to create minimize this number which is also greater than input
			// now sort the digits after i+1 in ascending order
			
			char a[] = s.toCharArray();
			Arrays.sort(a, i+1, n);
			
			s = String.valueOf(a);
			
			System.out.println(s);
		}
		// further optimizations can be made by using binary search instead of linear search
		// sorting can be performed in O(n) because only one character which is swapped is misplaced
		// and after placing it simply reverse the string
	}
	
	static String swap(String s, int i, int j)
	{
		char a[] = s.toCharArray();
		char temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		
		return String.valueOf(a);
		
		
	}
	
	static String reverse(String s)
	{
		int n=s.length();
		char arr[] = s.toCharArray();
		int i=0;                                                           //  0;
		int j=n-1;
		while(i<j)
		{
			char temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		
		return String.valueOf(arr);
	}

	public static void main(String[] args) {
		
		String s ="534976";        // 
		String s1 = "218765";
		String s2 = "1234";
		String s3 = "4321";
		next(s);
		next(s1);
		next(s2);
		next(s3);
		next("9");
		next("538976");
		next("8976");
	}

}
