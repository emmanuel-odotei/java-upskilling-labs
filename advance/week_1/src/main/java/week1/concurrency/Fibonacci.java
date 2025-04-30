package week1.concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Fibonacci extends RecursiveTask<Integer> {
    private final int n;
    
    public Fibonacci (int n) {
        this.n = n;
    }
    
    // Step 2: Implement compute() method
    @Override
    protected Integer compute () {
        if ( n <= 1 ) {
            return n; // Base case
        }
        
        // Create subtasks
        Fibonacci task1 = new Fibonacci( n - 1 );
        Fibonacci task2 = new Fibonacci( n - 2 );
        
        // Fork one task to run asynchronously
        task1.fork();
        
        // Compute the second task synchronously
        int result2 = task2.compute();
        
        // Wait and get the result of the forked task
        int result1 = task1.join();
        
        // Combine results
        return result1 + result2;
    }
    
    public static void main (String[] args) {
        // Step 3: Setup ForkJoinPool and execute task
        ForkJoinPool pool = new ForkJoinPool();
        
        int number = 25; // You can change this for performance comparison
        Fibonacci task = new Fibonacci( number );
        
        System.out.println( "Calculating Fibonacci for: " + number );
        
        long startTime = System.currentTimeMillis();
        int result = pool.invoke( task ); // Submit task to ForkJoinPool
        long endTime = System.currentTimeMillis();
        
        System.out.println( "Fibonacci(" + number + ") = " + result );
        System.out.println( "Time taken: " + ( endTime - startTime ) + "ms" );
        
        pool.shutdown(); // Properly shut down the pool
    }
}
