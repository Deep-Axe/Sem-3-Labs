import java.util.Scanner; 
public class Datatype_Conversion {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num;
        double num_d;
        char a;

        System.out.println("Enter an integer");
        num = in.nextInt();
        System.out.println("Enter a double");
        num_d = in.nextDouble();
        System.out.println("Enter a character");
        a = in.next().charAt(0);

        byte b = (byte) num;
        // int to byte converion
        System.out.println("Int: " + num + " to byte: " + b + " conversion verified.");

        int num2 = (int) a;
        //char to inr conversion    
        System.out.println("Char: " + a + " to int: " + num2 + " conversion verified.");
        
        byte b2 = (byte) num_d;
        // double to byte converion
        System.out.println("Double: " + num_d + " to byte: " + b2 + " conversion verified.");
        
        int num3 = (int) num_d;
        // double to int converion
        System.out.println("Double: " + num_d + " to int: " + num3 + " conversion verified.");
    
        in.close();
    }
}
