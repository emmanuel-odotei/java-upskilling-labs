package week2_labs.chain_of_reponsibility.src.simple_chain_of_responsibility;

public abstract class SupportHandler {
    protected SupportHandler nextHandler;

    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
    public abstract void handleIssue(String issue);
}
