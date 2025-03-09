package pt.isec.pa.ex6;

import java.util.Random;
import java.util.Scanner;

public class Matrix {
    private int[][] matrix;
    public Matrix() {
        this(3);
    }

    public Matrix(int columns) {
        this.matrix = new int[columns][columns];
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public void fillRandomMatrix() {
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(101);
            }
        }
    }

    public void fillMatrix() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println("Value in [" + i + "][" + j + "]: ");
                if (scanner.hasNextInt())
                    matrix[i][j] = scanner.nextInt();
            }
        }
    }

    public int[][] transpose() {

        if (matrix.length != matrix[0].length)
            return null;

        int[][] aux = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                aux[j][i] = matrix[i][j];
            }
        }

        return aux;
    }

    public void printMatrix() {
        System.out.println("Matrix:");
        for (int[] ints : matrix) {
            System.out.print("[");
            for (int j = 0; j < ints.length - 1; j++) {
                System.out.print(ints[j] + ", ");
            }
            System.out.println(ints[ints.length - 1] + "]");
        }
    }
}
