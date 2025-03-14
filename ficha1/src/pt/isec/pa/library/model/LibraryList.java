package pt.isec.pa.library.model;

import java.util.ArrayList;
import java.util.List;

public class LibraryList implements ILibrary {
    private List<Book> books;
    private String name;

    public LibraryList(String name) {
        this.name = name;
        books = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int addBook(String title, List<String> authors) {
        Book newBook = new Book(title, authors);
        if (books.contains(newBook)) {
            return -1;
        }
        books.add(newBook);
        return newBook.getId();
    }

    @Override
    public Book findBook(String title) throws CloneNotSupportedException {
        Book tempBook = new Book(title, List.of());
        int index = books.indexOf(tempBook); //indexOf uses the equals
        return index>=0 ? books.get(index).clone() : null;
    }

    @Override
    public Book findBook(int id) throws CloneNotSupportedException {
        //We don't use indexOf because it expects a book
        // and we don't have a book
        for (Book book : books)
            if (book.getId() == id)
                return book.clone();
        return null;
    }

    @Override
    public boolean removeBook(String title) {
        //returns false if the collection did not change
        return books.remove(new Book(title, List.of()));
    }

    @Override
    public boolean removeBook(int id) {
        for (Book book : books)
            if (book.getId() == id)
                return books.remove(book);
        return false;
    }
}
