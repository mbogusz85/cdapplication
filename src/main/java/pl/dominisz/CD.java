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

    public int getTotalTime() {
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

    public List<Track> findTracksByTitle(String title) {
        String lowerCaseTitle = title.toLowerCase();
        return tracks.stream()
                .filter(track -> track.getTitle().toLowerCase().contains(lowerCaseTitle))
                .collect(Collectors.toList());
    }

    public List<Track> findTracksByGenre(Genre genre) {
        return tracks.stream()
                .filter(track -> track.getGenre() == genre)
                .collect(Collectors.toList());
    }

    public String toString() {
        return artist + ", " + title + ", " + releaseYear + ", tracks: " + tracks.size();
    }

    public String toFullString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(artist);
        stringBuilder.append(", ");
        stringBuilder.append(title);
        stringBuilder.append(", ");
        stringBuilder.append(releaseYear);
        stringBuilder.append("\n");
        for (int i = 0; i < tracks.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(tracks.get(i));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
