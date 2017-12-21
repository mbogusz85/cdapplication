package pl.dominisz;

public class TrackBuilder {

    private String title;
    private int time;
    private Genre genre;
    private String artist;
    private String composer;
    private String lyricsAuthor;

    public TrackBuilder() {
    }

    public TrackBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public TrackBuilder withTime(int time) {
        this.time = time;
        return this;
    }

    public TrackBuilder withGenre(Genre genre) {
        this.genre = genre;
        return this;
    }

    public TrackBuilder withArtist(String artist) {
        this.artist = artist;
        return this;
    }

    public TrackBuilder withComposer(String composer) {
        this.composer = composer;
        return this;
    }

    public TrackBuilder withLyricsAuthor(String lyricsAuthor) {
        this.lyricsAuthor = lyricsAuthor;
        return this;
    }

    public Track build() {
        return new Track(title, time, genre, artist, composer, lyricsAuthor);
    }
}
