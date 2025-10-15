import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Library mainLibrary = new Library();
        Librarian ahmed = new Librarian("Ahmed", "Khushab", 12345, "ahmedbilal2857@gmail.com", "AB12345");
        Librarian bilal = new Librarian("Bilal", "Khushab", 98765, "abilal3326@gmail.com", "AB08765");

        Member m1 = new Member("Ahmed", "Khushab", 123, "ahmedbilal@gmail.com", "AB1234", mainLibrary);
        mainLibrary.librarians.add(ahmed);
        mainLibrary.librarians.add(bilal);


        Book b1 = new Book("AB234", "JAVA", 12345, "Ahmed", "Bilal");
        Book b2 = new Book("AB257", "Python", 125, "Ahmed", "Bilal");
        ahmed.add(b1, mainLibrary);
        ahmed.add(b2, mainLibrary);

        ahmed.issueBook(mainLibrary, m1, "JAVA");
        ahmed.issueBook(mainLibrary, m1, "Python");
        for (Transaction t : mainLibrary.transactions) {
            t.displayInfo();
        }

        ahmed.returnBook(mainLibrary, m1, "JAVA");
        for (Transaction t : mainLibrary.transactions) {
            t.displayInfo();
        }

        // m1.displayBorrowed();

    }
    
}
