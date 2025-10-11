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
        this.transactionCount++;
    } 

    public void displayInfo() {
        System.out.println(this.transactionCount + " : " + this.memberID + " : " + this.isbn + " : " + this.isReturned + " : " + this.transactionCount);
    }
}
