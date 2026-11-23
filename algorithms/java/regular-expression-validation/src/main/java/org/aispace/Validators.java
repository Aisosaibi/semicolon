package org.aispace;

import java.util.regex.Pattern;

public class Validators {

    private static final Pattern VALID_EMAIL = Pattern.compile(
            "^[a-z]"
                    + "\\.[a-z]{2,20}"
                    + "@(?:native|staff)"
                    + "\\.semicolon\\.africa$");

    public static boolean isValidEmail(String email) {
        if (email == null) return false;
        return VALID_EMAIL.matcher(email).matches();
    }

    private static final Pattern VALID_PASSWORD = Pattern.compile(
            "^(?=\\S{8,16}$)"
                    + "(?=.*\\d)"
                    + "(?=.*[@#_+])"
                    + ".*$");

    public static boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }
        return VALID_PASSWORD.matcher(password).matches();
    }
}
