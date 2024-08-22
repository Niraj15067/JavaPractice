package com.lamda;

import java.util.Arrays;

public class CycleSort {

	public static void main(String[] args) {
		int[] arr= {5,3,2,1,4,0};
		cycleSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void cycleSort(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			int correct = arr[i];
			if(arr[i]!=arr[correct]) {
				int temp=arr[i];
				arr[i]=arr[correct];
				arr[correct]=temp;
			}
		}
		
	}

}
