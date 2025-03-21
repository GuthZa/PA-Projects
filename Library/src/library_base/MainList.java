package pt.isec.pa.library_base;

import pt.isec.pa.library_base.model.ILibrary;
import pt.isec.pa.library_base.model.LibraryList;
import pt.isec.pa.library_base.ui.LibraryUI;

public class MainList {
    public static void main(String[] args) throws CloneNotSupportedException {
        ILibrary library = new LibraryList("DEIS-ISEC-List");
        LibraryUI ui = new LibraryUI(library);
        ui.start();
    }
}
