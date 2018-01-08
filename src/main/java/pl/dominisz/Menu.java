package pl.dominisz;

import java.util.ArrayList;
import java.util.List;

/**
 * http://dominisz.pl
 * 22.12.2017
 */
public class Menu {

    private List<MenuItem> menuItems;

    public Menu() {
        menuItems = new ArrayList<>();
    }

    public int size() {
        return menuItems.size();
    }

    public void add(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public void add(String message, Runnable action) {
        menuItems.add(new MenuItem(message, action));
    }

    public void showMessages() {
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i + 1) + menuItems.get(i).getMessage());
        }
    }

    public void runAction(int index) {
        index--;
        if (index >= 0 && index < menuItems.size()) {
            menuItems.get(index).getAction().run();
        }
    }
}
