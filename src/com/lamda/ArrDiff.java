package com.lamda;

public class ArrDiff {

	public static void main(String[] args) {
		int arr1[] = { 1, 4, 2, 3 };
		int arr2[] = { -4, -3, 6, 10, 20, 30 };
		System.out.println(findTheDistanceValue(arr1, arr2, 3));
	}

	public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
		int count = 0;
		boolean flag = true;
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if (Math.abs(arr1[i] - arr2[j]) <= d) {
					flag = false;
					break;
				}
			}
			if (flag) {
				count++;
			}
			flag = true;
		}
		return count;
	}

}
