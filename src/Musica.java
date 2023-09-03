public class Musica {

    private String Artist;
    private String Track;

    private Double Danceability;
    private Double Energy;
    private Double durationMin;
    private Double Views;
    private Double Likes;

    public Musica(String Artist, String Track, Double Danceability, Double Energy, Double durationMin, Double Views, Double Likes) {

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

    public Double getDanceability() {
        return Danceability;
    }

    public void setDanceability(Double danceability) {
        Danceability = danceability;
    }

    public Double getEnergy() {
        return Energy;
    }

    public void setEnergy(Double energy) {
        Energy = energy;
    }

    public Double getDurationMin() {
        return durationMin;
    }

    public void setDurationMin(Double durationMin) {
        this.durationMin = durationMin;
    }

    public Double getViews() {
        return Views;
    }

    public void setViews(Double views) {
        Views = views;
    }

    public Double getLikes() {
        return Likes;
    }

    public void setLikes(Double likes) {
        Likes = likes;
    }
}
