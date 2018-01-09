package pl.dominisz;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * http://dominisz.pl
 * 09.01.2018
 */
public class MenuBuilderTest {

    @Test
    public void shouldThrowExceptionWithoutScannerUtils() {
        Throwable exception = assertThrows(IllegalStateException.class, () -> {
            Menu menu = new MenuBuilder()
                    .build();
        });
        assertEquals("Metoda build() musi być wywołana po metodzie addScannerUtils()", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionWithoutExitItem() {
        assertThrows(IllegalStateException.class, () -> {
            Menu menu = new MenuBuilder()
                    .addScannerUtils(new ScannerUtils(new Scanner(System.in)))
                    .build();
        });
        //TODO check exception message
    }

    @Test
    public void shouldThrowExceptionWithoutAnyMenuItem() {
        assertThrows(IllegalStateException.class, () -> {
            Menu menu = new MenuBuilder()
                    .addScannerUtils(new ScannerUtils(new Scanner(System.in)))
                    .addExitItem("Wyjście z menu")
                    .build();
        });
        //TODO check exception message
    }

    @Test
    public void shouldThrowExceptionAfterExitItem() {
        assertThrows(IllegalStateException.class, () -> {
            Menu menu = new MenuBuilder()
                    .addScannerUtils(new ScannerUtils(new Scanner(System.in)))
                    .addMenuItem("Opcja 1", () -> {
                    })
                    .addExitItem("Wyjście z menu")
                    .addMenuItem("Opcja 2", () -> {
                    })
                    .build();
        });
        //TODO check exception message
    }

    @Test
    public void shouldCreateMenu() {
        Menu menu = new MenuBuilder()
                .addScannerUtils(new ScannerUtils(new Scanner(System.in)))
                .addMenuItem("Opcja 1", () -> {})
                .addMenuItem("Opcja 2", () -> {})
                .addExitItem("Wyjście z menu")
                .build();
        assertEquals(3, menu.size());
        //TODO check options and actions
    }
}