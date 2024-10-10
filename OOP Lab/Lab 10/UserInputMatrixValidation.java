import java.util.Scanner;

class NonSquareMatrixException extends Exception {
    public NonSquareMatrixException(String message) {
        super(message);
    }
}

public class UserInputMatrixValidation {
    public static void validateMatrix(int n, int m) throws NonSquareMatrixException {
        if (n != m) {
            throw new NonSquareMatrixException("Matrix is not square.");
        }
        System.out.println("Matrix is square.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the matrix (n x m): ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        try {
            validateMatrix(n, m);
        } catch (NonSquareMatrixException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
