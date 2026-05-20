package com.solvians.showcase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class CertificateUpdateTaskTest {

    @Test
    void call_returns_non_empty_line() {
        CertificateUpdateTask task = new CertificateUpdateTask();

        String line = task.call();

        assertFalse(line.isEmpty());
    }
}
