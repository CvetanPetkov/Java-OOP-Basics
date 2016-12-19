package p05_OnlineRadioDatabase;

public class Song {
    private String artistName;
    private String songName;
    private Integer minutes;
    private Integer seconds;

    public Song(String artistName, String songName, Integer minutes, Integer seconds){
        this.setArtistName(artistName);
        this.setSongName(songName);
        this.setMinutes(minutes);
        this.setSeconds(seconds);
    }

    //  GETTERS AND SETTERS
    public String getArtistName(){
        return this.artistName;
    }
    private void setArtistName(String artistName){
        if (isValidName(artistName)) {
            this.artistName = artistName;
        }
    }

    public String getSongName(){
        return this.songName;
    }
    private void setSongName(String songName){
        if (isValidSongName(songName)) {
            this.songName = songName;
        }
    }

    public Integer getMinutes(){
        return this.minutes;
    }
    private void setMinutes(Integer minutes){
        if (isValidMinutes(minutes)){
            this.minutes = minutes;
        }
    }

    public Integer getSeconds(){
        return this.seconds;
    }
    private void setSeconds(Integer seconds){
        if (isValidSeconds(seconds)){
            this.seconds = seconds;
        }
    }
    //  VALIDATORS
    private boolean isValidName(String artistName){
        if (artistName.trim().length() < 3 || artistName.trim().length() > 20){
            throw new IllegalArgumentException("Artist name should be between 3 and 20 symbols.");
        }
        else {
            return true;
        }
    }
    private boolean isValidSongName(String songName){
        if (songName.trim().length() < 3 || songName.trim().length() > 30){
            throw new IllegalArgumentException("Song name should be between 3 and 30 symbols.");
        }
        else {
            return true;
        }
    }
    private boolean isValidMinutes(Integer minutes){
        if (minutes < 0 || minutes > 14){
            throw new IllegalArgumentException("Song minutes should be between 0 and 14.");
        }
        else {
            return true;
        }
    }
    private boolean isValidSeconds(Integer seconds){
        if (seconds < 0 || seconds > 59){
            throw new IllegalArgumentException("Song seconds should be between 0 and 59.");
        }
        else {
            return true;
        }
    }
    //  METHODS
}
