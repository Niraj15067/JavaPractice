package com.lamda;

import java.util.Arrays;

public class ZeroEnd {

	public static void main(String[] args) {
		
		int[] arr = {1,0,2,1,0,4};
		solve(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void solve(int[] arr) {
		
		int index = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=0) {
				int temp = arr[i];
				arr[i]=arr[index];
				arr[index]=temp;
				index++;
			}
		}
	}

}
