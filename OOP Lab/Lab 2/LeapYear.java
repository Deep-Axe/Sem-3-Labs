import java.util.Scanner;

class LeapYear {

    public static void main(String[] args) {
        int year;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number to check for leap year: ");
        year = in.nextInt();

        if ((year % 4 != 0) || (year % 100 == 0 && year % 400 != 0)) {
            System.out.println("NOT A LEAP YEAR");
        } else {
            System.out.println("LEAP YEAR!");
        }

        in.close();
    }
}
