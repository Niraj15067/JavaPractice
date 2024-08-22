package Codes;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueChar {

	public static void main(String[] args) {

		int firstUniqChar = firstUniqChar("aabc");
		System.out.println(firstUniqChar);
	}

	//optimized.
	public static int firstUniqChar(String s) {
		int[] a = new int[26];
		Arrays.fill(a, 0);
		for (int i = 0; i < s.length(); i++) {
			int index = s.charAt(i) - 'a';
			a[index]++;
		}
		for (int i = 0; i < s.length(); i++) {
			int idx = s.charAt(i) - 'a';
			if (a[idx] == 1) {
				return i;
			}
		}
		return -1;
	}

	public int firstUniqChar1(String s) {
		Map<Character, Integer> count = new LinkedHashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (count.containsKey(s.charAt(i))) {
				count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);
			} else {
				count.put(s.charAt(i), 1);
			}
		}
		for (int i = 0; i < s.length(); i++) {
			if (count.get(s.charAt(i)) == 1) {
				return i;
			}
		}
		return -1;
	}
}
