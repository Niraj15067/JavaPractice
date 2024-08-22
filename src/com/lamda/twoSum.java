package com.lamda;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class twoSum {

	public static void main(String[] args) {
		int[] arr = {2,7,3,6,5,4};
		List<List<Integer>> ans = threeSum(arr, 9);
		System.out.println(ans);
	}
	public static List<List<Integer>> threeSum(int[] arr,int target){
	    Map<Integer,Integer> sum = new HashMap<>();
	    List<List<Integer>> ans = new ArrayList<>();
	    for(int i=0;i<arr.length;i++){
	      int diff = target-arr[i];
	      if(sum.containsKey(arr[i])){
	        ans.add(new ArrayList<>(Arrays.asList(arr[i],diff)));
	      }else{
	        sum.put(diff,i);
	      }
	    }
	    return ans;
	  }
}
