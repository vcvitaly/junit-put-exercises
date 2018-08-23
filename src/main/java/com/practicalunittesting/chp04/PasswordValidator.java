package com.practicalunittesting.chp04;

public class PasswordValidator {

    public boolean validate(String password) {
        if (password.length() < 8)
            throw new IllegalArgumentException("Password should be at least 8 characters long");
        if (password.matches(".*[a-z].*"))
            throw new IllegalArgumentException("Password should contain lowercase letters");
        if (password.matches(".*[A-Z].*"))
            throw new IllegalArgumentException("Password should contain uppercase letters");
        if (password.matches(".*[0-9].*"))
            throw new IllegalArgumentException("Password should contain digits");
        return true;
    }

}
