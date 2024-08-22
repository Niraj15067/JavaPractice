package com.lamda;

public class Ceil {

	public static void main(String[] args) {
		int ar[] = {2,3,5,7,9,14,17};
		int ans = binarySearch(ar,10);
		System.out.println(ans);
	}

	private static int binarySearch(int[] ar, int target) {
		int start = 0;
		int end = ar.length-1;
		while(start<=end) {
			int mid = start + (end-start)/2;
			if(ar[mid]==target)
				return mid;
			if(ar[mid]<target)
				start=mid;
			else 
				end=mid;
		}
		return start;
	}

}
