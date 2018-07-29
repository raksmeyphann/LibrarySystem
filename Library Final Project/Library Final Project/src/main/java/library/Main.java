package library;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Library libraries = new Library();
		
		String menuNumber = "";
		do {
			
			// Main menus of program
			System.out.println("---- Program Menus ----------");
			System.out.println("| 1. Add new book      		|");
			System.out.println("| 2. Add new thesis 		|");
			System.out.println("| 3. Add new member        	|");
			System.out.println("| 4. Borrow a book  		|");
			System.out.println("| 5. Return a book  		|");
			System.out.println("| 6. List members       	|");
			System.out.println("| 7. List books by category	|");
			System.out.println("| 8. List of borrowed books	|");
			System.out.println("-----------------------------");
			int mainSelectedMenu = sc.nextInt();
			sc.nextLine();
			switch(mainSelectedMenu) {
				// Add new book
				case 1 :
					String answerBook = "";
					do {
						System.out.println("----------------- Add New Book --------------------\n");
						System.out.println("Enter book id: ");
						String bookID = sc.nextLine();
						System.out.println("Enter book title: ");
						String bookTitle = sc.nextLine();
						System.out.println("Enter book publisher: ");
						String bookPublisher = sc.nextLine();
						System.out.println("Enter book published year: ");
						String bookPublishedYear = sc.nextLine();
						System.out.println("Enter book ISBN: ");
						String bookISBN = sc.nextLine();
						System.out.println("Enter book price: ");
						double bookPrice = sc.nextDouble();
						sc.nextLine();
						System.out.println("Enter book author: ");
						String bookAuthor = sc.nextLine();
						System.out.println("Enter book edition: ");
						int bookEdition = sc.nextInt();
						sc.nextLine();
						
						// Create book object
						BookModel bookObj = new Book(bookID, bookTitle, bookPublisher,
								bookPublishedYear, true, bookISBN, bookPrice,
								bookAuthor, bookEdition);
						libraries.addBook(bookObj);
						
						System.out.println("---------------------------------------------------");
						System.out.println("Book : " + bookTitle + " was successfully added.");
						System.out.println("---------------------------------------------------");
						System.out.println("Do you want to add more book? (Y/N)");
						answerBook = sc.nextLine();
					}while(answerBook.equalsIgnoreCase("Y"));
					break;
				// Add new thesis
				case 2 :
					String answerThesis = "";
					do {
						System.out.println("----------------- Add New Thesis --------------------\n");
						System.out.println("Enter thesis id: ");
						String thesisID = sc.nextLine();
						System.out.println("Enter thesis title: ");
						String thesisTitle = sc.nextLine();
						System.out.println("Enter thesis publisher: ");
						String thesisPublisher = sc.nextLine();
						System.out.println("Enter thesis published year: ");
						String thesisPublishedYear = sc.nextLine();
						System.out.println("Enter thesis writer: ");
						String thesisWriter = sc.nextLine();
						System.out.println("Enter type of thesis: ");
						String thesisType = sc.nextLine();
						
						// Create thesis object
						BookModel thesisObj = new Thesis(thesisID, thesisTitle, thesisPublisher,
								thesisPublishedYear, true, thesisWriter, thesisType);
						libraries.addBook(thesisObj);
						
						System.out.println("---------------------------------------------------");
						System.out.println("Thesis : " + thesisTitle + " was successfully added.");
						System.out.println("---------------------------------------------------");
						System.out.println("Do you want to add more thesis? (Y/N)");
						answerThesis = sc.nextLine();
					}while(answerThesis.equalsIgnoreCase("Y"));
					break;
				// Add new member
				case 3 :
					String answerMember = "";
					do {
						System.out.println("----------------- Add New Member --------------------\n");
						System.out.println("Enter member id: ");
						String memberID = sc.nextLine();
						System.out.println("Enter member name: ");
						String memberName = sc.nextLine();
						System.out.println("Enter member address: ");
						String memberAddress = sc.nextLine();
						System.out.println("Enter date of membership: ");
						String dateOfMembership = sc.nextLine();
						System.out.println("Enter type of membership: ");
						String typeMembership = sc.nextLine();
						
						// Create member object
						Member memberObj = new Member(memberID, memberName, memberAddress, dateOfMembership, typeMembership);
						libraries.addMember(memberObj);
						
						System.out.println("---------------------------------------------------");
						System.out.println("Member : " + memberName + " was successfully added.");
						System.out.println("---------------------------------------------------");
						System.out.println("Do you want to add more member? (Y/N)");
						answerMember = sc.nextLine();
					}while(answerMember.equalsIgnoreCase("Y"));
					break;
				// Borrow a book
				case 4 :
					System.out.println("----------------- Borrow a book --------------------\n");
					System.out.println("Enter member id: ");
					String mID = sc.nextLine();
					Member mObj = libraries.getMember(mID);
					if(mObj != null) {
						System.out.println("Enter book id: ");
						String bID = sc.nextLine();
						BookModel borrowedBook = libraries.getBook(bID);
						if(borrowedBook != null) {
							if(borrowedBook.isStatus()) {
								System.out.println("Enter date of issue: ");
								String dateIssue = sc.nextLine();
								System.out.println("Enter due date: ");
								String dueDate = sc.nextLine();
								// Update status of book
								borrowedBook.setStatus(false);
								// Process to borrow a book
								// Create transaction object
								Transaction tranObj = new Transaction(
										libraries.getAllTransactions().size() + 1,
										mObj,
										borrowedBook,
										dateIssue,
										dueDate
										);
								libraries.addTransaction(tranObj);
								System.out.println("You have successfully borrowed book " + borrowedBook.getTitle() + "\n");
							}else {
								System.out.println("Book with ID " + bID + " is not available for borrow!\n");
							}
						}else {
							System.out.println("Book with ID " + bID + " is not found!\n");
						}
					}else {
						System.out.println("Member with ID " + mID + " is not found!\n");
					}
					System.out.println("---------------------------------------------------");
					break;
				// Return a book
				case 5 :
					System.out.println("----------------- Return a book --------------------\n");
					System.out.println("Enter transaction id: ");
					int tranID = sc.nextInt();
					sc.nextLine();
					Transaction tObj = libraries.getTransaction(tranID);
					if(tObj != null) {
						// update status book to available
						tObj.getBook().setStatus(true);
						String bTitle = tObj.getBook().getTitle();
						// Remove transaction
						libraries.removeTransaction(tObj);
						System.out.println("You have successfully returned book " + bTitle + "\n");
					}else {
						System.out.println("Transaction with ID " + tranID + " is not found!\n");
					}
					System.out.println("---------------------------------------------------");
					break;
				// List members
				case 6 :
					System.out.println("----------------- Member List --------------------\n");
					System.out.println("[ID    Name        Address     Date       Membership]");
					System.out.println("---------------------------------------------------");
					for(Member member : libraries.getAllMembers()){
						System.out.println(member.toString());
					}
					System.out.println("---------------------------------------------------");
					break;
				// List books by category
				case 7 :
					System.out.println("----------------- Book List -------------------------------------------------------------------------\n");
					System.out.println("Total Book : " + BookModel.count);
					System.out.println("-----------------------------------------------------------------------------------------------------\n");
					String bookBody = "";
					String thesisBody = "";
					for(BookModel book : libraries.getAllBooks()){
						if(book instanceof Book)
							bookBody += book.toString() + "\n";
						if(book instanceof Thesis)
							thesisBody += book.toString() + "\n";
					}
					System.out.println("[ID    Title        Publisher     PublishedYear      Status    ISBN      Price     Author      Edition]");
					System.out.println("-------------------------------------------------------------------------------------------------------");
					System.out.println(bookBody);
					System.out.println("-------------------------------------------------------------------------------------------------------\n");
					System.out.println("[ID    Title        Publisher     PublishedYear      Status    Writer      Type]");
					System.out.println("--------------------------------------------------------------------------------");
					System.out.println(thesisBody);
					System.out.println("--------------------------------------------------------------------------------");
					break;
				// List of borrowed books
				case 8 :
					System.out.println("----------------- List of borrowed books --------------------\n");
					System.out.println("[ID    Member        Book     Issue       Due]");
					System.out.println("-------------------------------------------------------------");
					for(Transaction t : libraries.getAllTransactions()) {
						System.out.println(t.toString());
					}
					System.out.println("-------------------------------------------------------------");
					break;
			}
			
			System.out.println("Do you want to continue to Main Menu? (Y/N)");
			menuNumber = sc.next();
		}while(menuNumber.equalsIgnoreCase("Y"));

	}

}
