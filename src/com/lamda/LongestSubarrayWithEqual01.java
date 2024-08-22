package com.lamda;

import java.util.HashMap;

public class LongestSubarrayWithEqual01 {
    public static int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLen = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count--;
            } else {
                count++;
            }

            if (map.containsKey(count)) {
                maxLen = Math.max(maxLen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1};
        int maxLength = findMaxLength(nums);
        System.out.println("Longest subarray length with equal 0s and 1s: " + maxLength);
    }
}