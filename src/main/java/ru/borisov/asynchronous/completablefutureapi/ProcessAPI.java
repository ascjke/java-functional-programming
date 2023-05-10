package ru.borisov.asynchronous.completablefutureapi;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public class ProcessAPI {

    public static void main(String[] args) throws IOException {
        ProcessHandle currentProcess = ProcessHandle.current();
        System.out.println("PID: " + currentProcess.pid());
        System.out.println("User: " + currentProcess.info().user());

        long count = ProcessHandle.allProcesses()
                .filter(ProcessHandle::isAlive)
                .count();
        System.out.println(count);

        // CompletableFuture
        ProcessHandle process = new ProcessBuilder("java", "-version")
                .inheritIO()
                .start()
                .toHandle();

        System.out.printf("The process %d has started\n", process.pid());

        CompletableFuture<ProcessHandle> onProcessExit = process.onExit(); // returns a CompletableFuture
        onProcessExit.thenAccept(processHandle ->
                System.out.printf("The process %d has finished\n", processHandle.pid()));

        onProcessExit.join();
    }
}
