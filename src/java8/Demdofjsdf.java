package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demdofjsdf {

	public static void main(String[] args) {
		String str = "ABBCDEFGHHG";
		String ans = find(str);
		System.out.println(ans);

		int[] arr = { 1, 2, 3, 4, 5, 65, 6 };
		boolean anyMatch = Arrays.stream(arr).anyMatch(a -> a / 2 == 0);
		List<String> asList = Arrays.asList("Niraj", "Sumit", "Siddhu", "shubham");
		Map<String, List<Integer>> collect = asList.stream().collect(
				Collectors.groupingBy(Function.identity(), Collectors.mapping(String::length, Collectors.toList())));
		System.out.println(collect);
		Map<String, Integer> collect2 = asList.stream().collect(Collectors.toMap(Function.identity(), String::length));
		System.out.println(collect2);

	}

	private static String find(String str) {
		Map<Character, Integer> window = new HashMap<>();
		int start = 0, end = 0;
		StringBuilder curr = new StringBuilder();
		StringBuilder ans = new StringBuilder();
		while (end < str.length()) {
			if (!window.containsKey(str.charAt(end))) {
				window.put(str.charAt(end), 1);
				curr.append(str.charAt(end));
				end++;
			} else {
				ans.setLength(0);// new ans is being found so set current one to 0.
				ans.append(curr.toString());// store the new ans found.
				curr.setLength(0);// current ans set to none to found new ans.
				window.clear(); // clear the map to find recurrence for the new substring from start to end.
				start = end; // new start from the duplicate found.
			}
		}
		return curr.length() > ans.length() ? curr.toString() : ans.toString();
	}
}
