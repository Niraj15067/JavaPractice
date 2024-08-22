package string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChars {

	public static void main(String[] args) {
		String s = "pwwkew";
		int ans = lengthOfLongestSubstring1(s);
		System.out.println(ans);
	}
	public static int lengthOfLongestSubstring(String s) {
		int max = 0;
		Map<Character, Integer> map = new HashMap<>();
		int start = 0;
		int end = 0;
		while(end<s.length()) {
			char ch = s.charAt(end);
			map.put(ch,map.getOrDefault(ch, 0)+1);
			if(map.get(ch)>1) {
				max = Math.max(max, end-start);
				while(map.get(s.charAt(start))!=map.get(s.charAt(end))) {
					map.remove(s.charAt(start++));
				}
				map.put(s.charAt(start), map.get(s.charAt(start))-1);
				start++;//break ho raha hai jab equal hai pwwkew me 
			}else {
				max = Math.max(max, end-start+1);
			}
			end++;
		}
		return max;
	}
	//better.
	public static int lengthOfLongestSubstring1(String s) {
		Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for(int right = 0;right<s.length();right++){
            char current = s.charAt(right);
            if(map.containsKey(current)){
                left = Math.max(left, map.get(current)+1);
            }
            map.put(current,right);
            max = Math.max(max,right-left+1);
        }
        return max;
	    }
}
