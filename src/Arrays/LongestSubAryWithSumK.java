package Arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubAryWithSumK {

	public static void main(String[] args) {
		int[] arr = { 10, 5, -10, -10, 5, 5, 8, -3, 2 };
		int ans = find1(arr, 5);
		System.out.println(ans);
	}

	private static int find1(int[] arr, int k) {
		int maxLen = 0;
		int sum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1); // Initialize the map with the sum 0 at index -1 (used for handling subarrays
						// starting from index 0)

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (map.containsKey(sum - k)) {
				// If there exists a sum - k in the map, update maxLen
				maxLen = Math.max(maxLen, i - map.get(sum - k));
			}
			// Put the current sum into the map if it doesn't exist
			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}

		return maxLen;
	}

	// not able to cover all the scenarios. Need to cahn
	private static int find(int[] arr, int k) {
		int start = 0;
		int end = 0;
		int size = 0;
		int cs = 0;
		while (end < arr.length) {
			cs += arr[end];
			if (cs < k) {
				end++;
			} else if (cs == k) {
				size = Math.max(size, end - start + 1);
				end++;
			} else {
				while (cs > k) {
					cs -= arr[start++];
				}
				end++;
			}
		}
		return size;
	}
}
