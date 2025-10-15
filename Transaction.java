import java.time.*;

public class Transaction {
    public String transactionID;
    public String memberID;
    public int isbn;
    public boolean isReturned;
    public double fineAmount;
    private static int count = 1;
    LocalDate issueDate;
    LocalDate dueDate;
    LocalDate returnedDate;
    Fine fine;


    public Transaction(String memberID, int isbn, boolean isReturned) {
        this.transactionID = "LIB-" + String.format("%03d", count++);
        this.memberID = memberID;
        this.isbn = isbn; 
        this.isReturned = isReturned;
        issueDate = LocalDate.now();
        dueDate = issueDate.plusDays(15);

        Period p = Period.between(dueDate, LocalDate.now());
        int days = (p.getYears()*365) + (p.getMonths()*30) + (p.getDays());
        if (days > 0) fine = new Fine(days);
        else fine = null;
        // this.count += 1;
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
    
}
