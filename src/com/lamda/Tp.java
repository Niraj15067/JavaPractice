package com.lamda;

import java.util.Arrays;

public class Tp {

	public static void main(String[] args) {
		int matrix[][] = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		int ans[] = search(matrix, 8);
		System.out.println(Arrays.toString(ans));
	}

	private static int[] search(int[][] matrix, int target) {
		int rows = matrix.length-1;
		int cols = matrix[0].length-1;
		
		if(rows==1)
			return binarySearch(matrix, 0, 0, cols, target);
		
		int rStart = 0;
		int rEnd = rows;
		int cMid = (cols+1)/2;
		
		while(rStart<rEnd-1) {//will find the last 2 rows to search into
			int rMid = rStart +(rEnd-rStart)/2;
			if(matrix[rMid][cMid]==target)
				return new int[] {rMid, cMid};
			if(matrix[rMid][cMid]<target)
				rStart=rMid;
			else
				rEnd=rMid;	
		}
		if(target==matrix[rStart][cMid])
			return new int[] {rStart,cMid};
		
		if(target==matrix[rStart+1][cMid])
			return new int[] {rStart+1,cMid};
		
		if(target<matrix[rStart][cMid])
			return binarySearch(matrix, rStart, 0, cMid-1, target);
		
		if(target>matrix[rStart][cMid] && target<matrix[rStart][cols])
			return binarySearch(matrix, rStart, cMid+1, cols, target);
		
		if(target<matrix[rStart+1][cMid])
			return binarySearch(matrix, rStart+1, 0, cMid-1, target);
		
		else
			return binarySearch(matrix, rStart+1, cMid+1, cols, target);
	}

	private static int[] binarySearch(int[][] matrix, int row, int cStart, int cEnd, int target) {
		
		while(cStart<=cEnd) {
			int mid = cStart + (cEnd-cStart)/2;
			if(target==matrix[row][mid])
				return new int[] {row,mid};
			if(target<matrix[row][mid])
				cEnd = mid-1;
			else
				cStart = mid+1;
		}
		return new int[] {-1,-1};
	}

}
