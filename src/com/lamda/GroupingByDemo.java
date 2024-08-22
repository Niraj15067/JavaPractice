package com.lamda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class GroupingByDemo {

	public static void main(String[] args) {

		ArrayList<Integer> arr=new ArrayList<>();

		arr.add(1);

		arr.add(2);

		arr.add(4);

		arr.add(3);

		arr.add(6);

		arr.add(5);

		arr.add(8);

		

		System.out.println(arr);

		

		List<Student> students = new ArrayList<>();

		students.add(new Student("1","Xaurav",20,200));

		students.add(new Student("2","Aaurav",21,300));

		students.add(new Student("3","Baurav",21,500));

		students.add(new Student("4","Caurav",22,203));

		students.add(new Student("5","Daurav",23,220));

		students.add(new Student("6","Eaurav",23,600));

		students.add(new Student("7","Faurav",20,300));

		students.add(new Student("8","Gaurav",223,200));

		students.add(new Student("9","Haurav",28,500));

		students.add(new Student("10","Iaurav",29,234));

		//students.stream().filter(a->a.getAge()==20).map(a->a.setAge(30));

		//get student with marks greater than 500	
		List<Student> greater = students.stream().filter(a->a.getMarks()>500).collect(Collectors.toList());
		System.out.println(greater);
		//get student names with id less than 7
		List<Student> less = students.stream().filter(a->Integer.valueOf(a.getRollNo())>7).collect(Collectors.toList());
		System.out.println(less);
		//group student by even or odd id 
		List<Student> even = students.stream().filter(a->Integer.parseInt(a.getRollNo())%2==0).toList();
		System.out.println("Even: "+even);
		System.out.println("----------------------------");
		List<Student> odd = students.stream().filter(a->Integer.parseInt(a.getRollNo())%2==1).toList();
		System.out.println("odd:  "+odd);
		System.out.println("----------------------------");
		//in above question find output as number of student having even and odd ids
		int evenCount = students.stream().mapToInt(a->Integer.parseInt(a.getRollNo())%2==0?1:0).sum();
		System.out.println("Even count is: "+evenCount);
		System.out.println("----------------------------");
		int oddCount = students.stream().mapToInt(a->Integer.parseInt(a.getRollNo())%2==1?1:0).sum();
		System.out.println("Odd count is: "+oddCount);
		System.out.println("----------------------------");
		//in above question find total marks of student having even and odd number
		int evenMarkStudents = students.stream().mapToInt(a->a.getMarks()%2==0?1:0).sum();
		System.out.println("even marks students count: "+evenMarkStudents);
		System.out.println("----------------------------");
		int oddMarkStudents = students.stream().mapToInt(a->a.getMarks()%2==1?1:0).sum();
		System.out.println("odd marks students: "+oddMarkStudents);
		System.out.println("----------------------------");
		//group student by markrange 0-100 100-200 200-300 and so on    lower order inclusive until max mark which is 900
		
		Map<String, List<Student>> rangeWise = new HashMap<>();
		students.stream().forEach(a->{
			int marks = a.getMarks();
//			int lowerBound = (marks%100)>0?(marks/100)*100:(marks/100)-1*100;
			int lowerBound = (marks/100)*100;
			int upperBound = lowerBound + 100;
			String key = lowerBound+"-"+upperBound;
			if(rangeWise.containsKey(key)) {
				List<Student> list = rangeWise.get(key);
				list.add(a);
			}else {
				List<Student> list = new ArrayList<>();
				list.add(a);
				rangeWise.put(key, list);
			}
		});	
		for(Entry<String, List<Student>> entry : rangeWise.entrySet()) {
			List<Student> stu = entry.getValue();
			System.out.println("In range: "+entry.getKey()+" we have: ");
			System.out.println(stu);
		}
		
		//Even and odd list marks according to id.
		Map<Boolean, List<Student>> eo = students.stream().collect(Collectors.
				partitioningBy(a->Integer.parseInt(a.getRollNo())%2==0?true:false));
		
		Map<String, List<Student>> str = students.stream().collect(Collectors.groupingBy(a->a.getMarks()%2==0?"even":"odd"));
//		Map<String, List<Student>> s = students.stream();
		
		System.out.println("--------------------------------------------------------");
		for(Entry<Boolean, List<Student>> entry : eo.entrySet()) {
			List<Student> stu = entry.getValue();
			System.out.println("Type : "+entry.getKey()+" we have: ");
			System.out.println(stu);
		}
		//same age group together
		Map<Integer, List<Student>> ages = students.stream().collect(Collectors.groupingBy(s->s.getAge()));
		for(Map.Entry<Integer, List<Student>> entry : ages.entrySet()) {
			System.out.println("For age "+entry.getKey()+" we have following students: ");
			List<Student> list = entry.getValue();
			for(Student s:list) {
				System.out.println(s);
			}
		}
	}
}
class Student {
	String rollNo;
	String name;
	int age;
	int marks;
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", age=" + age + ", marks=" + marks + "]";
	}
	public Student(String rollNo, String name, int age, int marks) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.age = age;
		this.marks = marks;
	}
	
}
