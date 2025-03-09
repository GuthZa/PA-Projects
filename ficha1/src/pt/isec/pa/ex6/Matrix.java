package pt.isec.pa.ex6;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Matrix {
    private int[][] matrix;
    public Matrix() {
        this(3,3);
    }

    public Matrix(int columns, int rows) {
        this.matrix = new int[columns][rows];
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
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("[");
            for (int j = 0; j < matrix[i].length - 1; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println(matrix[i][matrix[i].length - 1] + "]");
        }
    }
}
