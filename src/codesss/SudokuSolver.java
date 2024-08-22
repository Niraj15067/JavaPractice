package codesss;

public class SudokuSolver {

	public static void main(String[] args) {
		 int[][] board = {
		            {5, 3, 0, 0, 7, 0, 0, 0, 0},
		            {6, 0, 0, 1, 9, 5, 0, 0, 0},
		            {0, 9, 8, 0, 0, 0, 0, 6, 0},
		            {8, 0, 0, 0, 6, 0, 0, 0, 3},
		            {4, 0, 0, 8, 0, 3, 0, 0, 1},
		            {7, 0, 0, 0, 2, 0, 0, 0, 6},
		            {0, 6, 0, 0, 0, 0, 2, 8, 0},
		            {0, 0, 0, 4, 1, 9, 0, 0, 5},
		            {0, 0, 0, 0, 8, 0, 0, 7, 9}
		        };
		 solve(board);
		 display(board);
	}

	private static void display(int[][] board) {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board.length;j++) {
				System.out.print(board[i][j] + "  ");
			}
			System.out.println();
		}	
	}

	public static boolean solve(int[][] board) {	
		boolean flag = false;
		int row = 0, col = 0;
		for (int i = 0; i < board.length; i++) {
			for(int j=0;j<board[0].length;j++) {
				if(board[i][j]==0) {
					row = i;
					col = j;
					flag = true;
					break;
				}
			}
			if(flag) {
				break;
			}
		}
		if(!flag) {
			return true;
		}
		for(int val=1;val<=9;val++) {
			if(check(board,row, col, val)) {
				board[row][col]=val;
				if(solve(board))
					return true;
				else
					board[row][col]=0;
			}
		}		
		return false;
	}
	public static boolean check(int[][] board, int r, int c, int val) {
		//horizontal check
		for(int i=0;i<board[0].length;i++) {
			if(board[r][i]==val) {
				return false;
			}
		}
		//vertical check
		for(int i=0;i<board.length;i++) {
			if(board[i][c]==val) {
				return false;
			}
		}
		//sub matrix check.
		int rStart = 3*(r/3);
		int cStart = 3*(c/3);
		int rEnd = rStart + 2, cEnd = cStart+2;
		
		for(int i=rStart;i<=rEnd;i++) {
			for(int j=cStart;j<=cEnd;j++) {
				if(board[i][j]==val) {
					return false;
				}
			}
		}
		return true;
	}
}
