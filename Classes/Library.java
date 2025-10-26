import java.util.ArrayList;
public class Library {


    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Transaction> transactions = new ArrayList<>();
    private Librarian supervisor = new Librarian("Ahmed", "Lahore", "12345", "bilal235@gmail.com", "SP23456");
    private static final int MAX_ALLOWED = 3;
    private static int DAYS_ALLOWED = 30;
    private static final int FINE_PER_DAY = 50;
    private Librarian librarian = null;
    private int booksCount;
    private static double totalFine;
     

    public void incBookCount() {
        this.booksCount++;
    }

    public void decBookCount() {
        this.booksCount--;
    }

    public static boolean isEmailValid(String email){
        return email.endsWith("@gmail.com");
        // return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    public boolean adminLogin(String username, int password){
        String adminUName = "@ahmed";
        int admPass = 1234;
        if (!username.equals(adminUName) || (password != admPass)) {
            return false;
        }
        return true;
    }

    public Librarian librarianLogin(String username, String id){
        if (librarian == null) {return null;}
        if (username.equals(this.librarian.getName()) && id.equals(this.librarian.getLibrarianID())) {
            return this.librarian;
        }
        return null;
    }

    public Member memberLogin(String userName, String id, ArrayList<Member> members) {
        if (members.isEmpty() == true) return null;
        for (Member memb : members) {
            if (memb.getName().equals(userName) && memb.getMemberID().equals(id)) return memb;
        }
        return null;
    }
    
    public boolean searchMemberbyID(String id) {
        for (Member m : members) {
            if (m.getMemberID().equals(id)) return true;
        }
        return false;
    }

    public boolean searchBookbyID(String id) {
        for (Book b : books)  {
            if (b.getBookID().equals(id)) 
            return true;
        }
        return false;
    }
    

    public String showAllBooks() {
        String bookData = "";
        for (Book b : books)  {
            bookData += b.toString();
        }
        return bookData;
    }

    public String showAllMembers() {
        String memberData = "";
        for (Member m : members) {
            memberData += m.toString();
        }
        return memberData;
    }


    public String addLibrarian(String name, String address, String contact, String email, String librarianID) {
        this.librarian = new Librarian(name, address, contact, email, librarianID);
        assignSupervisor(librarian);
        return "Librarian Added Successfully";
    }


    public void assignSupervisor(Librarian llLibrarian) {
        if (supervisor != null) {
            librarian.setSupervisor(supervisor);
        }
    }

    public String displayTransactions() {
        String transactionHistory = "";
        for (Transaction t : transactions) {
            transactionHistory += t.toString();
        }
        return transactionHistory;
    }

    public void displayFineHistory() {
        for (Transaction t : transactions) {
            if (t.getFine() != null) {
                System.out.println(t.getFine().toString());
            }
        }
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public Librarian getSupervisor() {
        return supervisor;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public int getBooksCount() {
        return booksCount;
    }

    public boolean duplicateEmail(String email) {
        for (Member m : members) {
            if (m.getEmail().equals(email)) return true;
        }
        return false;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }

    public static int getMaxAllowed() {
        return MAX_ALLOWED;
    }

    public static void setDAY_ALLOWED(int DAY_ALLOWED) {
        Library.DAYS_ALLOWED = DAY_ALLOWED;
    }

    public static int getDAY_ALLOWED()  {
        return DAYS_ALLOWED;
    }
    public static int getMAX_ALLOWED() {
        return MAX_ALLOWED;
    }

    public static void setTotalFine(double totalFine) {
        Library.totalFine = totalFine;
    }

    public static double getTotalFine() {
        return totalFine;
    }

    public static int getFinePerDay() {
        return FINE_PER_DAY;
    }
}

