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
        for (Book b : lib.books) {
           if (b.getTitle().equals(title) && b.isAvailable() == true) {
            if (m.getBorrowedCount() != m.MAX_ALLOWED) {
                m.getBorrowedBooks()[m.getBorrowedCount()] = b;
                m.incBorrowedCount();
                lib.transactions.add(new Transaction(m.getMemberID(), b.getISBN(), false));
            } else {
                System.out.println("Member Reached Borrowing Limit.");
            }
           } else {
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

    // public void addMember(Library lib, Member m) {
    //     for (int i = 0; i<lib.members.size(); i++) {
    //         if (lib.members.get(i).getMemberID().equals(m.getMemberID())) {
    //             System.out.println("Member already added");
    //             break;
    //         }
    //         else if (i == lib.members.size()) {
    //             lib.members.add(m);
    //             System.out.println("Member Added Successfully");
    //         }
    //     }
        
    // }
    

}

    