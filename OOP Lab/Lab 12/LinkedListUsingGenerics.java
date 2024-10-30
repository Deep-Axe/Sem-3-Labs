import java.util.Scanner;

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class GenericLinkedList<T> {
    private Node<T> head;
    private int size;

    public GenericLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Add an element to the end of the list
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // Get the size of the list
    public int size() {
        return size;
    }

    // Display the elements of the list
    public void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class LinkedListUsingGenerics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create both linked lists
        GenericLinkedList<Integer> integerList = new GenericLinkedList<>();
        GenericLinkedList<Double> doubleList = new GenericLinkedList<>();

        while (true) {
            System.out.print("Enter a number (or type 'done' to finish): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }

            try {
                if (input.contains(".")) {
                    // Attempt to parse as Double
                    double doubleValue = Double.parseDouble(input);
                    doubleList.add(doubleValue);
                    System.out.println("Added to Double Linked List.");
                } else {
                    // Attempt to parse as Integer
                    int intValue = Integer.parseInt(input);
                    integerList.add(intValue);
                    System.out.println("Added to Integer Linked List.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }

            // Show current state of both lists
            System.out.println("\nCurrent Integer Linked List:");
            integerList.display();
            System.out.println("Size: " + integerList.size());

            System.out.println("Current Double Linked List:");
            doubleList.display();
            System.out.println("Size: " + doubleList.size());
        }

        scanner.close();
    }
}
