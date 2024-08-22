package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class RedistributeChars {

	public static void main(String[] args) {
		String s[] = { "abc", "aabc", "bc" };
		boolean equal = makeEqual1(s);
		System.out.println(equal);
	}

	//faster 2 ms
	public static boolean makeEqual1(String[] words) {
		int[] a = new int[26];
		for (String s : words) {
			for (int i = 0; i < s.length(); i++) {
				int idx = s.charAt(i) - 'a';
				a[idx]+=1;
			}
		}
		int total = words.length;
		for(int i=0;i<26;i++) {
			if(a[i]%total!=0) {
				return false;
			}
		}
		return true;
	}

	//slower 15 ms
	public static boolean makeEqual(String[] words) {
		Map<Character, Integer> map = new HashMap<>();
		for (String s : words) {
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (map.containsKey(c)) {
					map.put(c, map.get(c) + 1);
				} else {
					map.put(c, 1);
				}
			}
		}
		int total = words.length;
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			int val = entry.getValue();
			if (!(val % total == 0)) {
				return false;
			}
		}
		return true;
	}
}
