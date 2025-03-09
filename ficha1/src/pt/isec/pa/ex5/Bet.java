package pt.isec.pa.ex5;

import java.util.Arrays;
import java.util.Random;

import static pt.isec.pa.ex5.utils.*;

public class Bet {
    private int luckyNumber;
    private int[] betNumbers;
    private int currentBetSize;

    public Bet() {
        resetBet();
    }

    public void start() {
    }

    public boolean checkIsWinningBet(Bet winningBet) {
        if (!checkIsBetFinished())
            return false;

        if (winningBet.getLuckyNumber() != luckyNumber)
            return false;

        boolean isCorrectValue = false;
        for (int i = 0; i < MAX_BET_SIZE; i++) {
            if (betNumbers[i] == 0) {
                return false;
            }
            for (int j = 0; j < MAX_BET_SIZE; j++) {
                if (betNumbers[i] == winningBet.getBetNumberAtPos(j)) {
                    isCorrectValue = true;
                    break;
                }
            }
            if (!isCorrectValue) {
                return false;
            }
            isCorrectValue = false;
        }
        return true;
    }

    public void resetBet() {
        luckyNumber = 0;
        betNumbers = new int[MAX_BET_SIZE];
        currentBetSize = 0;
    }

    public void fillRandomBet() {
        Random random = new Random();
        addNumber(random.nextInt(MAX_LUCKY_VALUE) + 1, true);
        for (int i = 0; i < MAX_BET_SIZE; i++) {
            addNumber(random.nextInt(MAX_BET_VALUE) + 1, false);
        }
    }
    public boolean checkIsBetFinished() {
        return (luckyNumber != 0 && currentBetSize == MAX_BET_SIZE);
    }

    public boolean addNumber(int number, boolean isLucky) {
        return isLucky ? addLuckyNumber(number) : addBetNumber(number);
    }

    private boolean addLuckyNumber(int number) {
        if (number < MIN_BET_VALUE
                || number > MAX_LUCKY_VALUE
                || luckyNumber != 0)
            return false;

        luckyNumber = number;
        return true;
    }

    private boolean addBetNumber(int number) {
        if (number < MIN_BET_VALUE
                || number > MAX_BET_VALUE
                || currentBetSize == MAX_BET_SIZE)
            return false;

        if (!checkIsValueDuplicated(number))
            return false;

        betNumbers[currentBetSize] = number;
        currentBetSize++;
        return true;
    }

    private boolean checkIsValueDuplicated(int number) {
        for (int i = 0; i < currentBetSize; i++) {
            if (betNumbers[i] == number) {
                return false;
            }
        }
        return true;
    }

    public int getLuckyNumber() {
        return luckyNumber;
    }

    public int[] getBetNumbers() {
        return betNumbers;
    }

    public int getBetNumberAtPos(int position) {
        if (position < 0 || position >= currentBetSize || betNumbers[position] == 0)
            return -1;
        return betNumbers[position];
    }

    @Override
    public String toString() {
        return "Current bet: " +
                "Bet = " + Arrays.toString(betNumbers) +
                "\nluckyNumber = " + luckyNumber +
                "\ncurrentBetSize = " + currentBetSize;
    }
}
