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

public class MatrixOperations {
    public static void main(String[] args) {
        int[][] data = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        Matrix matrix = new Matrix(data);

        // Create and start threads
        DisplayMatrixThread t1 = new DisplayMatrixThread(matrix);
        TransposeMatrixThread t2 = new TransposeMatrixThread(matrix);
        MaxValueThread t3 = new MaxValueThread(matrix);
        PrincipalDiagonalThread t4 = new PrincipalDiagonalThread(matrix);
        NonDiagonalElementsThread t5 = new NonDiagonalElementsThread(matrix);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        
        // Wait for all threads to finish
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
