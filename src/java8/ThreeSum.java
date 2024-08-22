package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, -1, 7, 11, 12 };
		List<List<Integer>> is = find(arr, 6);
		System.out.println(is);
	}

	private static List<List<Integer>> find(int[] arr, int target) {

		List<List<Integer>> triplets = new ArrayList<>();
		
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		for(int current = 0;current<arr.length;current++) {
			if (current > 0 && arr[current] == arr[current - 1]) {
				continue;
			}
			int diff = target - arr[current];
			int start = current + 1;
			int end = arr.length - 1;
			while (start < end) {
				int sum = arr[start] + arr[end];
				if (sum == diff) {
					triplets.add(Arrays.asList(arr[current],arr[start],arr[end]));
					end--;
					start++;
				} else if (sum > diff) {
					end--;
				} else {
					start++;
				}
			}
		}
		return triplets;
	}
}
