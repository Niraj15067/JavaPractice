package codesss;

import java.util.Arrays;

public class RemoveDuplicates {

	public static void main(String[] args) {
		int[] nums = { 0, 0, 1, 1, 1, 1, 2, 3, 4, 5, 5, 6, 6, 7 };
		int k = removeDuplicates(nums);
		System.out.println("===========================================");
		System.out.println("No of elements in the expected array is: " + k);
		System.out.println(Arrays.toString(nums));
		StringBuilder sb = new StringBuilder();
		sb.reverse();
	}

	public static int removeDuplicates(int[] nums) {
		int k = 0;
		int prev = Integer.MIN_VALUE;
		int[] expected = new int[nums.length];
		for(int i=0;i<nums.length;i++) {
			if(!(prev==nums[i])) {
				prev = nums[i];
				expected[k] = nums[i];
				k++;
			}
		}
		for(int i=0;i<k;i++) {
			nums[i] = expected[i];
		}
		return k;
	}

//	for(int i = 0; i< nums.length; i++) {
//		if(!(prev == nums[i])) {
//			prev = nums[i];
//			expected[k] = prev;
//			k++;
//		}
//	}
}
