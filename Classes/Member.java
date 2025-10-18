import java.util.ArrayList;

public class Member extends User{
    private String memberID;
    private Book[] borrowedBooks;
    private ArrayList<Transaction> borrowingHistory = new ArrayList<Transaction> ();
    private final int MAX_ALLOWED = 3;
    private int borrowedCount;

    public Member(String name, String address, int contact, String email, String memberID, Library lib) {
        super(name, address, contact, email);
        this.memberID = memberID;
        this.borrowedBooks = new Book[MAX_ALLOWED];
        if (lib.searchbyID(memberID) == false) lib.members.add(this);
        else System.out.println("Member Already Added");
    }

    public void borrowBook(Library lib, Librarian l1) {
        l1.issueBook(lib);
    }   


    public void returnBook(Library lib, Librarian l1) {
        l1.returnBook(lib, this);
    }
    
    public void displayBorrowed() {
        for (Book b : borrowedBooks) {
            if (b != null) System.out.println(b.getDetails());
        }
    }

    public void viewHistory() {
        for (Transaction t : borrowingHistory) {
            t.displayInfo();
        }
    }
    
    public String displayDetails() {
        return String.format("--- Member Details ---\nName: %s\nID: %s\n", this.getName(), this.getMemberID());
    }

    public String getMemberID() {
        return this.memberID;
    }    

    public Book[] getBorrowedBooks() {
        return this.borrowedBooks;
    }

    public int getBorrowedCount() {
        return this.borrowedCount;
    }

    public void incBorrowedCount() {
        this.borrowedCount++;
    }

    public void decBorrowedCount() {
        this.borrowedCount--;
    }

    public ArrayList<Transaction> getBorrowingHistory() {
        return borrowingHistory;
    }

    public int getMaxAllowed() {
        return this.MAX_ALLOWED;
    }
}
