package intermediate.week1_labs.src.oop.design_patterns.concrete_classes;

import intermediate.week1_labs.src.oop.design_patterns.Notification;

public class SMSNotification implements Notification {

    @Override
    public void notify(String message) {
        System.out.println("SMS notification: " + message);
    }
}
