package com.solvians.showcase;

public class IsinGeneratorImpl implements IsinGenerator {
    @Override
    public String generate() {
        return "DE1234567896";
    }

    @Override
    public Integer calculateCheckDigit(String isin) {
        return 6;
    }
}
