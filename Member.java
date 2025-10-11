public class Member extends User{
    private String memberID;
    private Book[] borrowedBooks;
    // private Transaction[] borrowingHistory;
    public final int MAX_ALLOWED = 3;
    private int borrowedCount;

    public Member(String name, String address, int contact, String email, String memberID) {
        super(name, address, contact, email);
        this.memberID = memberID;
        this.borrowedBooks = new Book[MAX_ALLOWED];
    }

    public void borrowBook(Library lib, Librarian l1, String title) {
        l1.issueBook(lib, this, title);
    }   


    public void returnBook(Library lib, Librarian l1, String title) {
        l1.returnBook(lib, this, title);
    }
    
    public void displayBorrowed() {
        for (Book b : borrowedBooks) {
            System.out.println(b.getDetails());
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

}
