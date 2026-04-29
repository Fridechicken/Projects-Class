/*
* Project 2
* Logan Mitchell
* 3/24/26
* This is my own original work and complies with hands-free sharing
* I discussed this work with no one
*/
import java.util.Arrays;
public class Project2 {
    /**
     * this is the main function that complies everything
     * @param args
     */
    public static void main(String[] args) {
        String[] row1 = {"D","E","H","H","A","G","O","R","F","S"};
        String[] row2 = {"E","T","K","K","L","J","H","B","C","I"};
        String[] row3 = {"S","F","G","W","K","G","E","W","R","Q","N","D","F","E","A","C","E","A","R"};
        String[] row4 = {"Q","J","A","N","X","T","B","K","N","A","D","L","G","E","D","L","G","P","J","E"};
        String[] row5 = {"S","W","E","A","T","R","A","N","T","L","N","M","F","K","L","J","E","F","A","W","F","V","G","H","H","M","W","E"};
        String[] row6 = {"X","T","T","L","K","K","F","W","W","C","C","B","A","J","J"};
        String[] row7 = {"N","L","K","P","O","L","K","A","N","N"};
        String[] row8 = {"V","I","C","G","U","J","L","B","O","A","R","S","T","E","W"};
        String[] row9 = {"p","e","n","g","u","I","n","u","j","x"};
        String[] row10 = {"S","G","F","C","W","S","D","E","O","V"};
        String row1Print = row1Solved(row1);
        String row2Print = row2Solved(row2);
        String row3Print = row3Solved(row3);
        String row4Print = row4Solved(row4);
        String row5Print = row5Solved(row5);
        String row6Print = row6Solved(row6);
        String row7Print = row7Solved(row7);
        String row8Print = row8Solved(row8);
        String row9Print = row9Solved(row9);
        String row10Print = row10Solved(row10);
        System.out.print(row1Print);
        System.out.println();
        System.out.print(row2Print);
        System.out.println();
        System.out.print(row3Print);
        System.out.println();
        System.out.print(row4Print);
        System.out.println();
        System.out.print(row5Print);
        System.out.println();
        System.out.print(row6Print);
        System.out.println();
        System.out.print(row7Print);
        System.out.println();
        System.out.print(row8Print);
        System.out.println();
        System.out.print(row9Print);
        System.out.println();
        System.out.print(row10Print);
        System.out.println();
        System.out.println("Cat, Giraffe, Snake, Gnat, Elk, Elephant, Ape, Penguin, Frog, Dog");
    }
    /**
     * iterates throught the row backwords and returns it
     * @param row1 allows row one from main to be used
     * @return returns cleaned version
     */
    static public String row1Solved(String[] row1) {
        String result = "";
        for (int i = row1.length - 1; i >= 0; i--) { // -- allows for the walkthrough to be backwards
                result += row1[i] + " ";
            } 
        return result;
    }
    /**
     * sorts row into alphabetical order and returns it
     * @param row2 allows row two from main to be used
     * @return returns cleaned version
     */
    static public String row2Solved(String[] row2) {
        String result = "";
        Arrays.sort(row2);//sorts aphabetically
        for (int i = 0; i < row2.length; i++) {
            result += row2[i] + " ";
        }
        return result; 
    }
    /**
     * does mod 2 to find even indices and returns it
     * @param row3 allows row three from main to be used
     * @return returns cleaned version
     */
    static public String row3Solved(String[] row3) {
        String result = "";
        for (int i = 0; i < row3.length; i++) {
            if (i % 2 == 0) {//checks if remainder is 0
                result += row3[i] + " ";//if yes then add to results
            }
        }
        return result;
    }
    /**
     * does mod 2 to find odd indices and returns it
     * @param row4 allows row four from main to be used
     * @return returns cleaned version
     */
    static public String row4Solved(String[] row4) {
        String result = "";
        for( int i = 0; i < row4.length; i++) {
            if (i % 2 != 0) {//checks if remanined is not 0
                result += row4[i] + " ";//if yes then add to results
            }
        }
        return result;
    }
    /**
     * does mod 3 to find indices divisible by three and returns it
     * @param row5 allows row five from main to be used
     * @return returns cleaned version
     */
    static public String row5Solved(String[] row5) {
        String result = "";
        for( int i = 0; i < row5.length; i++) {
            if (i % 3 == 0) {//checks if remainder is 0
                result += row5[i] + " ";// if yes then add to results
            }
        }
        return result;
    }
    /**
     * checks the letter before it in the row, and if not a duplicate, returns it
     * @param row6 allows row six from main to be used
     * @return returns cleaned version
     */
    static public String row6Solved(String[] row6) {
        String result = "";
        for (int i = 0; i < row6.length; i++) {
            if (i == 0 || !row6[i].equals(row6[i - 1])) {//checks if element before is equal
                result += row6[i] + " ";
            }
        }
        return result;
    }
    /**
     * changes the the letter at index 4 to E and returns it
     * @param row7 allows row seven from main to be used
     * @return returns cleaned version
     */
    static public String row7Solved(String[] row7) {
        String result = "";
        row7[4] = "E";//changes o to e
        for (int i = 0; i < row7.length; i++) {
            result += row7[i] + " ";
        }
        return result;
    }
    /**
     * checks if vowel and returns the ones that are not 
     * @param row8 allows row eight from main to be used
     * @return returns cleaned version
     */
    static public String row8Solved(String[] row8) {
    String result = "";
    for (int i = 0; i < row8.length; i++) {
        char val = row8[i].charAt(0); //makes val which is a character for checking in if
        if (val != 'A' && val != 'E' && val != 'I' && val != 'O' && val != 'U') {//checks if element is not a vowel
            result += row8[i] + " "; //if not then add to results
        }
    }
        return result; 
    }
    /**
     * converts the row to upper case and retuns it
     * @param row9 allows row nine from main to be used
     * @return returns cleaned version
     */
    static public String row9Solved(String[] row9) {
        String result = "";
         for (int i = 0; i < row9.length; i++) {
            result += row9[i].toUpperCase() + " ";//converts row to upper case
        }
        return result;
    }
    /**
     * take each element in the row and finds if even or odd indices through mod and the returns the even first and odd after
     * @param row10 allows row ten from main to be used
     * @return returns cleaned version
     */
    static public String row10Solved(String[] row10) {
        String result = "";
        for (int i = 0; i < row10.length; i++) {
            if (i % 2 == 0) {//chackes if remainder is zero
                result += row10[i] + " ";//if yes then add to results 
            }
        }
        for (int i = 1; i < row10.length; i++) {
            if (i % 2 != 0) {//checks if remainder is not zero
                result += row10[i] + " ";//if yes then add to results
            }
        }
        return result;
    }

}
