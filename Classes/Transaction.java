import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;


public class Transaction {
    private final String transactionID;
    private Member member;
    private Book book;
    private boolean isReturned;
    private static int count = 1;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private LocalDate returnedDate;
    private Fine fine;


    public Transaction(Member member, Book book, boolean isReturned, ArrayList<Transaction> transactions) {
        this.transactionID = "CTS-LHR-" + String.format("%03d", count++);
        this.member = member;
        this.book = book; 
        this.isReturned = isReturned;

        issueDate = LocalDate.now();
        dueDate = issueDate.plusDays(Library.getDAY_ALLOWED());

        int days = (int) ChronoUnit.DAYS.between(dueDate, LocalDate.now());
        if (days > 0) { 
            fine = new Fine(member, days, this);
        } else fine = null;
    } 

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String issued = (this.issueDate != null) ? issueDate.format(fmt) : "N/A";
        String due = (this.dueDate != null) ? dueDate.format(fmt) : "N/A";
        String returned =  (this.returnedDate != null) ? this.returnedDate.format(fmt) : "Not Returned";
        String fineA = (fine != null) ? String.format("%.2f", this.fine.calculateFine()) : "No Fine";

        return String.format("\n--- Transaction Details ---\nTransaction ID: %s\nMember ID: %s\nBook ID: %s\nStatus: %b\nIssuing Date: %s\nDue Date: %s\nReturn Date: %s\nFine Amount: %s", 
        this.transactionID, this.member.getMemberID(), this.book.getBookID(), this.isReturned, issued, due, returned, fineA);
    }

    public void setStatusOfTransaction(boolean status) {this.isReturned = status;}

    public void setReturned()  {
        this.returnedDate = LocalDate.now();
    }

    public Fine getFine() {
        return this.fine;
    }

    public Member getMember() {return this.member;}
    public Book getBook() {return this.book;}
    public boolean getStatus() {return this.isReturned;}
    public String getTransactionID() {return this.transactionID;}
    
}
