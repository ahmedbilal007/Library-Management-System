import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;


public class Transaction {
    private final String transactionID;
    private String memberID;
    private String bookId;
    private boolean isReturned;
    private static int count = 1;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private LocalDate returnedDate;
    private Fine fine;


    public Transaction(String memberID, String bookId, boolean isReturned, ArrayList<Transaction> transactions) {
        this.transactionID = "CTS-LHR-" + String.format("%03d", count++);
        this.memberID = memberID;
        this.bookId = bookId; 
        this.isReturned = isReturned;

        issueDate = LocalDate.now();
        dueDate = issueDate.plusDays(Library.getDAY_ALLOWED());

        int days = (int) ChronoUnit.DAYS.between(dueDate, LocalDate.now());
        if (days > 0) { 
            fine = new Fine(memberID, days, this.transactionID);
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
        this.transactionID, this.memberID, this.bookId, this.isReturned, issued, due, returned, fineA);
    }

    public void setMemberId(String id) {this.memberID = id;}
    public void setbookID(String id) {this.bookId = id;}
    public void setStatusOfTransaction(boolean status) {this.isReturned = status;}

    public void setReturned()  {
        this.returnedDate = LocalDate.now();
    }

    public Fine getFine() {
        return this.fine;
    }

    public String getMemberID() {return this.memberID;}
    public String getBookid() {return this.bookId;}
    public boolean getStatus() {return this.isReturned;}
    
}
