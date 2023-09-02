public class Musica {

    private String Artist, Track, Danceability, Energy, durationMin, Views, Likes;

    public Musica(String Artist, String Track, String Danceability, String Energy, String durationMin, String Views, String Likes) {

        this.Artist = Artist;
        this.Track = Track;
        this.Danceability = Danceability;
        this.Energy = Energy;
        this.durationMin = durationMin;
        this.Views = Views;
        this.Likes = Likes;
    }

    public String getArtist() {
        return Artist;
    }

    public void setArtist(String artist) {
        Artist = artist;
    }

    public String getTrack() {
        return Track;
    }

    public void setTrack(String track) {
        Track = track;
    }

    public String getDanceability() {
        return Danceability;
    }

    public void setDanceability(String danceability) {
        Danceability = danceability;
    }

    public String getEnergy() {
        return Energy;
    }

    public void setEnergy(String energy) {
        Energy = energy;
    }

    public String getDurationMin() {
        return durationMin;
    }

    public void setDurationMin(String durationMin) {
        this.durationMin = durationMin;
    }

    public String getViews() {
        return Views;
    }

    public void setViews(String views) {
        Views = views;
    }

    public String getLikes() {
        return Likes;
    }

    public void setLikes(String likes) {
        Likes = likes;
    }
}
