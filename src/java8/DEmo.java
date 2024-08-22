package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class DEmo {

	private static Map<String, List<String>> collect;

	public static void main(String[] args) {
		List<List<List<Integer>>> inputList = Arrays.asList(
				Arrays.asList(Arrays.asList(1,2,3)),
				Arrays.asList(Arrays.asList(3,3,4)),
				Arrays.asList(Arrays.asList(4,5,6))
				);
//		char[] ch = {'a','b','c'};
		String[] input = {"cat","tac","act","bat","tab","yes","no"};
		List<String> asList = Arrays.asList(input);
		collect = asList.stream().collect(Collectors.groupingBy(word->{
			char[] chars = word.toCharArray();
			Arrays.sort(chars);
			return new String(chars);
		}));
		List<String> anagrams = new ArrayList<>();
		List<String> notAnagrams = new ArrayList<>();
		
		for(Entry<String, List<String>> entry : collect.entrySet()) {
			if(entry.getValue().size()==1) {
				notAnagrams.add(entry.getValue().get(0));
			}else {
				List<String> current = entry.getValue();
				anagrams.addAll(current);
			}
		}
		System.out.println(collect);
		System.out.println("All anagrams are : "+anagrams);
		System.out.println("Non anagrams are : "+notAnagrams);

//		System.out.println(asList);
		
//		List<List<Integer>> a = new ArrayList<>();
//		a.add(Arrays.asList(1,2,3));
//		a.add(Arrays.asList(1,2,3));
//		a.add(Arrays.asList(1,2,3));
//		a.add(Arrays.asList(1,2,3));
//		List<Integer> ans = a.stream().flatMap(List::stream).toList();
//		System.out.println(ans);
		
		
//		List<Double> result = inputList.stream()
//                .flatMap(a->a.stream()
//                				.flatMap(b->b.stream()))
//                .distinct().map(a->Math.sqrt(a))
////                .map(x -> Math.sqrt(Double.valueOf(x+"")))
//                .collect(Collectors.toList());
//		System.out.println(result);
//		inputList.stream().flatMap(List::stream).distinct().forEach(x->System.out.println(Math.sqrt(Double.valueOf(x+""))));
		
	}
}
