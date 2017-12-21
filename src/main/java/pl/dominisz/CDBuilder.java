package pl.dominisz;

import java.util.ArrayList;
import java.util.List;

public class CDBuilder {

    private String title;
    private String artist;
    private List<Track> tracks;
    private int releaseYear;

    public CDBuilder() {
        tracks = new ArrayList<>();
    }

    public CDBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public CDBuilder withArtist(String artist) {
        this.artist = artist;
        return this;
    }

    public CDBuilder withTracks(List<Track> tracks) {
        this.tracks.addAll(tracks);
        return this;
    }

    public CDBuilder withTrack(Track track) {
        this.tracks.add(track);
        return this;
    }

    public CDBuilder withReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
        return this;
    }

    public CD build() {
        CD cd = new CD(title, artist, releaseYear);
        cd.setTracks(tracks);
        return cd;
    }
}
