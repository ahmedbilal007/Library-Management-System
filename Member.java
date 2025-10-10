public class Member extends User{
    private String memberID;
    private Book[] borrowedBooks;
    // private Transaction[] borrowingHistory;
    private final int MAX_ALLOWED = 3;
    private int borrowedCount;

    public Member(String name, String address, int contact, String email, String memberID) {
        super(name, address, contact, email);
        this.memberID = memberID;
        this.borrowedBooks = new Book[MAX_ALLOWED];
    }

    public String borrowBook(Library lib, String title) {
        Book b = Book.getBook(lib, title);
        if (b != null) {
            if (this.borrowedCount < MAX_ALLOWED) {
                this.borrowedBooks[borrowedCount] = b;
                borrowedCount++;
                b.setStatus(false);
                return title + " by " + b.getAuthor() + " borrowed by " + this.getName();
            } else {
                return "Limit Reached.";
            }
        }
        return "Book not found";
    }   


    public String returnBook(Library lib, String title) {
        Book b = Book.getBook(lib, title);
        for (int i = 0; i<borrowedBooks.length; i++) {
            if (borrowedBooks[i].getTitle().equals(title)) {
                borrowedBooks[i] = null;
                borrowedCount--;
                b.setStatus(true);
                return "Book Returned";
            }
        }
        return "Book not found";
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


}
