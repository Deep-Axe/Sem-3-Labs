import java.util.ArrayList;
import java.util.List;

class WildcardExample<T> {
    private List<T> elements;

    public WildcardExample() {
        this.elements = new ArrayList<>();
    }

    public void addElement(T element) {
        elements.add(element);
    }

    public void displayElements() {
        for (T element : elements) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // Method using wildcards
    public void printWithWildcard(List<? extends T> list) {
        for (T item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}

public class WildcardArgsinJava {
    public static void main(String[] args) {
        // Example with Integer
        WildcardExample<Number> intExample = new WildcardExample<>();
        intExample.addElement(10);
        intExample.addElement(20);
        System.out.println("Integer Example:");
        intExample.displayElements();

        // Using wildcard method with a List of Integers
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intExample.printWithWildcard(intList);

        // Example with Double
        WildcardExample<Number> doubleExample = new WildcardExample<>();
        doubleExample.addElement(1.1);
        doubleExample.addElement(2.2);
        System.out.println("\nDouble Example:");
        doubleExample.displayElements();

        // Using wildcard method with a List of Doubles
        List<Double> doubleList = new ArrayList<>();
        doubleList.add(3.3);
        doubleList.add(4.4);
        doubleExample.printWithWildcard(doubleList);
    }
}
