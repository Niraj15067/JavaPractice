package com.lamda;

import java.util.ArrayList;
import java.util.List;

public class ReturnModified {

	public static void main(String[] args) {
		int[] arr = { 0, 2, 3, 4, 6, 8, 9 };
		List<String> ans = calculate(arr);
		System.out.println(ans);
	}

	private static List<String> calculate(int[] arr) {
		int start = arr[0];
		List<String> ans = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if(i==arr.length-1 || arr[i]+1 != arr[i+1]) {
				if(arr[i]!=start) {
					ans.add(start+"->"+arr[i]);
				}
				else {
					ans.add(String.valueOf(start));
				}
				if(i!=arr.length-1) {
					start=arr[i+1];
				}
			}
		}
		return ans;
	}

}
