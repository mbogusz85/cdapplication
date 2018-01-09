package pl.dominisz;

import java.util.Scanner;

/**
 * http://dominisz.pl
 * 09.01.2018
 */
public class ScannerUtils {

    private Scanner scanner;

    public ScannerUtils(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Pobiera od użytkownika z klawiatury liczbę z przedziału <min, max>
     * Wymusza na użytkowniku podanie poprawnych danych
     *
     * @param min najmniejsza dozwolona liczba całkowita
     * @param max największa dozwolona liczba całkowita
     * @return wczytana liczba
     */
    public int readInt(int min, int max) {
        while (true) {
            try {
                int menuPosition = Integer.parseInt(scanner.nextLine());
                if (menuPosition >= min && menuPosition <= max) {
                    return menuPosition;
                }
            } catch (NumberFormatException e) {
            }
            System.out.println("Musisz podać liczbę od " + min + " do " + max + ".");
        }
    }

    public int readInt(int max) {
        return readInt(1, max);
    }
}

