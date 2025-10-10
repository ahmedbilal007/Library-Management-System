import java.util.ArrayList;

public class Library {
    ArrayList<Book> books = new ArrayList<Book>();
    ArrayList<Member> members = new ArrayList<Member>();
    public int booksCount;
    
    public boolean searchBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
    Library l1 = new Library();
    Librarian ahmed = new Librarian("Ahmed", "Lahore", 123456, "ahmedbilal@gmail.com", "LB1234");
    Member m1 = new Member("ahmed", "Lahore", 1234, "ahmedbilal", "e56789l");
    ahmed.addBook(l1);
    ahmed.addBook(l1);

    
    System.out.print(m1.borrowBook(l1, "Java"));
    ahmed.removeBook(l1, "Java");
    

    }
}



// Library --- Issue Book -- transaction ///