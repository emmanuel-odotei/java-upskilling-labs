package intermediate.src.week1_labs.concurrency;

public class NoDeadLockDemo {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();
    
    public void thread1() {
        synchronized (lock1) {
            System.out.println("Thread 1: Holding lock 1...");
            try {
                Thread.sleep(100); // Simulate work with lock 1
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            synchronized (lock2) {
                System.out.println("Thread 1: Acquired lock 2!");
            }
        }
    }
    
    public void thread2() {
        synchronized (lock1) { // Lock order changed to lock1 first
            System.out.println("Thread 2: Holding lock 1...");
            try {
                Thread.sleep(100); // Simulate work with lock 1
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            synchronized (lock2) {
                System.out.println("Thread 2: Acquired lock 2!");
            }
        }
    }
    
    public static void main(String[] args) {
        NoDeadLockDemo noDeadlockDemo = new NoDeadLockDemo();
        
        Thread t1 = new Thread( noDeadlockDemo::thread1 );
        Thread t2 = new Thread( noDeadlockDemo::thread2 );
        
        t1.start();
        t2.start();
    }
}
