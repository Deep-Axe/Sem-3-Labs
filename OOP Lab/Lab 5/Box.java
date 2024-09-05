import java.util.Scanner;
public class Box {

    private double length;
    private double width;
    private double height;
    private double volume;

    public void init(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double Vol(){
        this.volume = (this.length)*(this.width)*(this.height);
        return volume;
    }

    public void printDimensions() {
        System.out.println("Box dimensions:");
        System.out.println("Length: " + length);
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of box: ");
        double length = sc.nextDouble();
        System.out.println("Enter width of box: ");
        double width = sc.nextDouble();
        System.out.println("Enter height of box: ");
        double height = sc.nextDouble();
        Box myBox = new Box();
        myBox.init(length, width, height);
        
        myBox.printDimensions();
        System.out.println("Volume: "+ myBox.Vol());
        sc.close();
    }
}
