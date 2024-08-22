package codesss;

public class NKnights {

	public static void main(String[] args) {

		boolean[][] board = new boolean[5][5];
		int count = place(board, 0, 0, 5);
		System.out.println(count);
	}

	public static int place(boolean[][] board, int r, int c, int k) {
		if (k == 0) {
			display(board);
			System.out.println("=========================");
			return 1;
		}
		int count = 0;
		if (r == board.length-1 && c==board.length) {
			return count;
		}
		if (c == board.length) {
			return place(board, r + 1, 0, k); 
		}

		if (isSafe(board, r, c)) {
			board[r][c] = true;
			count += place(board, r, c + 1, k - 1);
			board[r][c] = false;
		}
		count += place(board, r, c + 1, k);
		return count;
	}

	public static boolean isSafe(boolean[][] board, int r, int c) {
		// upper left check
		if (isValid(board, r-2, c-1)) {
			if(board[r-2][c-1]==true) {
				return false;
			}
		}
		// upper right check
		if (isValid(board, r-1, c-2)) {
			if(board[r-1][c-2]==true) {
				return false;
			}
		}
		// upper mid left check
		if (isValid(board, r-1, c+2)) {
			if(board[r-1][c+2]==true) {
				return false;
			}
		}
		// upper mid right check
		if (isValid(board, r-2, c+1)) {
			if(board[r-2][c+1]==true) {
				return false;
			}
		}
		return true;
	}
	
	private static void display(boolean[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j]) {
					System.out.print("K" + "  ");
				} else {
					System.out.print("X" + "  ");
				}
			}
			System.out.println();
		}
	}

	private static boolean isValid(boolean[][] board, int r, int c) {
		if (r >= 0 && r < board.length && c >= 0 && c < board.length) {
			return true;
		}
		return false;
	}
}
