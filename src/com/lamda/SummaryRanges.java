package com.lamda;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

	public static void main(String[] args) {
		int arr[]= {0,2,3,4,6,8,9};
		List<String> ans = summaryRanges(arr);
		System.out.println(ans);
	}
	public static List<String> summaryRanges(int[] nums) {
		List<String> str = new ArrayList<>();
		int start=0;
		for(int i=0;i<nums.length;i++) {
			if(i==nums.length-1 || nums[i]+1 != nums[i+1]) {
				if(i==start) {
					str.add(nums[i]+"");
					start=i+1;
				}else {
					str.add(nums[start]+"->"+nums[i]);
					start=i+1;
				}
			}
		}
		return str;
	}

}
