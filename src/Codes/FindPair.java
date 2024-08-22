package Codes;

import java.util.HashMap;

public class FindPair {

	public static void main(String[] args) {
		int[] arr = {1,6,7,2,3,4};
		find(arr,7);
	}

	private static void find(int[] arr, int sum) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			int diff = sum - arr[i];
			if(map.containsKey(diff)) {
				System.out.println(diff+" , "+ arr[i]);
			}else {
				map.put(arr[i], diff);
			}
		}
		
	}
}
