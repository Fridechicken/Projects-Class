/*
* Final Project
* Logan Mitchell
* 5/4/26
* This is my own original work and complies with hands-free sharing
* I discussed this work with no one
*/
import java.util.Scanner;
public class Player {
    private Scanner in = new Scanner(System.in);
    private int score = 0;
    /**
     * this will be used to get the word to be guessed
     * @return this will return the word in lowercaseto avoid errors
     */
    public String getSecretWord(String name) {
        System.out.print(name+" enter a 4-letter word: ");
        return in.nextLine().toLowerCase();
    }
    /**
     * this will get the geuss from the second player
     * @return this will return their guess in lowercase to avoid errors
     */
    public String getGuess(String name) {
        System.out.print(name+" enter your guess: ");
        return in.nextLine().toLowerCase();
    }
    /**
     * 
     * @param playerNum this is to distingush between the two players
     * @return the name that the user enters
     */
    public String getName(int playerNum) {
        System.out.println("Player "+playerNum+" please enter you name: ");
        return in.nextLine();
    }
    /**
     * this updates the score to keep track
     */
    public void addWin() { 
        score++; 
    }
    /**
     * this returns the score to be printed off
     * @return the score
     */
    public int getScore() { 
        return score; 
    }
    /**
     * this takes the name of one of the players and displays their stats
     * @param name the user entered name
     */
    public void displayStats(String name) {
        System.out.println("Player: "+name+" | Wins: "+score);
    }
}