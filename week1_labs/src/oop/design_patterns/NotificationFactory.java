package intermediate.src.week1_labs.oop.design_patterns;

import intermediate.src.week1_labs.oop.design_patterns.concrete_classes.EmailNotification;
import intermediate.src.week1_labs.oop.design_patterns.concrete_classes.SMSNotification;
import intermediate.src.week1_labs.oop.design_patterns.concrete_classes.WhatsAppNotification;

public class NotificationFactory {
    
    public static Notification createNotification (String type) {
        return switch ( type ) {
            case "email" -> new EmailNotification();
            case "sms" -> new SMSNotification();
            case "whatsapp" -> new WhatsAppNotification();
            default -> throw new IllegalArgumentException( "Invalid notification type: " + type );
        };
    }
}
