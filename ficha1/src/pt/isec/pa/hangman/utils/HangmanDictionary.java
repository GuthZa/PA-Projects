package pt.isec.pa.hangman.utils;

public class HangmanDictionary {
    private static final String[] words = {
            "TOMORROW", "ARCHIMEDES", "LION", "TIGER", "ZEBRA", "PLATE",
            "BROWN", "ORANGE", "PEA", "OTTER", "BALLAST", "ORANGUTAN",
            "DISCIPLINE", "PROGRAMMING", "POTATO", "CLOWN", "BRAIN",
            "TUNA", "PORTUGAL", "WILD", "ANIMAL", "IRRATIONAL",
            "MATHEMATICS", "DISCREET", "EFFICIENT", "EFFECTIVE", "MARVEL",
            "SYNOPSIS", "DEVICE", "LINEAR", "LEMON", "LAMP","EAR",
            "BUFFALO", "SHOE", "LOBSTER", "RISKY", "SCRATCHED",
            "CARNIVAL", "BOLD", "RELEASED", "SIMPLE", "COMPLEX",
            "STAPLER", "MONITOR", "KEYBOARD", "KEY", "CLOCK",
            "HANDKERCHIEF", "WINDOW", "ROPE", "VIOLA", "GUITAR",
            "POINTER", "ARGUER", "SAGACIOUS", "ERRONEOUS", "INSTITUTE",
            "UPPER", "ENGINEERING", "DEPARTMENT", "INFORMATICS", "SYSTEM",
            "CALL", "PRESIDENT", "FEBRUARY", "INCREASE", "SALARY",
            "MONEY", "IMMEDIATE", "FLAMINGO", "RHINOCEROS",
            "HIPPOPOTAMUS", "CODFISH", "PORGIE", "SARDINE", "SNAIL",
            "INSECT", "FLYING", "ORANGE", "SPRINKLING", "EXTINCT",
            "EXTERNAL","AMBIGUOUS"};

    private HangmanDictionary() {}

    public static int getNumWords() { return words.length; }

    public static String getWord(int index) {
        if  (index < 0 || index >= words.length) {
            return null;
        }
        return words[index];
    }
}
