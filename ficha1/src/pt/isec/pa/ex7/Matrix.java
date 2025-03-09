package pt.isec.pa.ex7;

import java.util.Arrays;
import java.util.Random;

public class Matrix {
    private final float[][] matrix;
    public Matrix(int columns, int rows) {
        this.matrix = new float[rows][columns];
    }

    public Matrix(Matrix m1) {
        this(m1.matrix.length, m1.matrix[0].length);
        for (int i = 0; i < m1.matrix.length; i++) {
            this.matrix[i] = Arrays.copyOf(m1.matrix[i], m1.matrix[i].length);
        }
    }

    public float[][] getMatrix() {
        return matrix;
    }

    public void addMatrix(float[][] matrixToAdd) {
        if (matrix.length != matrixToAdd.length && matrix[0].length != matrixToAdd[0].length)
            return;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] += matrixToAdd[i][j];
            }
        }

    }

    public static Matrix addMatrix(Matrix m1, Matrix m2) {
        if (m1.matrix.length != m2.matrix.length && m1.matrix[0].length != m2.matrix[0].length)
            return null;

        for (int i = 0; i < m1.matrix.length; i++) {
            for (int j = 0; j < m1.matrix[i].length; j++) {
                m1.matrix[i][j] += m2.matrix[i][j];
            }
        }
        return m1;
    }

    public void fillRandomMatrix() {
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextFloat(101);
            }
        }

    }

    public void show() {
        System.out.println("Matrix:");

        for (float[] row : matrix) {
            System.out.print("[");
            for (int j = 0; j < row.length - 1; j++) {
                System.out.printf("%-8.2f, ", row[j]);
            }
            System.out.printf("%-8.2f]\n", row[row.length - 1]);
        }
    }

}
