import java.util.Scanner;
public class Date_formating {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean goodInput = true; 
        int month = inputMonth(in);
        if (month < 1 || month > 12) {
            goodInput = false;
        }
        int day = 0; 
        if (goodInput) { 
            day = inputDay(in, month); 
            if (day == 0) {
                goodInput = false;
            }
        }
        int year = 0;
        if (goodInput) {
            year = inputYear(in);
            if (year == 0) {
                goodInput = false;
            }
        }
        if (goodInput) { 
        printAmerican(month, day, year);
        printEuropean(month, day, year);
        } 
        else {
        System.out.println("invalid input");
    }
    in.close();
    }
    public static int inputMonth(Scanner input) {
        int month = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.println("Enter the month in numbers: ");
            if (input.hasNextInt()) {
                month = input.nextInt();
                isValid = true;
            } else {
                input.next();
                System.out.println("Please enter an integer");
            }    
            }
            return month;
    }
    public static String nameMonth(int month) {
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        if (month >= 1 && month <= 12) {
            return monthNames[month - 1];
        }
        return "invalid";
    }
    public static int inputDay(Scanner input, int month) {
    int day = 0;
    int[] numOfDays = {28, 30, 31};
    boolean isValid = false;
    while (!isValid) {
        System.out.print("Enter the day: ");
        if (input.hasNextInt()) {
            day = input.nextInt(); 
            int maxDays;
            switch (month) {
                case 2: maxDays = numOfDays[0]; 
                break;
                case 4: 
                case 6: 
                case 9: 
                case 11: maxDays = numOfDays[1]; 
                break;
                default: maxDays = numOfDays[2]; 
                break;
            }
            if (day >= 1 && day <= maxDays) {
                isValid = true; 
            } else {
                System.out.println("Invalid day");
            }
        } else {
            System.out.println("Please enter a valid integer.");
            input.next(); 
        }
    }
    return day; 
}
    public static int inputYear(Scanner input) {
        int year = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print("Enter the year: ");
            if (input.hasNextInt()) {
                year = input.nextInt();
                if (year >= 1000 && year <= 9999) {
                    isValid = true;
                } else {
                    System.out.println("Invalid year. Please enter a 4-digit year.");
                }
            } else {
                System.out.println("Please enter a number.");
                input.next();
            }
        }
        return year;
    }
    public static void printAmerican(int month, int day, int year) {
            String monthName = nameMonth(month);
            System.out.println(monthName + " " + day + ", " + year);
    }
    public static void printEuropean(int month, int day, int year) {
            String monthName = nameMonth(month);
            System.out.println(day + " " + monthName + " " + year);
    }
}
