package com.solvians.showcase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IsinGeneratorTest {

    private final IsinGenerator generator = new IsinGeneratorImpl();

    @Test
    void generated_isin_number_has_exactly_twelve_characters() {
        String isin = generator.generate();

        assertEquals(12, isin.length());
    }

    @Test
    void generated_isin_starts_with_two_uppercase_letters() {
        String isin = generator.generate();

        assertTrue(isin.substring(0, 2).matches("[A-Z]{2}"));
    }

    @Test
    void generated_isin_has_nine_alphanumeric_characters_after_first_two_letters() {
        String isin = generator.generate();

        /*Description says 9 alphanumeric characters but Conversion table only has uppercase letter mapping,
        so I assume that the alphanumeric characters should be either uppercase letters or digits.*/
        assertTrue(isin.substring(2, 11).matches("[A-Z0-9]{9}"));
    }

    @Test
    void generated_isin_always_ends_with_digit() {
        String isin = generator.generate();

        assertTrue(isin.substring(11).matches("[0-9]"));
    }

    @Test
    void validate_generator_function_against_a_known_check_digit() {
        int checkDigit = generator.calculateCheckDigit("DE123456789");

        assertEquals(6, checkDigit);
    }

    @Test
    void validate_generator_function_against_multiple_known_check_digit() {
        int checkDigit = generator.calculateCheckDigit("US037833100");
        assertEquals(5, checkDigit);

        checkDigit = generator.calculateCheckDigit("IE00B4BNMY3");
        assertEquals(4, checkDigit);

        checkDigit = generator.calculateCheckDigit("DE000710000");
        assertEquals(0, checkDigit);
    }
}
