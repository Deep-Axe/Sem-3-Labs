import java.util.Scanner;
public class LabEval {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter dimension of matrix: ");
        int dim1 = sc.nextInt(); 
        int dim2 = sc.nextInt();
        int matrix[][] = new int[dim1][dim2];
        int i,j;
        
        if (dim1 <= 0 || dim2 <= 0) {
            throw new IllegalArgumentException("Invalid dimensions for matrix: dimensions must be greater than zero.");
        }

        System.out.println("ENTER MATRIX ELEMENTS: ");
        for (i=0;i<dim1;i++){
            for (j=0;j<dim2;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        sumPrimeNumbers(matrix);
        sumEvenNumbers(matrix);
        sc.close();
    }


    static void sumPrimeNumbers(int[][] matrix) {
        int sum = 0;
        System.out.println("Sum of prime numbers in the array are:");
        for(int[] array : matrix){
            for (int number : array) {
                if (isPrime(number)) {
                    sum += number;
                }
            }
        }
        System.out.println(sum);
    }

    static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number == 2) {
            return true; 
        }
        if (number % 2 == 0) {
            return false; 
        }
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) {
                return false; 
            }
        }
        return true; 
    }

    static void sumEvenNumbers(int[][] matrix){
        int sum_even = 0;
        System.out.println("Sum of even numbers in the array are:");
        for (int[] array : matrix){
            for (int number : array) {
                if ((number % 2) == 0) {
                    sum_even += number;
                }
            }
        }
        System.out.println(sum_even);

    }
}
