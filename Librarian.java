
import java.time.*;
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
        System.out.print("Enter Author Name: ");
        author = input.nextLine();
        Book b = new Book(ID,title, ISBN, publisher, author);
        lib.books.add(b);
        lib.booksCount += 1;
        System.out.println("----------------------------------");
        return true;
    }

    public void add(Book b, Library lib) {
        lib.books.add(b);
        lib.booksCount++;
    }


    public void removeBook(Library lib, String title) {
        for (Book b : lib.books) {
            if (b.getTitle().equals(title)) {
                lib.books.remove(b);
                lib.booksCount -= 1;
            }
        }
    }

    public void issueBook(Library lib, Member m, String title) {
        for (int i = 0; i < lib.books.size(); i++) {
           if (lib.books.get(i).getTitle().equals(title) && (lib.books.get(i).isAvailable() == true)) {
            if (m.getBorrowedCount() != m.MAX_ALLOWED) {
                m.getBorrowedBooks()[m.getBorrowedCount()] = lib.books.get(i);
                m.incBorrowedCount();
                
                Transaction t = new Transaction(m.getMemberID(), lib.books.get(i).getISBN(), false);
                lib.transactions.add(t);
                lib.books.get(i).setStatus(false);
                m.getBorrowingHistory().add(t);

                break;
            } else {
                System.out.println("Member Reached Borrowing Limit.");
            }
           } else if (i == lib.books.size()) {
            System.out.println("Book Not Found.");
           }
        }
        
    }

    public void returnBook(Library lib, Member m, String title) {
        Book b = Book.getBook(lib, title);
       for (int i = 0; i<m.getBorrowedBooks().length; i++) {
        if (m.getBorrowedBooks()[i] != null && m.getBorrowedBooks()[i].getTitle().equals(title)) {
            m.getBorrowedBooks()[i] = null;
            m.decBorrowedCount();
            lib.books.get(i).setStatus(true);
            for (Transaction t : m.getBorrowingHistory()) {
                if (t.isbn == b.getISBN()) {
                    t.isReturned = true;
                }
            }
        }

        for (Transaction t : lib.transactions) {
            if (t.isbn == (b.getISBN())) {
                t.isReturned = true;
            }
        }
       }
    }

    public void viewIssued(Library lib) {
        for (Book b : lib.books) {
            if (b.isAvailable() == false) {
                System.out.println(b.getDetails());
            } 
        }
    }

    public void addMember(Library lib, Member m) {
        System.out.println("Enter name: ");
        String name = input.nextLine();
        System.out.println("Enter address: ");
        String address = input.nextLine();
        System.out.println("Enter contact: ");
        int contact = input.nextInt();
        input.nextLine();
        System.out.println("Enter emial: ");
        String email = input.nextLine();
        System.out.println("Enter Member ID: ");
        String id = input.nextLine();

        if (lib.searchMember(id) == false) {
        m = new Member(name, address, contact, email, id, lib);
        System.out.println("");
        } else {
            System.out.println("Memer Already Added...");
        } 
    }
}

    