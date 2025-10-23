import java.util.ArrayList;
import java.util.Scanner;
public class Library {

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Transaction> transactions = new ArrayList<>();
    private Librarian supervisor = new Librarian("Ahmed", "Lahore", "12345", "bilal235@gmail.com", "SP23456");

    private Librarian librarian = null;
    private int booksCount;

    public void incBookCount() {
        this.booksCount++;
    }

    public void decBookCount() {
        this.booksCount--;
    }

    public boolean adminLogin(){
        Scanner admin = new Scanner(System.in);
        String adminUName = "@ahmed";
        int admPass = 1234;
        System.out.println("ADMIN LOGIN PAGE");
        System.out.print("Enter Admin UserName: ");
        String uName = admin.next();
        System.out.print("Enter Admin PIN: ");
        int pin = admin.nextInt();

        if (!uName.equals(adminUName) || (pin != admPass)) {
            System.out.println("INVALID USERNAME OR PASSWORD. TRY AGAIN.");
            return false;
        } else {
            System.out.println("Logged In Successfully.");
        }
        return true;
    }

    public boolean librarianLogin(){
        Scanner input = new Scanner(System.in);
        System.out.println("LIBRARIAN LOGIN");
        System.out.println("ENTER USERNAME AND ID.\n");
        System.out.print("Enter Username: ");
        String username = input.nextLine();
        System.out.print("Enter ID: ");
        String id = input.nextLine();

        if (username.equals(this.librarian.getName()) && id.equals(this.librarian.getLibrarianID())) {
            System.out.println("Logged In Successfully.");
            return true;
        } else {
            System.out.println("Invalid Username Or ID.");
        }
        return false;
    }

    public Member memberLogin() {
        if (this.members.isEmpty() == true) {
            System.out.println("No Member Registered.");
            return null;
        } 
        Scanner input = new Scanner(System.in);
        System.out.println("MEMBER LOGIN");
        System.out.println("ENTER USERNAME AND ID.\n");
        System.out.print("Enter Username: ");
        String username = input.nextLine();
        System.out.println("Enter ID: ");
        String id = input.nextLine();
        for (int i = 0; i<members.size(); i++) {
            if (username.equals(members.get(i).getName()) && id.equals(members.get(i).getMemberID())) {
                System.out.println("Logged In Successfully");
                return members.get(i);
            } else if (i == members.size()) {
                System.out.println("Invalid Username or ID.");
            }
        }
        return null;
    }
    
