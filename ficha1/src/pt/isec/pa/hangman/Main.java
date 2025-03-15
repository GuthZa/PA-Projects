package pt.isec.pa.hangman;

import pt.isec.pa.hangman.model.HangmanModel;
import pt.isec.pa.hangman.ui.HangmanUI;

public class Main {
    public static void main(String[] args) {
        HangmanModel model = new HangmanModel();
        HangmanUI ui = new HangmanUI(model);
        ui.play();
    }
}
