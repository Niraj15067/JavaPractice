package Arrays;

import java.util.ArrayList;
import java.util.List;

public class SubArrayWithGivenSum {

	public static void main(String[] args) {
		int arr[] = { 12, 5, 31, 9, 21, 8 };
		List<Integer> ans = find(arr, 38);
		System.out.println(ans);
	}

	private static List<Integer> find(int[] arr, int sum) {
		List<Integer> ans = new ArrayList<>();
		int start = 0, end = 0, size = arr.length;
		int curSum = 0;
		while (end < size) {
			if (curSum == sum) {
				break;
			} else if (curSum < sum) {
				curSum += arr[end];
				end++;
			} else {
				curSum -= arr[start++];
			}
		}
		for(int i=start;i<end;i++) {
			ans.add(arr[i]);
		}
		return ans;
	}
}
