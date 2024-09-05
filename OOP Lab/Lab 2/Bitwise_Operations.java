import java.util.Scanner;
public class Bitwise_Operations {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number to perform operation: ");
        int num = sc.nextInt();

        int two_x = num << 1;
        int x_bytwo = num >> 1;

        System.out.println("Integer division by two using bitwise: "+x_bytwo);
        System.out.println("Multiplication by two using bitwise: "+two_x);

        sc.close();
    }
}
