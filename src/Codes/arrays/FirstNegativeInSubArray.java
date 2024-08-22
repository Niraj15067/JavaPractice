package Codes.arrays;

import java.util.ArrayList;
import java.util.List;

//using sliding window to find first negative in each and every window of size k.
public class FirstNegativeInSubArray {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, -1, 2, 3, -2, -1 };
		int k = 3;
		List<Integer> ans = find(arr, k);
		System.out.println(ans);
	}

	private static List<Integer> find(int[] arr, int k) {
		int start = 0;
		int end = 0;
		List<Integer> cur = new ArrayList<>();
		List<Integer> ans = new ArrayList<>();
		while (end < arr.length) {
			if (end - start + 1 < k) {
				if (arr[end] < 0) {
					cur.add(arr[end++]);
				} else {
					end++;
				}
			} else {
				if (arr[end] < 0) {
					cur.add(arr[end]);
				}
				if (cur.isEmpty()) {
					ans.add(0);
				} else {
					ans.add(cur.get(0));
					if (arr[start] == cur.get(0))
						cur.remove(0);
				}
				start++;
				end++;
			}
		}
		return ans;
	}
}
