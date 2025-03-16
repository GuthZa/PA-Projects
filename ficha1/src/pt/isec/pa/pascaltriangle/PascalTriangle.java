package pt.isec.pa.pascaltriangle;

public class PascalTriangle {
    private final int[][] matrix;

    public PascalTriangle(int depth) {
        this.matrix = new int[depth][];
        fillTriangle(depth);
    }

    private void fillTriangle(int depth) {
        for (int row = 0; row < depth; row++) {
            matrix[row] = new int[row + 1];
            matrix[row][0] = matrix[row][row] = 1;
            for (int col = 1; col < row; col++) {
                matrix[row][col] = matrix[row-1][col-1] + matrix[row-1][col];
            }
        }
    }

    private String generateString(boolean align) {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < matrix.length; row++) {
            if (align) {
                sb.append(" ".repeat(((matrix.length - 1) * 6 - row * 6) / 2));
            }
            for (int col = 0; col < matrix[row].length; col++) {
                sb.append(String.format("%6d", matrix[row][col]));
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public void show(boolean align) {
        System.out.println(generateString(align));
    }

    public void getString() {
        System.out.println(generateString(false));
    }
}
