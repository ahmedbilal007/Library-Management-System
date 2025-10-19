import java.util.Scanner;

public class Main {

    public static void mainFlow(Library lib) {

        Scanner input = new Scanner(System.in);

        System.out.println("-------------------------\n\n\n\n");
        System.out.println("LIBRARY MANAGEMENT SYSTEM");
        System.out.println("\n\n\n\n-------------------------");
        System.out.println("1. Administration Use");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        
        while (true) { 
            System.out.print("\nENTER YOUR CHOICE:  ");
            int choice = input.nextInt();
        if (choice == 1)  {
            boolean login = lib.adminLogin();
            if (login == true) {
                System.out.println("FOLLOWING FUNCTIONATLITIES ARE AVAILABLE AS AN ADMIN.\n");
                System.out.println("1. Search Book\n2. Search Member\n3. Show All Books\n4. Show All Members\n5. Add Librarian\n6. View Transaction History\n7. Fine History\n8. Log Out");
                while (true) {
                    System.out.print("\nEnter your choice: ");
                    int admChoice = input.nextInt();
                    if (admChoice == 1) {lib.searchBook();}
                    else if (admChoice == 2) {lib.searchMember();}
                    else if (admChoice == 3) {lib.showAllBooks();}
                    else if (admChoice == 4) {lib.showAllMembers();}
                    else if (admChoice == 5) {lib.addLibrarian();}
                    else if (admChoice == 6) {lib.displayTransactions();}
                    else if (admChoice == 7) {lib.displayFines();}
                    else if (admChoice == 8) {
                        System.out.println("\nLogged Out.");
                        break;
                    } else {System.out.println("\nInvalid Input.");}
                }
            } 
        } else if (choice == 2) {
            if (lib.librarian == null) {System.out.println("\nNo Librarian Found.");}
            else {
                boolean login2 = lib.librarian.login();
                if (login2 == true) {
                    System.out.println("FOLLOWING FUNCTIONATLITIES ARE AVAILABLE AS A LIBRARIAN.\n");
                    System.out.println("1. Add New Book\n2. Remove Book\n3. Issue Book\n4. Return Book\n5. View Issued Books\n6. Add New Member\n7. Update Book Details\n8. Display Books\n9. Display Members\n10. Log Out");
                    while (true) {
                        System.out.print("\nEnter your choice: ");
                        int libChoice = input.nextInt();
                        if (libChoice == 1) {lib.librarian.addNewBook(lib);}
                        else if (libChoice == 2) {lib.librarian.removeBook(lib);}
                        else if (libChoice == 3) {lib.librarian.issueBook(lib);}
                        else if (libChoice == 4) {lib.librarian.removeBook(lib);}
                        else if (libChoice == 5) {lib.librarian.viewIssued(lib);}
                        else if (libChoice == 6) {lib.librarian.addNewMember(lib);}
                        else if (libChoice == 7) {lib.librarian.updateBookDetails(lib);}
                        else if (libChoice == 8) {lib.librarian.displayBooks(lib);}
                        else if (libChoice == 9) {lib.librarian.displayMembers(lib);}
                        else if (libChoice == 10) {
                            System.out.println("\nLogged Out");
                            break;
                        } else {System.out.println("");}
                    }
                }
            }
        } else if (choice == 3) {
            break;
        } 
        }
        }
    
    public static void main(String[] args) {
        
        Library mainLibrary = new Library();
        // mainFlow(mainLibrary);

        Member m1 = new Member("Ahmed", "Lahore", 123456, "ahmedbilal2857@gmail.com", "AB234", mainLibrary);

        Librarian l1 = new Librarian("Muhammad", "Pindi", 65432, "bilal@gmail.com", "LI2345");

        Book b1 = new Book("B123", "Python", 1234, "Talha", "Ahmed");
        Book b2 = new Book("B456", "Java", 765, "Talha", "Ahmed");
        Book b3 = new Book("B789", "JavaScript", 9873, "Talha", "Ahmed");

        mainLibrary.books.add(b1);
        mainLibrary.books.add(b2);
        mainLibrary.books.add(b3);

        mainLibrary.members.add(m1);

        m1.borrowBook(mainLibrary, l1);
        // m1.borrowBook(mainLibrary, l1);
        // m1.borrowBook(mainLibrary, l1);

        l1.viewIssued(mainLibrary);

        m1.returnBook(mainLibrary, l1);

        mainLibrary.displayTransactions();
        mainLibrary.displayFines();
        System.out.println("End");
    }
    
}
