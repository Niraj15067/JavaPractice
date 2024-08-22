package com.lamda;

import java.util.Arrays;

public class MergeSortInPlace {

	public static void main(String[] args) {
		int arr[] = { 5, 4, 3, 2, 1 };
		mergeSort(arr, 0, arr.length);
		System.out.println(Arrays.toString(arr));
	}

	private static void mergeSort(int[] arr, int start, int end) {
		if(end-start==1)
			return;
		
		int mid = (start+end)/2;
		mergeSort(arr, start, mid);
		mergeSort(arr, mid, end);
		
		merge(arr, start, mid, end);
	}

	private static void merge(int[] arr, int left, int mid, int right) {
		int[] mix = new int[right-left];
		int i = left, j = mid, k = 0;

		while (i < mid && j < right) {
			if (arr[i] < arr[j]) {
				mix[k] = arr[i];
				i++;
			} else {
				mix[k] = arr[j];
				j++;
			}
			k++;
		}
		while (i < mid) {
			mix[k] = arr[i];
			i++;
			k++;
		}
		while (j < right) {
			mix[k] = arr[j];
			j++;
			k++;
		}
		
		for(int l=0;l<mix.length;l++) {
			arr[left+l]=mix[l];
		}
	}

}
