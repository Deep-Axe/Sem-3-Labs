import java.util.Scanner;

class Matrix {
    private int[][] matrix;
    private int rows;
    private int cols;

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
        this.rows = matrix.length;
        this.cols = matrix[0].length;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}

class DisplayMatrixThread extends Thread {
    private Matrix matrix;

    public DisplayMatrixThread(Matrix matrix) {
        this.matrix = matrix;
    }

    @Override
    public void run() {
        System.out.println("Matrix:");
        for (int[] row : matrix.getMatrix()) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}

class TransposeMatrixThread extends Thread {
    private Matrix matrix;

    public TransposeMatrixThread(Matrix matrix) {
        this.matrix = matrix;
    }

    @Override
    public void run() {
        System.out.println("Transpose of the Matrix:");
        for (int j = 0; j < matrix.getCols(); j++) {
            for (int i = 0; i < matrix.getRows(); i++) {
                System.out.print(matrix.getMatrix()[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class MaxValueThread extends Thread {
    private Matrix matrix;

    public MaxValueThread(Matrix matrix) {
        this.matrix = matrix;
    }

    @Override
    public void run() {
        int max = Integer.MIN_VALUE;
        for (int[] row : matrix.getMatrix()) {
            for (int value : row) {
                if (value > max) {
                    max = value;
                }
            }
        }
        System.out.println("Maximum value in the Matrix: " + max);
    }
}

class PrincipalDiagonalThread extends Thread {
    private Matrix matrix;

    public PrincipalDiagonalThread(Matrix matrix) {
        this.matrix = matrix;
    }

    @Override
    public void run() {
        System.out.println("Principal Diagonal Elements:");
        for (int i = 0; i < Math.min(matrix.getRows(), matrix.getCols()); i++) {
            System.out.print(matrix.getMatrix()[i][i] + " ");
        }
        System.out.println();
    }
}

class NonDiagonalElementsThread extends Thread {
    private Matrix matrix;

    public NonDiagonalElementsThread(Matrix matrix) {
        this.matrix = matrix;
    }

    @Override
    public void run() {
        System.out.println("Non-Diagonal Elements:");
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getCols(); j++) {
                if (i != j) {
                    System.out.print(matrix.getMatrix()[i][j] + " ");
                }
            }
        }
        System.out.println();
    }
}

public class MatrixOperationsImproved {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();

        int[][] data = new int[rows][cols];

        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = scanner.nextInt();
            }
        }
        Matrix matrix = new Matrix(data);

        // Create threads
        DisplayMatrixThread t1 = new DisplayMatrixThread(matrix);
        TransposeMatrixThread t2 = new TransposeMatrixThread(matrix);
        MaxValueThread t3 = new MaxValueThread(matrix);
        PrincipalDiagonalThread t4 = new PrincipalDiagonalThread(matrix);
        NonDiagonalElementsThread t5 = new NonDiagonalElementsThread(matrix);

        // Start and join threads
        Thread[] threads = {t1, t2, t3, t4, t5};

        for (Thread thread : threads) {
            thread.start();
            try {
                // Wait for the thread to finish
                thread.join();
                System.out.println(thread.getName() + " is alive after join: " + thread.isAlive());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All threads have completed execution.");
        scanner.close();;
    }
}
