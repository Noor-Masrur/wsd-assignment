package com.solvians.showcase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Stream;

public class CertificateUpdateGenerator {
    private final int threads;
    private final int quotes;

    public CertificateUpdateGenerator(int threads, int quotes) {
        this.threads = threads;
        this.quotes = quotes;
    }

    public Stream<CertificateUpdate> generateQuotes() {
        ExecutorService executorService = Executors.newFixedThreadPool(threads);

        try {
            List<Callable<CertificateUpdate>> tasks = new ArrayList<>();
            for (int i =0; i< quotes; i++) {
                tasks.add(CertificateUpdate::new);
            }

            List<CertificateUpdate> certificateUpdates = new ArrayList<>();

            List<Future<CertificateUpdate>> certificateUpdateFutures = executorService.invokeAll(tasks);
            for (Future<CertificateUpdate> certificateUpdateFuture : certificateUpdateFutures) {
                try {
                    certificateUpdates.add(certificateUpdateFuture.get());
                } catch (ExecutionException e) {
                    throw new RuntimeException("Certificate update generation failed", e);
                }
            }

            return certificateUpdates.stream();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Certificate update generation was interrupted", e);
        } finally {
            executorService.shutdown();
        }
    }
}
