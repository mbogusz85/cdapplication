package pl.dominisz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {

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
    }

    private void deleteCD() {

    }

    private void addNewCD() {

    }

    private void mainMenu() {
        System.out.println("Witamy w programie");
        Menu mainMenu = createMainMenu();
        boolean again = true;
        while (again) {
            mainMenu.showMessages();
            int option = readInt(mainMenu.size());
            mainMenu.runAction(option);
        }
    }

    /**
     * Pobiera od użytkownika z klawiatury liczbę z przedziału <1, max>
     * Wymusza na użytkwniku podanie poprawnych danych
     *
     * @param max największa dozwolona liczba całkowita
     * @return wczytana liczba
     */
    private int readInt(int max) {
        while (true) {
            try {
                int menuPosition = Integer.parseInt(in.nextLine());
                if (menuPosition >= 1 && menuPosition <= max) {
                    return menuPosition;
                }
            } catch (NumberFormatException e) {
            }
            System.out.println("Musisz podać liczbę od 1 do " + max + ".");
        }
    }

    public static void main(String[] args) {
        App app = new App();
        app.start();
        System.out.println("Dziękujemy za korzystanie z programu");
    }

}
