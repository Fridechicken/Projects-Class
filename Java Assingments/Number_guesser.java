//Start -> generate random number -> prmopt for int input from 1-10 -> check if input is int -> if no print error prompt again -> if yea check if input is in range -> if not then print error prompt again -> check if input is too low -> if too low display and prompt again -> if too high display and prompt again -> if input is number the display -> End
import java.util.Random;
import java.util.Scanner;
public class Number_guesser {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int userInput = getInput(in);
        int randomNum = generateRandomNumber();
        while (userInput != randomNum) {
            if (userInput > randomNum) {
                System.out.println("Too big guess again");
            }
            else {
                System.out.println("Too small guess again");
            }
            userInput = getInput(in);
        }
        System.out.println("You guessed the number!");
    }
    public static int generateRandomNumber() {
        Random rand = new Random();
        int randomNum = rand.nextInt(10) + 1;
        return randomNum;
    }
    public static int getInput(Scanner input) {
        int userInput = -1;
            while (userInput == -1){
            System.out.println("Please enter a number between 1 - 10: ");
            if (input.hasNextInt()){
                userInput = input.nextInt();
                if (userInput < 1 || userInput > 10) {
                    userInput = -1;
                    System.out.println("Please enter a number within the range");
            }
            }
            else {
                System.out.println("Please enter a number");
                input.nextLine();
            }
        }   
        return userInput;   
    }
/*  public static int checkNumber(Scanner input, int userInput, int randomNum) {
        while (userInput != randomNum) {
        if (userInput == randomNum) {
            System.out.println("You guessed the number!");
            
        }
        else if (userInput > randomNum) {
            System.out.println("To big guess again");
        }
        else {
            System.out.println("To small guess again");
        }
    }
} */
}
