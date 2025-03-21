package pt.isec.pa.library_base.model;

import pt.isec.pa.library.model.Book;

import java.util.List;

public class OldBook extends Book {

    private int numberOfCopies;

    public OldBook(String title, List<String> author) {
        super(title, author);
    }

    public OldBook(String title, String... authors) {
        super(title, authors);
    }

    public int increaseNumberOfCopies() {
        return ++numberOfCopies;
    }

    private void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }
}
