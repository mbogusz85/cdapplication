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

    public App() {
        library = new Library();
        in = new Scanner(System.in);
    }

    public void start() {
        library.loadFromFile();
        mainMenu();
        library.saveToFile();
    }

    private void showMainMenu() {
        System.out.println("1. Dodaj nową płytę");
        System.out.println("2. Usuń płytę");
        System.out.println("3. Wyświetl wszystkie płyty");
        System.out.println("4. Wyszukaj płyty po tytule płyty");
        System.out.println("5. Wyszukaj utwory po tytule utworu");
        System.out.println("6. Wyszukaj płyty po tytule utworu");
        System.out.println("7. Wyszukaj płyty po gatunku");
        System.out.println("8. Wyszukaj utwory po gatunku");
        System.out.println("9. Wyszukaj płyty po roku wydania");
        System.out.println("10. Wyjdź z programu");
    }

    private Menu createMainMenu() {
        Menu menu = new Menu();
        menu.add("Dodaj nową płytę", () -> addNewCD());
        menu.add("Usuń płytę", () -> deleteCD());
        menu.add("Wyświetl wszystkie płyty", () -> showAllCDs());
        menu.add("Wyszukaj płyty po tytule płyty", () -> findByCDTitle());
        menu.add("Wyszukaj utwory po tytule utworu", () -> findTracksByTrackTitle());
        menu.add("Wyjście z programu", () -> {});
        return menu;
    }

    private void findTracksByTrackTitle() {
    }

    private void findByCDTitle() {

    }

    private void showAllCDs() {
        List<CD> allCDs = library.getCdList();
        for (int i = 0; i < allCDs.size(); i++) {
            System.out.println((i + 1) + ". " + allCDs.get(i));
        }
        System.out.println("Podaj numer płyty do wyświetlenia");
        int index = readInt(library.getCdList().size()) - 1;
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
        int releaseDate = readInt(1950, LocalDate.now().getYear());
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
        int trackCount = readInt(MAX_TRACK_COUNT);
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
        int time = readInt(MAX_TRACK_TIME);
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
        int index = readInt(allGenres.length) - 1;
        return allGenres[index];
    }

    private void mainMenu() {
        System.out.println("Witamy w programie");
        Menu mainMenu = createMainMenu();
        boolean again = true;
        while (again) {
            mainMenu.showMessages();
            System.out.println("Co wybierasz?");
            int option = readInt(mainMenu.size());
            if (option < mainMenu.size()) {
                mainMenu.runAction(option);
            } else {
                again = false;
            }
        }
    }

    /**
     * Pobiera od użytkownika z klawiatury liczbę z przedziału <min, max>
     * Wymusza na użytkowniku podanie poprawnych danych
     *
     * @param min najmniejsza dozwolona liczba całkowita
     * @param max największa dozwolona liczba całkowita
     * @return wczytana liczba
     */
    private int readInt(int min, int max) {
        while (true) {
            try {
                int menuPosition = Integer.parseInt(in.nextLine());
                if (menuPosition >= min && menuPosition <= max) {
                    return menuPosition;
                }
            } catch (NumberFormatException e) {
            }
            System.out.println("Musisz podać liczbę od " + min + " do " + max + ".");
        }
    }

    private int readInt(int max) {
        return readInt(1, max);
    }

    public static void main(String[] args) {
        App app = new App();
        app.start();
        System.out.println("Dziękujemy za korzystanie z programu");
    }

}
