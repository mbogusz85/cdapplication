package pl.dominisz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * http://dominisz.pl
 * 21.12.2017
 */
class CDTest {

    @Test
    void totalTime() {
        Track track01 = new TrackBuilder()
                .withTime(100)
                .build();
        Track track02 = new TrackBuilder()
                .withTime(200)
                .build();
        Track track03 = new TrackBuilder()
                .withTime(300)
                .build();
        CD cd = new CDBuilder()
                .withTrack(track01)
                .withTrack(track02)
                .withTrack(track03)
                .build();
        assertTrue(cd.getTotalTime() == 100 + 200 + 300);
    }

    @Test
    void getGenres() {
        Track track01 = new TrackBuilder()
                .withGenre(Genre.POP)
                .build();
        Track track02 = new TrackBuilder()
                .withGenre(Genre.RAP)
                .build();
        CD cd = new CDBuilder()
                .withTrack(track01)
                .withTrack(track02)
                .build();
        assertTrue(cd.getGenres().size() == 2);
        assertTrue(cd.getGenres().contains(Genre.POP));
        assertTrue(cd.getGenres().contains(Genre.RAP));
    }

    @Test
    void addTrack() {

    }
}