package pl.dominisz;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * http://dominisz.pl
 * 22.12.2017
 */
public class MenuTest {

    @Test
    public void testMenu() {

        ScannerUtils scannerUtils = new ScannerUtils(new Scanner(System.in));
        Menu menu = new Menu(scannerUtils);

        menu.add("Piesek", () -> System.out.println("Hau hau!"));
        menu.add("Kotek", () -> System.out.println("Miau miau!"));
        menu.add("Sumator", new Sumator());

        menu.runAction(2);
    }
}
