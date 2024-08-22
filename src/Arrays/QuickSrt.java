package Arrays;

import java.util.Arrays;

import com.lamda.QuickSort;

public class QuickSrt {

	public static void main(String[] args) {
		int arr[] = {5,3,12,8,1,4,11};
		quickSort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	private static void quickSort(int[] arr, int low , int hi) {
		
		
		int mid = (low+hi)/2;
		int pivot = arr[mid];
		int start = low, end = hi;
//		while(start<)
		
	}
}
