package pl.dominisz;

import org.junit.jupiter.api.Test;

/**
 * http://dominisz.pl
 * 22.12.2017
 */
public class LibraryTest {

    @Test
    public void testSaveToFile() {
        Track track01 = new TrackBuilder()
                .withTitle("title1")
                .withTime(100)
                .withGenre(Genre.POP)
                .withArtist("artist1")
                .withComposer("composer1")
                .withLyricsAuthor("lyricsAuthor1")
                .build();
        Track track02 = new TrackBuilder()
                .withTitle("title2")
                .withTime(200)
                .withGenre(Genre.RAP)
                .withArtist("artist2")
                .withComposer("composer2")
                .withLyricsAuthor("lyricsAuthor2")
                .build();
        CD cd = new CDBuilder()
                .withTitle("cd title1")
                .withArtist("cd artist1")
                .withReleaseYear(2010)
                .withTrack(track01)
                .withTrack(track02)
                .build();
        Library library = new Library();
        library.addCD(cd);
        library.addCD(cd);
        library.saveToFile();
    }

    @Test
    public void testLoadFromFile() {
        Library library = new Library();
        library.loadFromFile();
    }
}
