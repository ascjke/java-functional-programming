package ru.borisov.asynchronous.completablefutureapi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpClientAPI {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper(); // from com.fasterxml.jackson.core

    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();
        HttpClient httpClient = HttpClient.newBuilder()
                .executor(executor)
                .build();
        Duration timeOut = Duration.ofSeconds(30);
        String courseUrl = "https://stepik.org/api/courses/91497";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(courseUrl))
                .timeout(timeOut)
                .GET()
                .build();

        httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString()) // returns a CompletableFuture
                .thenApply(HttpResponse::body) // gets a string body from the response
                .thenApply(bodyAsJson ->
                        getLearnersCountFromJsonString(OBJECT_MAPPER, bodyAsJson)) // parses the number of learners
                .whenComplete((result, e) ->
                        System.out.println(e == null ? "The number of learners: " + result : e.getMessage()))
                .join(); // waits for this future from the calling thread
    }

    public static long getLearnersCountFromJsonString(ObjectMapper mapper, String json) {
        try {
            JsonNode jsonRoot = mapper.readTree(json);
            JsonNode learnersCountNode = jsonRoot.get("courses").get(0).get("learners_count");
            return Long.parseLong(learnersCountNode.asText());
        } catch (Exception e) {
            throw new RuntimeException("Cannot extract the learners_count attribute from the json");
        }
    }
}
