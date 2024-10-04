package intermediate.src.week1_labs.exception_handling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionHandlingDemo {
    
    public void nestedTryCatch () {
        try {
            System.out.println( "Nested Try-Catch Example:" );
            try {
                // Simulating a situation that can throw a checked exception
                readFromFile( "nonexistingfile.txt" );
            } catch ( IOException e ) {
                System.err.println( "Inner catch: IOException caught: " + e.getMessage() );
            }
            
            // Simulating a situation that can throw an unchecked exception
            try {
                withdraw( 200.0, 50.0 );
            } catch ( InsufficientFundsException e ) {
                System.err.println( "Inner catch: Unchecked Exception: " + e.getMessage() );
            }
            
        } catch ( Exception e ) {
            System.err.println( "Outer catch: General Exception caught: " + e.getMessage() );
        }
    }
    
    //Throws checked exception
    public void fileReaderProcess () {
        System.out.println("Checked exception handling example: ");
        try {
            readFromFile( "test.txt" ); // Assume "test.txt" may not exist
        } catch ( IOException e ) {
            System.err.println( "IOException occurred: " + e.getMessage() );
        }
    }
    
    //Throws unchecked exception
    public void withdrawalProcess () {
        System.out.println("Unchecked exception handling example: ");
        try {
            withdraw( 150.0, 100.0 );
        } catch ( InsufficientFundsException e ) {
            System.err.println( "Unchecked Exception: " + e.getMessage() );
        }
    }
    
    // Method that throws a checked exception
    private void readFromFile (String filename) throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader( new FileReader( filename ) );
            String line;
            while ( ( line = reader.readLine() ) != null ) {
                System.out.println( line );
            }
        } finally {
            if ( reader != null ) {
                try {
                    reader.close(); // Ensure the file is closed
                } catch ( IOException e ) {
                    System.err.println( "Error closing the file: " + e.getMessage() );
                }
            }
        }
    }
    
    // Method that throws an unchecked exception
    private void withdraw (double amount, double balance) {
        if ( amount > balance ) {
            throw new InsufficientFundsException( "Insufficient funds for withdrawal: " + amount );
        }
        System.out.println( "Withdrawal successful: " + amount );
    }
}