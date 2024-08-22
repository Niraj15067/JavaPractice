package com.lamda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class LambdaTasks {

	public static void main(String[] args) {
		List<String> str = new ArrayList<>();
		str.add("niraj");
		str.add("siraj");
		str.add("dhiraj");
		str.add("suraj");
		
		List<Integer> i = new ArrayList<>();
		i.add(1);
		i.add(2);
		i.add(3);
		i.add(4);
		i.add(5);
		i.add(6);
		
		Optional<Integer> highest = i.stream().sorted(Comparator.comparing(Integer::intValue).reversed()).skip(1).findFirst();
		int h = highest.get();
		System.out.println(h);
		List<String> op = str.stream().map(s->s.toUpperCase()).toList();
		List<String> firstUpper = str.stream().map(s->s.substring(0,1).toUpperCase().concat(s.substring(1))).toList();
		System.out.println(firstUpper);
		System.out.println(op);
		
		str.sort(Comparator.comparing(String::length));
		int add = i.stream().reduce(0, (res,ele)->res+ele);
		System.out.println(add);
	}

}
