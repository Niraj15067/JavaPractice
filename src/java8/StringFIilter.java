package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class StringFIilter {

	public static void main(String[] args) {
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer("919359284408", "Niraj", 23));
		customers.add(new Customer("929459284408", "Sumit", 33));
		customers.add(new Customer("9290592484408", "Gaurav", 27));
		customers.add(new Customer("929359184408", "Balli", 30));
		customers.add(new Customer("919359284408", "Pari", 27));
		customers.add(new Customer("919159214408", "Shubhmangi", 30));
		customers.add(new Customer("919159284408", "Sumitranandan", 45));
		Map<String, List<Customer>> collect = customers.stream()
				.collect(Collectors.groupingBy(x -> x.getNumber().substring(0, 2)));
		for (Entry<String, List<Customer>> entry : collect.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		List<String> list = customers.stream().filter(x -> x.getName().length() > 3).map(x -> x.getName().toUpperCase())
				.toList();
		System.out.println(list);
		List<Worker> workers = new ArrayList<>();
		workers.add(new Worker("Niraj", "Backend", 31000));
		workers.add(new Worker("Gaurav", "Backend", 100000));
		workers.add(new Worker("Sumit", "Full stack", 310000));
		workers.add(new Worker("Tejas", "Full stack", 310000));
		workers.add(new Worker("Shubham", "Front End", 31000));
		workers.add(new Worker("Diksha", "Front End", 31000));
		workers.add(new Worker("Harshal", "BA", 71000));
		workers.add(new Worker("Ashit", "Sales", 150000));
		workers.add(new Worker("Palak", "Sales", 150000));
		Map<String, Long> collect2 = workers.stream().collect(Collectors.groupingBy(Worker::getDepartment,Collectors.counting()));
		for (Entry<String, Long> entry : collect2.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		List<Integer> nums = new ArrayList<>();
		
	}
}

class Customer {
	String number;
	String Name;
	int age;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Customer(String number, String name, int age) {
		super();
		this.number = number;
		Name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Customer [number=" + number + ", Name=" + Name + ", age=" + age + "]";
	}

}

class Worker {
	String name;
	String department;
	int salary;

	@Override
	public String toString() {
		return "Worker [name=" + name + ", department=" + department + ", salary=" + salary + "]";
	}

	public Worker(String name, String department, int salary) {
		super();
		this.name = name;
		this.department = department;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}
