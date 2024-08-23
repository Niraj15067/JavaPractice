package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeDemo {
	public static void main(String[] args) {

		List<Employeee> employees = Arrays.asList(new Employeee("John", 50000, Arrays.asList("Java", "Python")),
				new Employeee("Mary", 60000, Arrays.asList("C++", "JavaScript")),
				new Employeee("David", 700000, Arrays.asList("Java", "C#")),
				new Employeee("Emily", 40000, Arrays.asList("Python", "Ruby")),
				new Employeee("Michael", 65000, Arrays.asList("Java", "JavaScript")),
				new Employeee("John", 50000, Arrays.asList("Java", "golang")),
				new Employeee("Emily", 100000, Arrays.asList("Scala", "Php")),
				new Employeee("Natsu", 50000, Arrays.asList("C#", "Mandarin")));

		Map<String, Set<String>> collect = employees.stream().collect(Collectors.groupingBy(s -> s.getName(),
				Collectors.flatMapping(e -> e.getCourses().stream(), Collectors.toSet())));

		Map<String, Set<String>> collect2 = employees.stream()
				.flatMap(emp -> emp.getCourses().stream().map(course -> new CourseName(course, emp.getName())))
				.collect(Collectors.groupingBy(CourseName::getCourse,
						Collectors.mapping(x -> x.getName(), Collectors.toSet())));

		for (Entry<String, Set<String>> entry : collect2.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			System.out.println("====================================================");
		}
		List<Character> list = employees.stream().flatMap(x -> x.getName().chars().mapToObj(a -> (char) a)).toList();
		System.out.println(list);
		List<Employeee> list2 = employees.stream().sorted((a, b) -> b.getPrice() - a.getPrice()).skip(2).limit(1)
				.toList();
		System.out.println("Highest price record : " + list2);
		boolean anyMatch = employees.stream().anyMatch(x -> x.getName().equals("Natsu"));
		List<Employeee> list3 = employees.stream().sorted(Comparator.comparing(Employeee::getPrice).reversed()).toList();
		System.out.println(list3);
		List<Character> list4 = employees.stream().flatMap(emp -> emp.getName().chars().mapToObj(a -> (char) a))
				.toList();
		System.out.println("======================================================");
		System.out.println(list4);

	}

}

class Employeee {
	String name;
	int price;
	List<String> courses;

	public Employeee(String name, int price, List<String> courses) {
		super();
		this.name = name;
		this.price = price;
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Employeee [name=" + name + ", price=" + price + ", courses=" + courses + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<String> getCourses() {
		return courses;
	}

	public void setCourses(List<String> courses) {
		this.courses = courses;
	}

}

class CourseName {
	String course;
	String name;

	public CourseName(String course, String name) {
		super();
		this.course = course;
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {

		return this.course + " : " + this.getName();
	}

}
