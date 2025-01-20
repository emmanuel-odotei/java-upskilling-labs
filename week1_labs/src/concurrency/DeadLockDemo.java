package intermediate.src.week1_labs.concurrency;

public class DeadLockDemo {
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
            System.out.println("Thread 1: Waiting for lock 2...");
            synchronized (lock2) {
                System.out.println("Thread 1: Acquired lock 2!");
            }
        }
    }
    
    public void thread2() {
        synchronized (lock2) {
            System.out.println("Thread 2: Holding lock 2...");
            try {
                Thread.sleep(100); // Simulate work with lock 2
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Thread 2: Waiting for lock 1...");
            synchronized (lock1) {
                System.out.println("Thread 2: Acquired lock 1!");
            }
        }
    }
    
    public static void main(String[] args) {
        DeadLockDemo deadlockDemo = new DeadLockDemo();
        
        Thread t1 = new Thread( deadlockDemo::thread1 );
        Thread t2 = new Thread( deadlockDemo::thread2 );
        
        t1.start();
        t2.start();
        
        System.out.println( "Deadlock demo completed." );
        System.exit(0);
    }
}
