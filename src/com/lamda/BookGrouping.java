package com.lamda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookGrouping {

	public static void main(String[] args) {
		
		List<Book> library = new ArrayList<>();
		library.add(new Book("Game Of Thrones", "Robert Martin", "Adventure"));
		library.add(new Book("Attack on Titans", "Niraj Tiwari", "Thriller"));
		library.add(new Book("FT", "Hiro Mashima", "Magic"));
		library.add(new Book("Harry Potter", "J.K. Rollin", "Magic"));
		library.add(new Book("Darwins Game", "Niraj Tiwari", "Thriller"));
		library.add(new Book("Demon Slayer", "Hiro Mashima", "Demon"));
		library.add(new Book("Tokyo Ghoul", "Robert Martin", "Horror"));
		library.add(new Book("Passengers", "J.K. Rollin", "Sci-fi"));
		
		Map<String, Map<String, List<Book>>> category = library.stream()
				.collect(Collectors.groupingBy(l->l.getAuthor(),Collectors.groupingBy(l->l.getGenre())));
		for(Map.Entry<String, Map<String, List<Book>>> entry: category.entrySet()) {
			String author = entry.getKey();
			System.out.println("Author named : "+author);
			Map<String, List<Book>> genreWise = entry.getValue();
			for(Map.Entry<String, List<Book>> e : genreWise.entrySet()) {
				String genre = e.getKey();
				System.out.println("Wrote books on these genres: "+genre);
				List<Book> books = e.getValue();
				for(Book b : books) {
					System.out.println(b);
				}
			}
		}
	}

}
class Book {
    private String title;
    private String author;
    private String genre;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Book(String title, String author, String genre) {
		super();
		this.title = title;
		this.author = author;
		this.genre = genre;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", genre=" + genre + "]";
	}
    
}
