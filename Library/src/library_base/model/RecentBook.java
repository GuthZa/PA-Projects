package pt.isec.pa.library_base.model;

import pt.isec.pa.library.model.Book;

import java.util.List;

public class RecentBook extends Book {
    private String ISBN;
    private double price;

    public RecentBook(String title, List<String> author) {
        super(title, author);
    }

    public RecentBook(String title, String... authors) {
        super(title, authors);
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
