package pl.dominisz;

import java.util.ArrayList;
import java.util.List;

/**
 * http://dominisz.pl
 * 22.12.2017
 */
public class Menu {

    private ScannerUtils scannerUtils;
    private List<MenuItem> menuItems;

    public Menu(ScannerUtils scannerUtils) {
        this.scannerUtils = scannerUtils;
        this.menuItems = new ArrayList<>();
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

    public void showMenuItems() {
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i + 1) + ". " + menuItems.get(i).getMessage());
        }
    }

    public void runAction(int index) {
        index--;
        if (index >= 0 && index < menuItems.size()) {
            menuItems.get(index).getAction().run();
        }
    }

    /**
     * Metoda do obsługi menu
     * - wyświetla dostępne opcje
     * - czeka na wybór opcji
     * - wykonuje wybraną akcję
     * - wychodzi z menu, jeśli wybrano wyjście
     */
    public void handleMenu() {
        boolean again = true;
        while (again) {
            showMenuItems();
            System.out.println("Co wybierasz?");
            int option = scannerUtils.readInt(menuItems.size());
            if (option < menuItems.size()) {
                runAction(option);
            } else {
                again = false;
            }
        }
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}
