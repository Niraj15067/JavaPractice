package string;

import java.util.HashMap;
import java.util.Map;

public class LargestSubsBetwEqlChars {

	public static void main(String[] args) {
		int max = maxLengthBetweenEqualCharacters2("mgntdygtxrvxjnwksqhxuxtrv");
		System.out.println(max);
	}
	
	public static int maxLengthBetweenEqualCharacters(String s) {
		int[] a = new int[26];
		int max = -1;
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			int idx = c-'a';
			if(a[idx]>0) {
				max = Math.max(max, i-a[idx]);
			}else {
				a[idx] = i+1;
			}
		}
		return max;
	}

	public static int maxLengthBetweenEqualCharacters2(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int max = -1;
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if(map.containsKey(c)) {
				max = Math.max(max, i-map.get(c));
			}else {
				map.put(c, i+1);
			}
		}
		return max;
	}
	
	public static int maxLengthBetweenEqualCharacters1(String s) {
		if(s.length()==2) {
			return s.charAt(0)==s.charAt(1)?0:-1;
		}
		int max = -1;
		Map<Character, Integer> map = new HashMap<>();
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}else {
				map.put(c, 1);
			}
		}
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if(map.get(c)>1) {
				int j=i+1;
				int count = 0;
				while(j<s.length()) {
					if(s.charAt(j)==c) {
						max = Math.max(count, max);
					}
					count++;
					j++;
				}
			}
		}
		return max;
	}
}
