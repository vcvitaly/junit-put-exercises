package com.practicalunittesting.chp04;

import org.junit.Test;

import static com.practicalunittesting.chp04.PasswordValidator.PasswordValidationException.Messages.*;
import static org.junit.Assert.assertEquals;

/*
JUnit5 provides assertThrows
*/

public class PasswordValidatorTest {

    private PasswordValidator passwordValidator = new PasswordValidator();

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailIfLessThan8Chars() {
        try {
            passwordValidator.validate("1234567");
        } catch (IllegalArgumentException e) {
            assertEquals(SHOULD_BE_AT_LEAST_8_CHAR.toString(), e.getMessage());
            throw e;
        }
    }

    @Test
    public void shouldPassIfAtLeast8CharsIncludingDigitsLettersSymbols() {
        passwordValidator.validate("1aB@#$%^&*()");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailIfNoLowercaseLetters() {
        try {
            passwordValidator.validate("123ABCDEFG@");
        } catch (IllegalArgumentException e) {
            assertEquals(SHOULD_CONTAIN_LOWERCASE_LETTERS.toString(), e.getMessage());
            throw e;
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailIfNoUppercaseLetters() {
        try {
            passwordValidator.validate("123abcdefg@");
        } catch (IllegalArgumentException e) {
            assertEquals(SHOULD_CONTAIN_UPPERCASE_LETTERS.toString(), e.getMessage());
            throw e;
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailIfNoDigits() {
        try {
            passwordValidator.validate("ABCDefghij@");
        } catch (IllegalArgumentException e) {
            assertEquals(SHOULD_CONTAIN_DIGITS.toString(), e.getMessage());
            throw e;
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailIfNoSymbols() {
        try {
            passwordValidator.validate("123456aB");
        } catch (IllegalArgumentException e) {
            assertEquals(SHOULD_CONTAIN_SYMBOLS.toString(), e.getMessage());
            throw e;
        }
    }

}