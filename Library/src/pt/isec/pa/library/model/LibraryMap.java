package pt.isec.pa.library.model;

import java.util.*;

public class LibraryMap extends Library {
    private final Map<Integer, Book> books;

    public LibraryMap(String name) {
        super(name);
        books = new HashMap<>();
    }

    @Override
    public int addBook(Book newBook) {
        if (books.containsValue(newBook))
            return -1;
        books.put(newBook.getId(), newBook);
        return newBook.getId();
    }

    @Override
    Collection<Book> getBooks() {
        return books.values();
    }

    @Override
    public boolean removeBook(String title) {
        //From map, you can only remove with the key
        for(Book book : books.values())
            if (book.getTitle().equalsIgnoreCase(title))
                return books.remove(book.getId())!=null;
        return false;
    }

    @Override
    public boolean removeBook(int id) {
        return books.remove(id) != null;
    }

    /*
    //Forma mais correta de findBook para Maps, mas como já está implementado
    //na class abstrata, não utilizamos esta
    @Override
    public Book findBook(int id) throws CloneNotSupportedException {
        Book book = books.get(id);
        return  book != null ? book.clone() : null;
    }
     */
}
