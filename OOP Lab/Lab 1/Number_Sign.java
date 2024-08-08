import java.util.Scanner;
class Number_Sign{
	public static void main(String args[]){
		int num[] = new int[10];
		int i,neg = 0,zero = 0,pos = 0;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter 10 numbers");
		for(i=0; i<10; i++){
			num[i]=in.nextInt();
		}
		for(i=0; i<10; i++){
			if(num[i] < 0)
				neg++;
			if(num[i] > 0)
				pos++;
			if(num[i] == 0)
				zero++;
		}
		System.out.println("Number of negative numbers " + neg);
		System.out.println("Number of positive numbers " + pos);
		System.out.println("Number of zeroes " + zero);

		in.close();		
	}
}