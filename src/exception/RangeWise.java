package exception;

import java.util.ArrayList;
import java.util.List;

public class RangeWise {

	public static void main(String[] args) {
		int nums[] = {1,2,3,5,7,8};
		List<String> rangeWise = rangeWise(nums);
		System.out.println(rangeWise);
	}

	private static List<String> rangeWise(int[] nums) {
		
		List<String> list = new ArrayList<>();
		int start =nums[0], end = 0;
		for(int i=0;i<nums.length;i++) {
			end = nums[i];
			if(!(i+1<nums.length && nums[i]+1==nums[i+1])) {
				if(start==end) {
					list.add(start+"");
				}else {
					list.add(start+"->"+end);
				}
				if(i+1<nums.length)
					start = nums[i+1];
			}
		}
		return list;
	}
}
