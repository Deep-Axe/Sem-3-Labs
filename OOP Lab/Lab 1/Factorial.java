import java.util.Scanner;
class Factorial{
	public static void main(String args[]){
		int num,fac = 1;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number to print factorial");
		num = in.nextInt();
		while(num != 0){
			fac *= num;
			num--;
			
		}
		System.out.println(fac);		
		in.close();		
	}
}