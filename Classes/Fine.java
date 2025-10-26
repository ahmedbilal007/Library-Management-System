public class Fine {
    private String fineId;
    private String memberID;
    private String transactionID;
    private int daysLate;
    private double fineAmount;
    private boolean isPaid;
    private static int count = 1;

    public Fine(String memId,int daysLate, String transactionId) {
        this.fineId = "FN-" + String.format("%03d", count++);
        this.memberID = memId;
        this.daysLate = daysLate;
        this.fineAmount = calculateFine();
        isPaid = false;
        this.transactionID = transactionId;
    }
    
    public double calculateFine() {
        return this.daysLate * Library.getFinePerDay();
    }


    @Override
    public String toString() {
        return String.format("Fine Id: %s\nMember: %s\nTransaction ID: %s\nDays Late: %d\nFine Amount: %f\nPaid: %b",this.fineId, this.memberID, this.transactionID, this.daysLate
        , this.calculateFine(), this.isPaid);
    }

    public String getFineId() {
        return fineId;
    }

    public void setFineId(String fineId) {
        this.fineId = fineId;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public int getDaysLate() {
        return daysLate;
    }

    public void setDaysLate(int daysLate) {
        this.daysLate = daysLate;
    }

    public double getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(double fineAmount) {
        this.fineAmount = fineAmount;
    }

    public boolean isIsPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
