import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        Library mainLibrary = new Library();
        Book b1 = new Book("B123", "Python", "1234", "Talha", "Ahmed");
        Librarian l1 = new Librarian("Muhammad", "Pindi", "03247102857", "ahmedbilal@gmail.com", "LIB2345");
        Member ahmed = new Member("Ahmed", "Lahore" , "123456", "abilal@gmail.com", "AB12345");
        mainLibrary.getBooks().add(b1);
        mainLibrary.setLibrarian(l1);
        mainLibrary.getMembers().add(ahmed);
        int mainChoice = 0;
        int admChoice = 0;
        int libChoice = 0;
        int memChoice = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("--------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("                      LIBRARY MANAGEMENT SYSTEM                     ");
        System.out.println("--------------------------------------------------------------------\n\n\n");

        while (mainChoice != 4) {
            System.out.println("--------------------------------------------------------------------");
            System.out.println("|\t\t\t1. ADMINISTRATION USE  \t\t\t   |");
            System.out.println("|\t\t\t2. LIBRARIAN LOGIN     \t\t\t   |");
            System.out.println("|\t\t\t3. STUDENT LOGIN       \t\t\t   |");
            System.out.println("|\t\t\t4. EXIT                \t\t\t   |");
            System.out.println("--------------------------------------------------------------------\n");
            System.out.print("\nENTER YOUR CHOICE: ");
            mainChoice = input.nextInt();
            input.nextLine();
            switch (mainChoice) {
                case 1: {
                    System.out.println("\nADMINISTRATION LOGIN PORTAL\n");
                    System.out.print("Enter UserName: ");
                    String admUserName = input.nextLine();
                    System.out.print("Enter ID: ");
                    int admID = input.nextInt();
                    input.nextLine();
                    if (mainLibrary.adminLogin(admUserName, admID) == true) {
                        System.out.println("------------------------------------");
                        System.out.println("\n      WELCOME TO ADMIN PORTAL");
                        System.out.println("\n------------------------------------\n");
                        admChoice = 0;
                        while (admChoice != 5) {
                            System.out.println("-----------------------------------------------------------");
                            System.out.println("FOLLOWING FUNCTIONATLITIES ARE AVAILABLE AS AN ADMIN.");
                            System.out.println("-----------------------------------------------------------\n");
                            System.out.println("1. Show All Books\n2. Show All Members\n3. Add Librarian\n4. View Transaction History\n5. Log Out");

                            System.out.print("Enter Your Choice: ");
                            admChoice = input.nextInt();
                            input.nextLine();
                            switch (admChoice) {
                                case 1: {
                                    System.out.println("\nDISPLAYING ALL BOOKS\n");
                                    System.out.println(mainLibrary.showAllBooks());
                                    break;
                                }
                                case 2: {
                                    System.out.println("\nDISPLAYING ALL MEMBERS\n");
                                    System.out.println(mainLibrary.showAllMembers());
                                    break;
                                }
                                case 3: {
                                    if (mainLibrary.getLibrarian() != null) {
                                        System.out.println("\nA librarian is already available in this library. Can't add more.\n");
                                    } else {
                                        System.out.print("Enter Member Name: ");
                                        String name = input.nextLine();
                                        System.out.print("Enter Member Address: ");
                                        String address = input.nextLine();
                                        System.out.print("Enter Contact NO.");
                                        String contact = input.nextLine();
                                        System.out.print("Enter Email: ");
                                        String email = input.nextLine();
                                        System.out.print("Enter Libarian ID: ");
                                        String id = input.nextLine();
                                        System.out.println(mainLibrary.addLibrarian(name, address, contact, email, id));
                                    }
                                    break;
                                }
                                case 4: {
                                    System.out.println("\nDISPLAYING ALL TRANSACTIONS\n");
                                    System.out.println(mainLibrary.displayTransactions());
                                    break;
                                }
                                case 5: {
                                    System.out.println("\nLOGGED OUT\n");
                                    break;
                                }
                                default: {
                                    System.out.println("\nINVALID VALUE\n");
                                }
                            }
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.println("LIBRARIAN LOGIN PORTAL\n");
                    System.out.print("Enter Your UserName: ");
                    String libUserName = input.nextLine();
                    System.out.print("Enter Your ID: ");
                    String libID = input.nextLine();
                    Librarian librarian = mainLibrary.librarianLogin(libUserName, libID);
                    if (librarian == null) {
                        System.out.println("\nNO LIBRARIAN FOUND\n");
                    } else {
                        System.out.println("------------------------------------");
                        System.out.println("\n      WELCOME TO LIBRARIAN PORTAL");
                        System.out.println("\n------------------------------------\n");
                        libChoice = 0;
                        while (libChoice != 12) {
                            System.out.println("------------------------------------------------------------");
                            System.out.println("FOLLOWING FUNCTIONATLITIES ARE AVAILABLE AS A LIBRARIAN.");
                            System.out.println("------------------------------------------------------------\n");
                            System.out.println("1. Add New Book\n2. Remove Book\n3. Issue Book\n4. Return Book\n5. Search Book\n6. Search Member\n7. View Issued Books\n8. Add New Member\n9. Update Book Details\n10. Display Books\n11. Display Members\n12. Log Out");
                            System.out.print("Enter Your Choice: ");
                            libChoice = input.nextInt();
                            input.nextLine();
                            switch (libChoice) {
                                case 1: {
                                    System.out.println("\nAdding New Book\n");
                                    Book b = null;
                                    System.out.print("Enter Book ID: ");
                                    boolean found = false;
                                    boolean duplicatedISBN = false;
                                    String bookID = input.nextLine();
                                    for (Book book : mainLibrary.getBooks()) {
                                        if (book.getBookID().equals(bookID)) {
                                            System.out.println("\nBook already exists with this ID.\n");
                                            found = true;
                                        }
                                    }
                                    if (found == true) {
                                        break;
                                    }
                                    System.out.print("Enter Book Title: ");
                                    String bookTitle = input.nextLine();
                                    System.out.print("Enter Book ISBN: ");
                                    String bookISBN = input.nextLine();
                                    for (Book book : mainLibrary.getBooks()) {
                                        if (book.getISBN().equals(bookISBN)) {
                                            book.incBookQuantity();
                                            mainLibrary.incBookCount();
                                            duplicatedISBN = true;
                                        }
                                    }
                                    if (duplicatedISBN == true) {
                                        System.out.println("\nBOOK QUANTITY INCREASED.\n");
                                        break;
                                    }

                                    System.out.print("Enter Publisher Name: ");
                                    String publisher = input.nextLine();
                                    System.out.print("Enter Author Name: ");
                                    String author = input.nextLine();
                                    librarian.addBook(b, mainLibrary.getBooks(), bookID, bookTitle, bookISBN, publisher, author);
                                    break;
                                }
                                case 2: {
                                    System.out.println("\nRemoving Book\n");
                                    System.out.print("Enter Book ID: ");
                                    String bookID = input.nextLine();
                                    Book b = Book.getBook(mainLibrary.getBooks(), bookID);
                                    if (b == null) {
                                        System.out.println("\nBOOK NOT FOUND\n");
                                    } else if (b != null && b.isBookAvailable() == false) {
                                        System.out.println("\nBOOK BORROWED BY A MEMBER.\n");
                                    } else {
                                        System.out.println("\nDo You Want to Delete This Book Permanently? (y/n) :  ");
                                        String ch = input.nextLine();
                                        if (ch.equals("y")) {
                                            System.out.println(librarian.removeBook(b, mainLibrary.getBooks()));
                                        } else {
                                            System.out.println("\nBOOK NOT DELETED\n");
                                        }
                                    }
                                    break;
                                }
                                case 3: {
                                    System.out.println("\nIssuing Book\n");
                                    System.out.println("\nCheck Whether Member is in Library Membership.");
                                    System.out.print("Enter Member ID: ");
                                    String memberID = input.nextLine();
                                    Member mem = librarian.searchMemberbyID(memberID, mainLibrary.getMembers());
                                    if (mem == null) {
                                        System.out.println("\nNO MEMBER FOUND WITH THIS ID.\n");
                                    } else {
                                        System.out.println("Enter Book ID: ");
                                        String bookID = input.nextLine();
                                        Book b = Book.getBook(mainLibrary.getBooks(), bookID);
                                        System.out.println(librarian.issueBook(b, mem, mainLibrary.getTransactions()));
                                    }
                                    break;
                                }
                                case 4: {
                                    System.out.println("\nReturning Book\n");
                                    System.out.println("\nCheck Whether Member is in Library Membership.");
                                    System.out.print("Enter Member ID: ");
                                    String memberID = input.nextLine();
                                    Member mem = librarian.searchMemberbyID(memberID, mainLibrary.getMembers());
                                    if (mem == null) {
                                        System.out.println("\nNO MEMBER FOUND WITH THIS ID.\n");
                                    } else {
                                        System.out.println("Enter Book ID: ");
                                        String bookID = input.nextLine();
                                        Book b = Book.getBook(mainLibrary.getBooks(), bookID);
                                        System.out.println(librarian.returnBook(b, mem, mainLibrary.getTransactions()));
                                    }
                                    break;
                                }
                                case 5: {
                                    System.out.println("\nSearch Book by: \n\t1. Book ID\n\t2. Book Title\n\t3. Book ISBN");
                                    System.out.print("Enter Your Choice: ");
                                    int searchBookChoice = input.nextInt();
                                    input.nextLine();
                                    switch (searchBookChoice) {
                                        case 1:{
                                            System.out.print("Enter Book ID: ");
                                            String id = input.nextLine();
                                            Book bookFound = librarian.searchBookbyId(id, mainLibrary.getBooks());
                                            if (bookFound == null) System.out.println("\nNO BOOK FOUND WITH THIS ID.\n");
                                            else System.out.println(bookFound.toString());
                                            break;
                                        }
                                        case 2:{
                                            System.out.print("Enter Book Title: ");
                                            String title = input.nextLine();
                                            Book bookFound = librarian.searchBookbyTitle(title, mainLibrary.getBooks());
                                            if (bookFound == null) System.out.println("\tNO BOOK FOUND WITH THIS TITLE.\t");
                                            else System.out.println(bookFound.toString());
                                            break;
                                        }
                                        case 3:{
                                            System.out.print("Enter Book ISBN: ");
                                            String isbn = input.nextLine();
                                            Book bookFound = librarian.searchBookbyISBN(isbn, mainLibrary.getBooks());
                                            if (bookFound == null) System.out.println("\tNO BOOK FOUND WITH THIS ISBN.\t");
                                            else System.out.println(bookFound.toString());
                                            break;
                                        }
                                    }
                                    break;
                                }

                                case 6: {
                                    System.out.println("\nSearch Member by: \n\t1. Member ID\n\t2. Member Name");
                                    System.out.print("Enter Your Choice: ");
                                    int searchMemberChoice = input.nextInt();
                                    input.nextLine();
                                    switch (searchMemberChoice) {
                                        case 1: {
                                            System.out.print("Enter Member ID: ");
                                            String mID = input.nextLine();
                                            Member memFound = librarian.searchMemberbyID(mID, mainLibrary.getMembers());
                                            if (memFound == null) System.out.println("\nNO MEMBER FOUND WITH THIS ID.\n");
                                            else System.out.println(memFound.toString());
                                            break;
                                        }
                                        case 2: {
                                            System.out.print("Enter Member Name: ");
                                            String mName = input.nextLine();
                                            Member memFound = librarian.searchMemberbyName(mName, mainLibrary.getMembers());
                                            if (memFound == null) System.out.println("\nNO MEMBER FOUND WITH THIS NAME.\n");
                                            else System.out.println(memFound.toString());
                                            break;
                                        }
                                    }
                                    break;
                                }

                                case 7: {
                                    System.out.println("\nDISPLAYING ALL ISSUED BOOKS\n");
                                    if (librarian.viewIssued(mainLibrary.getTransactions()).equals("")) {
                                        System.out.println("\nNO BOOK ISSUED AT THIS TIME.\n");
                                    } else {
                                        System.out.println(librarian.viewIssued(mainLibrary.getTransactions()));
                                    }
                                    break;
                                }
                                case 8: {
                                    System.out.println("\nADDING NEW MEMBER\n");
                                    Member mem = null;
                                    System.out.print("Enter Member Name: ");
                                    String name = input.nextLine();
                                    System.out.print("Enter Member Address: ");
                                    String address = input.nextLine();
                                    System.out.print("Enter Email: ");
                                    String email = input.nextLine();
                                    if (Library.isEmailValid(email) == false) {
                                        System.out.println("\nINVALID EMAIL.\n");
                                        System.out.print("Enter Email Again: ");
                                        email = input.nextLine();
                                    }
                                    if (mainLibrary.duplicateEmail(email) == true) {
                                        System.out.println("\nEMAIL ALREADY ADDED. ENTER A DIFFERENT ONE.\n");
                                        System.out.print("Enter Email Again: ");
                                        email = input.nextLine();
                                    }
                                    System.out.print("Enter Member ID: ");
                                    String id = input.nextLine();
                                    if (mainLibrary.searchMemberbyID(id) == true) {
                                        System.out.print("\nA member with this ID is already added. Enter a different ID: ");
                                        id = input.nextLine();
                                    }
                                    System.out.println(librarian.addNewMember(mem, mainLibrary.getMembers(), name, address, email, name, id));
                                    break;
                                }
                                case 9: {
                                    System.out.println("\nUPDATE BOOK DETAILS\n");
                                    System.out.print("Enter Book ID for which you want to update:  ");
                                    String bookID = input.nextLine();
                                    Book book = Book.getBook(mainLibrary.getBooks(), bookID);
                                    if (book == null) {
                                        System.out.println("\nNO BOOK FOUND WITH THIS ID.\n");
                                        break;
                                    } else {
                                        String updateChoice = "";
                                        String ID = "";
                                        String title = "";
                                        String isbn = "";
                                        String publisher = "";
                                        String author = "";
                                        System.out.print("Do you want to update Book ID (y/n): ");
                                        updateChoice = input.next();
                                        input.nextLine();
                                        if (updateChoice.equals("y")) {
                                            System.out.print("Enter Book ID: ");
                                            ID = input.nextLine();
                                            for (Book books : mainLibrary.getBooks()) {
                                                if (books.getBookID().equals(bookID)) {
                                                    System.out.println("Book already exists with this ID. Enter a different ID: ");
                                                    ID = input.nextLine();
                                                }
                                            }
                                        } else {
                                            ID = book.getBookID();
                                        }

                                        System.out.print("Do you want to update Book Title (y/n): ");
                                        updateChoice = input.next();
                                        input.nextLine();
                                        if (updateChoice.equals("y")) {
                                            System.out.print("Enter Book Title: ");
                                            title = input.nextLine();
                                        } else {
                                            title = book.getTitle();
                                        }

                                        System.out.print("Do you want to update Book ISBN (y/n): ");
                                        updateChoice = input.next();
                                        input.nextLine();
                                        if (updateChoice.equals("y")) {
                                            System.out.print("Enter Book ISBN: ");
                                            isbn = input.nextLine();
                                        } else {
                                            isbn = book.getBookID();
                                        }

                                        System.out.print("Do you want to update Book Publisher (y/n): ");
                                        updateChoice = input.next();
                                        input.nextLine();
                                        if (updateChoice.equals("y")) {
                                            System.out.print("Enter Book Publisher: ");
                                            publisher = input.nextLine();
                                        } else {
                                            publisher = book.getBookID();
                                        }

                                        System.out.print("Do you want to update Book Author (y/n): ");
                                        updateChoice = input.next();
                                        input.nextLine();
                                        if (updateChoice.equals("y")) {
                                            System.out.print("Enter Book Author: ");
                                            author = input.nextLine();
                                        } else {
                                            ID = book.getBookID();
                                        }
                                        System.out.println(librarian.updateBookDetails(book, bookID, title, isbn, publisher, author));
                                        break;
                                    }
                                }
                                case 10: {
                                    System.out.println("\nDISPLAYING ALL BOOKS\n");
                                    System.out.println(librarian.displayBooks(mainLibrary.getBooks()));
                                    break;
                                }
                                case 11: {
                                    System.out.println("\nDISPLAYING ALL MEMBERS\n");
                                    System.out.println(librarian.displayMembers(mainLibrary.getMembers()));
                                    break;
                                }
                                case 12: {
                                    System.out.println("\nLOGGED OUT.\n");
                                    break;
                                }
                            }
                        }
                    }
                    break;
                }
                case 3: {
                    System.out.println("\nMEMBER LOGIN PORTAL\n");
                    System.out.print("Enter Username: ");
                    String memUName = input.nextLine();
                    System.out.println("Enter Member ID: ");
                    String memId = input.nextLine();
                    Member loggedMember = mainLibrary.memberLogin(memUName, memId, mainLibrary.getMembers());
                    if (loggedMember == null) {
                        System.out.println("NO MEMBER FOUND.");
                    } else {
                        System.out.println(loggedMember.getName() + " LOGGED IN SUCCESSFULLY");
                        System.out.println("------------------------------------");
                        System.out.println("\n      WELCOME TO MEMBER PORTAL");
                        System.out.println("\n------------------------------------\n");
                        memChoice = 0;
                        while (memChoice != 4) {
                            System.out.println("----------------------------------------------------");
                            System.out.println("FOLLOWING FUNCTIONALITIES ARE AVAILABLE AS A MEMBER");
                            System.out.println("-----------------------------------------------------\n");
                            System.out.println("1. Member Details\n2. Display Borrowed Books\n3. Display Transaction History\n4. Log Out");
                            System.out.print("Enter Your Choice: ");
                            memChoice = input.nextInt();
                            input.nextLine();
                            switch (memChoice) {
                                case 1: {
                                    System.out.println(loggedMember.toString());
                                    break;
                                }
                                case 2: {
                                    System.out.println("\nDISPLAYING BORROWED BOOKS\n");
                                    System.out.println(loggedMember.displayBorrowed());
                                    break;
                                }
                                case 3: {
                                    System.out.println("\nDISPLAYING MEMBER TRANSACTION HISTORY\n");
                                    System.out.println(loggedMember.viewTransactionHistory(mainLibrary.getTransactions()));
                                    break;
                                }
                                case 4: {
                                    System.out.println("\nLOGGED OUT\n");
                                    break;
                                }
                            }
                        }
                    }
                    break;
                }
                case 4: {
                    break;
                }
            }

        }
    }
}
