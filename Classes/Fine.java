public class Fine {
    String fineId;
    String memberID;
    String transactionID;
    int daysLate;
    double fineAmount;
    double finePerDay;
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
        return daysLate*finePerDay;
    }

    public void markPaid() {
        this.isPaid = true;
    }

    public String displayFineDetails() {
        return String.format("Fine Id: %s\nMember: %s\nTransaction ID: %s\nDays Late: %d\nFine Amount: %f\nPaid: %b",this.fineId, this.memberID, this.transactionID, this.daysLate
        , this.fineAmount, this.isPaid);
    }


}
