package arrays;

// Rotate by 90 degrees

//Bonus Question: What would happen if you reflect and then transpose? Would you still get the
//correct answer?
public class RotateMatrix {
	
	static int[][] transpose(int [][]mat)
	{
		for(int i = 0;i<mat.length;i++)
		{
			
			for(int j=i;j<mat[0].length;j++)
			{
				int temp = mat[i][j];
				mat[i][j] = mat[j][i];
				mat[j][i] = temp;				
			}
			
		}
		
		return mat;
	}
	
	static void reverseColumns(int [][]mat)  // Or horizontal reflection
	{
		int i = 0;                  
		int j = mat[0].length - 1;     // i and j represent column no
		while(i<j)
		{
			for(int k = 0;k<mat.length;k++)      // k represents row number
			{
				int temp = mat[k][i];
				mat[k][i] = mat[k][j];
				mat[k][j] = temp;
			}
			i++;
			j--;
		}
	}
	
	static void reverseRows(int [][]mat) // Or vertical reflection
	{
		int i = 0;                  
		int j = mat.length - 1;     // i and j represent rows no
		while(i<j)
		{
			for(int k = 0;k<mat[0].length;k++)      // k represents column number
			{
//				int temp = mat[i][k];
//				mat[i][k] = mat[j][k];
//				mat[j][k] = temp;
				
				// swap mat[i][k] and mat[j][k]
				mat[i][k] = mat[i][k] ^ mat[j][k];
				mat[j][k] = mat[i][k] ^ mat[j][k];
				mat[i][k] = mat[i][k] ^ mat[j][k];
			}
			i++;
			j--;
		}
	}
	
	public static void printMatrix(int [][]mat)
	{
		for(int i = 0;i<mat.length;i++)
		{
			for(int j=0;j<mat[0].length;j++)
			{
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static void rightRotation(int mat[][])
	{
		// simply transpose and do horizontal reflection
		transpose(mat);
		reverseColumns(mat); 
	}
	
	static void leftRotation(int mat[][])
	{
		// transpose and do vertical reflection
		transpose(mat);  
		reverseRows(mat);
	}
	
	
//	Bonus Question: If you're not too confident with matrices and linear algebra, get some more practice
//	by also coding a method that transposes the matrix on the other diagonal, and another that reflects 
//	from top to bottom. You can test your functions by printing out the matrix before and after each 
//	operation. Finally, use your functions to find three more solutions to this problem. Each solution 
//	uses two matrix operations.
//
//
//	Interview Tip: Terrified of being asked this question in an interview? Many people are: it can be 
//	intimidating due to the fiddly logic. Unfortunately, if you do a lot of interviewing, the
//	probability of seeing it at least once is high, and some people have claimed to have seen it multiple
//	times! This is one of the few questions where I recommend practicing until you can confidently code
//	it and explain it without thinking too much.

	public static void main(String[] args) {
		
		int mat[][] = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9},
		};
		leftRotation(mat);
//		rightRotation(mat);
		printMatrix(mat);
		
	}

}

