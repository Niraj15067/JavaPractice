package Arrays;

import java.lang.Character;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FirstAndLastOfEachEle {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 2, 1, 1, 4 };
		find(arr);
		findNumberOfChars("my name is 123 i");
	}

	private static void findNumberOfChars(String s) {
		int count = 0;
		for(int i=0;i<s.length();i++) {
			
		}
		System.out.println("number of chars are : "+count);
		
		Map<Character, Long> collect = s.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c,Collectors.counting()));
		System.out.println(collect);
		long ans = s.chars().filter(c->Character.isLetter(c)).count();
		System.out.println(ans);
	}

	private static void find(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
//		Map<Integer, List<Integer>> occur = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {

			if (!map.containsKey(arr[i])) {
				map.put(arr[i], i);
				System.out.println("First index of " + arr[i] + " is " + map.get(arr[i]));
			}
			map.put(arr[i], i);

		}
		System.out.println("--------------------------------");
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Last index of " + arr[i] + " is " + map.get(arr[i]));
		}
	}
}
