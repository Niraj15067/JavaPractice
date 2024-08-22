package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class CountFrequency {

	public static void main(String[] args) {
		String str = "abbbbbcabcdefdeff";
		char[] charArray = str.toCharArray();
		List<Character> list = new ArrayList<>();
		for (char c : charArray) {
			list.add(c);
		}
		char max = find(list);
		System.out.println(max);
	}

	private static char find(List<Character> list) {
		return list.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting())).entrySet().stream()
				.max((a, b) -> Integer.parseInt((a.getValue() - b.getValue()) + "")).get().getKey();
	}

}
