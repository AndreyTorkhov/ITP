package laba4;

import java.io.FileWriter;
import java.io.IOException;

class CustomExceptionLogger {
    public void logException(Exception e) {
        try (FileWriter writer = new FileWriter("exception.log", true)) {
            writer.write(e.toString() + "\n");
        } catch (IOException ex) {
            System.out.println("Ошибка записи: " + ex.getMessage());
        }
    }
}

public class CustomNumberFormatException extends NumberFormatException {
    public CustomNumberFormatException(String message) {
        super(message);
    }
}

class Main {
    public static void main(String[] args) {
        CustomExceptionLogger exceptionLogger = new CustomExceptionLogger();

        String str = "123";
        try {
            int num = Integer.parseInt(str);
            System.out.println("Введенное число: " + num);
        } catch (NumberFormatException e) {
            CustomNumberFormatException customException = new CustomNumberFormatException("Failed to parse integer from string: " + str);
            exceptionLogger.logException(customException);
            System.out.println("Ошибка: " + customException.getMessage());
        }
    }
}