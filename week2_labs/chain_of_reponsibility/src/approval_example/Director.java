package week2_labs.chain_of_reponsibility.src.approval_example;

public class Director extends Approval {
    @Override
    public void approve(int amount) {
        if(amount >=100 && amount <=200){
            System.out.printf("An amount of %d has been approved by the Director \n", amount);
        }else{
            forwardToNextApproval(amount);
        }
    }
}
