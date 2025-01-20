package intermediate.src.week1_labs.oop.design_patterns.concrete_classes;

import intermediate.src.week1_labs.oop.design_patterns.Notification;

public class EmailNotification implements Notification {

    @Override
    public void notify(String message) {
        System.out.println("Email notification: " + message);
    }
}
