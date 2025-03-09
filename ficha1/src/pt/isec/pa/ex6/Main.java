package pt.isec.pa.ex6;

public class Main {
    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        matrix.fillRandomMatrix();
        matrix.printMatrix();
        matrix.setMatrix(matrix.transpose());
        matrix.printMatrix();
    }
}
