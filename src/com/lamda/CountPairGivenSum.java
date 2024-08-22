package com.lamda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountPairGivenSum {

	public static void main(String[] args) {
		int[]arr = {1, 5, 7, -1, 5};
		int target = 6;
		List<Integer> list =  new ArrayList<>();
		HashMap<Integer, Integer> hash = new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			int diff = target-arr[i];
			if(hash.containsKey(diff)) {
				list.add(diff);
				list.add(arr[i]);
			}else {
				hash.put(arr[i], i);
			}
		}
		System.out.println(list.size()/2);
	}
}
