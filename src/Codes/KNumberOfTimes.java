package Codes;

import java.util.HashMap;
import java.util.Map;

public class KNumberOfTimes {

	public static void main(String[] args) {
		int arr[] = { 3, 1, 3, 4, 5, 1, 3, 3, 5, 4 };
		int ans = find(arr, 3);
		System.out.println(ans);
	}

	private static int find(int[] arr, int k) {

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
				if (map.get(arr[i]) == k) {
					return arr[i];
				}
			}else {
				map.put(arr[i], 1);
			}
			
		}
		return -1;
	}
}
