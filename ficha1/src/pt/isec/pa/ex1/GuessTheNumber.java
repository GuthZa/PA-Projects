package pt.isec.pa.ex1;

import java.util.Scanner;

public class GuessTheNumber {

    public GuessTheNumber() {}

    public void start() {
        Scanner sc = new Scanner(System.in);
        int guess = 0;
        //0.0 - 0.99
        //0.0 - 99.99
        //Restriction: User Math.Random
        int numberToGuess = (int) (Math.random() * 101);
        do {
            System.out.println("Guess the number! (0 to 100)");
            if (sc.hasNextInt())
                guess = sc.nextInt();

            if (guess > 100 || guess < 0)
                System.out.println("Please write a valid number");

            if (numberToGuess > guess) {
                System.out.println("Close, but it's higher");
            } else if (numberToGuess < guess) {
                System.out.println("Close, but it's lower");
            } else {
                System.out.println("You found the number! Congratulations!");
                return;
            }

        } while (true);
    }
}
