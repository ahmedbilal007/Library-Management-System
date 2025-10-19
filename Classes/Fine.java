import java.util.Scanner;
public class Fine {
    String fineId;
    String memberID;
    String transactionID;
    int daysLate;
    double fineAmount;
    double finePerDay = 50;
    boolean isPaid;
    private int count = 1;

    public Fine(String m,int daysLate, String transactionId) {
        this.fineId = "FN-" + String.format("%03d", count++);
        this.memberID = m;
        this.daysLate = daysLate;
        this.fineAmount = calculateFine();
        isPaid = false;
        this.transactionID = transactionId;
    }
    
    public double calculateFine() {
        return this.daysLate * this.finePerDay;
    }

    public void markPaid() {
        this.isPaid = true;
    }

    public String displayFineDetails() {
        return String.format("Fine Id: %s\nMember: %s\nTransaction ID: %s\nDays Late: %d\nFine Amount: %f\nPaid: %b",this.fineId, this.memberID, this.transactionID, this.daysLate
        , this.calculateFine(), this.isPaid);
    }

    // public void payFine() {
    //     Scanner input = new Scanner(System.in);
    //     System.out.print("Enter Amount: ");
    //     double amount = input.nextDouble();
    //     System.out.println("Amount Paid.");
    // }


}
