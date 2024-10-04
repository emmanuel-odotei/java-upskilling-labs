package intermediate.src.week1_labs.exception_handling;

public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException (String message) {
        super( message );
    }
}
