package arrays;

public class FirstMissingPositive {
// idea is to arrange numbers to their respective indexes i.e a[i] = i
	static int solve(int a[])
	{
        int n = a.length;
        int i=0;
        while(i<n)
        {   
            if(a[i] != i)
            {
                if(a[i] < n && a[i] >= 0)   // if element is in range of array
                {
                    if(a[i] == a[a[i]]) //// IMP: if duplicate value is present at a[a[i] than avoid infinite loop
                        i++;
                    else{      
                        int temp = a[a[i]];
                        a[a[i]] = a[i];
                        a[i] = temp;
                    }
                }
                else       // if not in range than simply ignore it
                {
                    i++;
                }
            }
            else
            {
                i++;
            }
        }
        
        // now check for the answer in modified array
        for(i=1;i<n;i++)              
        {
            if(a[i] != i)
                return i;
        }
        // IMP:
        // if all values are inplace from index 1 to n
        // than check if a[0] is n than return n+1 else return n
        if(a[0] == n)               
            return n+1;
        
        return n;
	}
	
	public static void main(String[] args) {
		
		
	}

}
