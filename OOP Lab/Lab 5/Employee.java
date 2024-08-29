
import java.util.Scanner;
public class Employee {
    private String name;
    private String city;
    private double Basic_Salary;
    private double Dearness_Allowance;
    private double House_Rent;

    public void getdata(String name , String city, double Basic_Salary, double Dearness_Allowance, double House_Rent){
        this.name = name;
        this.city = city;
        this.Basic_Salary = Basic_Salary;
        this.Dearness_Allowance = Dearness_Allowance;
        this.House_Rent = House_Rent;
    }
    public double calculate(){
        double total = (this.Basic_Salary)+(this.Basic_Salary*this.Dearness_Allowance/100) + (this.Basic_Salary*this.House_Rent/100);
        return total;
    }
    public void display(){
        System.out.println("Name: " + this.name);
        System.out.println("City: " + this.city);
        System.out.println("Total Salary: " + calculate());

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = sc.next();

        System.out.println("Enter city: ");
        String city = sc.next();

        System.out.println("Enter Basic Salary: ");
        double Basic_Salary = sc.nextDouble();

        System.out.println("Enter Dearness Allowance: ");
        double Dearness_Allowance = sc.nextDouble();

        System.out.println("Enter House Rent: ");
        double House_Rent = sc.nextDouble();

        Employee employee1 = new Employee();
        employee1.getdata(name, city, Basic_Salary, Dearness_Allowance, House_Rent);      
        employee1.display();

        sc.close();
    }
}
