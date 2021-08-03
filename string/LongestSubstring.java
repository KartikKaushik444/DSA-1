import java.util.HashMap;

// find the longest substring without repeating character
public class LongestSubstring {
	
//	the basic idea is, keep a hashmap which stores the characters in string as keys and their positions as
//  values, and keep two pointers which define the max substring. move the right pointer to scan through
//  the string , and meanwhile update the hashmap. If the character is already in the hashmap, then move the
//  left pointer to the right of the same character last found. Note that the two pointers can only move forward.
	
	static void solve(String s)
	{
		int n = s.length();
		char a[] = s.toCharArray();
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int i=0;
        int j=0;
        String ans = "";
        int maxLen = 0;
        while(j<n)
        {
           if(map.containsKey(a[j]) && map.get(a[j]) >= i)  // IMP:check if the last occurrence of ch is not out of 
           {												// range of i & j
            
                i = map.get(a[j])+1;
               
           }
             map.put(a[j], j);
             if(j-i+1 > maxLen)
             {
            	 ans = s.substring(i, j+1);
            	 maxLen = j-i+1;
             }
               
            j++;
        }
       System.out.println(ans);
        
    //      if (s.length()==0) return 0;
    //     HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    //     int max=0;
    //     for (int i=0, j=0; i<s.length(); ++i){
    //         if (map.containsKey(s.charAt(i))){
    //             j = Math.max(j,map.get(s.charAt(i))+1);
    //         }
    //         map.put(s.charAt(i),i);
    //         max = Math.max(max,i-j+1);
    //     }
    //     return max;
	}

	public static void main(String[] args) {
		solve("abba");

	}

}
