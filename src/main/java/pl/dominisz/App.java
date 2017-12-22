package pl.dominisz;

public class App {

    private Library library;

    public App() {
        library = new Library();
    }

    public void start() {
        library.loadFromFile();
        mainMenu();
        library.saveToFile();
    }

    private void mainMenu() {

    }

    public static void main(String[] args) {
        App app = new App();
        app.start();
    }

}
