import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Library mainLibrary = new Library();
        Librarian ahmed = new Librarian("Ahmed", "Khushab", 12345, "ahmedbilal2857@gmail.com", "AB12345");
        Librarian bilal = new Librarian("Bilal", "Khushab", 98765, "abilal3326@gmail.com", "AB08765");

        mainLibrary.librarians.add(ahmed);
        mainLibrary.librarians.add(bilal);

        System.out.println("------ LIBRARY MANAGEMENT SYSTEM ------");
        System.out.println();
        System.out.println("----------- USERS LOGIN PAGE ----------");
        System.out.println();

        System.out.println("Enter your Email: ");
        String email = input.nextLine();
        System.out.println("Enter your ID: ");
        String id = input.nextLine();

    }
    
}
