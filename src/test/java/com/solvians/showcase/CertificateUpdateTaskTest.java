package com.solvians.showcase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CertificateUpdateTaskTest {

    @Test
    void call_returns_non_empty_line() {
        CertificateUpdateTask task = new CertificateUpdateTask();

        String line = task.call();

        assertFalse(line.isEmpty());
    }

    @Test
    void call_returns_formatted_as_comma_separated_line_with_six_component() {
        CertificateUpdateTask task = new CertificateUpdateTask();

        String line = task.call();

        String[] components = line.split(",");

        assertEquals(6, components.length);
    }

    @Test
    void call_returns_sequence_of_components_is_correct() {
        CertificateUpdateTask task = new CertificateUpdateTask();

        String line = task.call();

        String[] components = line.split(",");

        assertTrue(components[0].matches("\\d+"));
        assertTrue(components[1].matches("[A-Z]{2}[A-Z0-9]{9}\\d"));
        assertTrue(components[2].matches("\\d+\\.\\d{2}"));
        assertTrue(components[3].matches("\\d+"));
        assertTrue(components[4].matches("\\d+\\.\\d{2}"));
        assertTrue(components[5].matches("\\d+"));
    }
}
