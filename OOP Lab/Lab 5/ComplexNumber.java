import java.util.Scanner;

class ComplexNumber {
    int real, imaginary;
    public ComplexNumber(int r, int i) {
        this.real = r;
        this.imaginary = i;
    }

    public void showC() {
        System.out.print(this.real + " + i" + this.imaginary);
    }

    public ComplexNumber add(ComplexNumber second) {
        return new ComplexNumber(this.real + second.real, this.imaginary + second.imaginary);
    }

    public ComplexNumber add(int r) {
        return new ComplexNumber(this.real + r, this.imaginary);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the real and imaginary part of first complex number: ");
        int real1 = scanner.nextInt();
        int image1 = scanner.nextInt();
        ComplexNumber c1 = new ComplexNumber(real1, image1);

        System.out.print("Enter the real and imaginary part of the second complex number: ");
        int real2 = scanner.nextInt();
        int image2 = scanner.nextInt();
        ComplexNumber c2 = new ComplexNumber(real2, image2);

        System.out.print("First Complex number: ");
        c1.showC();
        System.out.print("\nSecond Complex number: ");
        c2.showC();
        ComplexNumber result1 = c1.add(c2);
        System.out.print("\nAddition: ");
        result1.showC();

        System.out.print("\nEnter an integer to add to the first complex number: ");
        int integerToAdd = scanner.nextInt();
        ComplexNumber result2 = c1.add(integerToAdd);
        System.out.print("Addition of integer to the first complex number is: ");
        result2.showC();
        scanner.close();
    }
}
