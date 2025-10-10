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
        input.nextLine();
        System.out.print("Enter Author Name: ");
        author = input.nextLine();
        Book b = new Book(ID,title, ISBN, publisher, author);

        lib.books.add(b);
        lib.booksCount += 1;
        System.out.println("----------------------------------");
        return true;
    }

    public void removeBook(Library lib, String title) {
        for (Book b : lib.books) {
            if (b.getTitle().equals(title)) {
                lib.books.remove(b);
                lib.booksCount -= 1;
            }
        }
    }

    // public void issueBook(Library lib, Member m, String title) {
    //     m.borrowBook(lib, title);
    //     Transaction t1 = new Transaction(m.getMemberID(), b.getISBN(), false);
        
    // }

    public void returnBook(Library lib, Member m, String title) {
        m.returnBook(lib, title);
    }

    public void viewIssued(Library lib) {
        for (Book b : lib.books) {
            if (b.isAvailable() == true) {

            }
        }
    }
    

}




// private String bookID;
    