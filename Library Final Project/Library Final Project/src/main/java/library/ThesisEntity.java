package library;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tblthesis")
public class ThesisEntity {
	
	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="publisher")
	private String publisher;
	
	@Column(name="yearPublished")
	private String yearPublished;
	
	@Column(name="writer")
	private String writer;
	
	
	@Column(name="type")
	private String type;

	
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
  
	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	public ThesisEntity(String id, String title, String publisher, String yearPublished, String writer, String type) {

		this.id = id;
		this.title = title;
		this.publisher = publisher;
		this.yearPublished = yearPublished;
		this.writer = writer;
		this.type = type;
	}

	public String[] toStringData()
	{
	
		String data[] = { id,title,publisher,yearPublished,writer,type};
		return data;
	}

	public ThesisEntity() {
		
	}

	
	
}