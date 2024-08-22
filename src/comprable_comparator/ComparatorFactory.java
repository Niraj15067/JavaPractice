package comprable_comparator;

import java.util.Comparator;

//create as many comparators as required and create methods to return the comparator which is required.
public class ComparatorFactory {
	public RatingCompare getRatingComparator() {
		return new RatingCompare();
	}

	public NameCompare getNameComparator() {
		return new NameCompare();
	}

}

class RatingCompare implements Comparator<Movie> {

	@Override
	public int compare(Movie o1, Movie o2) {
		return o1.rating - o2.rating;
	}

}
class NameCompare implements Comparator<Movie> {

	@Override
	public int compare(Movie o1, Movie o2) {
		return o1.getName().compareTo(o2.getName());
	}

}