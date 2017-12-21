package pl.dominisz;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class CD {

    private String title;
    private String artist;
    private List<Track> tracks;
    private int releaseYear;

    public CD(String title, String artist, int releaseYear) {
        this.title = title;
        this.artist = artist;
        this.tracks = new ArrayList<>();
        this.releaseYear = releaseYear;
    }

    public void addTrack(Track track) {
        tracks.add(track);
    }

    public int totalTime() {
        return tracks.stream()
                .mapToInt(track -> track.getTime())
                .sum();
    }

    public Set<Genre> getGenres() {
        Set<Genre> genres = new HashSet<>();
        for (Track track : tracks) {
            genres.add(track.getGenre());
        }
        return genres;
        /*
        return tracks.stream()
                .map(track -> track.getGenre())
                .collect(Collectors.toSet());
        */
    }
}
