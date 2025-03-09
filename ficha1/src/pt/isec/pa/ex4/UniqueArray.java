package pt.isec.pa.ex4;

import java.util.Random;

public class UniqueArray {
    private static final int ARRAY_SIZE = 20;
    private int[] array;
    int duplicated;
    public UniqueArray() {
    }

    public void start() {
        setUp();
        System.out.print("[");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[array.length - 1] + "]");
        System.out.println("Quantity of duplicated numbers: " + duplicated);
    }

    private void setUp() {
        duplicated = 0;
        fillArray();
    }
    private void fillArray() {
        array = new int[ARRAY_SIZE];
        Random random = new Random();
        boolean isDuplicated = false;
        int newValue;
        for (int i = 0; i < ARRAY_SIZE;) {
            isDuplicated = false;
            newValue = random.nextInt(101);
            for (int j = 0; j < i; j++) {
                if (array[j] == newValue) {
                    duplicated++;
                    isDuplicated = true;
                    break;
                }
            }
            if (!isDuplicated) {
                array[i] = newValue;
                i++;
            }
        }
    }
}
