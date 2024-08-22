package Codes;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingNumber {

	public static void main(String[] args) {
		int[] arr = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
		int ans = missing3(arr);
		System.out.println("The missing value is : " + ans);
	}

	private static void cycleSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= arr.length) {
				continue;
			}
			int idx = arr[i];
			if (arr[i] != arr[idx]) {
				arr[i] = arr[i] + arr[idx];
				arr[idx] = arr[i] - arr[idx];
				arr[i] = arr[i] - arr[idx];
			}
		}
		System.out.println(Arrays.toString(arr));
	}

	private static int missing(int[] arr) {
		int ans = 0;
		Set<Integer> nums = new HashSet<>();
		for (int i : arr) {
			nums.add(i);
		}
		for (int i = 1; i <= arr.length; i++) {
			if (!nums.contains(i)) {
				ans = i;
				break;
			}
		}
		return ans;
	}

	private static int missing1(int[] arr) {
		boolean hash[] = new boolean[arr.length + 2];
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			hash[arr[i]] = true;
		}
		for (int i = 1; i <= arr.length; i++) {
			if (!hash[i]) {
				ans = i;
				break;
			}
		}
		return ans;
	}

	private static int missing3(int[] arr) {
		cycleSort(arr);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != i) {
				return i + 1;
			}
		}
		return -1;
	}
}
