import java.util.Scanner;
class MyRunnable implements Runnable {
    private String threadName;

    public MyRunnable(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        System.out.println("Runnable Thread: " + threadName + " is running.");
        try {
           
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Runnable Thread: " + threadName + " was interrupted.");
        }
        System.out.println("Runnable Thread: " + threadName + " has completed.");
    }
}


class MyThread extends Thread {
    private String threadName;

    public MyThread(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        System.out.println("Thread: " + threadName + " is running.");
        try {
            
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread: " + threadName + " was interrupted.");
        }
        System.out.println("Thread: " + threadName + " has completed.");
    }
}

public class ThreadDemoAah {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Create and start a thread using Runnable");
            System.out.println("2. Create and start a thread by extending Thread class");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Runnable thread name: ");
                    String runnableName = scanner.next();
                    MyRunnable runnable = new MyRunnable(runnableName);
                    Thread runnableThread = new Thread(runnable);
                    runnableThread.start();
                    break;

                case 2:
                    System.out.print("Enter Thread name: ");
                    String threadName = scanner.next();
                    MyThread myThread = new MyThread(threadName);
                    myThread.start();
                    break;

                case 3:
                    exit = true;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
