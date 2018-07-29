package library;


import javax.persistence.*;


@Entity
@Table(name="tblbook")
public class BookEntity {
	
	@Id
	@Column(name = "id")  
	private String id;
	
	@Column(name = "title")  
	private String title;
	
	@Column(name = "publisher")
	private String publisher;
	
	@Column(name = "yearPublished")
	private String yearPublished;

	
	@Column(name="ISBN")
	private String ISBN;
	
	@Column(name="price")
	private double price;
	
	@Column(name="author")
	private String author;
	
	@Column(name="edition")
	private int edition;
	@Column(name="status")
	private boolean status;

	public BookEntity(String id, String title, String publisher, String yearPublished,String iSBN,
			double price, String author, int edition, boolean status)
	{
	
		this.id = id;
		this.title = title;
		this.publisher = publisher;
		this.yearPublished = yearPublished;
		ISBN = iSBN;
		this.price = price;
		this.author = author;
		this.edition = edition;
		this.status=status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getYearPublished() {
		return yearPublished;
	}

	public void setYearPublished(String yearPublished) {
		this.yearPublished = yearPublished;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}


	
public String[] toStringData()
	{
	
		String data[] = { this.getId(),this.getTitle(),this.getPublisher(),this.getYearPublished() ,this.ISBN, this.price + "" ,this.author, this.edition + "" };
		return data;
	}

	public BookEntity() {
		
	}
	
	
	
	
	
	
	
	
}
