import java.util.ArrayList;

public class Library {
    ArrayList<Book> books = new ArrayList<Book>();
    ArrayList<Member> members = new ArrayList<Member>();
    ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    public int booksCount;
    
    public boolean searchBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    public boolean searchMember(String name) {
        for (Member m : members) {
            if (m.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
    Library l1 = new Library();
    Librarian ahmed = new Librarian("Ahmed", "Lahore", 123456, "ahmedbilal@gmail.com", "LB1234");
    Member m1 = new Member("ahmed", "Lahore", 1234, "ahmedbilal", "3456");
    Member m2 = new Member("ahmed", "Lahore", 1234, "ahmedbilal", "876");
    l1.members.add(m1);
    

    Book b1 = new Book("A2343F", "Java", 234,"Muhammad Talha","Ahmed Bilal");
    Book b2 = new Book("234567VD", "C++", 678,"Muhammad Zaid","Amir Hussain");

    ahmed.addMember(l1, m2);
    ahmed.addMember(l1, m2);


    ahmed.add(b1, l1);
    System.out.println(l1.booksCount);
    ahmed.add(b2, l1);
    System.out.println(l1.booksCount);

    
    ahmed.issueBook(l1, m1, "Java");
    for (Transaction t : l1.transactions) t.displayInfo();
    ahmed.returnBook(l1, m1, "Java");
    for (Transaction t : l1.transactions) t.displayInfo();

    ahmed.viewIssued(l1);
    
    }
}



// Librarian -- addMember() -- issue here