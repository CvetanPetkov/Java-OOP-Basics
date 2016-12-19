package p05_OnlineRadioDatabase;

import java.util.ArrayList;

public class PlayList {
    private Integer totalSongs;
    private Integer hours;
    private Integer minutes;
    private Integer seconds;
    private ArrayList<Song> songList;

    public PlayList(ArrayList<Song> list){
        this.songList = list;
        this.setTotalSongs();
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }

    // GETTERS AND SETTERS
    private Integer getTotalSongs(){
        return this.totalSongs;
    }
    private void setTotalSongs(){
        this.totalSongs = this.songList.size();
    }

    private Integer getHours(){
        return this.hours;
    }

    private Integer getMinutes(){
        return this.minutes;
    }
    private void setMinutes(){
        for (Song song : songList) {
            this.minutes += song.getMinutes();
        }
    }

    private Integer getSeconds(){
        return this.seconds;
    }
    private void setSeconds(){
        for (Song song : songList) {
            this.seconds += song.getSeconds();
        }
    }

    // METHODS
    @Override
    public String toString(){
        calculateTotalTime(this.songList);
        return String.format("Songs added: %d\nPlaylist length: %dh %dm %ds",
                getTotalSongs(), getHours(), getMinutes(), getSeconds());
    }

    private void calculateTotalTime(ArrayList<Song> songList){
        setMinutes();
        setSeconds();

        this.minutes += getSeconds() / 60;
        this.seconds %= 60;
        this.hours = this.minutes / 60;
        this.minutes %= 60;
    }
}
