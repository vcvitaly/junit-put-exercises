package com.practicalunittesting.chp04;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordValidatorTest {

    private PasswordValidator passwordValidator = new PasswordValidator();

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailIfLessThan8Chars() {
        passwordValidator.validate("1234567");
    }

    @Test
    public void shouldPassIfAtLeast8Chars() {
        passwordValidator.validate("12345678");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldContainLowerCaseLetters() {
        passwordValidator.validate("123ABCDEFG");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldContainUpperCaseLetters() {
        passwordValidator.validate("123abcdefg");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldContainDigits() {
        passwordValidator.validate("ABCDefghij");
    }

}