import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter lower range: ");
        int n = sc.nextInt();
        System.out.println("Enter upper range: ");
        int m = sc.nextInt();

        if (n > m) {
            System.out.println("Invalid range: n should be less than or equal to m.");
            sc.close();
            return;
        }

        System.out.println("Prime numbers between " + n + " and " + m + ":");
        for (int i = n; i <= m; i++) {
            if (i <= 1) {
                continue;
            }
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break; 
                }
            }
            if (isPrime) {
                System.out.println(i);
            }
        }
        sc.close();
    }
}
