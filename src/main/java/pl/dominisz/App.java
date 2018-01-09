package pl.dominisz;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {

    //zgodnie z https://pl.wikipedia.org/wiki/CD-Audio ;-)
    private static final int MAX_TRACK_COUNT = 99;
    private static final int MAX_TRACK_TIME = 99 * 60;

    private Library library;
    private Scanner in;
    private ScannerUtils scannerUtils;

    public App() {
        library = new Library();
        in = new Scanner(System.in);
        scannerUtils = new ScannerUtils(in);
    }

    public void start() {
        library.loadFromFile();
        mainMenu();
        library.saveToFile();
    }

    private Menu createMainMenu() {
        Menu menu = new MenuBuilder()
                .addScannerUtils(scannerUtils)
                .addMenuItem("Dodaj nową płytę", () -> addNewCD())
                .addMenuItem("Usuń płytę", () -> deleteCD())
                .addMenuItem("Wyświetl wszystkie płyty", () -> showAllCDs())
                .addMenuItem("Wyszukaj płyty po tytule płyty", () -> findByCDTitle())
                .addMenuItem("Wyszukaj płyty po roku wydania", () -> findCDByYearRelease())
                .addMenuItem("Wyszukaj utwory po tytule utworu", () -> findTracksByTrackTitle())
                .addExitItem("Wyjście z programu")
                .build();
        return menu;
    }

    private void findTracksByTrackTitle() {
    }

    private void findByCDTitle() {

    }

    private void findCDByYearRelease() {
        System.out.println("Podaj rok wydania płyty");
        int year = scannerUtils.readInt(1930, LocalDate.now().getYear());
        List<CD> CDByYear = library.findByReleaseYear(year);
        if (CDByYear.isEmpty()) {
            System.out.println("Brak płyt wydanych w roku " + year);
        } else {
            CDByYear.stream().forEach(System.out::println);
        }
    }

    private void showAllCDs() {
        List<CD> allCDs = library.getCdList();
        for (int i = 0; i < allCDs.size(); i++) {
            System.out.println((i + 1) + ". " + allCDs.get(i));
        }
        System.out.println("Podaj numer płyty do wyświetlenia");
        int index = scannerUtils.readInt(library.getCdList().size()) - 1;
        System.out.println(library.getCdList().get(index).toFullString());
    }

    private void deleteCD() {

    }

    private void addNewCD() {
        System.out.println("Podaj tytuł płyty");
        String title = in.nextLine();
        System.out.println("Podaj wykonawce");
        String artist = in.nextLine();
        System.out.println("Podaj rok wydania");
        int releaseDate = scannerUtils.readInt(1950, LocalDate.now().getYear());
        CD cd = new CD(title, artist, releaseDate);
        addNewTracks(cd);
        library.addCD(cd);
    }

    /**
     * Dodaje kilka utworów do płyty
     *
     * @param cd
     */
    private void addNewTracks(CD cd) {
        System.out.println("Podaj liczbę utworów");
        int trackCount = scannerUtils.readInt(MAX_TRACK_COUNT);
        for (int i = 0; i < trackCount; i++) {
            addNewTrack(cd);
        }
    }

    /**
     * Dodaje jeden utwór do płyty
     *
     * @param cd
     */
    private void addNewTrack(CD cd) {
        System.out.println("Podaj tytuł utworu");
        String title = in.nextLine();
        System.out.println("Podaj długość utworu w sekundach");
        int time = scannerUtils.readInt(MAX_TRACK_TIME);
        Genre genre = readGenre();
        System.out.println("Podaj wykonawcę");
        String artist = in.nextLine();
        System.out.println("Podaj kompozytora");
        String composer = in.nextLine();
        System.out.println("Podaj autora tekstu");
        String lyricsAuthor = in.nextLine();
        Track track = new TrackBuilder()
                .withTitle(title)
                .withTime(time)
                .withGenre(genre)
                .withArtist(artist)
                .withComposer(composer)
                .withLyricsAuthor(lyricsAuthor)
                .build();
        cd.addTrack(track);
    }

    private Genre readGenre() {
        Genre[] allGenres = Genre.values();
        System.out.println("Gatunki muzyki");
        for (int i = 0; i < allGenres.length; i++) {
            System.out.println((i + 1) + ". " + allGenres[i].getDescription());
        }
        System.out.println("Wybierz numer");
        int index = scannerUtils.readInt(allGenres.length) - 1;
        return allGenres[index];
    }

    private void mainMenu() {
        System.out.println("Witamy w programie");
        Menu mainMenu = createMainMenu();
        mainMenu.handleMenu();
    }

    public static void main(String[] args) {
        App app = new App();
        app.start();
        System.out.println("Dziękujemy za korzystanie z programu");
    }

}
