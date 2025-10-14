public class Transaction {
    public String transactionID;
    public String memberID;
    public int isbn;
    public boolean isReturned;
    public double fineAmount;
    public int transactionCount = 100;

    public Transaction(String memberID, int isbn, boolean isReturned) {
        this.transactionCount = transactionCount + 1;
        this.memberID = memberID;
        this.isbn = isbn; 
        this.isReturned = isReturned;
        // this.transactionCount++;
    } 

    public void displayInfo() {
        System.out.println();
        System.out.println("Transaction ID: " + this.transactionID);
        System.out.println("Member ID: " + this.memberID);
        System.out.println("ISBN Number: " + this.isbn);
        System.out.println("Status: " + isReturned);
        System.out.println();
    }

    
}
