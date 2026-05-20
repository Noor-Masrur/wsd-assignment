package com.solvians.showcase;

import java.util.concurrent.Callable;

public class CertificateUpdateTask implements Callable<String> {

    @Override
    public String call() {
        return new CertificateUpdate().toString();
    }
}
