import java.util.Scanner;
public class Magic_Square {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter dimensions for Square Matrix: ");
        int dim = sc.nextInt();
        int[][] mat = new int[dim][dim];

        System.out.println("Enter the elements of the matrix: ");
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        
        sc.close();
        
        if (isMagicSquare(mat, dim)) {
            System.out.println("The matrix is a magic square.");
        } else {
            System.out.println("The matrix is not a magic square.");
        }
    }

    private static boolean isMagicSquare(int[][] mat, int dim) {
        int magicSum = sumRow(mat, 0, dim); // Initial magic sum from the first row

        for (int i = 1; i < dim; i++) {
            if (sumRow(mat, i, dim) != magicSum) {
                return false;
            }
        }
        for (int j = 0; j < dim; j++) {
            if (sumColumn(mat, j, dim) != magicSum) {
                return false;
            }
        }
        if (sumMainDiagonal(mat, dim) != magicSum) {
            return false;
        }

        if (sumSecondaryDiagonal(mat, dim) != magicSum) {
            return false;
        }

        return true;
    }

    private static int sumRow(int[][] mat, int row, int dim) {
        int sum = 0;
        for (int j = 0; j < dim; j++) {
            sum += mat[row][j];
        }
        return sum;
    }

    private static int sumColumn(int[][] mat, int col, int dim) {
        int sum = 0;
        for (int i = 0; i < dim; i++) {
            sum += mat[i][col];
        }
        return sum;
    }

    private static int sumMainDiagonal(int[][] mat, int dim) {
        int sum = 0;
        for (int i = 0; i < dim; i++) {
            sum += mat[i][i];
        }
        return sum;
    }

    private static int sumSecondaryDiagonal(int[][] mat, int dim) {
        int sum = 0;
        for (int i = 0; i < dim; i++) {
            sum += mat[i][dim - i - 1];
        }
        return sum;
    }
}
