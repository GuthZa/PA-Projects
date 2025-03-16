package pt.isec.pa.report.model;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Report {
    private static final int INC_AUTHORS = 5;
    private String title;
    private String[] authors;
    private int qtAuthors;
    private StringBuilder text;

    public Report(String title) {
        this.title = title;
        this.text = new StringBuilder();
        this.authors = new String[INC_AUTHORS];
        this.qtAuthors = 0;
    }

    public boolean addAuthor(String newAuthor) {
        if (newAuthor == null || newAuthor.isBlank())
            return false;

        //Guarantees no duplicates
        for (int i = 0; i < qtAuthors; i++) {
            if (authors[i].equalsIgnoreCase(newAuthor)) {
                return false;
            }
        }

        //If the array is full, add more positions
        if (qtAuthors >= authors.length) {
            authors = Arrays.copyOf(authors, authors.length + INC_AUTHORS);
        }

        authors[qtAuthors++] = newAuthor;
        return true;
    }

    public boolean removeAuthor(String authorToRemove) {
        if (authorToRemove == null || authorToRemove.isBlank())
            return false;

        for (int i = 0; i < qtAuthors; i++) {
            if (authors[i].equalsIgnoreCase(authorToRemove)) {
                for (int j = i; j < qtAuthors - 1; j++) {
                    authors[j] = authors[j+1];
                }
                authors[qtAuthors] = null;
                qtAuthors--;
                return true;
            }
        }
        return false;
    }

    public boolean addText(String newText) {
        if (newText == null)
            return false;

        if (text == null) {
            text = new StringBuilder(newText);
        } else {
            text.append(newText);
        }
        return true;
    }

    public void capitalizeSentence() {
        boolean changeNext = false;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (".?!".indexOf(c) >= 0) {
                changeNext = true;
            } else if (changeNext || Character.isLetter(c)) {
                text.setCharAt(i, Character.toUpperCase(c));
                changeNext = false;
            }
        }
    }

    public int getNumberOfWords() {
        //v1
//        int counter=0;
//        Scanner stext = new Scanner(text.toString());
//        stext.useDelimiter("[\\s,.?!]+");
//        while (stext.hasNext()) {
//            counter++;
//            stext.next();
//        }
//        return counter;

        //v2
//        String[] words = text.toString().split("[\\s,.?!]+");
//        return words.length;

        StringTokenizer st = new StringTokenizer(text.toString(), "\t\n,.?!");
        return st.countTokens();
    }

    public int getOccurrencesOfWord(String word) {
        int count = 0;
        StringTokenizer st = new StringTokenizer(text.toString(), "\t\n,.?!");

        while (st.hasMoreTokens()) {
            if (word.equalsIgnoreCase(st.nextToken())) {
                count++;
            }
        }
        return count;
    }

    //Override toString()


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Report\n");
        sb.append("Title: ").append(title).append("\n");
        sb.append("Authors: ").append("\n");
        if (qtAuthors > 0) {
            sb.append("QtAuthors: ").append(qtAuthors).append("\n");
        }
        return sb.toString();
    }

    public String getTitle() {
        return title;
    }

    public int getQtAuthors() {
        return qtAuthors;
    }

    public String[] getAuthors() {
        return authors;
    }
}
