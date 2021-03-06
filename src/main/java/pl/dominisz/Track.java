package pl.dominisz;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class Track {

    private String title;
    private int time;
    private Genre genre;
    private String artist;
    private String composer;
    private String lyricsAuthor;

}
