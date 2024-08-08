import java.util.Scanner;
class Rectangle{
	public static void main(String args[]){
		int length, breadth, circum, area;
		Scanner in = new Scanner(System.in);

		System.out.println("Enter length of rectangle");
		length = in.nextInt();

		System.out.println("Enter breadth of rectangle");
		breadth = in.nextInt();

		circum = 2*(length + breadth);
		area = length * breadth;

		System.out.println("Area of rectangle " + area);
		System.out.println("Circumference of rectangle " + circum);

		in.close();
	}
}