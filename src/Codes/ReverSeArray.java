package Codes;

import java.util.Arrays;

public class ReverSeArray {

	public static void main(String[] args) {
		int[] arr = { 5, 4, 3, 2, 1 };
		reverse(arr);
		System.out.println(Arrays.toString(arr));
	}

	// in place swap just as we do for the string most optimal rev two pointers
	// starting from the start and the end.
	private static void reverse(int[] arr) {
		int end = arr.length - 1;

		for (int start = 0; start < end; start++, end--) {
			arr[start] = arr[start]+arr[end];
			arr[end] = arr[start]-arr[end];
			arr[start] = arr[start]-arr[end];
		}
	}
}
