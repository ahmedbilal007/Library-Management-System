import java.util.ArrayList;
public class Library {

    public ArrayList<Book> books = new ArrayList<Book>();
    ArrayList<Member> members = new ArrayList<Member>();
    ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    ArrayList<Librarian> librarians = new ArrayList<Librarian>();

    private int booksCount;

    public void incBookCount() {
        this.booksCount++;
    }

    public void decBookCount() {
        this.booksCount--;
    }
    
    public boolean searchBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    public boolean searchMember(String memberID) {
        for (Member m : members) {
            if (m.getMemberID().equals(memberID)) {
                return true;
            }
        }
        return false;
    }

    // public ArrayList getBooks() {return this.books;}
}

