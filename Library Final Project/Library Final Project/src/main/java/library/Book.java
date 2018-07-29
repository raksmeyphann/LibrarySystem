package library;

import java.util.Arrays;

public class Book extends BookModel {

	private String ISBN;
	private double price;
	private String author;
	private int edition;
	

	public String toString() {
		return super.toString() + "  " + this.ISBN + "  " + this.price + "  " + this.author + "  " + this.edition;
	}

	public Book(String id, String title, String publisher, String yearPublished, boolean status,String ISBN, 
			double price, String author, int edition) {
		super(id, title, publisher, yearPublished, status);
		this.ISBN = ISBN;
		this.price = price;
		this.author = author;
		this.edition = edition;
	
	}


}
