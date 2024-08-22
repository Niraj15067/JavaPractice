package Arrays;

import java.util.ArrayList;
import java.util.List;

public class Range {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,7,8,10,12,13,14,15};
		List<String> ans = calculate(arr);
		System.out.println(ans);
	}

	private static List<String> calculate(int[] arr) {
		List<String> ans = new ArrayList<>();
		int start = 0,end=0;
		while(end<arr.length) {
			if(end+1<arr.length && arr[end]+1==arr[end+1]) {
				end++;
			}else {
				if(start==end) {
					ans.add(arr[end]+"");
				}else {
					ans.add(arr[start]+"-"+arr[end]);
				}
				start = end+1;
				end++;
			}
		}
		return ans;
	}
}
