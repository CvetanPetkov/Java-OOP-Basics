package p05_OnlineRadioDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Song> songList = new ArrayList<>();
        int n = Integer.valueOf(reader.readLine());

        for (int i = 0; i < n; i++) {

            try {
                String[] tokens = reader.readLine().split(";");
                if (isValidSong(tokens)) {
                    String author = tokens[0];
                    String songTitle = tokens[1];
                    String[] songLength = tokens[2].split(":");
                    if (isValidLength(songLength)) {
                        Integer minutes = Integer.valueOf(songLength[0]);
                        Integer seconds = Integer.valueOf(songLength[1]);
                        Song song = new Song(author, songTitle, minutes, seconds);
                        songList.add(song);
                        System.out.println("Song added.");
                    }
                }
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }

        }

        PlayList playList = new PlayList(songList);
        System.out.println(playList.toString());

    }


    private static boolean isValidLength(String[] songLength) {
        if (songLength.length != 2) {
            throw new IllegalArgumentException("Invalid song length.");
        } else {
            return true;
        }
    }

    private static boolean isValidSong(String[] tokens) {
        if (tokens.length != 3) {
            throw new IllegalArgumentException("Invalid song.");
        } else {
            return true;
        }
    }
}
