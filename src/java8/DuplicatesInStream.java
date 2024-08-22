package java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DuplicatesInStream {

	public static void main(String[] args) {
		int[] arr = { 5, 13, 4, 21, 13, 27, 2, 59, 59, 34 };
		Set<Integer> set = new HashSet<>();

		int[] array = Arrays.stream(arr).filter(x -> !set.add(x)).toArray();
		System.out.println(Arrays.toString(array));

//		System.out.println("list of duplicates : " + collect);
		Map<String, Integer> map = new HashMap<>();
		map.put("niraj", 1000);
		map.put("vivek", 2022);
		map.put("shantanu", 1019);
		map.put("balli", 909);
		map.put("sfdd", 10000);
		map.put("sfdjd", 10000);

		List<Entry<Integer, List<Entry<String, Integer>>>> list3 = map.entrySet().stream()
				.collect(Collectors.groupingBy(Entry::getValue)).entrySet().stream()
				.sorted((a, b) -> b.getKey() - a.getKey()).skip(1).limit(1).toList();

		System.out.println(list3);

		String ab = "nirajaer";
		List<Character> list2 = ab.chars().mapToObj(x -> (char) x).toList();
		System.out.println(list2);

		List<Entry<Integer, List<Entry<String, Integer>>>> list = map.entrySet().stream()
				.collect(Collectors.groupingBy(a -> a.getValue())).entrySet().stream()
				.sorted((a, b) -> b.getKey() - a.getKey()).skip(1).limit(1).toList();

		System.out.println(list);

	}
}

class emp {
	int val;
	String name;

	public emp(int val, String name) {
		super();
		this.val = val;
		this.name = name;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
