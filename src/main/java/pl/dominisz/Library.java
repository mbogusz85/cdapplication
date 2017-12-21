package pl.dominisz;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
klasa biblioteka - kolekcja płyt,
metody: dodawanie płyty, usuwanie płyty,
wyszukiwanie na podstawie kryteriów: szukaj po tytule płyty, szukaj po tytule utworu,
szukaj po gatunkach, szukaj po roku wydania,
zapis danych na dysk,
odczyt z dysku, pliki tekstowe
 */
public class Library {

    private List<CD> cdList;

    public Library() {
        cdList = new ArrayList<>();
    }

    public void addCD(CD cd) {
        cdList.add(cd);
    }

    public void removeCD(int index) {
        cdList.remove(index);
    }

    public List<CD> findByCDTitle(String title) {
        String lowerCaseTitle = title.toLowerCase();
        return cdList.stream()
                .filter(cd -> cd.getTitle().toLowerCase().contains(lowerCaseTitle))
                .collect(Collectors.toList());
    }

    public List<Track> findTracksByTrackTitle(String title) {
        return cdList.stream()
                .flatMap(cd -> cd.findTracksByTitle(title).stream())
                .collect(Collectors.toList());
    }

    public List<CD> findCDsByTrackTitle(String title) {
        String lowerCaseTitle = title.toLowerCase();
        return cdList.stream()
                .filter(
                        cd -> cd.getTracks().stream()
                                .anyMatch(track -> track.getTitle().toLowerCase().contains(lowerCaseTitle))
                )
                .collect(Collectors.toList());
    }

    public List<Track> findTracksByGenre(Genre genre) {

    }

    public List<CD> findCDsByGenre(Genre genre) {

    }

    public List<CD> findByReleaseYear(int releaseYear) {

    }

    public void saveToFile() {

    }

    public void loadFromFile() {

    }
}
