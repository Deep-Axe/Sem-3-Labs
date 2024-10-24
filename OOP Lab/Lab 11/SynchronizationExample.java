class SharedResource {
    private int counter = 0;

    public synchronized void increment() {
        counter++;
        System.out.println("Counter (synchronized method): " + counter);
    }

    public int getCounter() {
        return counter;
    }
}

class SynchronizedMethodThread extends Thread {
    private SharedResource sharedResource;

    public SynchronizedMethodThread(SharedResource resource) {
        this.sharedResource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            sharedResource.increment();
            try {
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SynchronizedBlockThread extends Thread {
    private SharedResource sharedResource;

    public SynchronizedBlockThread(SharedResource resource) {
        this.sharedResource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (sharedResource) { 
                int currentCounter = sharedResource.getCounter();
                sharedResource.increment();
                System.out.println("Counter (synchronized block): " + (currentCounter + 1));
            }
            try {
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class SynchronizationExample {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        SynchronizedMethodThread thread1 = new SynchronizedMethodThread(sharedResource);
        SynchronizedBlockThread thread2 = new SynchronizedBlockThread(sharedResource);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Counter Value: " + sharedResource.getCounter());
    }
}
