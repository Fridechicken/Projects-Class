/*
* Final Project
* Logan Mitchell
* 5/4/26
* This is my own original work and complies with hands-free sharing
* I discussed this work with no one
*/
public class Board {
    private char[] lettersFromWord = new char[4]; // This is where the word to be guessed broken into indvidual letters is stored
    /**
     * Breaks the word to be guessed into seperate letter
     * @param word this is the word to be guessed
     */
    public void separateLetters(String word) {
        for (int i = 0; i < 4; i++) {
            lettersFromWord[i] = word.charAt(i);
        }
    }
    /**
     * this program takes a user entered guess and checks it to find how many bulls and cows and returns them
     * @param guess this is the guess that the user enterned
     * @return true for a correct guess or false for anything else
     */
    public boolean checkGuess(String guess){
        int cows = 0;
        int bulls = 0;
        boolean[] secretUsed = new boolean[4];
        boolean[] guessUsed = new boolean[4];
        for (int i = 0; i < 4; i++) {
            if (guess.charAt(i) == lettersFromWord[i]) {
                bulls++;
                secretUsed[i] = true;
                guessUsed[i] = true;
            }
        }
        for (int i = 0; i < 4; i++) {
            if (!guessUsed[i]) {
                for (int j = 0; j < 4; j++) {
                    if (!secretUsed[j] && guess.charAt(i) == lettersFromWord[j]) {
                        cows++;
                        secretUsed[j] = true;
                        break;
                    }
                }
            }
        }
        System.out.println("Result: "+bulls+" Bull(s) and "+cows+" Cow(s)");
        return bulls == 4;
    }
    /**
     * This is the menu for the game
     */
    public void menu(){
        System.out.println("Bulls and Cows");
        System.out.println("1 - Start Playing");
        System.out.println("2 - Read the rules");
        System.out.println("3 - Exit the game");
    }
    /**
     * This is where the user can see their options on their turn
     */
    public void turnMenu() {
        System.out.println("Turn Menu");
        System.out.println("1 - Guess");
        System.out.println("2 - Status");
        System.out.println("3 - Exit");
    }
}
