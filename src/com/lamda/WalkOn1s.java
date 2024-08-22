package com.lamda;

public class WalkOn1s {

	public static void main(String[] args) {
		
		int[][] maze = {
				{1,1,1},
				{1,1,1},
				{1,1,1}
		};
		findPath(maze,0,0,"");
	}

	private static void findPath(int[][] maze, int r, int c, String p) {
		if(r==maze.length-1 && c==maze.length-1) {
			System.out.println(p);
			return;
		}
		if(r==maze.length || r<0) {
			return;
		}
		if(c==maze.length || c<0) {
			return;
		}
		if(maze[r][c]==2) {
			return;
		}
		int currentVal = maze[r][c];
			maze[r][c]=2;
			if(isValid(r+1, c, maze)) {
				if(r<maze.length && maze[r+1][c]==1) {
					findPath(maze, r+1, c, p+"D");
				}
			}
			if(isValid(r, c+1, maze)) {
				if(c<maze.length && maze[r][c+1]==1) {
					findPath(maze, r, c+1, p+"R");
				}
			}
			if(isValid(r-1, c, maze)) {
				if(r>=0 && maze[r-1][c]==1) {
					findPath(maze, r-1, c, p+"U");
				}
			}
			if(isValid(r, c-1, maze)) {
				if(c>=0 && maze[r][c-1]==1) {
					findPath(maze, r, c-1, p+"L");
				}
			}
		maze[r][c]=currentVal;
		return;
	}
	public static boolean isValid(int r, int c,int[][] maze){
		if(r>=0 && r<maze.length && c>=0 && c<maze.length) {
			return true;
		}
		return false;	
	}

}