    public Book searchBook() {
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
                    return b;
                } else {System.out.println("Book Not Found.");}
                }
                break;
            }
            case 2: {
                System.out.print("Enter Book ID: ");
                String id = input.nextLine();
                for (Book b : books) {
                    if (b.getBookID().equals(id)) {
                        System.out.println("Book Found.");
                        return b;
                    } else {System.out.println("Book Not Found.");}
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
                        return b;
                    } else {System.out.println("Book Not Found.");}
            }
            break;
            }
            default: {
                System.out.println("Invalid Input.");
                break;
            }
        }
        return null;
    }

    public boolean searchMemberbyID(String id) {
        for (Member m : members) {
            if (m.getMemberID().equals(id)) return true;
        }
        return false;
    }

    public Member searchMember() {
        Scanner input = new Scanner(System.in);
        System.out.println("Search Member By: \n1. Name \n2. Member ID: ");
        System.out.println();
        System.out.print("Enter your Choice: ");
        int choice = input.nextInt();
        input.nextLine();
        System.out.println();
        switch (choice) {
            case 1: {
                System.out.print("Enter Member Name: ");
                String name = input.nextLine();
                System.out.println();
                for (Member m : members) {
                    if (m.getName().equals(name)) {
                        return m;
                    }
                }
                break;
            }
            case 2: {
                System.out.println("Enter Member ID: ");
                String mID = input.nextLine();
                System.out.println();
                for (Member m : members) {
                    if (m.getMemberID().equals(mID)) {
                        return m;
                    }
                }
            }
        }
        return null;
    }


    public String addBook() {
        Scanner input = new Scanner(System.in);
        Book newBook;
        System.out.print("Enter Book ID: ");
        String ID = input.nextLine();
        System.out.println();
        for (int i = 0; i<books.size(); i++) {
            if (books.get(i).getBookID().equals(ID)) 
                { 
                    System.out.println("A book is already available with this ID.");
                    System.out.print("Enter a different ID: ");
                    ID = input.nextLine();
                    // newBook.setBookID(ID);
                    System.out.println();
                }
            // else if (i == books.size()) newBook.setBookID(ID); 
        }

        System.out.print("Enter Book Title: ");
        String title = input.nextLine();
        System.out.println();
        for (int i = 0; i<books.size(); i++) {
            if (books.get(i).getTitle().equals(title)) 
            {
                System.out.println("A book is already available with this Title.");
                System.out.print("Enter a different Title: ");
                title = input.nextLine();
                System.out.println();
                // newBook.setTitle(title);
            }
            // else if (i == books.size()) newBook.setTitle(title); 
        }
        
        System.out.print("Enter Book ISBN: ");
        int ISBN = input.nextInt();
        System.out.println();
        for (int i = 0; i<books.size(); i++) {
            if (books.get(i).getISBN() == ISBN) 
            {
                System.out.println("A book is already available with this ISBN.");
                System.out.print("Enter a different ISBN: ");
                ISBN = input.nextInt();
                System.out.println();
                // newBook.setISBN(ISBN);
            }
            // else if (i == books.size()) newBook.setISBN(ISBN); 
        }
        input.nextLine();
        System.out.print("Enter Publisher Name: ");
        String publisher = input.nextLine();
        System.out.println();
        // newBook.setPublisher(publisher);
        System.out.print("Enter Author Name: ");
        String author = input.nextLine();
        System.out.println();
        // newBook.setAuthor(author);
        newBook = new Book(ID, title, ISBN, publisher, author);
        books.add(newBook);
        incBookCount();
        return "------------- BOOK ADDED SUCCESSFULLY -------------\n";
    }


    public String removeBook() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Book ID: ");
        String bookID = input.nextLine();
        System.out.println();
        for (int i = 0; i<books.size(); i++) {
            if (books.get(i).getBookID().equals(bookID)){
                if (books.get(i).isBookAvailable() == true)
                {
                    System.out.print("Permanently remove the Book(y/n)? : ");
                    String choice = input.nextLine();
                    if (choice.equals("y")) {
                    this.books.remove(books.get(i));
                    decBookCount();
                    return "Removed Successfully\n";
                    } else {
                        return "Book Not Removed.\n";
                    }
                } else return "This Book is Borrowed by any Member.\n";
            } else if (i == books.size()) {
                return "Book not Found.\n";
            }
        } return "Book Not Found";
    }

    public void showAllBooks() {
        for (Book b : books)  {
            System.out.println(b.toString());
        }
    }

    public void showAllMembers() {
        for (Member m : members) {
            System.out.println(m.toString());
        }
    }


    public String addLibrarian() {
        Scanner input = new Scanner(System.in);
        if (this.librarian != null) {
            return "A librarian is already available for this library. Can't add another librarian.";
        } else {
            System.out.print("Enter Librarian Name: ");
            String name = input.nextLine();
            System.out.print("Enter Librarian Address: ");
            String address = input.nextLine();
            System.out.print("Enter Email: ");
            String email = input.nextLine();
            System.out.print("Enter Libarian ID: ");
            String id = input.nextLine();
            System.out.print("Enter Contact: ");
            String contact = input.nextLine();
            this.librarian = new Librarian(name, address, contact, email, id);
            this.assignSupervisor(librarian);
            System.out.println("Librarian Added Successfully.");
            return "Librarian Added Successfully";
        }
    }


    public void assignSupervisor(Librarian llLibrarian) {
        if (supervisor != null) {
            librarian.setSupervisor(supervisor);
        }
    }

    public void displayTransactions() {
        for (Transaction t : transactions) {
            System.out.println(t.toString());
        }
    }

    public void displayFineHistory() {
        for (Transaction t : transactions) {
            if (t.getFine() != null) {
                System.out.println(t.getFine().toString());
            }
        }
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public Librarian getSupervisor() {
        return supervisor;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public int getBooksCount() {
        return booksCount;
    }

    public boolean duplicateEmail(String email) {
        for (Member m : members) {
            if (m.getEmail().equals(email)) return true;
        }
        return false;
    }
}

