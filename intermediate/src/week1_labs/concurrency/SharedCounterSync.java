package intermediate.src.week1_labs.concurrency;

public class SharedCounterSync {
    private int counter = 0;
    
    public void increment() {
        synchronized (this) {
            counter++;
            System.out.println("Counter incremented to: " + counter);
        }
    }
    
    public int getCounter() {
        return counter;
    }
    
    public static void main(String[] args) {
        SharedCounterSync sharedCounter = new SharedCounterSync();
        sharedCounter.increment();
        sharedCounter.increment();
        sharedCounter.increment();
        System.out.println("Counter value: " + sharedCounter.getCounter());
    }
}
