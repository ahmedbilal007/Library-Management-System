import java.util.ArrayList;

// Library Member Class inherited from User Class
public class Member extends User{
    private String memberID;
    private Book[] borrowedBooks;
    private int borrowedCount;

    public Member(String name, String address, String contact, String email, String memberID) {
        super(name, address, contact, email);       // super class constructor
        this.memberID = memberID;
        this.borrowedBooks = new Book[Library.getMaxAllowed()];
    }
    
    public String displayBorrowed() {
        String borrowed = "";
        for (Book book : borrowedBooks) {
            if (book != null) borrowed += book.toString() + "\n";
        }
        return borrowed;
    }

    public String viewTransactionHistory(ArrayList<Transaction> transactions) {
        String memberTransaction = "";
        for (Transaction transaction : transactions) {
            if (transaction.getMemberID().equals(this.memberID)) {
                memberTransaction += transaction.toString();
            }
        }
        return memberTransaction;
    }
    
    @Override
    public String toString() {
        return String.format("\n--- Member Details ---\n%s\nMember ID: %s", super.toString(), this.getMemberID());
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
