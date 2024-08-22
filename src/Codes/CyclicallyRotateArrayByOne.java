package Codes;

import java.util.Arrays;

public class CyclicallyRotateArrayByOne {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		rotate(arr);
		System.out.println(Arrays.toString(arr));

	}

	private static void rotate(int[] arr) {
		int last = arr[arr.length-1];
		for(int i=arr.length-1;i>0;i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = last;
	}

}
