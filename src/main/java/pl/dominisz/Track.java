package pl.dominisz;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Track {

    private String title;
    private int time;
    private Genre genre;
    private String artist;
    private String composer;
    private String lyricsAuthor;

    public String toString() {
        return title + ", "
                + TimeUtils.format(time) + ", "
                + genre.getDescription() + ", wykonawca: "
                + artist + ", kompozytor: "
                + composer + ", autor tekstu: "
                + lyricsAuthor;
    }

}
