public class Fine {
    int amountPerDay = 50;
    int totalFine;
    int days;
    public Fine(int days) {
        this.days = days;
    }
    
    public int calculateFine() {
        return days * amountPerDay;
    }

}
