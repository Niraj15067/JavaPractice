package com.lamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Maze {

	public static void main(String[] args) {

		// To print the path from the source to the destination.
//		List<String> ans = findNumberOfPaths(1, 1, "", 3, 3);
//		List<int[]> ans = findNumberOfPaths2(1, 1, "", 3, 3);
//		for (int[] a : ans) {
//
//			System.out.println(Arrays.toString(a));
//			if (a[0] == 3 && a[1] == 3) {
//				System.out.println("================================================");
//			}
//		}
		List<String> ans = findNumberOfPathsDiagonallyAlso(1, 1, "", 3, 3);
		System.out.println(ans);
	}

	private static List<String> findNumberOfPaths(int row, int col, String p, int destR, int destC) {

		List<String> ans = new ArrayList<>();

		if (row == destR && col == destC) {
			ans.add(p);
			return ans;
		}
		if (row < destR)
			ans.addAll(findNumberOfPaths(row + 1, col, p + "D", destR, destC));
		if (col < destC)
			ans.addAll(findNumberOfPaths(row, col + 1, p + "R", destR, destC));
		return ans;
	}

	private static List<int[]> findNumberOfPaths2(int row, int col, String p, int destR, int destC) {

		List<int[]> ans = new ArrayList<>();

		if (row == destR && col == destC) {
			ans.add(new int[] { row, col });
			return ans;
		}
		if (row < destR) {
			ans.add(new int[] { row, col });
			ans.addAll(findNumberOfPaths2(row + 1, col, p + "D", destR, destC));
		}

		if (col < destC) {
			ans.add(new int[] { row, col });
			ans.addAll(findNumberOfPaths2(row, col + 1, p + "R", destR, destC));
		}
		return ans;
	}
	
	private static List<String> findNumberOfPathsDiagonallyAlso(int row, int col, String p, int destR, int destC) {

		List<String> ans = new ArrayList<>();

		if (row == destR && col == destC) {
			ans.add(p);
			return ans;
		}
		if (row < destR)
			ans.addAll(findNumberOfPathsDiagonallyAlso(row + 1, col, p + "D", destR, destC));
		if (col < destC)
			ans.addAll(findNumberOfPathsDiagonallyAlso(row, col + 1, p + "R", destR, destC));
		if (col < destC && row <destR)
			ans.addAll(findNumberOfPathsDiagonallyAlso(row+1, col + 1, p + "X", destR, destC));
		return ans;
	}

}
