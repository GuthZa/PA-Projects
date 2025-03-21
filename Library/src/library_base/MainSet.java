package pt.isec.pa.library_base;

import pt.isec.pa.library_base.model.ILibrary;
import pt.isec.pa.library_base.model.LibrarySet;
import pt.isec.pa.library_base.ui.LibraryUI;

public class MainSet {
    public static void main(String[] args) throws CloneNotSupportedException {
        ILibrary library = new LibrarySet("DEIS-ISEC-Set");
        LibraryUI ui = new LibraryUI(library);
        ui.start();
    }
}
