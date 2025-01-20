package intermediate.src.week1_labs.oop.design_patterns;

public class NotificationApp {
    public static void main (String[] args) {
        //Create email notification
        Notification emailNotification = NotificationFactory.createNotification("email");
        emailNotification.notify("Your subscription is about to expire!");
        
        //Create SMS notification
        Notification smsNotification = NotificationFactory.createNotification("sms");
        smsNotification.notify("You've received $100 in your account!");
        
        //Create WhatsApp notification
        Notification whatsAppNotification = NotificationFactory.createNotification("whatsapp");
        whatsAppNotification.notify("You've got a new message!");
    }
}
