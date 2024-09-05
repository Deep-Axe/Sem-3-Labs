public class PrimeNumbersInArray {
    public static void main(String[] args) {
        int[] array = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 17, 19, 23};
        printPrimeNumbers(array);
    }


    static void printPrimeNumbers(int[] array) {
        System.out.println("Prime numbers in the array are:");
        for (int number : array) {
            if (isPrime(number)) {
                System.out.println(number);
            }
        }
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
}
