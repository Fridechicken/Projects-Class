/*
* Final Project
* Logan Mitchell
* 5/4/26
* This is my own original work and complies with hands-free sharing
* I discussed this work with no one
*/
import java.util.Scanner;
public class Game{
    static Scanner in = new Scanner(System.in);
    static Player player1 = new Player();
    static Player player2 = new Player();
    static Board board = new Board();
    static String name1;
    static String name2;
    static int state = 0; // 0 is the menu, 1 is setup, 2 is playing, 3 is the score, 4 is to exit
    static Player chooser;
    static Player guesser;
    static String chooserName;
    static String guesserName;
    /**
     * This will show the current status of the game
     */
    public static void showStatus() {
        System.out.println("Current Status: "+chooserName+" is choosing, "+guesserName+" is guessing.");
    }
    /**
     * This is where the game logic will be exucuted
     * @param args takes from command line
     */
    public static void main(String[] args) {
        name1 = player1.getName(1);
        name2 = player2.getName(2);
        chooser = player1;
        guesser = player2;
        chooserName = name1;
        guesserName = name2;
        while (state != 4) {
            if (state == 0) {
                board.menu();
                int choice = in.nextInt();
                in.nextLine();
                if (choice == 1) {
                    state = 1;
                }
                else if (choice == 2) {
                    System.out.println("These are the rules: ");
                    System.out.println("""
                                        One player, the Chooser, thinks of a four-letter word and the other player, the Guesser, tries to guess it.\r
                                        At each turn the Guesser tries a four-letter word, and the Chooser says how close it is to the answer by giving:\r
                                        The number of Bulls - letters correct in the right position.\r
                                        The number of Cows - letters correct but in the wrong position.\r
                                        The Guesser tries to guess the answer in the fewest number of turns.\r
                                        If either word has repeated letters the rule is that each letter can only count towards the score once, and Bulls are counted before Cows.\r
                                        Rules taken from: http://www.papg.com/show?1TLX""" 
                        );
                } 
                else if (choice == 3) {
                    state = 4;//ends the game
                } 
            } 
            else if (state == 1) {
                String word = chooser.getSecretWord(chooserName);
                if (word.length() == 4) {
                    board.separateLetters(word);
                    for (int i = 0; i < 100; i++) { //this prevents the guesser from seeing the word
                        System.out.println();
                    } 
                    state = 2; 
                }
                else {
                    System.out.println("Please enter a 4 lettter word");
                }
            } 
            else if (state == 2) {
                System.out.println(guesserName+" chose what to do:");
                board.turnMenu();
                int turnChoice = in.nextInt();
                in.nextLine();
                if (turnChoice == 1) {
                    String guess = guesser.getGuess(guesserName);
                    if (guess.length() == 4) {
                        boolean won = board.checkGuess(guess);
                        if (won) {
                            guesser.addWin();
                            state = 3; 
                        }
                    } else {
                        System.out.println("Guesses must be 4 letters.");
                    }
                }
                else if (turnChoice == 2){
                    showStatus();
                    guesser.displayStats(guesserName);
                }
                else if (turnChoice == 3) {
                    state = 4;
                }
                else {
                    System.out.println("Please enter a valid option");
                }
            } 
            else if (state == 3) {
                System.out.println("Score: "+name1+" ("+player1.getScore()+") - "+name2+" ("+player2.getScore()+")");
                Player SwapPositions = chooser; 
                chooser = guesser; 
                guesser = SwapPositions;
                String SwapNames = chooserName; 
                chooserName = guesserName; 
                guesserName = SwapNames;
                System.out.println("Next round? (1: Yes, 3: Exit)");
                int nextChoice = in.nextInt();
                if (nextChoice == 1) {
                    state = 1; 
                } else {
                    state = 4; 
                }
            }
        }
        System.out.println("Goodbye!");
    }
}