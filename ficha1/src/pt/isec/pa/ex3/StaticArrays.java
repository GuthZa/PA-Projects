package pt.isec.pa.ex3;

import java.util.Random;
import java.util.Scanner;

public class StaticArrays {
    private int[] array;
    public StaticArrays() {
        fillArray();
    }
    public void start() {
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        while (true) {
            System.out.println("1 -> Print Array");
            System.out.println("2 -> Sum all elements");
            System.out.println("3 -> Calculate median");
            System.out.println("4 -> Invert array");
            System.out.println("-1 -> leave");
            if (scanner.hasNextInt())
                input = scanner.nextInt();


            switch (input) {
                case 1 -> printArray();
                case 2 -> {
                    int sum;
                    if (array == null || (sum = sumAllElements()) == -1){
                        System.out.println("No array defined yet");
                    } else {
                        System.out.println("Sum of all elements: " + sum);
                    }
                }
                case 3 -> {
                    int sum;
                    if (array == null || (sum = sumAllElements()) == -1){
                        System.out.println("No array defined yet");
                    } else {
                        System.out.println("Median of the array is: " + (sum / array.length));
                    }
                }
                case 4 -> {
                    if (array == null){
                        System.out.println("No array defined yet");
                    } else {
                        array = invertArray();
                        printArray();
                    }
                }
                case -1 -> {
                    return;
                }
                default -> System.out.println("I didn't understand");
            }
        }
    }

    private int[] invertArray() {
        int[] aux = new int[array.length];

        for (int i = 0, j = array.length - 1; i < array.length; i++, j--) {
            aux[j] = array[i];
        }

        return aux;
    }

    private int sumAllElements() {
        if (array == null) return -1;
        int sum = 0;
        for (int j : array) {
            sum += j;
        }
        return sum;
    }
    private void printArray() {
        if (array == null) {
            System.out.println("No array defined yet");
            return;
        }

        System.out.print("[");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println(array[array.length - 1] + "]");


    }

    private void fillArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Array size: ");
        int size = 0;
        if (scanner.hasNextInt())
            size = scanner.nextInt();

        array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Value for position " + i + ":");
            if (scanner.hasNextInt())
                array[i] = scanner.nextInt();
        }
    }
}
