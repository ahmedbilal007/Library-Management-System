public class Fine {
    private String fineId;
    private Member member;
    private Transaction transaction;
    private int daysLate;
    private double fineAmount;
    private boolean isPaid;
    private static int count = 1;

    public Fine(Member member,int daysLate, Transaction transaction) {
        this.fineId = "FN-" + String.format("%03d", count++);
        this.member = member;
        this.daysLate = daysLate;
        this.fineAmount = calculateFine();
        isPaid = false;
        this.transaction = transaction;
    }
    
    public double calculateFine() {
        return this.daysLate * Library.getFinePerDay();
    }


    @Override
    public String toString() {
        return String.format("Fine Id: %s\nMember: %s\nTransaction ID: %s\nDays Late: %d\nFine Amount: %f\nPaid: %b",this.fineId, this.member.getMemberID(), this.transaction.getTransactionID(), this.daysLate
        , this.calculateFine(), this.isPaid);
    }

    public String getFineId() {
        return fineId;
    }

    public Member getMember() {
        return member;
    }


    public int getDaysLate() {
        return daysLate;
    }
    
    public double getFineAmount() {
        return fineAmount;
    }


    public boolean isPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public int getCount() {
        return count;
    }

}
