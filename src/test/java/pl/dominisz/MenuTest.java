package pl.dominisz;

import org.junit.jupiter.api.Test;

/**
 * http://dominisz.pl
 * 22.12.2017
 */
public class MenuTest {

    @Test
    public void testMenu() {
        Menu menu = new Menu();

        menu.add("Piesek", () -> System.out.println("Hau hau!"));
        menu.add("Kotek", () -> System.out.println("Miau miau!"));
        menu.add("Sumator", new Sumator());

        menu.showMessages();

        menu.runAction(3);

    }
}
