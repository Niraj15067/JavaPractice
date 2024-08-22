package Arrays;

import java.util.Arrays;

public class MergeSortInplace {

	public static void main(String[] args) {
		int arr[] = {5,3,12,8,1,4,11};
		mergeSort(arr,0,arr.length);
		System.out.println(Arrays.toString(arr));
	}

	private static void mergeSort(int[] arr, int start, int end) {
		if(end-start==1) {
			return;
		}
		int mid = start + (end - start)/2;
		mergeSort(arr, start, mid);
		mergeSort(arr, mid, end);
		
		merge(arr,start,mid,end);
	}

	private static void merge(int[] arr, int start, int mid, int end) {
		
		int merged[] = new int[end-start];
		int k = 0;
		int j = mid;
		int i = start;
		while(i<mid && j < end) {
			if(arr[i]<arr[j]) {
				merged[k] = arr[i];
				i++;
			}else {
				merged[k] = arr[j];
				j++;
			}
			k++;
		}
		while(i<mid) {
			merged[k] = arr[i];
			k++;
			i++;
		}
		while(j<end) {
			merged[k] = arr[j];
			k++;
			j++;
		}
		for(int x = 0;x<merged.length;x++) {
			arr[start+x] = merged[x];
		}
	}
}
