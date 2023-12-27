package laba5;

import java.util.regex.*;

public class task3HyperlinkReplacer {
    public static void main(String[] args) {
        String input = "Пример текста с ссылками www.eogpwode.com и www.example.ru";
        try {
            Pattern pattern = Pattern.compile("\\b(https?:\\/\\/)?(www\\.[a-zA-Z]+\\.[a-zA-Z]+)\\b");
            Matcher matcher = pattern.matcher(input);

            StringBuilder output = new StringBuilder();

            while (matcher.find()) {
                if (matcher.group(1) != null) {
                    throw new IllegalArgumentException("Ошибка: это гиперссылка");
                }
                matcher.appendReplacement(output, "https://$2");
            }
            matcher.appendTail(output);

            System.out.println("Результат: " + output);
        }catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
