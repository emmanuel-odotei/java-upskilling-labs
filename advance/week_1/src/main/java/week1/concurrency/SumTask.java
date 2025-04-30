package week1.concurrency;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Long> {
    private static final int THRESHOLD = 1000;
    
    private final long[] array;
    private final int start;
    private final int end;
    
    public SumTask(long[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }
    
    // Step 2: Implement compute method
    @Override
    protected Long compute() {
        int length = end - start;
        
        if (length <= THRESHOLD) {
            // Base case: sum directly
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        }
        
        // Split into two subtasks
        int mid = start + length / 2;
        SumTask leftTask = new SumTask(array, start, mid);
        SumTask rightTask = new SumTask(array, mid, end);
        
        // Fork one task, compute the other
        leftTask.fork();
        long rightResult = rightTask.compute();
        long leftResult = leftTask.join();
        
        // Combine results
        return leftResult + rightResult;
    }
    
    public static void main(String[] args){
        // Step 3: Create large array with random data
        int size = 10_000_000;
        long[] data = new long[size];
        Random random = new Random();
        
        for (int i = 0; i < size; i++) {
            data[i] = random.nextInt(100); // values from 0 to 99
        }
        
        // Setup ForkJoinPool and task
        ForkJoinPool pool = new ForkJoinPool();
        SumTask task = new SumTask(data, 0, data.length);
        
        System.out.println("Starting parallel summation...");
        
        long startTime = System.currentTimeMillis();
        long totalSum = pool.invoke(task);
        long endTime = System.currentTimeMillis();
        
        System.out.println("Total sum: " + totalSum);
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
        
        pool.shutdown();
    }
}
