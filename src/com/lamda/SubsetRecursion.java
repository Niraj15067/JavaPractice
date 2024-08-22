package com.lamda;

import java.util.ArrayList;
import java.util.List;

public class SubsetRecursion {

	public static void main(String[] args) {
		
		int arr[] = {1,2,3,4};
		List<Integer> ans = new ArrayList<>();
		List<List<Integer>> whole = new ArrayList<>();
		subset(arr,0,ans,whole);
		System.out.println(whole);
	}

	private static void subset(int[] arr, int idx, List<Integer> ans, List<List<Integer>> whole) {
		
		if(idx==arr.length) {
			whole.add(new ArrayList<>(ans));
			return;
		}
		
		ans.add(arr[idx]);
		subset(arr, idx+1, ans, whole);
		ans.remove(ans.size()-1);
		subset(arr, idx+1, ans, whole);
		
	}

}
