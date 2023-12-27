package laba5;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task2PasswordValidator {
    public static void main(String[] args) {
        String password = "bcd1234!";

        try {
            validatePassword(password);
            System.out.println("Пароль корректен.");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void validatePassword(String password) {
        String regex = "^(?=.*[A-Z])(?=.*\\d)[^.]{8,16}$";

        if (!password.matches(regex)) {
            throw new IllegalArgumentException("Некорректный пароль. Пароль должен состоять из латинских букв и цифр, быть длиной от 8 до 16 символов, и содержать хотя бы одну заглавную букву и одну цифру.");
        }
    }
}
