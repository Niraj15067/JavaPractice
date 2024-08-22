package com.lamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPossibleSubset {

	static List<String> subsets = new ArrayList<>();
	static List<List<Integer>> list = new ArrayList<>();

	public static void main(String[] args) {

//		countSubsets("abc","");
//		ArrayList<String> ans = subsetsReturn("abc","");
//		subsetsAscii("abc","");
		ArrayList<String> subsetsReturn = subsetsReturn("abc", "");
		System.out.println(subsetsReturn);
		int[] arr = { 1, 2, 2 };
		System.out.println("subsets using ");
		List<List<Integer>> list = subsets1(arr);
		System.out.println(list);
		System.out.println("subset using choose unchoose method ");
		List<List<Integer>> subsets1 = subsets(arr);
		System.out.println(subsets1);
		System.out.println("==============");
		System.out.println("subset with duplicate elements: ");
		List<List<Integer>> subsetsWithDup = subsetsWithDup(arr);
		System.out.println(subsetsWithDup);
	}

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		subsetWithDup(nums, ans, 0, new ArrayList<>());
		return ans;
	}

	private static void subsetWithDup(int[] nums, List<List<Integer>> ans, int start, List<Integer> current) {
		ans.add(new ArrayList<>(current));
	    for(int i = start; i < nums.length; i++){
	        if(i >start  && nums[i] == nums[i-1]) continue; // skip duplicates
	        current.add(nums[i]);
	        subsetWithDup(nums, ans,i+1, current);
	        current.remove(current.size() - 1);
	    }
	}

	public static List<List<Integer>> subsets(int[] nums) {
		Arrays.sort(nums);
		subsets(new ArrayList<>(), 0, nums);
		return list;
	}

	private static void subsets(ArrayList<Integer> current, int start, int[] nums) {

		if (start == nums.length) {
            list.add(new ArrayList<>(current));
            return;
        }
        // Include the current element
        current.add(nums[start]);
        subsets(current, start + 1, nums);
        // Skip duplicates
        while (start + 1 < nums.length && nums[start] == nums[start + 1]) {
            start++;
        }
        // Exclude the current element
        current.remove(current.size() - 1);
        subsets(current, start + 1, nums);

	}

	public static List<List<Integer>> subsets1(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(nums);
		subsets(ans, new ArrayList<>(), 0, nums);
		return ans;
	}

	private static void subsets(List<List<Integer>> ans, List<Integer> current, int start, int[] nums) {
		ans.add(new ArrayList<>(current));
		for (int i = start; i < nums.length; i++) {
			current.add(nums[i]);
			subsets(ans, current, i + 1, nums);
			current.remove(current.size() - 1);
		}
	}

	private static void countSubsets(String up, String p) {
		if (up.isEmpty()) {
			if (!p.isEmpty())
				subsets.add(p);
			return;
		}

		char ch = up.charAt(0);

		countSubsets(up.substring(1), p + ch);
		countSubsets(up.substring(1), p);
	}

	static ArrayList<String> subsetsReturn(String up, String p) {
		if (up.isEmpty()) {
			ArrayList<String> list = new ArrayList<>();
			list.add(p);
			return list;
		}

		char ch = up.charAt(0);
		ArrayList<String> left = subsetsReturn(up.substring(1), p + ch);
		ArrayList<String> right = subsetsReturn(up.substring(1), p);

		left.addAll(right);
		return left;
	}

	private static void subsetsAscii(String up, String p) {
		if (up.isEmpty()) {
			if (!p.isEmpty())
				subsets.add(p);
			return;
		}

		char ch = up.charAt(0);

		subsetsAscii(up.substring(1), p + ch);
		subsetsAscii(up.substring(1), p);
		subsetsAscii(up.substring(1), p + (ch + 0));
	}

}
