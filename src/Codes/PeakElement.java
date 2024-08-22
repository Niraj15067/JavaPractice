package Codes;

public class PeakElement {

	public static void main(String[] args) {
		int[] arr = {10,20,15,2,23,90,67};
		int peak = findPeak(arr);
		System.out.println(peak);
	}

	private static int findPeak(int[] arr) {
		int start = 0;
		int end = arr.length-1;
		while(start<end) {
			int mid = start+(end-start)/2;
			if(arr[mid]>arr[start]) {
				start = mid;
			}else {
				end = mid;
			}
		}
		return arr[start];
	}
}
