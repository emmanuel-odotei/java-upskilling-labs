package intermediate.src.week1_labs.oop.inner_class;

public class BankAccount {
    
    private double balance;
    private final String accountNumber;
    
    public BankAccount (String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }
    
    public void deposit (double amount) {
        if ( amount > 0.0 ) {
            Transaction transaction = new Transaction( TransactionType.DEPOSIT, amount );
            transaction.processTransaction();
            System.out.println( "Deposited $" + amount + " to " + accountNumber );
        } else {
            System.out.println( "Amount must be positive" );
        }
    }
    
    public void withdraw (double amount) {
        if ( amount > 0.0 && amount <= balance ) {
            Transaction transaction = new Transaction( TransactionType.WITHDRAWAL, amount );
            transaction.processTransaction();
            System.out.println( "Withdrew $" + amount + " from " + accountNumber );
        } else if ( amount > balance ) {
            System.out.println( "Insufficient funds" );
        } else {
            System.out.println( "Amount must be positive" );
        }
    }
    
    public double getBalance () {
        return balance;
    }
    
    /*
     * Inner class to process bank transactions
     */
    public class Transaction {
        private final TransactionType type;
        private final double amount;
        
        public Transaction (TransactionType type, double amount) {
            this.type = type;
            this.amount = amount;
        }
        
        public void processTransaction () {
            if ( type == TransactionType.DEPOSIT ) {
                balance += amount;
            } else if ( type == TransactionType.WITHDRAWAL ) {
                balance -= amount;
            }
        }
        
        @Override
        public String toString () {
            return "Transaction: " + type + ", Amount: " + amount;
        }
    }
    
    /*
     * Enum for transaction types
     */
    public enum TransactionType {
        DEPOSIT, WITHDRAWAL
    }
}
