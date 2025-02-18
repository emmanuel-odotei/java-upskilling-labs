package week2_labs.chain_of_reponsibility.src.approval_example;

public abstract class Approval {
    private Approval nextApproval;

    public abstract void approve(int amount);

    public void setNextApproval(Approval nextApproval) {
        this.nextApproval = nextApproval;
    }
    public void forwardToNextApproval(int amount) {
        if(nextApproval != null){
            nextApproval.approve(amount);
        }
    }
}
