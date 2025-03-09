package pt.isec.pa.ex7;

public class Main {
    public static void main(String[] args) {
        Matrix m1 = new Matrix(3,3);
        m1.fillRandomMatrix();
        Matrix m2 = new Matrix(m1);
        m2.show();
        m2.fillRandomMatrix();
        m2.show();
        m1.addMatrix(m2.getMatrix());
        Matrix m3 = Matrix.addMatrix(m1, m2);
        if (m3!=null)
            m3.show();
    }
}
