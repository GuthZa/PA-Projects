package pt.isec.pa.library.model;

import java.util.List;

public class RecentBook extends Book {
    private String ISBN;
    private double price;

    public RecentBook(String title, List<String> author, String ISBN, double price) {
        super(title, author);
        this.ISBN = ISBN;
        this.price = price;
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

    @Override
    public String toString() {
        return "-RecentBook- " + super.toString() +
                ", ISBN=" + ISBN +
                ", price=" + price;
    }
}
