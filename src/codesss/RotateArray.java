package codesss;

import java.util.Arrays;

public class RotateArray {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		rotate(arr, 3);
		System.out.println(Arrays.toString(arr));
	}

	private static void rotate(int[] nums, int k) {
		int[] ans = new int[nums.length];
		int len = nums.length;
		int rotateFrom = len - (k % len);
		for(int i = 0,j=0;i<len;i++,j++) {
			ans[j] = nums[(rotateFrom+i)%len];
		}
		for(int i=0;i<len;i++) {
			nums[i] = ans[i];
		}
	}
}
