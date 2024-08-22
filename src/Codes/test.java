package Codes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {

	public static void main(String[] args) {
		int[] arr = {1,2,3};
		List<List<Integer>> ans = find(arr);
		System.out.println(ans);
	}

	private static List<List<Integer>> find(int[] arr) {
		List<List<Integer>> ans = new ArrayList<>();
		find(arr,ans,new ArrayList<>(),0);
		return ans;
	}

	private static void find(int[] arr, List<List<Integer>> ans, List<Integer> current, int idx) {
		if(idx==arr.length) {
			ans.add(new ArrayList<>(current));
			return;
		}
		
		current.add(arr[idx]);
		find(arr, ans, current, idx+1);
		current.remove(current.size()-1);
		find(arr, ans, current, idx+1);
	}
	
	
}
