import java.time.*;

public class Transaction {
    private String transactionID;
    private String memberID;
    private String bookId;
    private boolean isReturned;
    private double fineAmount;
    private static int count = 1;
    LocalDate issueDate;
    LocalDate dueDate;
    LocalDate returnedDate;
    Fine fine;


    public Transaction(String memberID, String bookId, boolean isReturned, Library l1) {
        this.transactionID = "CTS-LHR-" + String.format("%03d", count++);
        this.memberID = memberID;
        this.bookId = bookId; 
        this.isReturned = isReturned;

        issueDate = LocalDate.now();
        dueDate = issueDate.plusDays(15);


        Period p = Period.between(dueDate, LocalDate.now());
        int days = p.getDays();
        if (days > 0) { 
            fine = new Fine(memberID, days, this.transactionID);
            l1.fines.add(fine);
        } else fine = null;
    } 

    public void displayInfo() {
        System.out.println();
        System.out.println("Transaction ID: " + this.transactionID);
        System.out.println("Member ID: " + this.memberID);
        System.out.println("Book ID: " + this.bookId);
        System.out.println("Status: " + isReturned);
        System.out.println("Issuing Date: " + this.issueDate);
        System.out.println("Due Date: " + this.dueDate);
        System.out.println("Date of Returning: " + this.returnedDate);
        if (fine != null) System.out.println("Fine Amount: " + this.fine.calculateFine());
        System.out.println();
    }

    public void setMemberId(String id) {this.memberID = id;}
    public void setISBN(String id) {this.bookId = id;}
    public void setStatusOfTransaction(boolean status) {this.isReturned = status;}

    public String getMemberID() {return this.memberID;}
    public String getBookid() {return this.bookId;}
    public boolean getStatus() {return this.isReturned;}
    
}
