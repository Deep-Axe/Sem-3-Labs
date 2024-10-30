import java.util.ArrayList;
import java.util.Scanner;

class Stack<T> {
    private ArrayList<T> items;

    public Stack() {
        items = new ArrayList<>();
    }

    public void push(T item) {
        items.add(item);
    }

    public T pop() {
        if (!isEmpty()) {
            return items.remove(items.size() - 1);
        }
        throw new IndexOutOfBoundsException("Pop from empty stack");
    }

    public T peek() {
        if (!isEmpty()) {
            return items.get(items.size() - 1);
        }
        throw new IndexOutOfBoundsException("Peek from empty stack");
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        return items.size();
    }
}

class Student {
    private String name;
    private int studentId;

    public Student(String name, int studentId) {
        this.name = name;
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Student(Name: " + name + ", ID: " + studentId + ")";
    }
}

class Employee {
    private String name;
    private int employeeId;

    public Employee(String name, int employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "Employee(Name: " + name + ", ID: " + employeeId + ")";
    }
}

public class StacksUsingGeneric {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a stack for Students
        Stack<Student> studentStack = new Stack<>();
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter name for Student " + (i + 1) + ": ");
            String name = scanner.nextLine();
            System.out.print("Enter ID for Student " + (i + 1) + ": ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            studentStack.push(new Student(name, id));
        }

        // Student stack operations
        String studentAction;
        do {
            System.out.print("\nEnter 'pop' to pop or 'peek' to peek at the top student (or 'exit' to stop): ");
            studentAction = scanner.nextLine();

            switch (studentAction.toLowerCase()) {
                case "pop":
                    if (!studentStack.isEmpty()) {
                        System.out.println("Popped: " + studentStack.pop());
                    } else {
                        System.out.println("The student stack is empty.");
                    }
                    break;
                case "peek":
                    if (!studentStack.isEmpty()) {
                        System.out.println("Top Student: " + studentStack.peek());
                    } else {
                        System.out.println("The student stack is empty.");
                    }
                    break;
                case "exit":
                    break;
                default:
                    System.out.println("Invalid action. Please enter 'pop', 'peek', or 'exit'.");
            }
        } while (!studentAction.equalsIgnoreCase("exit"));

        // Create a stack for Employees
        Stack<Employee> employeeStack = new Stack<>();
        System.out.print("\nEnter the number of employees: ");
        int numEmployees = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numEmployees; i++) {
            System.out.print("Enter name for Employee " + (i + 1) + ": ");
            String name = scanner.nextLine();
            System.out.print("Enter ID for Employee " + (i + 1) + ": ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            employeeStack.push(new Employee(name, id));
        }

        // Employee stack operations
        String employeeAction;
        do {
            System.out.print("\nEnter 'pop' to pop or 'peek' to peek at the top employee (or 'exit' to stop): ");
            employeeAction = scanner.nextLine();

            switch (employeeAction.toLowerCase()) {
                case "pop":
                    if (!employeeStack.isEmpty()) {
                        System.out.println("Popped: " + employeeStack.pop());
                    } else {
                        System.out.println("The employee stack is empty.");
                    }
                    break;
                case "peek":
                    if (!employeeStack.isEmpty()) {
                        System.out.println("Top Employee: " + employeeStack.peek());
                    } else {
                        System.out.println("The employee stack is empty.");
                    }
                    break;
                case "exit":
                    break;
                default:
                    System.out.println("Invalid action. Please enter 'pop', 'peek', or 'exit'.");
            }
        } while (!employeeAction.equalsIgnoreCase("exit"));

        scanner.close();
    }
}
