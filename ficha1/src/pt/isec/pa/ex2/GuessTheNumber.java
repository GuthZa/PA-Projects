package pt.isec.pa.ex2;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    private final Random random;
    private int tries;
    private int lowerBound, upperBound;
    public GuessTheNumber() {
        this.random = new Random();
        setUp();
    }

    private void setUp() {
        this.lowerBound = 0;
        this.upperBound = 100;
        this.tries = 0;
    }

    public void start() {
        System.out.println("Think of a number between 0 and 100\nI will try to guess it! (sair to leave)");
        Scanner scanner = new Scanner(System.in);
        String input = "";
        int guess = getNewNumber();

        do {
            System.out.println("I thought of: " + guess);
            if (scanner.hasNext())
                input = scanner.next();

            switch (input) {
                case "sair", "SAIR", "exit" -> {
                    return;
                }
                case "maior", "higher", "PENSEI NUM NUMERO MAIOR" -> {
                    lowerBound = guess + 1;
                    guess = getNewNumber();
                    tries++;
                }
                case "menor", "lower", "PENSEI NUM NUMERO MENOR" -> {
                    upperBound = guess - 1;
                    guess = getNewNumber();
                    tries++;
                }
                case "acertou", "correct" -> {
                    System.out.println("YAAAAAAY!!!!!!\nI got it in " + tries + " tries");
                    System.out.println("Let's play again!");
                    setUp();
                    guess = getNewNumber();
                }
                default -> System.out.println("I couldn't understand what you wrote.");
            }
        } while (true);
    }

    private int getNewNumber() {
        //Binary search
        return (upperBound - lowerBound) / 2 + lowerBound;
        //Randomized search
//        return random.nextInt(upperBound - lowerBound) + lowerBound;
    }
}
