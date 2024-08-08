import java.util.Scanner;
class Boolean_to_Int{
	public static void main(String args[]){
		boolean a = true;
		int b = a; // Compilation error verified: "Type mismatch: cannot convert from boolean to int"
		System.out.println(a);
		System.out.println(b);


		boolean x = true;
		int y= (int) x;
		 // Compilation error verified, typecasting from boolean to int not possible
		System.out.println(x);
		System.out.println(y);		
	}
}