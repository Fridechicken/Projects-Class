import java.util.Scanner;
public class Library {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Book book1 = new Book("Novel","Person","1","Januray 4, 2003");
        Book book2 = new Book("My Book","Me","2","Januray 1, 2000");
        Book book3 = new Book("Book","Book","3","Januray 2, 2001");
        Book book4 = new Book("Rand","Random","4","Januray 3, 2002");
        int choice = 0;
        while (choice != 4) {
        System.out.println("\nWelcome to the library");
        System.out.println("1. Check out book");
        System.out.println("2. Return Books");
        System.out.println("3. Veiw books");
        System.out.println("4. Quit");
        System.out.print("Enter choice: ");
        choice = in.nextInt();
        in.nextLine();
        switch (choice) {
            case 1:  System.out.print("Which book (1-4) would you like to check out: ");
                    int outNum = in.nextInt();
                    switch (outNum) {
                        case 1:
                            book1.checkOut();
                            break;
                        case 2:
                            book2.checkOut();
                            break;
                        case 3:
                            book3.checkOut();
                            break;
                        case 4:
                            book4.checkOut();
                            break;
                        default:
                            System.out.println("Invalid book number");
                            break;
                    }
                    break;
            case 2: System.out.print("Which book (1-4) would you like to return: ");
                    int returnNum = in.nextInt();
                    switch (returnNum) {
                        case 1:
                            book1.returnBook();
                            break;
                        case 2:
                            book2.returnBook();
                            break;
                        case 3:
                            book3.returnBook();
                            break;
                        case 4:
                            book4.returnBook();
                            break;
                        default:
                            System.out.println("Invalid book number");
                            break;
                    }
            break;
            case 3: System.out.println("Books:");
                    System.out.println("1. " + book1);
                    System.out.println("2. " + book2);
                    System.out.println("3. " + book3);
                    System.out.println("4. " + book4);
            break;
            case 4: System.out.println("Goodbye!");
            break;
            default:
                    System.out.println("Please enter a valid option"); 

        } 
        }        
        
        
    }
}
