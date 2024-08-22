package java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapOperations {

	public static void main(String[] args) {

		List<Book> books= new ArrayList<>();
		books.add(new Book("RR Martin", "Game of Thrones", "Adventure"));
		books.add(new Book("J.K Rollins", "harry Potter", "Magic"));
		books.add(new Book("Christopher Nolan", "Batman", "Action"));
		books.add(new Book("RR Martin", "Elden Ring", "Mystery"));
		books.add(new Book("J.K Rollins", "Cursed Child", "Horror"));
		
		Map<String, List<Book>> collect = books.stream().collect(Collectors.groupingBy(b->b.author));
		books.stream().collect(Collectors.groupingBy(null));
		System.out.println(collect);
	}
}

class Book {
	String author;
	String bookname;
	String genre;

	
	public Book(String author, String bookname, String genre) {
		super();
		this.author = author;
		this.bookname = bookname;
		this.genre = genre;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Book [author=" + author + ", bookname=" + bookname + ", genre=" + genre + "]";
	}

}
