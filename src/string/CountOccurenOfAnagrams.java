package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountOccurenOfAnagrams {

	public static void main(String[] args) {

		String s = "aabaabaa";
		String p = "aaba";

		int ans = search(s, p);
		System.out.println(ans);

	}

	static int search(String txt, String pattern) {
		int n = txt.length();
		int w = pattern.length();
		int start = 0, end = 0, ans = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < pattern.length(); i++) {
			char ch = pattern.charAt(i);
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}
		int count = map.size();
		while (end < txt.length()) {
			char ch = txt.charAt(end);
			if (map.containsKey(ch)) {
				int val = map.get(ch);
				map.put(ch, val - 1);
				if (val - 1 == 0) {
					count--;
				}
			} 
			if(end-start+1==w) {
				if (count == 0) {
					ans++;
				}
				char s = txt.charAt(start++);
				if (map.containsKey(s)) {
					map.put(s, map.get(s) + 1);
					if (map.get(s) == 1) {
						count++;
					}
				}
			}
			end++;
		}
		return ans;
	}

	private static int usingBruteForce(String text, String word) {
		int n = text.length();
		int w = word.length();
		char[] wordArr = word.toCharArray();
		int start = 0, end = 0;
		Arrays.sort(wordArr);
		int ans = 0;
		StringBuilder sb = new StringBuilder();
		while (end < n) {
			if (end - start + 1 < w) {
				sb.append(text.charAt(end++));
			} else {
				if (sb.length() == w)
					sb.deleteCharAt(start);
				sb.append(text.charAt(end));
				boolean ana = araAnagram(sb.toString(), wordArr);
				if (ana) {
					ans++;
				}
				end++;
			}
		}
		return ans;
	}

	static boolean araAnagram(String cur, char[] word) {
		char c[] = cur.toCharArray();
		Arrays.sort(c);
		if (Arrays.equals(c, word))
			return true;
		else {
			return false;
		}
	}

}
