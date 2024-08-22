package string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStrWithKUniqueChars {

	public static void main(String[] args) {
		String s = "aabacbebebe";
		int ans = longestkSubstr1(s, 3);
		System.out.println(ans);
	}

	// using map.
	public static int longestkSubstr(String s, int k) {
		int max = -1;
		Map<Character, Integer> map = new HashMap<>();
		int start = 0, end = 0, unique = 0;
		while (end < s.length()) {
			char ch = s.charAt(end);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
			if (map.get(ch) == 1) {
				unique++;
			}
			while (unique > k) {
				char i = s.charAt(start);
				map.put(i, map.get(i) - 1);
				if (map.get(i) == 0) {
					unique--;
				}
				start++;
			}
			if (unique == k) {
				max = Math.max(max, end - start + 1);
			}
			end++;
		}
		return max;
	}

	// using array for the map purpose. Bit faster and less memory i guess.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
	public static int longestkSubstr1(String s, int k) {
		int max = -1;
		int[] map = new int[26];
		int start = 0, end = 0, unique = 0;
		while (end < s.length()) {
			int idx = s.charAt(end)-'a';
			map[idx]++;
			if (map[idx] == 1) {
				unique++;
			}
			while (unique > k) {
				int i = s.charAt(start)-'a';
				map[i]--;
				if (map[i] == 0) {
					unique--;
				}
				start++;
			}
			if (unique == k) {
				max = Math.max(max, end - start + 1);
			}
			end++;
		}
		return max;
	}
}
