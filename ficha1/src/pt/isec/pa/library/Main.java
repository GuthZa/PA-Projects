package pt.isec.pa.library;

import pt.isec.pa.library.model.LibraryList;
import pt.isec.pa.library.ui.LibraryUI;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        LibraryList libraryList = new LibraryList("Coimbra");
        LibraryUI libraryUI = new LibraryUI(libraryList);
        libraryUI.start();
    }
}
