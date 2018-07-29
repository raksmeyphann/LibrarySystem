package library;

import javax.persistence.*;

@Entity
@Table(name="tblborrow")
	public class BorrowEntity {
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "id")  
		private int id;
		
		@Column(name = "member")  
		private String member;
		
		@Column(name = "book")
		private String book;
		@Column(name="issue")
		private String issue;
		@Column(name = "due")
		private String	due;


		public BorrowEntity(String member, String book, String issue, String due) {
			this.member = member;
			this.book = book;
			this.issue = issue;

			this.due = due;
		}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getDue() {
		return due;
	}

	public void setDoe(String due) {
		this.due = due;
	}

	public String[] toStringData() {
			String data[] = { this.getId() + "" , this.getMember() , this.getBook() , this.getIssue() , this.getDue() } ;
			return data;
		}


	
}
