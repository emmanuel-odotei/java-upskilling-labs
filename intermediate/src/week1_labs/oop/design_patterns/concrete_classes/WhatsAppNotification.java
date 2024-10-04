package intermediate.src.week1_labs.oop.design_patterns.concrete_classes;

import intermediate.src.week1_labs.oop.design_patterns.Notification;

public class WhatsAppNotification implements Notification {

    @Override
    public void notify(String message) {
        System.out.println("WhatsApp notification: " + message);
    }
}
