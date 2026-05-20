package com.solvians.showcase;

import java.util.concurrent.ThreadLocalRandom;

public class CertificateUpdate {
    private static final int MIN_PRICE = 100;
    private static final int MAX_PRICE = 200;
    private static final int MIN_BID_SIZE = 1000;
    private static final int MAX_BID_SIZE = 5000;
    private static final int MIN_ASK_SIZE = 1000;
    private static final int MAX_ASK_SIZE = 10000;

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
        this.bidPrice = randomPrice();
        this.bidSize = randomBidSize();
        this.askPrice = randomPrice();
        this.askSize = randomAskSize();
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

    private double randomPrice() {
        return ThreadLocalRandom.current().nextInt(MIN_PRICE*100, MAX_PRICE*100 + 1) / 100.0;
    }

    private int randomAskSize() {
        return ThreadLocalRandom.current().nextInt(MIN_ASK_SIZE, MAX_ASK_SIZE + 1);
    }

    private int randomBidSize() {
        return ThreadLocalRandom.current().nextInt(MIN_BID_SIZE, MAX_BID_SIZE+1);
    }

    @Override
    public String toString() {
        return String.format("%d,%s,%.2f,%d,%.2f,%d", timestamp, isin, bidPrice, bidSize, askPrice, askSize);
    }
}
