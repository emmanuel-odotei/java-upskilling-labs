package intermediate.src.week1_labs.exception_handling;

public class ExceptionHandlingApp {
    public static void main (String[] args) {
        ExceptionHandlingDemo demo = new ExceptionHandlingDemo();
        // Simulating nested try-catch blocks
        demo.nestedTryCatch(  );
        
        //Simulating a situation that can throw a checked exception
        demo.fileReaderProcess();
        
        //Simulating a situation that can throw an unchecked exception
        demo.withdrawalProcess(  );
    }
}
