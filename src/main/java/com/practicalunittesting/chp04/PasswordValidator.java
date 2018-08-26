package com.practicalunittesting.chp04;

import static com.practicalunittesting.chp04.PasswordValidator.PasswordValidationException.Messages.*;

public class PasswordValidator {

    public boolean validate(String password) {
        if (password.length() < 8)
            throw new IllegalArgumentException(SHOULD_BE_AT_LEAST_8_CHAR.toString());
        if (!password.matches(".*[a-z].*"))
            throw new IllegalArgumentException(SHOULD_CONTAIN_LOWERCASE_LETTERS.toString());
        if (!password.matches(".*[A-Z].*"))
            throw new IllegalArgumentException(SHOULD_CONTAIN_UPPERCASE_LETTERS.toString());
        if (!password.matches(".*[0-9].*"))
            throw new IllegalArgumentException(SHOULD_CONTAIN_DIGITS.toString());
        if (!password.matches(".*[@#$%^&*()_\\-+=].*"))
            throw new IllegalArgumentException(SHOULD_CONTAIN_SYMBOLS.toString());
        return true;
    }

    public static class PasswordValidationException extends IllegalArgumentException {

        public enum Messages {
            SHOULD_BE_AT_LEAST_8_CHAR("Password should be at least 8 characters long"),
            SHOULD_CONTAIN_LOWERCASE_LETTERS("Password should contain lowercase letters a-z"),
            SHOULD_CONTAIN_UPPERCASE_LETTERS("Password should contain uppercase letters A-Z"),
            SHOULD_CONTAIN_DIGITS("Password should contain digits"),
            SHOULD_CONTAIN_SYMBOLS("Password should contain at least one of special symbols - @#$%^&*()_-+=");

            private String message;

            Messages(String message) {
                this.message = message;
            }

            @Override
            public String toString() {
                return message;
            }
        }
    }

}
