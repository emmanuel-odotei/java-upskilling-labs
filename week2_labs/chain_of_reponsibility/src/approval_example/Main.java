package week2_labs.chain_of_reponsibility.src.approval_example;

public class Main {
    public static void main(String[] args) {
        Approval manager = new Manager();
        Approval director = new Director();
        Approval ceo = new CEO();

        manager.setNextApproval(director);
        director.setNextApproval(ceo);


        System.out.println("Handle a request of amount 100");
        manager.approve(100);

        System.out.println("Handle a request of amount 150");
        manager.approve(150);

        System.out.println("Handle a request of amount 500");
        manager.approve(500);
    }
}
