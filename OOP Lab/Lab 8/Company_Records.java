import java.util.Scanner;
public class Company_Records {
    public interface Item {
        String getDetails();
        double getSalesForLastThreeMonths();
    }

    public static class Hardware implements Item {
        private String category;
        private String manufacturer;
        private double[] salesForLastThreeMonths;

        public Hardware(String category, String manufacturer, double[] salesForLastThreeMonths) {
            this.category = category;
            this.manufacturer = manufacturer;
            this.salesForLastThreeMonths = salesForLastThreeMonths;
        }

        public String getDetails() {
            return "Category: " + category + ", Manufacturer: " + manufacturer;
        }

        public double getSalesForLastThreeMonths() {
            double totalSales = 0;
            for (double sale : salesForLastThreeMonths) {
                totalSales += sale;
            }
            return totalSales;
        }
    }

    public static class Software implements Item {
        private String type;
        private String operatingSystem;
        private double[] salesForLastThreeMonths;

        public Software(String type, String operatingSystem, double[] salesForLastThreeMonths) {
            this.type = type;
            this.operatingSystem = operatingSystem;
            this.salesForLastThreeMonths = salesForLastThreeMonths;
        }

       
        public String getDetails() {
            return "Type: " + type + ", Operating System: " + operatingSystem;
        }

       
        public double getSalesForLastThreeMonths() {
            double totalSales = 0;
            for (double sale : salesForLastThreeMonths) {
                totalSales += sale;
            }
            return totalSales;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of hardware products:");
        int numHardware = scanner.nextInt();
        scanner.nextLine(); 

        Hardware[] hardware = new Hardware[numHardware];
        
        for (int i = 0; i < numHardware; i++) {
            System.out.println("Enter details for Hardware " + (i + 1) + ":");

            System.out.print("Category: ");
            String hardwareCategory = scanner.nextLine();

            System.out.print("Manufacturer: ");
            String hardwareManufacturer = scanner.nextLine();

            double[] hardwareSales = new double[3];
            for (int j = 0; j < hardwareSales.length; j++) {
                System.out.print("Sale for month " + (j + 1) + ": $");
                hardwareSales[j] = scanner.nextDouble();
            }
            scanner.nextLine(); 

            hardware[i] = new Hardware(hardwareCategory, hardwareManufacturer, hardwareSales);
        }

        System.out.println("\nEnter number of software products:");
        int numSoftware = scanner.nextInt();
        scanner.nextLine(); 

        Software[] software = new Software[numSoftware];
        
        for (int i = 0; i < numSoftware; i++) {
            System.out.println("Enter details for Software " + (i + 1) + ":");

            System.out.print("Type: ");
            String softwareType = scanner.nextLine();

            System.out.print("Operating System: ");
            String softwareOperatingSystem = scanner.nextLine();

            double[] softwareSales = new double[3];
            for (int j = 0; j < softwareSales.length; j++) {
                System.out.print("Sale for month " + (j + 1) + ": $");
                softwareSales[j] = scanner.nextDouble();
            }
            scanner.nextLine(); 

            software[i] = new Software(softwareType, softwareOperatingSystem, softwareSales);
        }
        System.out.println("\nHardware Details and Sales:");
        for (Hardware hw : hardware) {
            printItemDetailsAndSales(hw);
        }

        System.out.println("\nSoftware Details and Sales:");
        for (Software sw : software) {
            printItemDetailsAndSales(sw);
        }

        scanner.close();
    }

    public static void printItemDetailsAndSales(Item item) {
        System.out.println("Item Details: " + item.getDetails());
        System.out.println("Sales for Last 3 Months: $" + item.getSalesForLastThreeMonths());
        System.out.println();
    }
}
