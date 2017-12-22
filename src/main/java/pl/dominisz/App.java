package pl.dominisz;

import java.util.HashMap;
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

    private void mainMenu() {
        System.out.println("Witamy w programie");
        boolean again = true;
        while (again) {
            showMainMenu();
            int option = readInt(10);
            switch (option) {
                case 1:
                    //addNewCD();
                    break;
                case 2:
                    //deleteCD();
                    break;
                case 3:
                    //showAllCDs();
                    break;
                case 4:
                    //findByCDTitle();
                    break;
                case 5:
                    //findTracksByTrackTitle();
                    break;
                case 10:
                    again = false;
                    break;
            }
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
    }

}
