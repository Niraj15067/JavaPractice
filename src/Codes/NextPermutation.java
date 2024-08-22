package Codes;

import java.util.ArrayList;
import java.util.List;

public class NextPermutation {

	public static void main(String[] args) {
		int[] arr = {1,2,3};
		List<List<Integer>> permute = permute(arr);
		System.out.println(permute);
	}
	
	
	public static List<List<Integer>> generate(int[] arr) {
		List<List<Integer>> ans = new ArrayList<>();
		generate(ans,arr,new ArrayList<>());
		return ans;
	}
	
	private static void generate(List<List<Integer>> ans, int[] arr, ArrayList arrayList) {
		
	}


	private static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> current = new ArrayList<>();
		boolean[] used = new boolean[nums.length];
		permute(list,current,used,nums);
		return list;
	}

	private static void permute(List<List<Integer>> list, List<Integer> current, boolean[] used, int[] nums) {
		if(current.size()==nums.length) {
			list.add(new ArrayList<>(current));
		}
		
		for(int i=0;i<nums.length;i++) {
			if(!used[i]) {
				current.add(nums[i]);
				used[i] = true;
				permute(list,current,used,nums);
				used[i]=false;
				current.remove(current.size()-1);
			}
		}
		
	}
}
