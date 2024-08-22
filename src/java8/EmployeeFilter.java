//package java8;
//
//import java.util.AbstractMap;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Map;
//import java.util.Map.Entry;
//import java.util.stream.Collectors;
//
//public class EmployeeFilter {
//
//	public static void main(String[] args) {
//
//		Employee e1 = new Employee("N1", 29, 301000, Arrays.asList("nagpur", "pune", "mumbai"));
//		Employee e3 = new Employee("N2", 28, 302, Arrays.asList("nagpur", "pune"));
//		Employee e6 = new Employee("N3", 27, 302, Arrays.asList("nagpur", "pune", "mumbai", "delhi"));
//		Employee e5 = new Employee("N4", 28, 3069, Arrays.asList("nagpur", "pune", "mumbai", "delhi"));
//		Employee e2 = new Employee("N5", 25, 305, Arrays.asList("nagpur"));
//		Employee e4 = new Employee("N6", 30, 3069, Arrays.asList("bhopal", "pune", "mumbai", "delhi"));
//		Employee e8 = new Employee("N8", 31, 306, Arrays.asList("jaipur", "pune", "mumbai", "delhi"));
//
//		List<Employee> emps = new ArrayList<>();
//		emps.add(e1);
//		emps.add(e2);
//		emps.add(e3);
//		emps.add(e4);
//		emps.add(e5);
//		emps.add(e6);
//		emps.add(e8);
//
//		Map<String, List<CityEmployee>> collect = emps.stream()
//				.flatMap(e -> e.getCities().stream().map(city -> new CityEmployee(city, e)))
//				.collect(Collectors.groupingBy(CityEmployee::getCity));
//
//		Map<String, Long> count = emps.stream()
//				.flatMap(e -> e.getCities().stream().map(city -> new CityEmployee(city, e)))
//				.collect(Collectors.groupingBy(CityEmployee::getCity, Collectors.counting()));
//
//		count.entrySet().forEach(e -> System.out.println(e));
//
//		collect.entrySet().forEach(e -> System.out.println(e));
//		
//		Map<String, List<CityEmployee>> collect2 = emps.stream().flatMap(e->e.getCities().stream().map(city->new CityEmployee(city, e)))
//		.collect(Collectors.groupingBy(CityEmployee::getCity));
//		
//		for(Entry<String, List<CityEmployee>> entry : collect2.entrySet()) {
//			System.out.println(entry.getKey());
//			System.out.println(entry.getValue());
//			System.out.println("-------------------------------------------------------------------------");
//		}
//
//	}
//}
//
//class Employee {
//
//	String firstName;
//	int age;
//	int salary;
//	List<String> cities;
//
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public int getAge() {
//		return age;
//	}
//
//	public void setAge(int age) {
//		this.age = age;
//	}
//
//	public int getSalary() {
//		return salary;
//	}
//
//	public void setSalary(int salary) {
//		this.salary = salary;
//	}
//
//	public List<String> getCities() {
//		return cities;
//	}
//
//	public void setCities(List<String> cities) {
//		this.cities = cities;
//	}
//
//	public Employee(String firstName, int age, int salary, List<String> cities) {
//		super();
//		this.firstName = firstName;
//		this.age = age;
//		this.salary = salary;
//		this.cities = cities;
//	}
//
//	@Override
//	public String toString() {
//		return "Employee [firstName=" + firstName + ", age=" + age + ", salary=" + salary + ", cities=" + cities + "]";
//	}
//
//}
//
//class CityEmployee {
//	String city;
//	Employee employee;
//
//	public CityEmployee(String city, Employee e) {
//		super();
//		this.city = city;
//		this.employee = e;
//	}
//
//	public String getCity() {
//		return city;
//	}
//
//	public void setCity(String city) {
//		this.city = city;
//	}
//
//	@Override
//	public String toString() {
//		return "CityEmployee [city=" + city + ", employee=" + employee + "]";
//	}
//
//}
