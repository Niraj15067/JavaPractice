package Codes;

import java.util.ArrayList;
import java.util.List;

public class Range {

	public static void main(String[] args) {
		int[] arr = {1,2,3,5,7,8,9};
		List<String> ans = rangeWise(arr);
		System.out.println(ans);
	}

	private static List<String> rangeWise(int[] arr) {
		
		List<String> result = new ArrayList<>();
		int start = 0;
		for(int i=0;i<arr.length;i++) {
			if(i==arr.length-1 || !(arr[i]+1==arr[i+1])) {
				if(i==start) {
					result.add(arr[i]+"");
				}else {
					result.add(arr[start]+"-"+arr[i]);
				}
				start = i+1;
			}
		}
		return result;
	}
}
