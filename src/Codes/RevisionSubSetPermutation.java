package Codes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RevisionSubSetPermutation {

	public static void main(String[] args) {
		int[] nums = {1,2,2};
		List<List<Integer>> permute = permute(nums);
		System.out.println("permutations are : ");
		System.out.println(permute);
		System.out.println("------------------------");
		List<List<Integer>> permuteUnique = permuteUnique(nums);
		System.out.println("permutations for duplicate nums in the array: ");
		System.out.println(permuteUnique);
		List<List<Integer>> subsets = subsets(nums);
		System.out.println("subsets: ");
		System.out.println(subsets);
		List<List<Integer>> subsetsDup = subsetsDup(nums);
		System.out.println("subsets with duplicate : ");
		System.out.println(subsetsDup);
	}

	private static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		subsets(ans,new ArrayList<>(),nums, 0);
		return ans;
	}
	
	private static List<List<Integer>> subsetsDup(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		subsetsDup(ans,new ArrayList<>(),nums,0);
		return ans;
	}

	private static void subsetsDup(List<List<Integer>> ans, List<Integer> current, int[] nums,int index) {
		ans.add(new ArrayList<>(current));
		for(int i=index;i<nums.length;i++) {
			if(i>index && nums[i]==nums[i-1])continue;
			current.add(nums[i]);
			subsetsDup(ans, current, nums,i+1);
			current.remove(current.size()-1);
		}
		
	}

	private static void subsets(List<List<Integer>> ans, List<Integer> current, int[] nums, int index) {
		if(index==nums.length) {
			ans.add(new ArrayList<>(current));
			return;
		}
		current.add(nums[index]);
		subsets(ans,current,nums,index+1);
		current.remove(current.size()-1);
		subsets(ans,current,nums,index+1);
	}

	private static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		boolean used[] = new boolean[nums.length];
		Arrays.sort(nums);
		permuteUnique(nums,ans,new ArrayList<>(),used);
		return ans;
		
	}

	private static void permuteUnique(int[] nums, List<List<Integer>> ans, List<Integer> current,boolean[] used) {
		if(current.size()==nums.length) {
			ans.add(new ArrayList<>(current));
			return;
		}
		for(int i=0;i<nums.length;i++) {
			
			if(used[i] || i>0 && nums[i]==nums[i-1] && !used[i-1]) {
				continue;
			}
			used[i] = true;
			current.add(nums[i]);
			permuteUnique(nums, ans, current, used);
			used[i] = false;
			current.remove(current.size()-1);
		}
		
	}

	private static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		permute(nums,ans,new ArrayList<>());
		return ans;
	}

	private static void permute(int[] nums, List<List<Integer>> ans, List<Integer> current) {
		if(current.size()==nums.length) {
			ans.add(new ArrayList<>(current));
			return;
		}
		for(int i=0;i<nums.length;i++) {
			if(current.contains(nums[i]))continue;
			current.add(nums[i]);
			permute(nums,ans,current);
			current.remove(current.size()-1);
		}
		
	}
}
