package com.lamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShiftAdd {

	public static void main(String[] args) {
		int nums[] = {0,1,2,3,4};
		int[] index = {0,1,2,2,1};
		System.out.println(Arrays.toString(shiftKrle(nums,index)));
		
	}

	private static int[] shiftKrle(int[] nums, int[] index) {
		List<Integer> ans = new ArrayList<>();
		for(int i=0;i<nums.length;i++) {
			ans.add(index[i],nums[i]);
		}
		int[] result = new int[ans.size()];
		for(int i=0;i<ans.size();i++) {
			result[i]=ans.get(i);
		}
		return result;
	}

}
