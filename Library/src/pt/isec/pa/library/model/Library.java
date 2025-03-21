package pt.isec.pa.library.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class Library implements ILibrary {
    protected String name;

    public Library(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    abstract int addBook(Book book);

    @Override
    public int addOldBook(String title, List<String> authors, int numberOfCopies) {
        return addBook(new OldBook(title, authors, numberOfCopies));
    }

    @Override
    public int addRecentBook(String title, List<String> authors, String ISBN, double price) {
        return addBook(new RecentBook(title, authors, ISBN, price));
    }

    abstract Collection<Book> getBooks();

    @Override
    public Book findBook(String title) throws CloneNotSupportedException {
        Collection<Book> books = getBooks();
        for (Book book : books)
            if (book.getTitle().equalsIgnoreCase(title))
                return book.clone();
        return null;
    }

    @Override
    public Book findBook(int id) throws CloneNotSupportedException {
        Collection<Book> books = getBooks();
        for (Book book : books)
            if (book.getId() == id)
                return book.clone();
        return null;
    }

    @Override
    public boolean removeBook(String title) {
        Collection<Book> books = getBooks();
        return books.remove(new Book(title, List.of()));
    }

    @Override
    public boolean removeBook(int id) {
        Collection<Book> books = getBooks();
        for (Book book : books)
            if (book.getId() == id)
                return books.remove(book);
        return false;
    }

    @Override
    public String toString() {
        Collection<Book> books = getBooks();
        StringBuilder output = new StringBuilder();
        output.append(String.format("Library %s:\n", name));
        for (Book book : books)
            output.append(String.format("  = %s\n", book));
        return output.toString();
    }

    @Override
    public String toStringSorted() {
        StringBuilder sb = new StringBuilder(String.format("Library %s:\n", name));
        Collection<Book> books = getBooks();
        if (books == null || books.isEmpty())
            sb.append("The library is empty");
        else {
            sb.append("Books:\n");
            List<Book> orderList = new ArrayList<>(books);
            Collections.sort(orderList);
//            Collections.sort(orderList, new BookComparator());
//            orderList.sort(new BookComparator());
            for (Book book : orderList)
                sb.append(String.format("- %s\n", book.toString()));
        }
        return sb.toString();
    }
}
