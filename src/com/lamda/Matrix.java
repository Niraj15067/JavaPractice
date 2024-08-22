package com.lamda;

import java.util.ArrayList;
import java.util.List;

public class Matrix {

	public static void main(String[] args) {
		int[][] matrix = { { 7,8}, { 1,2}};
		System.out.println(matrix.length);
		List<Integer> ans = luckyNumbers(matrix);
		System.out.println(ans);
	}

	public static List<Integer> luckyNumbers(int[][] matrix) {
		List<Integer> ans = new ArrayList<>();
		for (int col = 0; col < matrix[0].length; col++) {
			int maxRow = 0, maxCol = 0, max = 0;
			boolean flag = true;
			for (int row = 0; row < matrix.length; row++) {
				if (max <= matrix[row][col]) {
					max = matrix[row][col];
					maxRow = row;
				}
			}
			for (int interCol = 0; interCol < matrix[0].length; interCol++) {
				if (max > matrix[maxRow][interCol]) {
					flag=false;
				}
			}
			if((!ans.contains(max)) && flag)
				ans.add(max);
		}
		return ans;
	}

}
