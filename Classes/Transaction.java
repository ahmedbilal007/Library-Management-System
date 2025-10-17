import java.time.*;

public class Transaction {
    private String transactionID;
    private String memberID;
    private int isbn;
    private boolean isReturned;
    private double fineAmount;
    private static int count = 1;
    LocalDate issueDate;
    LocalDate dueDate;
    LocalDate returnedDate;
    Fine fine;


    public Transaction(String memberID, int isbn, boolean isReturned) {
        this.transactionID = "CTS-LHR-" + String.format("%03d", count++);
        this.memberID = memberID;
        this.isbn = isbn; 
        this.isReturned = isReturned;
        issueDate = LocalDate.now();
        dueDate = issueDate.plusDays(15);

        Period p = Period.between(dueDate, LocalDate.now());
        int days = (p.getYears()*365) + (p.getMonths()*30) + (p.getDays());
        if (days > 0) fine = new Fine(days);
        else fine = null;
    } 

    public void displayInfo() {
        System.out.println();
        System.out.println("Transaction ID: " + this.transactionID);
        System.out.println("Member ID: " + this.memberID);
        System.out.println("ISBN Number: " + this.isbn);
        System.out.println("Status: " + isReturned);
        System.out.println("Issuing Date: " + this.issueDate);
        System.out.println("Due Date: " + this.dueDate);
        System.out.println("Date of Returning: " + this.returnedDate);
        if (fine != null) System.out.println("Fine Amount: " + fine.calculateFine());
        System.out.println();
    }

    public void setMemberId(String id) {this.memberID = id;}
    public void setISBN(int isbn) {this.isbn = isbn;}
    public void setStatusOfTransaction(boolean status) {this.isReturned = status;}

    public String getMemberID() {return this.memberID;}
    public int getisbn() {return this.isbn;}
    public boolean getStatus() {return this.isReturned;}
    
}
