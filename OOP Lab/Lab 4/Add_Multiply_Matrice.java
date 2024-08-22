import java.util.Scanner;

public class Add_Multiply_Matrice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input dimensions for Matrix 1
        System.out.println("Enter dimensions for Matrix 1 (rows and columns): ");
        int rows1 = sc.nextInt();
        int cols1 = sc.nextInt();
        int[][] mat1 = new int[rows1][cols1];

        // Input elements for Matrix 1
        System.out.println("Enter Matrix 1 elements: ");
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                mat1[i][j] = sc.nextInt();
            }
        }

        // Input dimensions for Matrix 2
        System.out.println("Enter dimensions for Matrix 2 (rows and columns): ");
        int rows2 = sc.nextInt();
        int cols2 = sc.nextInt();
        int[][] mat2 = new int[rows2][cols2];

        // Input elements for Matrix 2
        System.out.println("Enter Matrix 2 elements: ");
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < cols2; j++) {
                mat2[i][j] = sc.nextInt();
            }
        }

        // Check if matrices can be added
        if (rows1 == rows2 && cols1 == cols2) {
            int[][] mat_sum = new int[rows1][cols1];

            // Perform matrix addition
            System.out.println("Sum Matrix: ");
            for (int i = 0; i < rows1; i++) {
                for (int j = 0; j < cols1; j++) {
                    mat_sum[i][j] = mat1[i][j] + mat2[i][j];
                    System.out.print(mat_sum[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Matrices cannot be added due to dimension mismatch.");
        }

        // Check if matrices can be multiplied
        if (cols1 == rows2) {
            int[][] mat_product = new int[rows1][cols2];

            // Perform matrix multiplication
            System.out.println("Matrix Multiplication: ");
            for (int i = 0; i < rows1; i++) {
                for (int j = 0; j < cols2; j++) {
                    mat_product[i][j] = 0;
                    for (int k = 0; k < cols1; k++) {
                        mat_product[i][j] += mat1[i][k] * mat2[k][j];
                    }
                    System.out.print(mat_product[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Matrices cannot be multiplied due to dimension mismatch.");
        }
    }
}