package week2_labs.chain_of_reponsibility.src.simple_chain_of_responsibility;

public class BillingSupport extends SupportHandler{
    @Override
    public void handleIssue(String issue) {
        if(issue.equals("billing")){
            System.out.println("Support billing is available");
        }else if(nextHandler != null){
            nextHandler.handleIssue(issue);
        }
    }
}
