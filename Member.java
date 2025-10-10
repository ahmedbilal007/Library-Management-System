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

    public String displayDetails() {
        return String.format("--- Member Details ---\nName: %s\nID: %s\nBorrowed Books: %s", this.getName(), this.getMemberID(),getBorrowedBooks());
    }

    public String getMemberID() {
        return this.memberID;
    }    

    public Book[] getBorrowedBooks() {
        return this.borrowedBooks;
    }


}
