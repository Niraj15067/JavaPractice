package Codes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SubArrayProductLessThanK {

	public static void main(String[] args) {
		int[] arr = { 1,1,1};
		int numSubarrayProductLessThanK = numSubarrayProductLessThanK1(arr, 2);
		System.out.println(numSubarrayProductLessThanK);
	}

	public static int numSubarrayProductLessThanK(int[] nums, int k) {
		int s = 0, e = 0, prod = 1, ans = 0;
		while (e < nums.length) {
			prod *= nums[e++]; // include
			while (s < e && prod >= k) {
				prod /= nums[s++]; // exclude start
			}
			if (prod < k) {
				ans += e - s; // add to answer if it is valid
			}
		}
		return ans;
	}

	public static int numSubarrayProductLessThanK1(int[] nums, int k) {

		Set<List<Integer>> ans = new HashSet<>();
		if (k == 0) {
			return 0;
		}
		find(nums, ans, new ArrayList<>(), k, 0, 1);
		System.out.println(ans);
		return ans.size();
	}

	private static void find(int[] arr, Set<List<Integer>> ans, List<Integer> current, int k, int idx, int product) {
		if (product < k && idx == arr.length) {
			if (current.size() > 0)
				ans.add(new ArrayList<>(current));
			return;
		}
		int mul = 1;
		for (int val : current)
			mul = mul * val;
		if (mul * arr[idx] < k) {
			current.add(arr[idx]);
		}
		if (idx < arr.length)
			find(arr, ans, current, k, idx + 1, mul);
		if (!current.isEmpty())
			current.remove(current.size() - 1);
		if (idx < arr.length)
			find(arr, ans, current, k, idx + 1, mul);
	}
}
