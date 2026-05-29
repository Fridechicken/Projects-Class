import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class Journal_writer {
    static final String FILE_NAME = "journal.txt";
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (choice != 3) {
            System.out.println("\n--- Journal Menu ---");
            System.out.println("1. Write a new entry");
            System.out.println("2. Read all entries");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            choice = input.nextInt();
            input.nextLine(); // consume leftover newline
            switch (choice) {
            case 1: writeEntry(input);
            break;
            case 2: readEntries();
            break;
            case 3: System.out.println("Goodbye!");
            break;
            default: System.out.println("Invalid option. Try again.");
            break;
            }
        }
        input.close();
    }
    static void writeEntry(Scanner in) {
        try {
            System.out.print("Write your entry: ");
            String entry = in.nextLine();
            LocalDateTime current = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");
            String formatted = current.format(formatter);
            FileWriter fileOut = new FileWriter("journal.txt", true);
            fileOut.write("----------------------"+"\n");
            fileOut.write(formatted+ ": ");
            fileOut.write(entry+"\n");
            fileOut.close();
            System.out.println("Done writing");   
        } catch (Exception e) {
            System.out.println("An error occurred.");
        }
    }
    static void readEntries() {
        File fileToRead = new File("journal.txt");
        try (Scanner read = new Scanner(fileToRead)) {
            if (fileToRead.exists()) {
                while (read.hasNextLine()) {
                    String data = read.nextLine();
                    System.out.println(data);
                }
                read.close();
            }
            else {
                System.out.println("This file is empty");
            }
        } 
        catch (Exception e) {
        System.out.println("An error occurred."+e.getMessage());
        }
    }
}
