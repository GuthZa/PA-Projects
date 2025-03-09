package pt.isec.pa.ex6;

public class Main {
    public static void main(String[] args) {
        Matrix m1 = new Matrix();
        m1.fillRandomMatrix();
        m1.printMatrix();
        m1.setMatrix(m1.transpose());
        m1.printMatrix();
    }
}
