import java.util.Scanner;
class Multiplication_Table{
	public static void main(String args[]){
		int mult , i;

		Scanner in = new Scanner(System.in);
		System.out.println("Enter number to print multiplication tables");
		mult = in.nextInt();

		for (i = 1;i <= 10; i++){
			System.out.println(mult + " * " + i + " = " + (mult*i));
		}				
		in.close();
	}
}