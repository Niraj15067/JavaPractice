package recursion;

public class MazeWalkOn1 {

	public static void main(String[] args) {
		int[][] board = { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 } };
		findPath(board, 0, 0, "");
	}

	private static void findPath(int[][] board, int row, int col, String path) {
		if (row == 3 && col == 3) {
			System.out.println(path);
			return;
		}

		if (check(row + 1, col) && board[row + 1][col] == 1) {
			board[row][col] = 0;
			findPath(board, row + 1, col, path + "D");
		}
		if (check(row, col + 1) && board[row][col + 1] == 1) {
			board[row][col] = 0;
			findPath(board, row, col + 1, path + "R");
		}
		if (check(row - 1, col) && board[row - 1][col] == 1) {
			board[row][col] = 0;
			findPath(board, row - 1, col, path + "U");
		}
		if (check(row, col - 1) && board[row][col - 1] == 1) {
			board[row][col] = 0;
			findPath(board, row, col - 1, path + "L");
		}
		board[row][col] = 1;

	}

	public static boolean check(int r, int c) {
		if ((r < 4 && c < 4) && (r >= 0 && c >= 0)) {
			return true;
		}
		return false;
	}
}
