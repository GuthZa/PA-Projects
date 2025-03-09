package pt.isec.pa.ex1;

import java.util.Scanner;

public class GuessTheNumber {

    private int numberToGuess;

    public GuessTheNumber() {}

    public void start() {
        Scanner sc = new Scanner(System.in);
        int guess = 0;
        numberToGuess = generateNewNumber();
        do {System.out.println("Guess the number between 0 and 100! (-1 to leave)");

            if (sc.hasNextInt() &&
                    (guess = sc.nextInt()) == -1)
                return;

            checkNumber(guess);

        } while (true);
    }

    private int generateNewNumber() {
        //0.0 - 0.99
        //0.0 - 99.99
        //Restriction: User Math.Random
        return (int) (Math.random() * 101);
    }

    private void checkNumber(int numberToCheck) {
        if (numberToCheck > 100 || numberToCheck < 0)
            System.out.println("Please write a valid number");

        if (numberToGuess > numberToCheck) {
            System.out.println("Close, but it's higher");
        } else if (numberToGuess < numberToCheck) {
            System.out.println("Close, but it's lower");
        } else {
            System.out.println("You found the number! Congratulations!");
        }
    }
}
