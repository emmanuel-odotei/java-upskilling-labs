package week1.reflection_and_annotation;

import java.lang.reflect.Method;

public class LogExecutionTimeExample {
    
    public static void main(String[] args) {
        MyService service = new MyService();
        
        // Get all methods from the class
        for (Method method : MyService.class.getMethods()) {
            // Check if the method has @LogExecutionTime annotation
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                logExecutionTime(service, method);
            }
        }
    }
    
    // Method that logs the execution time of annotated methods
    public static void logExecutionTime(Object object, Method method) {
        try {
            long startTime = System.nanoTime(); // Start time
            method.invoke(object); // Invoke the method
            long endTime = System.nanoTime(); // End time
            long executionTime = endTime - startTime; // Calculate execution time
            System.out.println(method.getName() + " executed in " + executionTime + " ns");
        } catch (Exception e) {
            System.out.println( "e = " + e );;
        }
    }
}

class MyService {
    
    @LogExecutionTime
    public void process() {
        try {
            Thread.sleep(1000);  // Simulating a time-consuming task
        } catch (InterruptedException e) {
            System.out.println( "e = " + e );
        }
    }
}
