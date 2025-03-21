package pt.isec.pa.library.model;

import java.util.List;

public interface ILibrary {
    String getName();
    void setName(String name);
    int addOldBook(String title, List<String> authors, int numberOfCopies);
    int addRecentBook(String title, List<String> authors, String ISBN, double price);
    Book findBook(String title) throws CloneNotSupportedException;
    Book findBook(int id) throws CloneNotSupportedException;
    boolean removeBook(String title);
    boolean removeBook(int id);
    //Comparator
    String toStringSorted();
}
