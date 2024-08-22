package Codes;

import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		char[][] board = new char[3][3];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = ' ';
			}
		}
		display(board);
		Scanner sc = new Scanner(System.in);
		char player = 'X';
		boolean gameOver = false;
		while (!gameOver) {
			System.out.println("Player : " + player + " enter the row and col : ");
			int r = sc.nextInt();
			int c = sc.nextInt();
			if (board[r][c] == ' ') {
				board[r][c] = player;
				gameOver = isWinner(board, r, c, player);
				if (gameOver) {
					System.out.println("Player : " + player + " won !");
				}
				player = (player=='X')?'O':'X';
			} else {
				System.out.println("Invalid coordinates. Try again");
			}
			display(board);
		}
	}

	public static boolean isWinner(char[][] board,int row, int col, char player) {
		
		//horizontal check.
		if(board[row][0]==player && board[row][1]==player && board[row][2]==player) {
			return true;
		}
		//vertical check
		if(board[0][col]==player && board[1][col]==player && board[2][col]==player) {
			return true;
		}
		//diagonal check.
		if((board[0][0]==player && board[1][1]==player && board[2][2]==player) ||
				(board[2][0]==player && board[1][1]==player && board[0][2]==player)) {
			return true;
		}
		return false;
	}
	public static void display(char[][] board) {
	    int size = board.length;
	    for (int i = 0; i < size; i++) {
	        System.out.print(" ------------------\n");
	        for (int j = 0; j < size; j++) {
	            System.out.print(" | " + board[i][j] + " ");
	        }
	        System.out.print(" |\n");
	    }
	    System.out.println(" ------------------");
	}


}
