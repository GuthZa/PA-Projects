package pt.isec.pa.hangman.ui;

import pt.isec.pa.hangman.model.HangmanModel;

import java.util.Scanner;

public class HangmanUI {
    private final HangmanModel game;

    public HangmanUI(HangmanModel hangmanModel) {
        this.game = hangmanModel;
    }

    public void play() {
        Scanner sc = new Scanner(System.in);

        while (!game.concluded()) {
            System.out.print(game.getHangman());

            System.out.println("\nCurrent situation: " + game.getCurrentSituation());  // mostrar as letras descobertas
            // se a palavra for CAFE
            // inicialmente deverá mostrar:  ....
            System.out.println("Number of attempts: " + game.getNumberOfGuesses()); // inicio: 0
            System.out.printf("Errors: %d (máx.: %d)\n", game.getNumberOfErrors(), HangmanModel.getMaxErrors());
            System.out.println("Attempted characteres: " + game.getAttemptedCharacters());

            System.out.print("\nSuggestion: ");

            String option = sc.nextLine().trim();

            if (!option.isBlank())
                game.tryOption(option);
        }

        if (game.isWordFound())
            System.out.printf("Congratulations! You guessed the word %s in %d attempts\n",
                    game.getWordToGuess(), game.getNumberOfGuesses());
        else {
            System.out.print(game.getHangman());
            System.out.println("Game over!!! The word to guess was: " + game.getWordToGuess());
        }
    }
}
