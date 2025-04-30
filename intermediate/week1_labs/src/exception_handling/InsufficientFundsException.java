package intermediate.week1_labs.src.exception_handling;

public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException (String message) {
        super( message );
    }
}
