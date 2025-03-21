package pt.isec.pa.library.model;

import pt.isec.pa.library.model.Book;

import java.util.List;

public interface ILibrary {
    String getName();
    void setName(String name);
    int addBook(String title, List<String> authors);
    Book findBook(String title) throws CloneNotSupportedException;
    Book findBook(int id) throws CloneNotSupportedException;
    boolean removeBook(String title);
    boolean removeBook(int id);
}
