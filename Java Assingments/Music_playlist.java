import java.util.ArrayList;
import java.util.Scanner;
public class Music_playlist {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // TODO: Initialize ArrayLists for titles, artists, and genres
        ArrayList<String> songs = new ArrayList<String>();
        ArrayList<String> artists = new ArrayList<String>();
        ArrayList<String> genres = new ArrayList<String>();
        int choice = 0;
        while (choice != 4) {
            System.out.println("\n--- Playlist Menu ---");
            System.out.println("1. Add a song");
            System.out.println("2. Remove a song");
            System.out.println("3. Display playlist");
            System.out.println("4. Quit");
            System.out.print("Enter choice: ");
            choice = in.nextInt();
            in.nextLine();
            if (choice == 1) {
            // TODO: Add a song to the playlist
            System.out.print("Enter the song name: ");
            if (in.hasNextLine()) {
                String songName = in.nextLine();
                songs.add(songName);
            }
            System.out.print("Enter the artists name: ");
            if (in.hasNextLine()) {
                String artistsName = in.nextLine();
                artists.add(artistsName);
            }
            System.out.print("Enter the genre: ");
            if (in.hasNextLine()) {
                String genreType = in.nextLine();
            genres.add(genreType);
            }
            } else if (choice == 2) {
            // TODO: Remove a song from the playlist
            // Hint: Ask user for an index to remove
            System.out.print("Enter the song name you would like to remove: ");
            if (!songs.isEmpty()){
            if (in.hasNextLine()) {
                String songName = in.nextLine();
                if (songs.contains(songName)) {
                    songs.remove(songName);
                }
                else {
                    System.out.println("this song is not in the playlist");
                }
            }
            }
            else {
                System.out.println("There are no songs in the playlist");
            }
            System.out.print("Enter the artists name that you would like to remove: ");
            if (!artists.isEmpty()) {
            if (in.hasNextLine()) {
                String artistsName = in.nextLine();
                if (artists.contains(artistsName)) {
                    artists.remove(artistsName);
                }
                else {
                    System.out.println("this artists is not in the playlist");
                }
            }
            }
            else {
                System.out.println("There are no artisits in the playlist");
            }
            System.out.print("Enter the genre that you would like to remove: ");
            if (!genres.isEmpty()) {
            if (in.hasNextLine()) {
                String genreType = in.nextLine();
                if (genres.contains(genreType)) {
                    genres.remove(genreType);
                }
                else {
                    System.out.println("This genre is not in the playlist");
                }
            }
            }
            else {
                System.out.println("There are no genres in the playlist");
            }
            } else if (choice == 3) {
            // TOTO: Display the playlist
            for (int i = 0; i<songs.size(); i++) {
                System.out.print("Song: "+songs.get(i)+" ");
            }
            for (int i = 0; i<artists.size(); i++) {
                System.out.print("Artist: "+artists.get(i)+" ");
            }
            for (int i = 0; i<genres.size(); i++) {
                System.out.print("Genre: "+genres.get(i)+" ");
            }
            } else if (choice == 4) {
            System.out.println("Goodbye!");
            } else {
            System.out.println("Invalid choice.");
            }
        }
    }
}

