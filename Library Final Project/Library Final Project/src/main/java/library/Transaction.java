package library;

public class Transaction {
	
	private int id;
	private Member member;
	private BookModel book;
	private String dateOfIssue;
	private String dueDate;
	
	public Transaction(int id, Member member, BookModel book, String dateOfIssue, String dueDate) {
		this.id = id;
		this.member = member;
		this.book = book;
		this.dateOfIssue = dateOfIssue;
		this.dueDate = dueDate;
	}
	
	public int getID() {
		return this.id;
	}
	
	public BookModel getBook() {
		return this.book;
	}
	
	public String toString() {
		return this.id + "   '" + this.member.getName() + "'   '" + this.book.getTitle() + "'   "
				+ this.dateOfIssue + "   " + this.dueDate;
	} 

}
