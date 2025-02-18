package week2_labs.chain_of_reponsibility.src.approval_example;

public class Manager extends Approval{
    @Override
    public void approve(int amount) {
        if(amount <= 100) {
            System.out.printf("An amount of %d has been approved by Manager \n", amount);
        }else{
            forwardToNextApproval(amount);
        }
    }
}
