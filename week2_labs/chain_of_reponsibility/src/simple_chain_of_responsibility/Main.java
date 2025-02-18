package week2_labs.chain_of_reponsibility.src.simple_chain_of_responsibility;

public class Main {
    public static void main(String[] args) {
        SupportHandler technicalSupport = new TechnicalSupport();
        SupportHandler billingSupport = new BillingSupport();
        SupportHandler generalSupport = new GeneralSupport();

        technicalSupport.setNextHandler(billingSupport);
        billingSupport.setNextHandler(generalSupport);

        System.out.println("Technical Support:");
        technicalSupport.handleIssue("technical");

        System.out.println("Billing Support");
        billingSupport.handleIssue("billing");

        System.out.println("General Support");
        generalSupport.handleIssue("general");

        System.out.println("Unknown Support:");
        generalSupport.handleIssue("unknown");
    }
}
