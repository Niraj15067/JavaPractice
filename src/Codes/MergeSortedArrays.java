package Codes;

import java.util.Arrays;

public class MergeSortedArrays {

	public static void main(String[] args) {
		int nums1[] = {1,2,3,0,0,0};
		int nums2[] = {2,5,6};	
		merge(nums1, 3, nums2, nums2.length);
		System.out.println(Arrays.toString(nums1));
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {

		int idx = m;
		int j=0;
		for(int i=idx;i<m+n && j<n;i++) {
			nums1[i] = nums2[j++];
		}
		Arrays.sort(nums1);
	}
}
