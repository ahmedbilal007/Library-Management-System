import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Librarian extends User{ 
    Scanner input = new Scanner(System.in);
    private String librarianID;
    private Librarian supervisor;

    public Librarian(String name, String address, String contact, String email, String librarianID) {
        super(name, address, contact, email);
        this.librarianID = librarianID;
    }
 
    public void setSupervisor(Librarian supervisor) {
        this.supervisor = supervisor;
    }
    public void addNewBook(Library lib) {
        lib.addBook();
    }
    
    public void add(Book b, Library lib) {
        lib.getBooks().add(b);
        lib.incBookCount();
    }

    public String removeBook(Library lib) {
        return lib.removeBook();
    }


    public void issueBook(Library lib) {
        System.out.print("Enter Book Title: ");
        String title = input.nextLine();
        System.out.println();
        System.out.println("Check whether this member is in Library Membership.");
        System.out.println("---------------------------------------------------");
        System.out.println();
        Member m = lib.searchMember();

        for (int i = 0; i < lib.getBooks().size(); i++) {
            if (lib.getBooks().get(i).getTitle().equals(title)) {
                if (lib.getBooks().get(i).isBookAvailable() == false) {
                    System.out.println("Book is already issued.");
                    return;
                } 
            if (m.getBorrowedCount() < m.getMaxAllowed()) {
                m.getBorrowedBooks()[m.getBorrowedCount()] = lib.getBooks().get(i);
                m.incBorrowedCount();
                Transaction t = new Transaction(m.getMemberID(), lib.getBooks().get(i).getBookID(), false, lib);
                lib.getTransactions().add(t);
                lib.getBooks().get(i).setStatus(false);
                System.out.println("Issued.");
                break;
            } else {
                System.out.println("Member Reached Borrowing Limit.");
            }
        } else if (i == lib.getBooks().size()) {
            System.out.println("Book Not Found.");
           }
        }
    }

    public void returnBook(Library lib, Member m) {
        System.out.println("Enter Book Title: ");
        String title = input.nextLine();

        Book b = Book.getBook(lib, title);
        for (int i = 0; i<m.getBorrowedBooks().length; i++) {
            if (m.getBorrowedBooks()[i] != null && m.getBorrowedBooks()[i].getTitle().equals(title)) {
                m.getBorrowedBooks()[i] = null;
                m.decBorrowedCount();
                lib.getBooks().get(i).setStatus(true);
            }

            for (Transaction t : lib.getTransactions()) {
                if (t.getBookid().equals(b.getBookID())) {
                    t.setStatusOfTransaction(true);
                    t.setReturned();
                }
            }
        }
    }
    
    public void viewIssued(Library lib) {
        for (Book b : lib.getBooks()) {
            if (b.isBookAvailable() == false) {
                System.out.println(b.toString());
            } 
        }
    }

    public String addNewMember(Library lib) {
        System.out.print("Enter name: ");
        String name = input.nextLine();
        System.out.print("Enter address: ");
        String address = input.nextLine();
        System.out.print("Enter contact: ");
        String contact = input.nextLine();
        System.out.print("Enter email: ");
        String email = input.nextLine();
        if (isEmailValid(email) == false) {
            System.out.print("Invalid Email. Enter again: ");
            email = input.nextLine();
        }
        if (lib.duplicateEmail(email) == true) {
            System.out.print("Email already added to the system. Enter a different one: ");
            email = input.nextLine();
        }
        System.out.print("Enter Member ID: ");
        String id = input.nextLine();

        if (lib.searchMemberbyID(id) == true ) {
            System.out.print("A member with this ID is already present. Enter a different ID: ");
            id = input.nextLine();
        } 
        Member m = new Member(name, address, contact, email, id);
        lib.getMembers().add(m);
        return "Member Added Successfully";
    }

    public String updateBookDetails(Library lib) {
        String choice = "";
        System.out.println("Enter Book ID for the Book you want to update: ");
        String title = input.nextLine();
        if (lib.searchBook() != null) {
            Book b = Book.getBook(lib, title);
            System.out.print("Do you want to update Book ID (y/n): ");
            choice = input.next();
            if (choice.equals("y")) {
                System.out.print("Enter Book ID: ");
                String ID = input.nextLine();
                b.setBookID(ID);

            } else if (choice.equals("n")) System.out.println("Book ID unchanged.");

            System.out.print("Do you want to update Book Title (y/n): ");
            choice = input.next();
            if (choice.equals("y")) {
                System.out.print("Enter Book Title: ");
                String btitle = input.nextLine();
                b.setTitle(btitle);
            } else if (choice.equals("n")) System.out.println("Book Title unchanged.");

            System.out.print("Do you want to update Book ISBN (y/n): ");
            choice = input.next();
            if (choice.equals("y")) {
                System.out.print("Enter Book ISBN: ");
                int ISBN = input.nextInt();
                b.setISBN(ISBN);
            } else if (choice.equals("n")) System.out.println("Book ISBN unchanged.");
            input.nextLine();

            System.out.print("Do you want to update Book Publisher (y/n): ");
            choice = input.next();
            if (choice.equals("y")) {
                System.out.print("Enter Publisher Name: ");
                String publisher = input.nextLine();
                b.setPublisher(publisher);
            } else if (choice.equals("n")) System.out.println("Book Publisher unchanged.");

            System.out.print("Do you want to update Book Publisher (y/n): ");
            choice = input.next();
            if (choice.equals("y")) {
                System.out.print("Enter Author Name: ");
                String author = input.nextLine();
                b.setAuthor(author);
            } else if (choice.equals("n")) System.out.println("Book Author unchanged.");

            return "Updated Book Details";
        }
        return "Book Not Found";
    }  

    public void displayMembers(Library lib) {
        lib.showAllMembers();
    }

    public void displayBooks(Library lib) {
        lib.showAllBooks();
    }

    public String getLibrarianID() {
        return librarianID;
    }

    @Override
    public String toString() {
        return String.format("--- Librarian Details ---\n%s\nLibrarian ID: %s",super.toString(), this.getLibrarianID());
    }
}

    