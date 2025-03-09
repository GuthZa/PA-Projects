package pt.isec.pa.ex5;

import java.util.Scanner;

import static pt.isec.pa.ex5.utils.*;

public class Totoloto {
    Scanner scanner;
    Bet winningBet;
    Bet bet;
    public Totoloto() {
        this.scanner = new Scanner(System.in);
        setup();
    }

    public void setup(){
        this.winningBet = new Bet();
        this.bet = new Bet();
        winningBet.fillRandomBet();
    }

    public void start() {

        System.out.println("Welcome to Totoloto! Place your bets!!");
        int input = 0;
        while (true) {
            System.out.println("What do you want to do?");
            System.out.println("1 - Adicionar valor à aposta");
            System.out.println("2 - Check current bet");
            System.out.println("3 - Compare to winning bet");
            System.out.println("4 - Reset bet");
            System.out.println("0 - Exit");
            if (scanner.hasNextInt())
                input = scanner.nextInt();

            switch (input) {
                case 1 -> {
                    do {
                        System.out.println("1 - Normal number\n2 - lucky number\n0 - go back");
                        if (scanner.hasNextInt())
                            input = scanner.nextInt();

                        if (input == 0)
                            break;

                        if (addNumber(input == 2))
                            break;

                        System.out.println("Please write a valid number");
                    } while(true);
                }
                case 2 -> System.out.println(bet.toString());
                case 3 -> {
                    if (!bet.checkIsBetFinished()) {
                        System.out.println("You haven't finished your bet");
                        break;
                    }
                    if (winningBet.checkIsWinningBet(bet)) {
                        System.out.println("Congratulations you win!");
                        System.out.println(winningBet.toString());
                        winningBet.resetBet();
                        winningBet.fillRandomBet();
                        bet.resetBet();
                    } else {
                        System.out.println("It was not the correct bet! Try again another time!");
                        bet.resetBet();
                    }
                }
                case 4 -> {
                    bet.resetBet();
                    System.out.println("Your bet is now empty");
                }
                case 5 -> {
                    bet.fillRandomBet();
                }
                case 0 -> {
                    return;
                }
            }
        }
    }

    private boolean addNumber(boolean isLucky) {
        int input = 0;

        System.out.println("Number to add (" + MIN_BET_VALUE + ", " + (!isLucky ? MAX_BET_VALUE : MAX_LUCKY_VALUE) + "):");

        if (scanner.hasNextInt())
            input = scanner.nextInt();

        if (input >= MIN_BET_VALUE && input <= (!isLucky ? MAX_BET_VALUE : MAX_LUCKY_VALUE)) {
            isLucky = bet.addNumber(input, isLucky);
            if (isLucky)
            {
                System.out.println("The number " + input + " was added to the bet");
                System.out.println(bet.toString());
            } else {
                System.out.println("Unable to add the number to the bet");
                System.out.println(bet.toString());
            }
        }
        return isLucky;
    }
}
