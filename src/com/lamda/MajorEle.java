package com.lamda;

import java.util.HashMap;

public class MajorEle {

	public static void main(String[] args) {
		int[] nums= {3,2,3};
		int ans = majorityElement(nums);
		System.out.println(ans);

	}
	 static int majorityElement(int[] nums) {
	        HashMap<Integer,Integer> eleCount = new HashMap<>();
		    int major=0;
	        int maxCount=0;
	        if(nums.length==1)
	            return nums[0];
	        for(int num:nums){
	            if(eleCount.containsKey(num)){
	                int count=eleCount.get(num)+1;
	                eleCount.put(num,count);
	                if(maxCount<count){
	                    maxCount=count;
	                    major=num;
	                }
	            }
	            else{
	                 eleCount.put(num,1);
	            }     
	        }
	        return major;
	    }

}
