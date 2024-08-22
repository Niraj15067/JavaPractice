package comprable_comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Demo {

	public static void main(String[] args) {
		ComparatorFactory comparatorFactory = new ComparatorFactory();
		List<Movie> asList = Arrays.asList(new Movie("AOT", 3, 2002), new Movie("One piece", 5, 1996),
				new Movie("Code geass", 4, 2006));

//		Collections.swa
//		NameCompare nameComparator = comparatorFactory.getNameComparator();
//		Collections.sort(asList, nameComparator);
		System.out.println("sorting by using name comparator: ");
		asList.stream().forEach(x -> System.out.println(x));
//		Collections.sort(asList);
//		asList.stream().forEach(x -> System.out.println(x));
//
//		Collections.sort(asList, comparatorFactory.getRatingComparator());
//		System.out.println(asList);

	}

}

class Movie implements Comparable<Movie> {
	String name;
	int rating;
	int year;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Movie(String name, int rating, int year) {
		super();
		this.name = name;
		this.rating = rating;
		this.year = year;
	}

	@Override
	public String toString() {
		return "Movie [name=" + name + ", rating=" + rating + ", year=" + year + "]";
	}

	@Override
	public int compareTo(Movie o) {

		return o.year - this.year;
	}

}
