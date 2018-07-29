package library;

public class BookModel {
	
	private String id;
	private String title;
	private String publisher;
	private String yearPublished;
	private boolean status;
	public static int count = 0;
	
//	public BookModel(String id, String title, String publisher, String yearPublished) {
//		this.id = id;
//		this.title = title;
//		this.publisher = publisher;
//		this.yearPublished = yearPublished;
////		this.status = status;
//		count ++;
//	}
//	
	
	
	public BookModel(String id, String title, String publisher, String yearPublished, boolean status) {
	
		this.id = id;
		this.title = title;
		this.publisher = publisher;
		this.yearPublished = yearPublished;
		this.status = status;
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






	public static int getCount() {
		return count;
	}






	public static void setCount(int count) {
		BookModel.count = count;
	}






	@Override
	public String toString() {
		return " [id=" + id + ", title=" + title + ", publisher=" + publisher + ", yearPublished="
				+ yearPublished + ", status=" + status + "]";
	}
	
	public String[] toStringData()
	{
		String status = "Available";
 	if(!this.status) status = "Borrowed";
		String data[] = {id,title,publisher,yearPublished,status };
		return data;
	}
	
//	public String toString() {
//		String status = "Available";
//		if(!this.status) status = "Borrowed";
//		return this.id , this.title + "  " + this.publisher + "  " + this.yearPublished + "  " + status;
//	}
	
	

}
