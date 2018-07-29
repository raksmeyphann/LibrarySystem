package library;

public class Thesis extends BookModel {
	
	private String writer;
	private String type;
	
	public Thesis(String id, String title, String publisher, 
		String yearPublished, boolean status, String writer, String type) {
		
		super(id, title, publisher, yearPublished, status);
		this.writer = writer;
		this.type = type;
	}
	
	public String toString() {
		return super.toString() + "  " + this.writer + "  " + this.type;
	}

}
