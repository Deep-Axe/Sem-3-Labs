import java.util.Scanner;
class Palindrome{
	public static void main(String args[]){
		int pal,rev=0,copy,div;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number to check for palindrome");
		pal = in.nextInt();
		copy = pal;
		while(copy!=0){
			div=copy%10;
			copy/=10;
			rev=(rev*10)+div;
		}
		if (rev == pal){
			System.out.println("PALINDROME NUMBER");
		}
		else{
			System.out.println("NOT A PALINDROME NUMBER");
		}
		in.close();			
	}
}
