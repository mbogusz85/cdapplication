package pl.dominisz;

import java.util.ArrayList;
import java.util.List;

/**
 * http://dominisz.pl
 * 09.01.2018
 */
public class MenuBuilder {

    private ScannerUtils scannerUtils;
    private List<MenuItem> menuItems;
    private boolean exitItemExists;

    public MenuBuilder() {
        exitItemExists = false;
        menuItems = new ArrayList<>();
    }

    public MenuBuilder addScannerUtils(ScannerUtils scannerUtils) {
        this.scannerUtils = scannerUtils;
        return this;
    }

    public MenuBuilder addMenuItem(String message, Runnable action) {
        if (exitItemExists) {
            throw new IllegalStateException("Nie można już wywołać metody addMenuItem()");
        }
        this.menuItems.add(new MenuItem(message, action));
        return this;
    }

    /**
     * Po wywołaniu addExitItem nie można już wywołać addExitItem, ani addItem
     * @param exitMessage
     * @return
     */
    public MenuBuilder addExitItem(String exitMessage) {
        if (menuItems.isEmpty()) {
            throw new IllegalStateException("Najpierw należy użyć metody addMenuItem()");
        }
        if (exitItemExists) {
            throw new IllegalStateException("Metoda addExitItem() może być wywołana tylko raz");
        }
        menuItems.add(new MenuItem(exitMessage, () -> {}));
        exitItemExists = true;
        return this;
    }

    /**
     * Metodę build można wywołać dopiero po addScannerUtils i addExitItem
     * @return
     */
    public Menu build() {
        if (scannerUtils == null) {
            throw new IllegalStateException("Metoda build() musi być wywołana po metodzie addScannerUtils()");
        }
        Menu menu = new Menu(scannerUtils);
        menu.setMenuItems(menuItems);
        return menu;
    }

}
