import java.util.Scanner;

public class Main {
    public static void mainFlow(Library lib) {

        Scanner input = new Scanner(System.in);
        System.out.println("--------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("                      LIBRARY MANAGEMENT SYSTEM                     ");
        System.out.println("--------------------------------------------------------------------\n\n\n");
            

        while (true) { 
            System.out.println("--------------------------------------------------------------------");
            System.out.println("|\t\t\t1. ADMINISTRATION USE  \t\t\t   |");
            System.out.println("|\t\t\t2. LIBRARIAN LOGIN     \t\t\t   |");
            System.out.println("|\t\t\t3. STUDENT LOGIN       \t\t\t   |");
            System.out.println("|\t\t\t4. EXIT                \t\t\t   |");
            System.out.println("--------------------------------------------------------------------");
            System.out.print("\nENTER YOUR CHOICE: ");
            int choice = input.nextInt();
            if (choice == 1) {
                boolean login = lib.adminLogin();
                if (login == true) {
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("FOLLOWING FUNCTIONATLITIES ARE AVAILABLE AS AN ADMIN.");
                    System.out.println("-----------------------------------------------------------\n");
                    System.out.println("1. Search Book\n2. Search Member\n3. Show All Books\n4. Show All Members\n5. Add Librarian\n6. View Transaction History\n7. Log Out");
                    while (true) {
                        System.out.print("\nEnter Your Choice: ");
                        int admChoice = input.nextInt();
                        if (admChoice == 1) {
                            if (lib.searchBook() != null) System.out.println(lib.searchBook().toString());
                            else System.out.println("--- BOOK NOT FOUND ---");
                        }
                        else if (admChoice == 2) {
                            if (lib.searchMember() != null)  System.out.println(lib.searchMember().toString());
                            else System.out.println("--- MEMBER NOT FOUND ---");
                        }
                        else if (admChoice == 3) {lib.showAllBooks();}
                        else if (admChoice == 4) {lib.showAllMembers();}
                        else if (admChoice == 5) {System.out.println(lib.addLibrarian());}
                        else if (admChoice == 6) {lib.displayTransactions();}
                        else if (admChoice == 7) {
                            System.out.println("\n\nLogged Out.");
                            break;
                        } else {System.out.println("\n\nInvalid Input.");}
                    }
                } 
            } else if (choice == 2) {
                if (lib.getLibrarian() == null) {System.out.println("No Librarian Found.");}
                else {
                    boolean login2 = lib.librarianLogin();
                    if (login2 == true) {
                        System.out.println("------------------------------------------------------------");
                        System.out.println("FOLLOWING FUNCTIONATLITIES ARE AVAILABLE AS A LIBRARIAN.");
                        System.out.println("------------------------------------------------------------\n");
                        System.out.println("1. Add New Book\n2. Remove Book\n3. Issue Book\n4. Return Book\n5. View Issued Books\n6. Add New Member\n7. Update Book Details\n8. Display Books\n9. Display Members\n10. Log Out");
                        while (true) {
                            System.out.print("\nEnter your choice: ");
                            int libChoice = input.nextInt();
                            if (libChoice == 1) {lib.getLibrarian().addNewBook(lib);}
                            else if (libChoice == 2) {lib.getLibrarian().removeBook(lib);}
                            else if (libChoice == 3) {lib.getLibrarian().issueBook(lib);}
                            else if (libChoice == 4) {System.out.println(lib.getLibrarian().removeBook(lib));}
                            else if (libChoice == 5) {lib.getLibrarian().viewIssued(lib);}
                            else if (libChoice == 6) {System.out.println(lib.getLibrarian().removeBook(lib));}
                            else if (libChoice == 7) {System.out.println(lib.getLibrarian().updateBookDetails(lib));}
                            else if (libChoice == 8) {lib.getLibrarian().displayBooks(lib);}
                            else if (libChoice == 9) {lib.getLibrarian().displayMembers(lib);}
                            else if (libChoice == 10) {
                                System.out.println("Logged Out");
                                break;
                            } else {System.out.println("Invalid Choice.");}
                        }
                    }
                }
            } else if (choice == 3) {
                Member mLogin = lib.memberLogin();
                if (mLogin != null) {
                    System.out.println("----------------------------------------------------");
                    System.out.println("FOLLOWING FUNCTIONALITIES ARE AVAILABLE AS A MEMBER");
                    System.out.println("-----------------------------------------------------\n");
                    System.out.println("1. Member Details\n2. Display Borrowed Books\n3. Display Transaction History\n4. Log Out");
                    while (true) {
                        System.out.print("\nEnter Your Choice: ");
                        int memChoice = input.nextInt();
                        if (memChoice == 1) {System.out.println(mLogin.toString());}
                        else if (memChoice == 2) {mLogin.displayBorrowed();}
                        else if (memChoice == 3) {mLogin.viewTransactionHistory(lib);}
                        else if (memChoice == 4) {
                            System.out.println("Logged Out.");
                            break;
                        }
                    }
                } 
            }
            else if (choice == 4) {
                break;
            } 
        }
    }
    
    public static void main(String[] args) {
        
        Library mainLibrary = new Library();
        mainFlow(mainLibrary);

        // Member m1 = new Member("Ahmed", "Lahore", 123456, "ahmedbilal2857@gmail.com", "AB234");
        // // System.out.println(m1.toString());
        // Librarian l1 = new Librarian("Muhammad", "Pindi", 65432, "bilal@gmail.com", "LI2345");
        // System.out.println(l1.toString());
      
        // l1.addNewBook(mainLibrary);
        // l1.displayBooks(mainLibrary);
        

        // Book b1 = new Book("B123", "Python", 1234, "Talha", "Ahmed");

        // // Book b2 = new Book("B456", "Java", 765, "Talha", "Ahmed");
        // // Book b3 = new Book("B789", "JavaScript", 9873, "Talha", "Ahmed");

        // mainLibrary.getBooks().add(b1);
        // // mainLibrary.getBooks().add(b2);
        // // // mainLibrary.books.add(b3);

        // mainLibrary.searchBook();
        // mainLibrary.getMembers().add(m1);
        // mainLibrary.getMembers().add(m1);
        
        // l1.addNewMember(mainLibrary);

        // System.out.println(mainLibrary.getMembers().toString());

        // m1.borrowBook(mainLibrary, l1);
        // m1.borrowBook(mainLibrary, l1);

        // // // m1.borrowBook(mainLibrary, l1);

        // l1.viewIssued(mainLibrary);

        

        // mainLibrary.displayTransactions();

        // // m1.returnBook(mainLibrary, l1);


        // mainLibrary.displayTransactions();


        // mainLibrary.displayFines();
        // System.out.println("End");

    }
    
}
