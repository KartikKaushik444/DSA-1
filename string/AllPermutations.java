
public class AllPermutations {
	
	static void allPermutations(String s)
	{
		allPermutations(s, 0, s.length()-1);
	}
	
	static void allPermutations(String s,int i, int j )
	{
		if(i == j)
			System.out.println(s);
		else
		{
			for(int k=i;k<=j;k++)
			{
				s = swap(s,i,k);
				allPermutations(s,i+1,j);
				s = swap(s,i,k);      // backtracking(OR creating the original string again)
			}
		}
	}

	static String swap(String s, int i, int j)
	{
		char temp;
		char[] charArray = s.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);         // to convert back char array to string
	}
	
	/////////////////////////////////////////////////
	
	// another method
	// fix each character and find the answer of remaining string using recursion
	// just add the fixed with all of those answers of remaining string
	
	static void solve(String s)
	{
		solve(s, "");
	}
	
	static void solve(String s, String ans)
	{
		if(s.length() ==  0)
		{
			System.out.println(ans);
			return;
		}
		
		for(int i=0;i<s.length();i++)
		{
			char ch = s.charAt(i);        // we are fixing this character
			String ros = s.substring(0, i) + s.substring(i+1);
			// now find the answer of rest of the string
			
			solve(ros, ans+ch);
		}
	}
	public static void main(String[] args) {
		allPermutations("ABC");
		solve("abc");
	}

}
//Complexity: O(n*n!)     O(time to print one permutaions * no of permutations)