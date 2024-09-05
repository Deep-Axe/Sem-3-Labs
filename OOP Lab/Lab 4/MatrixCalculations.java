public class MatrixCalculations {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int trace = calculateTrace(matrix);
        System.out.println("Trace of the matrix: " + trace);

        double Norm = Norm(matrix);
        System.out.println("Norm of the matrix: " + Norm);
    }

    public static int calculateTrace(int[][] matrix) {
        int trace = 0;
        int size = matrix.length;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    public static double Norm(int[][] matrix) {
        double sumOfSquares = 0;
        int size = matrix.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sumOfSquares += matrix[i][j] * matrix[i][j];
            }
        }
        return Math.sqrt(sumOfSquares);
    }
}
