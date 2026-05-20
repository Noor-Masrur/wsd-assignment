package com.solvians.showcase;

public interface IsinGenerator {

    String generate();

    Integer calculateCheckDigit(String isin);
}
