package java8;

import java.util.function.Function;

public class MethodAsParameterExample {
	public static void main(String[] args) {
		// Define a method that takes a function as a parameter
		processString("Hello, World!", String::toUpperCase);
		processString("hello, world!", String::toLowerCase);
		
	}

	public static void processString(String input, Function<String, String> function) {
		String result = function.apply(input);
		System.out.println(result);
	}
}