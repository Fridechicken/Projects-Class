// Start -> get the movie title -> get number of friends -> get Start time -> 
import java.util.Scanner;
public class Party_planner {
    public static int getStartTime(Scanner input) {
        int time = 0;
        System.out.println("What time is the party starting: ");
        if (input.hasNextInt()) {
            time = input.nextInt();
            return time;
        }
        else {
            input.next();
            System.out.println("Please enter an intiger");
            return time;
        }
    }
    public static int getNumOfFriends(Scanner input) {
        int friends= 0;
        System.out.println("How many friends are coming: ");
        if ((input.hasNextInt())) {
            friends = input.nextInt();
            return friends;
        }
        else {
            input.next();
            System.out.println("Please enter an intiger");
            return friends;
        }
    }
    public static String getMovieTitle(Scanner input) {
        String movie;
        System.out.println("What movie will you be watching: ");
        movie = input.next();
        return movie;
    }
    public static String getFood(Scanner input, int time, int friends) {
        String food = "invalid";
        if (friends < 0) {
            System.out.println("We do not supoort sad parties");
            return food;
        }
        else {
            if (friends >= 5) {
                food = "Potluck!";
                return food;
            } 
            else {
                if (time < 4) {
                    if (friends < 3) {
                        food = "Popcorn";
                        return food;
                    }
                    else {
                        food = "bags of candy";
                        return food;
                    }   
                }
                else {
                    if (friends < 3) {
                        food = "sandwiches";
                        return food;
                    }
                    else {
                        food = "pizza";
                        return food;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // Get input for movie
        String movie = getMovieTitle(in);
        // get input for num of freinds
        int numOfFriends = getNumOfFriends(in);
        // get input for time
        int startTime = getStartTime(in);
        // calculate food
        String food = getFood(in, startTime, numOfFriends);
        // print
        System.out.println("The start time is: "+startTime+"\nThe movie is: "+movie+"\nNumber of friends coming are: "+numOfFriends+"\nThe food will be: "+food);
        in.close();
    }
}