package codesss;

import java.util.Arrays;

public class RemoveElement {

	public static void main(String[] args) {
		int[] nums = {0,1,2,2,3,0,4,2};
		int ans = remove(nums,2);
		System.out.println(ans);
		System.out.println(Arrays.toString(nums));
	}

	private static int remove(int[] nums, int val) {	
		int idx = 0;
		for(int i=0;i<nums.length;i++) {
			if(!(nums[i]==val)) {
				nums[idx] = nums[i];
				idx++;
			}
		}
		return idx;
	}

}
