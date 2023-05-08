package ru.borisov.streams.grouping;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.partitioningBy;

public class PartitioningEx {

    public static void main(String[] args) {

        List<Tweet> tweets = List.of(
                new Tweet("100", 1099),
                new Tweet("101", 1001),
                new Tweet("102", 7)
        );

        // partitioningBy() divides all elements of stream into two groups: in the first group will be all elements that satisfy the condition, in the second all others.
        Map<Boolean, List<Tweet>> popularTweets = tweets.stream()
                .collect(partitioningBy(tweet -> tweet.likeCount() >= 1000));

        popularTweets.get(true);  // Tweet("100", 1099), Tweet("101", 1001)
        popularTweets.get(false); // Tweet("102", 7)

    }
}

record Tweet(String id, int likeCount) {
}