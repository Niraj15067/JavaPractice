package com.lamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		List<List<Integer>> ans = threeSumUsingBs(arr,11);
		System.out.println(ans);
	}

	private static List<List<Integer>> threeSum(int[] arr, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		for(int i=0;i<arr.length;i++) {
			int twoSum = target-arr[i];
			int[] two = twoSum(arr,twoSum,i);
			ans.add(new ArrayList<>(Arrays.asList(arr[i],two[0],two[1])));
		}
		return ans;
	}

	private static int[] twoSum(int[] arr, int target, int skip) {
		int[] two = new int[2];
		Map<Integer, Integer> twoSum = new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			if(i==skip) {
				continue;
			}
			int diff = target - arr[i];
			if(twoSum.containsKey(arr[i])) {
				two[0]=arr[i];
				two[1]=diff;
			}else {
				twoSum.put(diff, i);
			}
		}
		return two;
	}
	//optimal approach using bs for three sum.
	public static List<List<Integer>> threeSumUsingBs(int[] arr, int target){
		List<List<Integer>> triplets = new ArrayList<>();
		Arrays.sort(arr);
		int n = arr.length;
		//we will stop 3 ele before which might be the last possible triplet.
		for(int i = 0; i < n-2; i++) {
			//skip duplicate elements 
			if(i>0 && arr[i]==arr[i-1]) {
				continue;
			}
			int left = i+1, right = n-1;
			//not less than or equal to as the left and right and i are going to form the triplet we don't want duplicates.
			while(left<right) {
				int sum = arr[left]+arr[right]+arr[i];
				if(sum==target) {
					triplets.add(Arrays.asList(arr[i],arr[left],arr[right]));
					left++;
					right--;
				}else if(sum<target) {
					left++;
				}else {
					right--;
				}
			}
		}
		return triplets;
	}
}
