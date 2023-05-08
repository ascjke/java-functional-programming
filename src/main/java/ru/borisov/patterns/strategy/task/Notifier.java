package ru.borisov.patterns.strategy.task;

public class Notifier {

    private NotificationStrategy notificationStrategy;

    public Notifier() {
    }

    public Notifier(NotificationStrategy notificationStrategy) {
        this.notificationStrategy = notificationStrategy;
    }

    public void setNotificationStrategy(NotificationStrategy notificationStrategy) {
        this.notificationStrategy = notificationStrategy;
    }

    public void notifyCustomer(User user) {
        notificationStrategy.notifyCustomer(user);
    }
}
