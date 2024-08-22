package string;

import java.util.ArrayList;
import java.util.List;

public class Tokens {

	public static void main(String[] args) {

		String str = "           YES      leading spaces        are valid,    problemsetters are         evillllll";
		StringBuilder sb = new StringBuilder();
		List<String> s = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (str.charAt(i) == ' ') {
				if (sb.length() == 0) {
					continue;
				}
				s.add(sb.toString());
				sb.delete(0, sb.length());
			} else if (!Character.isLetterOrDigit(ch)) {
				if (sb.length() == 0)
					continue;
				s.add(sb.toString());
				sb.delete(0, sb.length());
			} else {
				sb.append(ch);
			}
		}
		if (!sb.isEmpty()) {
			s.add(sb.toString());
		}
		System.out.println(s.size());
		for (String s1 : s) {
			System.out.println(s1);
		}

	}
}
