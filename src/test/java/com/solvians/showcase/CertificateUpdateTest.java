package com.solvians.showcase;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CertificateUpdateTest {

    @Test
    void certificate_update_has_current_timestamp() {
        long beforeCreation = System.currentTimeMillis();

        CertificateUpdate certificateUpdate = new CertificateUpdate();

        long afterCreation = System.currentTimeMillis();
        assertTrue(certificateUpdate.getTimestamp() >= beforeCreation);
        assertTrue(certificateUpdate.getTimestamp() <= afterCreation);
    }

    @RepeatedTest(100)
    void bid_price_is_between_100_and_200_inclusive_with_two_decimals_precision() {
        CertificateUpdate certificateUpdate = new CertificateUpdate();

        assertTrue(certificateUpdate.getBidPrice() >= 100.00);
        assertTrue(certificateUpdate.getBidPrice() <= 200.00);
    }

    @RepeatedTest(100)
    void ask_price_is_between_100_and_200_inclusive_with_two_decimals_precision() {
        CertificateUpdate certificateUpdate = new CertificateUpdate();

        assertTrue(certificateUpdate.getAskPrice() >= 100.00);
        assertTrue(certificateUpdate.getAskPrice() <= 200.00);
    }

    @RepeatedTest(100)
    void bid_size_is_between_1000_and_5000_inclusive() {
        CertificateUpdate certificateUpdate = new CertificateUpdate();

        assertTrue(certificateUpdate.getBidSize() >= 1000);
        assertTrue(certificateUpdate.getBidSize() <= 5000);
    }

    @RepeatedTest(100)
    void ask_size_is_between_1000_and_10000_inclusive() {
        CertificateUpdate certificateUpdate = new CertificateUpdate();

        assertTrue(certificateUpdate.getAskSize() >= 1000);
        assertTrue(certificateUpdate.getAskSize() <= 10000);
    }

}
