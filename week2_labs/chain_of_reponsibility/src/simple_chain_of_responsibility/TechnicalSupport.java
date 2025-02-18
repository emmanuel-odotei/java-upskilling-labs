package week2_labs.chain_of_reponsibility.src.simple_chain_of_responsibility;

public class TechnicalSupport extends SupportHandler{
    @Override
    public void handleIssue(String issue) {
        if(issue.equals("technical")){
            System.out.println("Technical Support is available");
        }else if(nextHandler !=null){
            nextHandler.handleIssue(issue);
        }
    }
}
