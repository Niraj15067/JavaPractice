package com.lamda;

public class WO1 {

	public static void main(String[] args) {
		
		int[][] maze  = {
				{1,1,1},
				{1,0,1},
				{1,1,1}
		};
		findPath(maze,0,0,"");
	}

	private static void findPath(int[][] maze, int r, int c,String path) {
		if(r==maze.length-1 && c==maze.length-1) {
			System.out.println(path);
			return;
		}
		if(r==maze.length || r<0) {
			return;
		}
		if(c==maze.length || c<0) {
			return;
		}
		//will end up in deadlock of DU or LR so to avoid this we can do backtracking or just mark the path we have walked
		//anyways we are checking if its 1 then only we will walk on it else not so just mark with anything other than 1.
		//after we return back from one path the path we have marked ramain as it is so we can't explore for other paths
		//so we need to backtrack and mark the path back to whatever it was before we walked on it .
		int pathValue = maze[r][c];
		maze[r][c]=2;
		//down
		if((isValid(maze, r+1, c)) && maze[r+1][c]==1) {
			findPath(maze, r+1, c, path+"D");
		}
		//right
		if((isValid(maze, r, c+1)) && maze[r][c+1]==1){
			findPath(maze, r, c+1, path+"R");
		}
		//up
		if((isValid(maze, r-1, c)) &&maze[r-1][c]==1) {
			findPath(maze, r-1, c, path+"U");
		}
		//left
		if((isValid(maze, r, c-1)) &&maze[r][c-1]==1) {
			findPath(maze, r, c-1, path+"L");
		}
		maze[r][c] = pathValue; // need this back tracking or we won't be able to explore for other paths.
								//but even if we dont backtrack we still get 1 or 2 valid paths.
	}
	public static boolean isValid(int[][] maze,int r, int c) {
		if(r>=0 && r<maze.length && c>=0 && c<maze.length) {
			return true;
		}
		return false;
	}

}
