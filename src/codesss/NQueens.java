package codesss;

public class NQueens {

	public static void main(String[] args) {

		boolean[][] board = new boolean[8][8];
		int count = place(board, 0);
		System.out.println(count);
	}
	private static void display(boolean[][] board) {
		for(int i=0;i<board.length;i++) {
			for(int j =0; j<board.length;j++) {
				if(board[i][j]) {
					System.out.print("Q"+"  ");
				}else {
					System.out.print("X"+"  ");
				}
			}
			System.out.println();
		}
	}
	public static int place(boolean[][] board, int r) {
		if(r==board.length) {
			display(board);
			System.out.println("==================================");
			return 1;
		}
		int count = 0;
		for(int i=0;i<board.length;i++) {
			if(isSafe(board,r,i)) {
				board[r][i] = true;
				count += place(board,r+1);
				board[r][i] = false;
			}
		}
		return count;
	}
	public static boolean isSafe(boolean[][] board, int r, int c) {
		
		//column check for above queens;
		for(int i =0;i<r;i++) {
			if(board[i][c]==true)
				return false;
		}
		//diagonal check left
		int maxL = Math.min(r, c);
		for(int i = 1;i<=maxL;i++) {
			if(board[r-i][c-i]==true)
				return false;
		}
		
		// diagonal right
        int maxRight = Math.min(r, board.length - c - 1);
        for (int i = 1; i <= maxRight; i++) {
            if(board[r-i][c+i]) {
                return false;
            }
        }
		return true;
	}
}
