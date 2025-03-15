package pt.isec.pa.hangman.model;

import pt.isec.pa.hangman.utils.HangmanDictionary;
import pt.isec.pa.hangman.utils.HangmanDisplay;

import java.util.Random;

public class HangmanModel {
    private static final int MAX_ERRORS = 7;
    private static final String HIDDEN_CHARACTER = ".";

    private String wordToGuess;
    private StringBuilder attemptedCharacters;
    private StringBuffer currentSituation;
    private StringBuilder hangman;

    private int numberOfGuesses, numberOfErrors;
    private final Random random;

    public HangmanModel() {
        random = new Random();
        setup();
    }

    public void setup() {
        wordToGuess = HangmanDictionary.getWord(random.nextInt(HangmanDictionary.getNumWords()));
        if (wordToGuess == null)
            return;

        numberOfGuesses = numberOfErrors = 0;
        wordToGuess = wordToGuess.toUpperCase();
        currentSituation = new StringBuffer(HIDDEN_CHARACTER.repeat(wordToGuess.length()));
        attemptedCharacters = new StringBuilder();
        hangman = new StringBuilder();
        hangman.append("+").append("-".repeat(10)).append("+").append("\n")
                .append("|").append(" ".repeat(10)).append("|").append("\n");
    }

    public boolean isWordFound() {
        return wordToGuess.equalsIgnoreCase(currentSituation.toString());
    }

    public boolean concluded() {
        return isWordFound() || getNumberOfErrors() >= MAX_ERRORS;
    }

    public boolean tryOption(String option) {
        if (option == null || concluded() || option.isEmpty())
            return false;

        if (attemptedCharacters.indexOf(option.toUpperCase()) >= 0)
            return false;

        numberOfGuesses++;

        option = option.toUpperCase();

        //option is a word
        if (option.length() > 1) {
            if (wordToGuess.equalsIgnoreCase(option)) {
                currentSituation = new StringBuffer(wordToGuess);
                return true;
            }
            numberOfErrors++;
            return false;
        }

        //option is a characters
        char op = Character.toUpperCase(option.charAt(0));
        attemptedCharacters.append(op);

        boolean found = false;
        for (int i = 0; i < wordToGuess.length(); i++) {
            char c = wordToGuess.charAt(i);
            if (op == c) {
                found = true;
                currentSituation.setCharAt(i, c);
            }
        }
        if (!found) numberOfErrors++;
        return found;
    }

    public String getHangman() {
        return HangmanDisplay.getStage(numberOfErrors);
    }

    public String getAttemptedCharacters() {
        return attemptedCharacters.toString();
    }

    public boolean addAttemptedCharacters(char c) {
        for (int i = 0; i < attemptedCharacters.length(); i++) {
            if (c == attemptedCharacters.charAt(c))
                return false;
        }

        attemptedCharacters.append(c);
        return true;
    }

    public String getCurrentSituation() {
        return currentSituation.toString();
    }

    public String getWordToGuess() {
        return wordToGuess;
    }

    public int getNumberOfGuesses() {
        return numberOfGuesses;
    }

    public int getNumberOfErrors() {
        return numberOfErrors;
    }

    public static int getMaxErrors() {
        return MAX_ERRORS;
    }
}
