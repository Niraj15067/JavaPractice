package com.lamda;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {

//		generate("abc", "");

		// without passing the paramter of count.
//		int ans = generateCount("abcde","");

		// with passing the parameter.
		System.out.println("generate count param");
		int ans = generateCountParam("abc", "", 0);
		System.out.println(ans);
		System.out.println("generate count");
		int count = generateCount("abc", "");
		System.out.println(count);
//		generate1("abc", "");
		find("abc", "");
		System.out.println(ans);
		System.out.println("===========================");
		System.out.println("permutations for array");
		int[] arr = { 1, 2, 2 };
		List<List<Integer>> permute = permute(arr);
		System.out.println(permute);
		System.out.println("============================");
		System.out.println("permutations for duplicate elements in an array.");
		List<List<Integer>> permuteUnique = permuteUnique(arr);
		System.out.println(permuteUnique);
	}

	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		boolean[] used = new boolean[nums.length];
		permuteUnique(nums, ans, new ArrayList<>(), used);
		return ans;
	}

	private static void permuteUnique(int[] nums, List<List<Integer>> ans, ArrayList current, boolean[] used) {

		if (current.size() == nums.length) {
			ans.add(new ArrayList<>(current));
			return;
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (used[i] || i>0 && nums[i]==nums[i-1] && !used[i-1]) {
					continue;
				}
				used[i] = true;
				current.add(nums[i]);
				permuteUnique(nums, ans, current, used);
				used[i] = false;
				current.remove(current.size() - 1);
			}
		}

	}

	public static List<List<Integer>> permute(int[] nums) {

		List<List<Integer>> ans = new ArrayList<>();
		permute(ans, nums, new ArrayList<>());
		return ans;
	}

	private static void permute(List<List<Integer>> ans, int[] nums, List<Integer> current) {
		if (current.size() == nums.length) {
			ans.add(new ArrayList<>(current));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (current.contains(nums[i])) {
				continue;
			}
			current.add(nums[i]);
			permute(ans, nums, current);
			current.remove(current.size() - 1);
		}

	}

	private static void find(String up, String p) {

		if (up.length() == 1) {
			System.out.println(p + up);
			return;
		}

		for (int i = 0; i < up.length(); i++) {
			String newP = p + up.charAt(i);
			String newUp = up.substring(0, i) + up.substring(i + 1, up.length());
			find(newUp, newP);
		}
	}

	private static int generateCountParam(String up, String p, int count) {
		if (up.isEmpty()) {
			return count + 1;
		}

		for (int i = 0; i <= p.length(); i++) {
			String first = p.substring(0, i);
			String second = p.substring(i, p.length());
			generateCountParam(up.substring(1), first + up.charAt(0) + second, count);
		}
		return count;
	}

	private static int generateCount(String up, String p) {

		int count = 0;

		if (up.isEmpty()) {
			return 1;
		}

		for (int i = 0; i <= p.length(); i++) {
			String first = p.substring(0, i);
			String second = p.substring(i, p.length());
			count += generateCount(up.substring(1), first + up.charAt(0) + second);
		}
		return count;

	}

	private static void generate(String up, String p) {

		if (up.isEmpty()) {
			System.out.println(p);
			return;
		}

		for (int i = 0; i <= p.length(); i++) {
			String first = p.substring(0, i);
			String second = p.substring(i, p.length());
			generate(up.substring(1), first + up.charAt(0) + second);
		}

	}

	private static List<String> generate1(String up, String p) {

		List<String> result = new ArrayList<>();

		if (up.isEmpty()) {
			List<String> ans = new ArrayList<>();
			ans.add(p);
			return ans;
		}

		for (int i = 0; i <= p.length(); i++) {
			String first = p.substring(0, i);
			String second = p.substring(i, p.length());
			result.addAll(generate1(up.substring(1), first + up.charAt(0) + second));
		}
		return result;

	}

}
