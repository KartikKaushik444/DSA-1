package backtracking;

import java.util.HashSet;

public class SudokuSolver {
	
	static int count = 0;
	
	public static void print(int[][] board, int N) 
	    { 
	        // we got the answer, just print it 
	        for (int r = 0; r < N; r++) { 
	            for (int d = 0; d < N; d++) { 
	                System.out.print(board[r][d]); 
	                System.out.print(" "); 
	            } 
	            System.out.print("\n"); 
	  
	            if ((r + 1) % (int)Math.sqrt(N) == 0) { 
	                System.out.print(""); 
	            } 
	        } 
	    } 
	
public static boolean solveSudoku(int grid[][], int i, int j)
{
	if( i == grid.length)
	{
		return true;
	}
	int ni = 0;
	int nj = 0;
	if(j == grid[0].length - 1)
	{
		ni = i+1;
		nj = 0;
	}
	else
	{
		ni = i;
		nj = j+1;
	}
	
	if(grid[i][j] != 0)
		return solveSudoku(grid, ni, nj);
	
	else
	{

		for(int value = 1;value<=9;value++)
		{
			if(isValid(grid, i, j, value))
			{
				grid[i][j] = value;
				if(!solveSudoku(grid, ni, nj))
				{
					// backtrack
					grid[i][j] = 0;
				}
				else
					return true;
			}
		}
	}
	return false;
		
}

static boolean isValid(int grid[][], int i, int j, int value)
{
	// for checking in row
	for(int col = 0;col < grid[0].length;col++)
	{
		if(grid[i][col] == value)
				return false;
	}
	
	// for checking in column
	for(int row = 0; row<grid.length; row++)
	{
		if(grid[row][j] == value)
			return false;
	}
	
	// for checking in subgrid
	int smi = (i/3) * 3;
	int smj = (j/3) * 3;
	
	for(int p=0;p<3;p++)
	{
		for(int q=0;q<3;q++)
		{
			if(grid[smi + p][smj + q] == value)
				return false;
		}
	}
	
	return true;
}
	
/////////////////////////////////////////////////////////////////

// two more simple ways

//Collect the set of things we see, encoded as strings. For example:
//
//'4' in row 7 is encoded as "(4)7".
//'4' in column 7 is encoded as "7(4)".
//'4' in the top-right block is encoded as "0(4)2".
//Scream false if we ever fail to add something because it was already added (i.e., seen before).

static boolean isValidSudoku(char[][] board) {
 
	//      Set seen = new HashSet();
	// for (int i=0; i<9; ++i) {
	//     for (int j=0; j<9; ++j) {
	//         if (board[i][j] != '.') {
	//             String b = "(" + board[i][j] + ")";
	//             if (!seen.add(b + i) || !seen.add(j + b) || !seen.add(i/3 + b + j/3))
	//                 return false;
	//         }
	//     }
	// }
	// return true;
 
	   for(int i = 0; i<9; i++){
	 HashSet<Character> rows = new HashSet<Character>();
	 HashSet<Character> columns = new HashSet<Character>();
	 HashSet<Character> cube = new HashSet<Character>();
	 for (int j = 0; j < 9;j++){
	     if(board[i][j]!='.' && !rows.add(board[i][j]))
	         return false;
	     if(board[j][i]!='.' && !columns.add(board[j][i]))
	         return false;
	     int RowIndex = 3*(i/3);
	     int ColIndex = 3*(i%3);
	     if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
	         return false;
	 }
	}
	return true;
 
}
	
	
	

	public static void main(String[] args) {
		int[][] board = new int[][] { 
            { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, 
            { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, 
            { 0, 8, 7, 0, 0, 0, 0, 3, 1 }, 
            { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, 
            { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, 
            { 0, 5, 0, 0, 9, 0, 6, 0, 0 }, 
            { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, 
            { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, 
            { 0, 0, 5, 2, 0, 6, 3, 0, 0 } 
        }; 
        int N = board.length; 
  
        if(solveSudoku(board, 0, 0))
        	print(board, N);
        else
        	System.out.println("NO solution");
        	
    

}
}
