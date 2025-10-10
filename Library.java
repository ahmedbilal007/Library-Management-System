
import java.util.ArrayList;

public class Library {
    ArrayList<Book> books = new ArrayList<Book>();
    public static void main(String[] args) {
    Library l1 = new Library();
    Librarian ahmed = new Librarian("Ahmed", "Lahore", 123456, "ahmedbilal@gmail.com", "LB1234");

    ahmed.addBook(l1);
    System.out.println(l1.books.toString());
    }
}
