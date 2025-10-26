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
    
    public String addBook(Book b, ArrayList<Book> books, String bookID, String title, String ISBN, String publisher, String author) {
        b = new Book(bookID, title, ISBN, publisher, author);
        books.add(b);
        return "Book " + title + " [" + bookID + "] added to Library";
    }
        

    public String removeBook(Book book, ArrayList<Book> books) {
       books.remove(book);
       return "BOOK REMOVED SUCCESSFULLY.";
    }

    public Member searchMemberbyID(String id, ArrayList<Member> members) {
        for (Member member : members) {
            if (member.getMemberID().equals(id)) return member;
        }
        return null;
    }

    public Member searchMemberbyName(String name, ArrayList<Member> members) {
        for (Member member : members) {
            if (member.getName().equals(name)) return member;
        }
        return null;
    }

    public Book searchBookbyId(String bookID, ArrayList<Book> books) {
        for (Book book : books) {
            if (book.getBookID().equals(bookID)) return book;
        }
        return null;
    }

    public Book searchBookbyTitle(String title, ArrayList<Book> books) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) return book;
        }
        return null;
    }

    public Book searchBookbyISBN(String isbn, ArrayList<Book> books) {
        for (Book book : books) {
            if (book.getISBN().equals(isbn)) return book;
        }
        return null;
    }


    public String issueBook(Book book,Member member, ArrayList<Transaction> transactions) {
        if (member.getBorrowedCount() < Library.getMaxAllowed()) {
            if (book.getAvailableQuantity() > 0) {
                member.getBorrowedBooks()[member.getBorrowedCount()] = book;
                member.incBorrowedCount();
                book.decAvailableQuantity();
                Transaction t = new Transaction(member.getMemberID(), book.getBookID(), false,transactions);
                transactions.add(t);
                return "BOOK ISSUED.";
            } else {return "BOOK NOT AVAILABLE.";}
        } 
        return "MEMBER REACHED BORROWING LIMIT";
    }

    public String returnBook(Book book, Member member, ArrayList<Transaction> transactions) {
        boolean found = false;
        for (int i = 0; i<member.getBorrowedBooks().length; i++) {
            if (member.getBorrowedBooks()[i] != null && member.getBorrowedBooks()[i].equals(book)) {
                member.getBorrowedBooks()[i] = null;
                member.decBorrowedCount();
                book.incAvailableQuantity();
                found = true;
                break;
            } 
        }
        if (!found) return "BOOK NOT FOUND IN THIS MEMBER'S BORROWED BOOKS";
        for (Transaction transaction : transactions) {
            if (transaction.getBookid().equals(book.getBookID())) {
                transaction.setStatusOfTransaction(true);
                transaction.setReturned();
                Library.setTotalFine(Library.getTotalFine() + transaction.getFine().getFineAmount());
            }
        }
        return "BOOK RETURNED";
    }
    
    public String viewIssued(ArrayList<Transaction> transactions) {
        String issuedBook = "";
        for (Transaction transaction : transactions) {
            if (transaction.getStatus() == false) {
                issuedBook += transaction.getBookid() + "\n";
            } 
        }
        return issuedBook;
    }

    public String addNewMember(Member member, ArrayList<Member> members, String name, String address, String email, String contact, String memberID) {
        member = new Member(name, address, contact, email, memberID);
        members.add(member);
        return "MEMBER ADDED SUCCESSFULLY";
    }

    public String updateBookDetails(Book book, String bookID, String title, String isbn, String publisher, String author) {
        book.setBookID(bookID);
        book.setTitle(title);
        book.setISBN(isbn);
        book.setPublisher(publisher);
        book.setAuthor(author);
        return "BOOK DETAILS UPDATED SUCCESSFULLY";
    }  

    public String displayMembers(ArrayList<Member> members) {
        String allMembers = "";
        for (Member member : members) {
            allMembers += member.toString();
        }
        return allMembers;
    }

    public String displayBooks(ArrayList<Book> books) {
        String allBooks = "";
        for (Book book : books) {
            allBooks += book.toString();
        }
        return allBooks;
    }

    public String getLibrarianID() {
        return librarianID;
    }

    @Override
    public String toString() {
        return String.format("--- Librarian Details ---\n%s\nLibrarian ID: %s",super.toString(), this.getLibrarianID());
    }    
}