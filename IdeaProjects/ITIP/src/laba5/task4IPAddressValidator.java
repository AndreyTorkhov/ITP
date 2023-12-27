package laba5;

import java.util.regex.*;

public class task4IPAddressValidator {
    public static void main(String[] args) {
        String ipAddress = "100.200.00.12";

        try {
            validateIPAddress(ipAddress);
            System.out.println("IP-адрес корректен.");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void validateIPAddress(String ipAddress) {
        String regex = "^((25[0-5]|2[0-4][0-9]|[0-1]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[0-1]?[0-9][0-9]?)$";

        if (!ipAddress.matches(regex)) {
            throw new IllegalArgumentException("Некорректный IP-адрес. IP-адрес должен состоять из 4 чисел, разделенных точками, и каждое число должно быть в диапазоне от 0 до 255.");
        }
    }
}
