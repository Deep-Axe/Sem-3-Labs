import java.util.Scanner;

public class Stack {
    private Object[] array;
    private int top;
    private int capacity;

    public Stack(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        this.capacity = initialCapacity;
        this.array = new Object[capacity];
        this.top = -1; // Indicates that the stack is empty
    }

    public void push(Object item) {
        if (top == capacity - 1) {
            resize();
        }
        array[++top] = item;
    }

    public Object pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        Object item = array[top];
        array[top--] = null; // Clear the reference
        return item;
    }

    public Object peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return array[top];
    }


    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    private void resize() {
        int newCapacity = capacity * 2;
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, capacity);
        array = newArray;
        capacity = newCapacity;
    }


    public void printStack() {
        for (int i = top; i >= 0; i--) {
            System.out.println(array[i]);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack stack = new Stack(5);

        while (true) {
            System.out.println("\nStack Operations:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Print Stack");
            System.out.println("5. Check if Empty");
            System.out.println("6. Check Size");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter an item to push as string: ");
                    scanner.nextLine(); 
                    String item = scanner.nextLine();
                    stack.push(item);
                    System.out.println("Item pushed.");
                    break;
                case 2: // Pop
                    try {
                        Object poppedItem = stack.pop();
                        System.out.println("Popped item: " + poppedItem);
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        Object topItem = stack.peek();
                        System.out.println("Top item: " + topItem);
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Stack contents:");
                    stack.printStack();
                    break;
                case 5: 
                    System.out.println("Is stack empty? " + stack.isEmpty());
                    break;
                case 6: 
                    System.out.println("Size of stack: " + stack.size());
                    break;
                case 7: 
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        }
    }
}
