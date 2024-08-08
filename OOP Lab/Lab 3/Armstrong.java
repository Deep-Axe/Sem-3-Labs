import java.util.Scanner;
public class Armstrong {
    public static void main(String[] args) {
        int num,orgNum, rem;
        int result = 0, n = 0;
        Scanner scanner = new Scanner(System.in);
            System.out.println("Enter number to check for armstrong number: ");
            num = scanner.nextInt();
            orgNum = num;

            for (;orgNum != 0; orgNum /= 10, ++n);

            orgNum = num;

            for (;orgNum != 0; orgNum /= 10)
            {
                rem = orgNum % 10;
                result += Math.pow(rem, n);
            }

            if(result == num){
                System.out.println(num + " is an Armstrong number.");
            }
            else {
                System.out.println(num + " is not an Armstrong number.");
            }
            scanner.close();
        }
}
