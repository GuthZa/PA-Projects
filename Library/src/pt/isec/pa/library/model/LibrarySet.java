package pt.isec.pa.library.model;

import java.util.*;

public class LibrarySet extends Library {
    private final Set<Book> books;

    public LibrarySet(String name) {
        super(name);
        books = new HashSet<>();
    }

    @Override
    public int addBook(Book newBook) {
        if (!books.add(newBook))
            return -1;
        return newBook.getId();
    }

    @Override
    Collection<Book> getBooks() {
        return List.of();
    }
}
