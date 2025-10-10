import java.util.Scanner;
public class Librarian extends User{ 
    Scanner input = new Scanner(System.in);
    private String librarianID;

    public Librarian(String name, String address, int contact, String email, String librarianID) {
        super(name, address, contact, email);
        this.librarianID = librarianID;
    }
 
    public boolean addBook(Library lib) {
        String ID;
        String title;
        int ISBN;
        String publisher;
        int totalCopies;
        int availableCopies;
        boolean status;
        String author;
        System.out.print("Enter Book ID: ");
        ID = input.nextLine();
        System.out.print("Enter Book Title: ");
        title = input.nextLine();
        System.out.print("Enter Book ISBN: ");
        ISBN = input.nextInt();
        input.nextLine();
        System.out.print("Enter Publisher Name: ");
        publisher = input.nextLine();
        System.out.print("Enter Number of Total Copies: ");
        totalCopies = input.nextInt();
        System.out.print("Enter Number of Available Copies: ");
        availableCopies = input.nextInt();
        input.nextLine();
        System.out.print("Enter Author Name: ");
        author = input.nextLine();
        Book b = new Book(ID,title, ISBN, publisher, totalCopies, author);
        lib.books.add(b);
        return true;
    }
}




// private String bookID;
    