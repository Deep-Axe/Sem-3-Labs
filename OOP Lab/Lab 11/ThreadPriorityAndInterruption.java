class MyThread extends Thread {
    private int threadId;

    public MyThread(int id) {
        this.threadId = id;
    }

    public void run() {
        try {
            System.out.println("Thread " + threadId + " (Priority: " + getPriority() + ") is starting at " + System.currentTimeMillis());
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread " + threadId + " is working...");
                Thread.sleep(500);
            }
            System.out.println("Thread " + threadId + " has completed at " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadId + " was interrupted!");
        }
    }
}

public class ThreadPriorityAndInterruption {
    public static void main(String[] args) {
        MyThread t1 = new MyThread(1);
        MyThread t2 = new MyThread(2);
        MyThread t3 = new MyThread(3);

        t1.setPriority(Thread.MIN_PRIORITY);    // Priority 1
        t2.setPriority(Thread.NORM_PRIORITY);   // Priority 5
        t3.setPriority(Thread.MAX_PRIORITY);     // Priority 10

        // Start threads
        t1.start();
        t2.start();
        t3.start();

        try {
            Thread.sleep(1000);
            // Interrupt the second thread
            t2.interrupt();
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
        }

        // Wait for all threads to finish
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted during join.");
        }

        System.out.println("All threads have completed execution.");
    }
}
