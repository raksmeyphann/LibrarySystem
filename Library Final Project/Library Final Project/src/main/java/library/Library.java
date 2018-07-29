package library;

import java.util.HashMap;
import java.util.ArrayList;

public class Library {

	private HashMap<String, BookModel> books;
	private HashMap<String, Member> members;
	private ArrayList<Transaction> transactions;
	
	public Library() {
		books = new HashMap<String, BookModel>();
		members = new HashMap<String, Member>();
		transactions = new ArrayList<Transaction>();
	}
	
	public void addBook(BookModel book) {
		this.books.put(book.getId(), book);
	}
	
	public BookModel getBook(String bookID) {
		return this.books.get(bookID);
	}
	
	public ArrayList<BookModel> getAllBooks(){
		ArrayList<BookModel> books = new ArrayList<BookModel>(this.books.values());
		return books;
	}
	
	public void addMember(Member member) {
		this.members.put(member.getID(), member);
	}
	
	public Member getMember(String memberID) {
		return this.members.get(memberID);
	}
	
	public ArrayList<Member> getAllMembers(){
		ArrayList<Member> members = new ArrayList<Member>(this.members.values());
		return members;
	}
	
	public void addTransaction(Transaction t) {
		this.transactions.add(t);
	}
	
	public void removeTransaction(Transaction t) {
		this.transactions.remove(t);
	}
	
	public Transaction getTransaction(int tranID) {
		for(Transaction t : this.transactions) {
			if(t.getID() == tranID) {
				return t;
			}
		}
		return null;
	}
	
	public ArrayList<Transaction> getAllTransactions(){
		return this.transactions;
	}
	
}
