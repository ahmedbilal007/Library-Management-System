import java.util.Scanner;

public class Main {

    public static void mainFlow(Library lib) {

        Scanner input = new Scanner(System.in);

        System.out.println("LIBRARY MANAGEMENT SYSTEM");
        System.out.println("-------------------------\n\n\n\n\n\n\n\n");
        System.out.println("1. Administration Use");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        while (true) { 
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            switch (choice) {
        // if (choice == 1)  {
            case 1: {
            boolean login = lib.adminLogin();
            if (login == true) {
                System.out.println("FOLLOWING FUNCTIONATLITIES ARE AVAILABLE AS AN ADMIN.\n");
                System.out.println("1. Search Book\n2. Search Member\n3. Show All Books\n4. Show All Members\n5. Add Librarian\n6. Log Out");
                while (true) {
                    System.out.print("Enter your choice: ");
                    int admChoice = input.nextInt();
                }
            }
        }
            case 2: break;
        // }  else if (choice == 3) {
            
        }
        
        }
    }
    


    public static void main(String[] args) {
        
        Library mainLibrary = new Library();
        mainFlow(mainLibrary);


    }
    
}
