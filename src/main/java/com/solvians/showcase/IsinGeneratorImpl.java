package com.solvians.showcase;

import java.util.concurrent.ThreadLocalRandom;

public class IsinGeneratorImpl implements IsinGenerator {
    private static final String ALPHANUMERIC_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private static final int NUMBER_OF_UPPERCASE_LETTERS_AT_START = 2;
    private static final int NUMBER_OF_ALPHANUMERIC_CHARACTERS_TO_FOLLOW = 9;

    @Override
    public String generate() {
        StringBuilder isin = new StringBuilder();

        isin.append(generateRandomUpperCaseLetters());

        isin.append(generateRandomAlphanumericCharacters());

        isin.append(calculateCheckDigit(isin.toString()));

        return isin.toString();
    }

    @Override
    public Integer calculateCheckDigit(String isin) {
        String onlyDigitIsin = convertLettersToNumbers(isin);
        int sum = 0;
        boolean skipDigitFlag = false;

        for (int i =onlyDigitIsin.length() - 1; i>= 0; i--) {
            int digit = Character.getNumericValue(onlyDigitIsin.charAt(i));

            if (!skipDigitFlag) {
                digit *= 2;
            }

            sum += digit / 10;
            //Handling multiplication res greater than 9
            sum += digit % 10;

            skipDigitFlag = !skipDigitFlag;
        }

        int checkDigit = (10 - (sum % 10)) % 10;

        return checkDigit;
    }

    private String generateRandomUpperCaseLetters() {
        StringBuilder randomUpperCaseLetters = new StringBuilder();

        for (int i= 0; i< IsinGeneratorImpl.NUMBER_OF_UPPERCASE_LETTERS_AT_START; i++) {
            randomUpperCaseLetters.append(randomUppercaseLetter());
        }
        return randomUpperCaseLetters.toString();
    }

    private char randomUppercaseLetter() {
        return (char) ('A' + generateRandomNumber(26));
    }

    private String generateRandomAlphanumericCharacters() {
        StringBuilder randomAlphanumericCharacters = new StringBuilder();

        for(int i= 0; i<IsinGeneratorImpl.NUMBER_OF_ALPHANUMERIC_CHARACTERS_TO_FOLLOW; i++){
            randomAlphanumericCharacters.append(randomAlphanumericCharacter());
        }

        return randomAlphanumericCharacters.toString();
    }

    private char randomAlphanumericCharacter() {
        return ALPHANUMERIC_CHARACTERS.charAt(generateRandomNumber(ALPHANUMERIC_CHARACTERS.length()));
    }

    private int generateRandomNumber(int bound) {
        return ThreadLocalRandom.current().nextInt(bound);
    }

    private String convertLettersToNumbers(String partialIsin) {
        StringBuilder onlyDigitIsin = new StringBuilder();

        for (int i= 0; i <partialIsin.length(); i++) {
            char character = partialIsin.charAt(i);

            if (Character.isDigit(character)) {
                onlyDigitIsin.append(character);
            } else {
                onlyDigitIsin.append(character - 'A' + 10);
            }
        }

        return onlyDigitIsin.toString();
    }
}
