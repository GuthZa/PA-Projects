package pt.isec.pa.library.model;

import java.util.List;
import java.util.Objects;

public class Book implements Cloneable {
    private static int counter = 0;

    private static int getNewId() {return ++counter;}

    private int id;
    private String title;
    private List<String> authors;

    public Book(String title, List<String> author) {
        id = getNewId();
        this.title = title;
        this.authors = List.copyOf(author);
    }

    public Book(String title, String... authors) {
        this(title, List.of(authors));
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    private static int getCounter() {
        return counter;
    }

    private static void setCounter(int counter) {
        Book.counter = counter;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = List.copyOf(authors);
    }

    @Override
    public String toString() {
        String strAuthors = authors.toString();
        return String.format("[%d] %s = %s",
                id, title,
                strAuthors.substring(1, strAuthors.length() - 1));
        //The substring removed the "[]" from the base string
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return title.equalsIgnoreCase(book.title);
    }

    @Override
    public int hashCode() {
        return title != null ? title.toLowerCase().hashCode() : 0;
    }

    @Override
    protected Book clone() throws CloneNotSupportedException {
        Book newBook = (Book) super.clone();
        newBook.authors = List.copyOf(authors);
        return newBook;
    }
}
