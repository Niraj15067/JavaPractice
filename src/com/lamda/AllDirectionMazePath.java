package com.lamda;

import java.util.Arrays;

public class AllDirectionMazePath {

	public static void main(String[] args) {

		boolean board[][] = { { true, true, true }, { true, true, true }, { true, true, true }, };
//		generatePath(board,0,0,"");
		// this will print the entire path taken to reach the destination.
		int[][] steps = new int[board.length][board[0].length];
		generatePathSteps(board, 0, 0, "",1,steps);
	}

	private static void generatePath(boolean[][] board, int r, int c, String path) {

		if (r == board.length - 1 && c == board[0].length - 1) {
			System.out.println(path);
			return;
		}

		if (board[r][c] == false) {
			return;
		}
		
		board[r][c] = false;
		if (r < board.length - 1) {
			generatePath(board, r + 1, c, path + "D");
		}
		if (c < board[0].length - 1) {
			generatePath(board, r, c + 1, path + "R");
		}
		if (r > 0) {
			generatePath(board, r - 1, c, path + "U");
		}
		if (c > 0) {
			generatePath(board, r, c - 1, path + "L");
		}
		board[r][c] = true;
	}

	private static void generatePathSteps(boolean[][] board, int r, int c, String path, int level,int[][] steps) {

		if (r == board.length - 1 && c == board[0].length - 1) {
			steps[r][c]=level;
			for(int[] row:steps) {
				System.out.println(Arrays.toString(row));
			}
			System.out.println(path);
			return;
		}

		if (board[r][c] == false) {
			return;
		}

		steps[r][c]=level;
		board[r][c] = false;
		if (r < board.length - 1) {
			generatePathSteps(board, r + 1, c, path + "D",level+1,steps);
		}
		if (c < board[0].length - 1) {
			generatePathSteps(board, r, c + 1, path + "R",level+1,steps);
		}
		if (r > 0) {
			generatePathSteps(board, r - 1, c, path + "U",level+1,steps);
		}
		if (c > 0) {
			generatePathSteps(board, r, c - 1, path + "L",level+1,steps);
		}
		board[r][c] = true;
		steps[r][c] = 0;
	}

}
