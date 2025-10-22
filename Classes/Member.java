public class Member extends User{
    private String memberID;
    private Book[] borrowedBooks;
    private final int MAX_ALLOWED = 3;
    private int borrowedCount;

    public Member(String name, String address, int contact, String email, String memberID) {
        super(name, address, contact, email);
        this.memberID = memberID;
        this.borrowedBooks = new Book[MAX_ALLOWED];
    }

    public void borrowBook(Library lib, Librarian l1) {
        l1.issueBook(lib);
    }   


    public void returnBook(Library lib, Librarian l1) {
        l1.returnBook(lib, this);
    }
    
    public void displayBorrowed() {
        for (Book b : borrowedBooks) {
            if (b != null) System.out.println(b.toString());
        }
    }

    public void viewHistory(Library lib) {
        for (Transaction t : lib.getTransactions()) {
            if (t.getMemberID().equals(this.memberID)) {
                System.out.println(t.toString());
            }
        }
    }
    
    @Override
    public String toString() {
        return String.format("--- Member Details ---\n%s\nMember ID: %s", super.toString(), this.getMemberID());
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

    public int getMaxAllowed() {
        return this.MAX_ALLOWED;
    }
}
