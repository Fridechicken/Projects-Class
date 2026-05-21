import java.util.Scanner;
public class Project1 {
    /**
     * This is the bulk of the code. Mostly activates other meathods and then does string formating at the end
     * @param args takes all arguments from other meathods to be used
     */
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       String product = getProductName(in);
       double price = getPrice(in);
       if (price <= 0) {
            in.close();
            System.out.println("The cost can't be negative");
            return;
       }//checks if input is negative
       double payment = getPayment(in);
       if (payment <= 0) {
            in.close();
            System.out.println("The payment can't be negative");
            return;
       }//checks if input is negative
       double total = payment - price;
       if (total <= 0) {
           in.close();
           System.out.println("The amount paid must be greater than or equal to the cost");
           return;
       }//checks if not enough for price
       String change = findChange(payment, price);
       System.out.printf("The purchase of %s for $%.2f with $%.2f requires change of $%.2f.%n", product, price, payment, total);
       System.out.println(change);
       in.close();
    }
    /**
     * This meathod gets price of the object
     * @param in gets input from user
     * @return returns price which is the price of the object
     */
    public static double getPrice(Scanner in) {
        double price = 0.0;
        System.out.println("What is the cost? Do not type the dollar sign.");
        if (in.hasNextDouble()) {
            double input = in.nextDouble(); 
                if (input > 0.0) {
                price = input;      
            }// checks user input to ensure ensure both a numeric input and a positive one                 
                else {
            System.out.println("The cost can't be negative");
            }// if the input is not positive
        } else {
            System.out.println("Please enter numbers only");
            in.next();
        }// if the input is not numeric 
        if (in.hasNextLine()) {
        in.nextLine();
    }  
        return price;   
    }
    /**
     * This meathod gets the name of the product
     * @param in gets input from the user
     * @return returns product which is the name of the product
     */
    public static String getProductName(Scanner in) {
        String productName = "Unknown Product";//default value
        System.out.println("What is the product purchased?");
        if (in.hasNextLine()) {
            productName = in.nextLine();
        }//checks to ensure that input is a string
        else {
            System.out.println("Please enter the name in words");
            in.next();
        }//if user input is not a string
    return productName;
    }
    /**
     * This meathod gets the payment amount from the user
     * @param in gets input from user
     * @return returns payment which is how much the user is paying
     */
    public static double getPayment(Scanner in) {
        double payment = 0.0;//default value
            System.out.println("How much was paid? Do not type the dollar sign.");
            if (in.hasNextDouble()){
                double input = in.nextDouble();
                if (input > 0.0) {  
                    payment = input;   
                }//checks user input to ensure ensure both a numeric input and a positive one
                    else {
                    System.out.println("The cost can't be negative");
                }// if the input is not positive
            }
            else {
                    System.out.println("Please enter numbers only");
                    in.next();  
            }// if the input is not numeric 
        return payment;
    }
    /**
     * this meathod calulates the change to give
     * @param payment takes the payment input from getPayment
     * @param price takes the price input from getPrice
     * @return returns change which is the formatted string with correct change
     */
    public static String findChange(double payment, double price) {
        String change;//needed for return value
        long totalChange;//needed for calculations. Uses long for protection
        long newPrice = (long) (price * 100 + 0.5);//converts price into pennies and adds 0.5 to fix rounding problem
        long newPayment = (long) (payment * 100 + 0.5);//converts payment into pennies and adds 0.5 to fix rounding problem
        totalChange = newPayment - newPrice;//subtracts the two to get change in pennies
        long fiveDollar = totalChange / 500;//finds 5 dollar amount needed
        totalChange %= 500;//updates totalChange for accurate change
        long oneDollar = totalChange / 100;//finds 1 dollar amount needed
        totalChange %= 100;//updates totalChange for accurate change
        long quarters = totalChange / 25;//finds quarters amount needed
        totalChange %= 25;//updates totalChange for accurate change
        long dimes = totalChange / 10;//finds dimes amount needed
        totalChange %= 10;//updates totalChange for accurate change
        long nickels = totalChange / 5;//finds nickel amount needed
        totalChange %= 5;//updates totalChange for accurate change
        long pennies = totalChange;//whats left at end
        change = "This is "+fiveDollar+" $5 bills, "+oneDollar+" $1 bills, "+quarters+" quarters, "+dimes+" dimes, "+nickels+" nickels and, "+pennies+" pennies.";//string to be printed in main in correct order
        return change;
    }
}

