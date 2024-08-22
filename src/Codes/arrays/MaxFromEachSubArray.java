package Codes.arrays;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MaxFromEachSubArray {

	public static void main(String[] args) {
		int[] arr = {8,7,9,2,3,-6,-7,-8};
		int k = 3;
		List<Integer> ans = find(arr,k);
		System.out.println(ans);
	}

	private static List<Integer> find(int[] arr, int k) {
		List<Integer> ans = new ArrayList<>();
		Deque<Integer> q = new ArrayDeque<>();
		int start = 0, end = 0;
		while(end<arr.length) {
			while(!q.isEmpty() && q.peekLast()<arr[end]) {
				q.pollLast();
			}
			q.offer(arr[end]);
			
			if(end-start+1<k) {
				end++;
			}else if(end-start+1==k) {
				ans.add(q.peek());
				if(!q.isEmpty() && arr[start]==q.peek()) {
					q.pop();
				}
				start++;
				end++;
			}
		}
		return ans;
	}
}
