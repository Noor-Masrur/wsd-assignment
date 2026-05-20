package com.solvians.showcase;

public class CertificateUpdate {
    private final long timestamp;
    private final String isin;
    private final double bidPrice;
    private final int bidSize;
    private final double askPrice;
    private final int askSize;

    public CertificateUpdate() {
        this(new IsinGeneratorImpl());
    }

    public CertificateUpdate(IsinGenerator isinGenerator) {
        this.timestamp = System.currentTimeMillis();
        this.isin = isinGenerator.generate();
        this.bidPrice = 101.23;
        this.bidSize = 1000;
        this.askPrice = 103.45;
        this.askSize = 1000;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getIsin() {
        return isin;
    }

    public double getBidPrice() {
        return bidPrice;
    }

    public int getBidSize() {
        return bidSize;
    }

    public double getAskPrice() {
        return askPrice;
    }

    public int getAskSize() {
        return askSize;
    }
}
