package intermediate.src.week1_labs.oop.inner_class;

public class BankApp {
    public static void main (String[] args) {
        BankAccount account = new BankAccount("123456789");
        account.deposit(100.0);
        System.out.println("Balance: $" + account.getBalance());
        
        account.withdraw(50.0);
        System.out.println("Balance: $" + account.getBalance());
        
        account.withdraw(150.0);
        System.out.println("Balance: $" + account.getBalance());
    }
}
