package ru.borisov.patterns.strategy.task;

public class Application {

    private EmailService emailService;
    private SMSService smsService;

    public Application(EmailService emailService, SMSService smsService) {
        this.emailService = emailService;
        this.smsService = smsService;
    }

    public void run(User user) {
        Notifier notifier = new Notifier(emailService::sendEmail);
        notifier.notifyCustomer(user);
        notifier.setNotificationStrategy(smsService::sendSMS);
        notifier.notifyCustomer(user);
    }
}
