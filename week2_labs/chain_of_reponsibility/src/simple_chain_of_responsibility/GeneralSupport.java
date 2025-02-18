package week2_labs.chain_of_reponsibility.src.simple_chain_of_responsibility;

public class GeneralSupport extends SupportHandler{

    @Override
    public void handleIssue(String issue) {
        if(issue.equals("general")){
            System.out.println("General Support is available");
        }else if(nextHandler != null){
            nextHandler.handleIssue(issue);
        }
        else{
            System.out.println("No support Available");
        }
    }
}
