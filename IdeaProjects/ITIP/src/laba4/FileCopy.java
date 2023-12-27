package laba4;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        String sourceFilePath = "C:\\Users\\AT\\Desktop\\source.txt";
        String targetFilePath = "C:\\Users\\AT\\Desktop\\new.txt";

        try {
            FileInputStream inputStream = new FileInputStream(sourceFilePath);
            FileOutputStream outputStream = new FileOutputStream(targetFilePath);

            int bytesRead;
            while ((bytesRead = inputStream.read()) != -1) {
                outputStream.write(bytesRead);
            }

            System.out.println("Файл успешно скопирован.");
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
        }
    }
}

