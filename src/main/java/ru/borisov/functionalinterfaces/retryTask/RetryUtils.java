package ru.borisov.functionalinterfaces.retryTask;

final class RetryUtils {
    public static Retry retry = RetryUtils::retryAction; // assign the retryAction method to this variable

    private RetryUtils() { }

    public static int retryAction(
            Runnable action, int maxAttempts, long delayBeforeRetryMs) {

        int fails = 0;
        while (fails < maxAttempts) {
            try {
                action.run();
                return fails;
            } catch (Exception e) {
                System.out.println("Something goes wrong");
                fails++;
                try {
                    Thread.sleep(delayBeforeRetryMs);
                } catch (InterruptedException interruptedException) {
                    throw new RuntimeException(interruptedException);
                }
            }
        }
        return fails;
    }
}
