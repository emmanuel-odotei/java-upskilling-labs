package intermediate.week1_labs.src.exception_handling;

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
