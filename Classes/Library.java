import java.util.ArrayList;
import java.util.Scanner;
public class Library {

    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Member> members = new ArrayList<>();
    ArrayList<Transaction> transactions = new ArrayList<>();
    ArrayList<Librarian> librarians = new ArrayList<>();

    private int booksCount;

    public void incBookCount() {
        this.booksCount++;
    }

    public void decBookCount() {
        this.booksCount--;
    }
    
    public boolean searchBook() {
        boolean found = false;
        System.out.println("Search Book by: \n1. Title\n2. Book ID\n3. Book ISBN");
        System.out.println("Enter your choice: ");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        input.nextLine();
        switch (choice) {
            case 1: {
                System.out.print("Enter Book Title: ");
                String title = input.nextLine();
                for (Book b : books) {
                    if (b.getTitle().equals(title)) {
                    System.out.println("Book Found.");
                    System.out.println(b.getDetails());
                    return true;
                } 
                }
                break;
            }
            case 2: {
                System.out.print("Enter Book ID: ");
                String id = input.nextLine();
                for (Book b : books) {
                    if (b.getBookID().equals(id)) {
                        System.out.println("Book Found.");
                        System.out.println(b.getDetails());
                        return true;
                    }
                }
                break;
            }
            case 3: 
            {
                System.out.print("Enter Book ISBN: ");
                int isbn = input.nextInt();
                for (Book b : books) {
                    if (b.getISBN() == isbn) {
                        System.out.println("Book Found.");
                        b.getDetails();
                        return true;
                    }
            }
            break;
            }
            default: {
                System.out.println("Invalid Input.");
                break;
            }
        }
        return false;
    }

    public boolean searchbyID(String id) {
        for (Member m : members) {
            if (m.getMemberID().equals(id)) return true;
        }
        return false;
    }
    public boolean searchMember() {
        Scanner input = new Scanner(System.in);
        System.out.println("Search Member By: \n1. Name \n2. Member ID: ");
        System.out.print("Enter your Choice: ");
        int choice = input.nextInt();

        switch (choice) {
            case 1: {
                System.out.print("Enter Member Name: ");
                String name = input.nextLine();
                for (Member m : members) {
                    if (m.getName().equals(name)) {
                        m.displayDetails();
                        return true;
                    }
                }
                break;
            }
            case 2: {
                System.out.println("Enter Member ID: ");
                String mID = input.nextLine();
                for (Member m : members) {
                    if (m.getMemberID().equals(mID)) {
                        m.displayDetails();
                        return true;
                    }
                }
            }
        }
        
        return false;
    }

}

