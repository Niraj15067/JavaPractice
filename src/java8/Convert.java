package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Convert {

	public static void main(String[] args) {
		
		List<String> s = new ArrayList<>();
		s.add("Shubham");
		s.add("Niraj");
		s.add("Balli");
		s.add("Shantya");
		
		String a  ="niraj";
		List<Character> list = a.chars().mapToObj(x->(char)x).toList();
		System.out.println(list);

		List<Character> list2 = s.stream()
				.map(x->x.chars().mapToObj(z->(char)z).toList())
				.flatMap(List::stream).toList();
		
		System.out.println(list2);
		
		

		
	}
}
