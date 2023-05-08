package ru.borisov.streams.grouping;

import java.util.*;

import static java.util.stream.Collectors.*;

class UserActivityMonitoring {

    /**
     * Write a method that leverages grouping collectors to calculate how many times each url was clicked by users.
     * The collector will be applied to a stream of log entries for creating a map: url -> click count.
     */
    public static Map<String, Long> getUrlToNumberOfVisited(List<LogEntry> logs) {
        return logs.stream()
                .collect(groupingBy(LogEntry::getUrl, counting()));
    }
}

class LogEntry {
    private final Date created;
    private final String login;
    private final String url;

    public LogEntry(Date created, String login, String url) {
        this.created = created;
        this.login = login;
        this.url = url;
    }

    public Date getCreated() {
        return created;
    }

    public String getLogin() {
        return login;
    }

    public String getUrl() {
        return url;
    }
}

class UserActivityMonitoringDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLogEntries = Integer.parseInt(scanner.nextLine());

        List<LogEntry> logs = new ArrayList<>();
        for (int i = 0; i < numberOfLogEntries; i++) {
            String[] info = scanner.nextLine().split(" ");

            Date dt = new Date();
            String user = info[0];
            String url = info[1];

            logs.add(new LogEntry(dt, user, url));
        }

        List<Map.Entry<String, Long>> result = UserActivityMonitoring.getUrlToNumberOfVisited(logs)
                .entrySet()
                .stream()
                .sorted((w1, w2) -> w2.getValue().compareTo(w1.getValue()))
                .collect(toList());

        StringBuilder resultString = new StringBuilder();
        for (Map.Entry<String, Long> entry : result) {
            resultString.append(entry.getKey())
                    .append("=")
                    .append(entry.getValue())
                    .append(" ");
        }

        System.out.println(resultString.toString().trim());
    }

}
