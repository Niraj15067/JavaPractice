package Codes;

import java.util.HashMap;

public class LongestSubstring {

	public static void main(String[] args) {
		int lengthOfLongestSubstring = lengthOfLongestSubstring("abcdabcee");
		System.out.println(lengthOfLongestSubstring);
	}
	
	public static int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))) {
            	max = Math.max(max, count);
            	map.clear();
            	count = 0;
            }else {
            	count++;
            	map.put(s.charAt(i), 1);
            }
        }
        return max;
    }
}
