package Codes;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int arr[] = { 4, 3, 2, 1 };
		mergeSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void mergeSort(int[] arr, int start, int end) {
		//when there is only one element left in the array then you need to return.
		if (start == end) {
			return;
		}
		int mid = start + (end - start) / 2;
		mergeSort(arr, start, mid);
		mergeSort(arr, mid + 1, end);

		merge(arr, start, mid + 1, end);//as we have not made the mid exclusive for the left hand side, the start of 
										// right hand side is mid + 1.
	}

	private static void merge(int[] arr, int start, int mid, int end) {
		int[] temp = new int[end - start + 1];
		int s = start;
		int e = mid, k = 0;
		//s<mid because right array is starting from the mid itself so left array is till mid -1 so < cond
		//on the other hand the <= condition is there because the right array expands till the end or rest.
		while (s < mid && e <= end) {
			if (arr[s] > arr[e]) {
				temp[k] = arr[e];
				e++;
			} else {
				temp[k] = arr[s];
				s++;
			}
			k++;
		}
		while (s < mid) {
			temp[k] = arr[s];
			s++;
			k++;
		}
		//similarly over here.
		while (e <= end) {
			temp[k] = arr[e];
			e++;
			k++;
		}
		for (int i = 0; i < temp.length; i++) {
			arr[i + start] = temp[i];
		}
	}
}
