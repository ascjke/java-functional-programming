package ru.borisov.streams.reduction;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ColletctorsRedcuing {

    public static void main(String[] args) {

        List<Payment> payments = List.of(
                new Payment(LocalDateTime.now(), 50),
                new Payment(LocalDateTime.now(), 21),
                new Payment(LocalDateTime.now(), 34),
                new Payment(LocalDateTime.now(), 15)
        );

        Optional<Long> totalAmount = payments.stream()
                .map(Payment::amountInDollars)
                .collect(Collectors.reducing((amount1, amount2) -> amount1 + amount2));

        Optional<Long> totalAmount2 = payments.stream()
                .map(Payment::amountInDollars)
                .reduce(Long::sum);

        // accepts the identity value, a mapper function applied to each input element, and a binary operator to reduce the mapped values
        long amountInCents = payments.stream()
                .map(Payment::amountInDollars)
                .collect(Collectors.reducing(
                        0L,
                        amount -> amount * 100,
                        Long::sum
                ));

        System.out.println(totalAmount);
    }
}

record Payment(LocalDateTime date, long amountInDollars) {
}
