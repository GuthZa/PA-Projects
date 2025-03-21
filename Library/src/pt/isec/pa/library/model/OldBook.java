package pt.isec.pa.library.model;

import java.util.List;

public class OldBook extends Book {

    private int numberOfCopies;

    public OldBook(String title, List<String> author, int numberOfCopies) {
        super(title, author);
        this.numberOfCopies = numberOfCopies;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    private void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    @Override
    public String toString() {
        return "-OldBook- " + super.toString() +
                ", #Copies=" + numberOfCopies;
    }
}
