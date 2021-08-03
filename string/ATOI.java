
public class ATOI {
	// This must be improved for covering all test cases
	static int atoi(String s)
	{
		int n = s.length();
		int i=0;
		int no = 0;
		while(i<n)
		{
			int digit = s.charAt(i) - '0';
			if(digit <= 9)
			{
				no = no*10 + digit;
			}
			else
			{
				System.out.println("NOt possible");
				return Integer.MIN_VALUE;
			}
			i++;
		}
		return no;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////
	
//	Four corner cases needs to be handled: 
//
//		1. Discards all leading whitespaces
//		2. Sign of the number
//		3. Overflow
//		4. Invalid input
//		To remove the leading whitespaces run a loop until a character of the digit is reached.
//		If the number is greater than or equal to INT_MAX/10. Then return INT_MAX if the sign is positive
//		and return INT_MIN if the sign is negative.
	
	static int myAtoi(String s)
    {
	
		char[] str = s.toCharArray();
        int sign = 1, base = 0, i = 0;
 
        // if whitespaces then ignore.
        while (str[i] == ' ')
        {
            i++;
        }
 
        // sign of number
        // if negative than sign holds -1 else it holds +1
        if (str[i] == '-' || str[i] == '+')
        {
            sign = 1 - 2 * (str[i++] == '-' ? 1 : 0);
        }
 
        // checking for valid input
        while (i < str.length
               && str[i] >= '0'
               && str[i] <= '9') {
 
            // handling overflow test case
            if (base > Integer.MAX_VALUE / 10
                || (base == Integer.MAX_VALUE / 10
                    && str[i] - '0' > 7))
            {
                if (sign == 1)     					// if it is a positive number
                    return Integer.MAX_VALUE;
                else               					// if negative
                    return Integer.MIN_VALUE;
            }
            base = 10 * base + (str[i++] - '0');
        }
        return base * sign;
    }

	public static void main(String[] args) {
		
		String s = "078978340";
		System.out.println(atoi(s));
		System.out.println(myAtoi("-123"));
		System.out.println(Integer.MAX_VALUE);
		System.out.println(myAtoi("2147483646"));
		System.out.println(myAtoi("2147483648"));
		int x = -2147483648 ;
		if(x < 0)
			System.out.println("Neg");
		else
			System.out.println("pos");
			

	}

}
